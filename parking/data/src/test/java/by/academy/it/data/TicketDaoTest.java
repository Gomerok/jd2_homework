package by.academy.it.data;

import by.academy.it.pojo.SessionFactoryHolder;
import by.academy.it.pojo.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;

import java.util.Date;
//import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TicketDaoTest {

    private static SessionFactoryHolder sessionFactory;
    static TicketDao ticketDao;
    static Transaction transaction;
    static Session session;

    @org.junit.Before
    public void setUp() throws Exception {
        ticketDao = new TicketDao(true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

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

//    @BeforeClass
//    public static void createDB() throws ClassNotFoundException {
//        sessionFactory = new SessionFactoryHolder();
//        ticketDao = new TicketDao();
//    }
//
//    /**
//     * Runs after all test methods
//     */
//    @AfterClass
//    public static void closeSessionFactory() {
//        sessionFactory.sessionFactory.close();
//    }
//
//    /**
//     * Runs before each test method
//     *
//     * @return
//     */
//    @Before
//    public void beginTransaction() {
//        session = sessionFactory.getSession();
//        transaction = session.beginTransaction();
//    }
//
//    /**
//     * Runs after each test method
//     */
//    @After
//    public void rollbackTransaction() {
//        if (transaction != null && transaction.isActive()) {
//            System.out.println("Rolling back trasnaction after @Test method");
//            // rollback transaction so that tests don't modify database
//            transaction.rollback();
//        }
//    }
//
//    @Test
//    public void testSaveUser() throws SQLException {
//
//        Ticket ticket = new Ticket();
//        Date date;
//        ticket.setDate(date = new Date());
//        ticket.setLicensePlateNumber("1111");
//        // save user. It delegates to `session.save(user1)` method.
//        ticketDao.saveNewTicket(ticket);
//
//        String number = ticket.getLicensePlateNumber();
//        Assert.assertNotNull(number);
//
//        // causes persistent entities to be saved into persistent context
//        session.flush();
//
//        // read languages from db
//        // next method annotated with @After is running.
//        // It rollbacks transaction causing hibernate not to store data into database. Thus database state is the same as when entering this test method
//    }

}