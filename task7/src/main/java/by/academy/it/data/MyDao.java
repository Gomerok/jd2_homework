package by.academy.it.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDao implements Dao {
    private DataSource dataSource;

    public MyDao() {
        dataSource = new DataSource();
    }

    @Override
    public Receiver getReceiver(int num) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM receiver WHERE num=" + num;
        ResultSet result = statement.executeQuery(query);
        Receiver receiver = null;
        if (result.next()) {
            receiver = new Receiver();
            receiver.setNum(result.getInt(1));
            receiver.setReceiverName(result.getString(2));
        }
        result.close();
        statement.close();
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM receiver";
        ResultSet result = statement.executeQuery(query);
        ArrayList<Receiver> receivers = new ArrayList<>();
        while (result.next()) {
            Receiver receiver = new Receiver();
            receiver.setNum(result.getInt(1));
            receiver.setReceiverName(result.getString(2));
            receivers.add(receiver);
        }
        return receivers;
    }

    @Override
    public Expense getExpense(int num) {
        return null;
    }

    @Override
    public ArrayList<Expense> getExpenses() {
        return null;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        return 0;
    }

    @Override
    public int addExpense(Expense expense) {
        return 0;
    }
}
