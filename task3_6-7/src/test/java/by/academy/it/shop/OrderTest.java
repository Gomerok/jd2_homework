package by.academy.it.shop;

import by.academy.it.data.OrderDao;
import by.academy.it.entities.Order;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderTest extends BaseTest{

    OrderDao orderDao;

    @Before
    public void setUp() throws Exception {
        orderDao = new OrderDao(sessionFactory);
    }

    @After
    public void tearDown() {
        orderDao = null;
    }

    @Test
    public void save() {
        //Given
        Order order = new Order("sasha", new Date());
        //When
        Serializable id = orderDao.saveOrder(order);
        //Then
        Session session = sessionFactory.openSession();
        Order saved = session.get(Order.class, id);
        assertNotEquals(saved.getId(),0);
        assertEquals(order.getId(), saved.getId());
    }
}
