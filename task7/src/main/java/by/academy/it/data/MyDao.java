package by.academy.it.data;

import java.sql.*;
import java.util.ArrayList;

public class MyDao implements Dao {
    private DataSource dataSource;

    public MyDao() {
        dataSource = new DataSource();
    }

    @Override
    public Receiver getReceiver(int num) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM listExpenses.receivers WHERE num=" + num;
        ResultSet result = statement.executeQuery(query);
        Receiver receiver = null;
        if (result.next()) {
            receiver = new Receiver();
            receiver.setNum(result.getInt(1));
            receiver.setReceiverName(result.getString(2));
        }
        result.close();
        statement.close();
        connection.close();
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM listExpenses.receivers";
        ResultSet result = statement.executeQuery(query);
        ArrayList<Receiver> receivers = new ArrayList<>();
        while (result.next()) {
            Receiver receiver = new Receiver();
            receiver.setNum(result.getInt(1));
            receiver.setReceiverName(result.getString(2));
            receivers.add(receiver);
        }
        result.close();
        statement.close();
        connection.close();
        return receivers;
    }

    @Override
    public Expense getExpense(int num) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM listExpenses.expenses WHERE num=" + num;
        ResultSet result = statement.executeQuery(query);
        Expense expense = null;
        if (result.next()) {
            expense = new Expense();
            expense.setNum(result.getInt(1));
            expense.setPayDate(result.getString(2));
            expense.setReceiverId(result.getInt(3));
            expense.setAmount(result.getDouble(4));
        }
        result.close();
        statement.close();
        connection.close();
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM listExpenses.expenses";
        ResultSet result = statement.executeQuery(query);
        ArrayList<Expense> expensesList = new ArrayList<>();
        while (result.next()) {
            Expense expense = new Expense();
            expense.setNum(result.getInt(1));
            expense.setPayDate(result.getString(2));
            expense.setReceiverId(result.getInt(3));
            expense.setAmount(result.getDouble(4));
            expensesList.add(expense);
        }
        result.close();
        statement.close();
        connection.close();
        return expensesList;
    }

    @Override
    public int addReceiver(Receiver receiver) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "INSERT INTO listExpenses.receivers VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, receiver.getNum());
        preparedStatement.setString(2, receiver.getReceiverName());
        preparedStatement.close();
        connection.close();
        return preparedStatement.executeUpdate();
    }

    @Override
    public int addExpense(Expense expense) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "INSERT INTO listExpenses.expenses VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, expense.getNum());
        preparedStatement.setString(2, expense.getPayDate());
        preparedStatement.setInt(3, expense.getReceiverId());
        preparedStatement.setDouble(4, expense.getAmount());
        preparedStatement.close();
        connection.close();
        return preparedStatement.executeUpdate();
    }
}
