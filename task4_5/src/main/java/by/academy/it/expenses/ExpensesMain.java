package by.academy.it.expenses;

import java.sql.*;

public class ExpensesMain {

//    java -jar D:\work\task4_5\target\ExpensesMain.jar '2020-07-05' 'receiverName' 1000

//    CREATE DATABASE listExpenses;
//    CREATE TABLE expenses (
//    num int NOT NULL AUTO_INCREMENT,
//    payDate date DEFAULT NULL,
//    receiverId int DEFAULT NULL,
//    amount decimal(10,2) DEFAULT NULL,
//    PRIMARY KEY (num)
//    )

//    CREATE TABLE receivers (
//    num int NOT NULL AUTO_INCREMENT,
//    receiverName varchar(50) DEFAULT NULL,
//    PRIMARY KEY (num)
//    )

    private static final String URL = "jdbc:mysql://localhost:3306/listExpenses?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean isThereReceiver(String receiver) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM listExpenses.receivers WHERE receiverName= " + receiver + " ;";
        ResultSet result = statement.executeQuery(query);
        if (result.next()) {
            result.close();
            statement.close();
            connection.close();
            return true;
        }
        result.close();
        statement.close();
        connection.close();
        return false;
    }

    public static void addReceiver(String receiver) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "INSERT INTO listExpenses.receivers (receiverName) values" +
                "(" + receiver + ");";
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    public static void addExpense(String payDate, String receiver, Double amount) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM listExpenses.receivers WHERE receiverName= " + receiver + " ;";
        ResultSet result = statement.executeQuery(query);
        int receiverId = 0;
        if (result.next()) {
            receiverId = result.getInt(1);
        }
        String queryAdd = "INSERT INTO listExpenses.expenses (payDate, receiverId, amount) values("
                + payDate + "," + receiverId + "," + amount + ");";
        statement.executeUpdate(queryAdd);
        result.close();
        statement.close();
        connection.close();
    }

    public static void showTable() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM listExpenses.expenses ;";
        ResultSet result = statement.executeQuery(query);
        System.out.println("Expenses_Table");
        while (result.next()) {
            int id = result.getInt(1);
            String payDate = result.getString(2);
            String receiverId = result.getString(3);
            double amount = result.getDouble(4);
            System.out.println(id + " " + payDate + " " + receiverId + " " + amount);
        }
        result.close();
        statement.close();
        connection.close();
    }

    private static void getAmount() throws SQLException {
        String template = "SELECT * FROM listExpenses.expenses WHERE amount > ? ;";
        Connection connection = getConnection();
        double value =100;
        PreparedStatement preparedStatement = connection.prepareStatement(template);
        preparedStatement.setDouble(1, value);
        ResultSet result = preparedStatement.executeQuery();
        System.out.println("getAmount > "+ value);
        while (result.next()){
            int id = result.getInt(1);
            String payDate = result.getString(2);
            String receiverId = result.getString(3);
            double amount = result.getDouble(4);
            System.out.println(id + " " + payDate + " " + receiverId + " " + amount);
        }
        result.close();
        preparedStatement.close();
        connection.close();
    }

    public static void main(String[] args) {
        if(args.length != 0){
            String payDate = args[0];
            String receiver = args[1];
            double amount = Double.parseDouble(args[2]);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                if (!isThereReceiver(receiver)) {
                    addReceiver(receiver);
                }
                addExpense(payDate, receiver, amount);  //Task4--------
                showTable();
                System.out.println();
                getAmount(); //Task5--------
                System.out.println();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Введите параметры!");
        }

    }
}