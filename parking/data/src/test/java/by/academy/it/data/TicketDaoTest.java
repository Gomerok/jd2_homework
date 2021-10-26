package by.academy.it.data;

import org.junit.Test;

import java.util.Date;
//import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TicketDaoTest {

    TicketDao ticketDao;

    @org.junit.Before
    public void setUp() throws Exception {
        ticketDao = new TicketDao(true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void testInstance() {
//        assertNotNull(ticketDao);
//    }

    @Test
    public void testSaveNewTicket() throws SQLException, ClassNotFoundException {
        ticketDao.deleteAll();
        // Given
        Ticket newTicket = new Ticket();
        newTicket.setDate(new Date());
        newTicket.setLicensePlateNumber("1234test");
        // When
        ticketDao.saveNewTicket(newTicket);
        // Then
        Ticket ticket = ticketDao.readAllTickets().get(0);
        assertNotNull(ticket);
        assertEquals("1234test", ticket.getLicensePlateNumber());
       // ticketDao.deleteAll();
    }


}