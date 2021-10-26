package by.academy.it.data;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao {
    Receiver getReceiver(int num) throws SQLException;
    ArrayList<Receiver> getReceivers() throws SQLException;
    Expense getExpense(int num);
    ArrayList<Expense> getExpenses();
    int addReceiver(Receiver receiver);
    int addExpense(Expense expense);
}
