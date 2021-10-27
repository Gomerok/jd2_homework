package by.academy.it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/listExpenses?serverTimezone=UTC",
                "root",
                "root");
    }
}
