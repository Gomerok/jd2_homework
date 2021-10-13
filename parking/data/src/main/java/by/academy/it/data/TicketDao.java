package by.academy.it.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    public TicketDao() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/parking", "root", "Gomer0013");
    }

    public List<Ticket> readAllTickets() throws SQLException {
        Connection con = getConnection();
        Statement st = getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM parking.tickets");
        List<Ticket> ticketList = new ArrayList<>();
        while (rs.next()) {
            Ticket ticket = new Ticket();
            ticket.setLicensePlateNumber(rs.getString("car_number"));
            ticket.setDate(rs.getTimestamp("ticket_date"));
            ticketList.add(ticket);
        }
        st.close();
        con.close();
        return  ticketList;
    }
}
