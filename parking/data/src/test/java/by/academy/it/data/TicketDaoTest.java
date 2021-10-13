package by.academy.it.data;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;


public class TicketDaoTest {

    TicketDao ticketDao;

    @org.junit.Before
    public void setUp() throws Exception {
        ticketDao = new TicketDao();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInstance() {
        assertNotNull(ticketDao);
    }

    @Test
    public void testGetConnection() throws SQLException {
        assertNotNull(ticketDao.getConnection());
    }

    @Test
    public void tesyRealAllTicket(){

    }
}