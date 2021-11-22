package by.academy.it.shop;

import by.academy.it.data.CustomerDao;
import by.academy.it.entities.Address;
import by.academy.it.entities.Customer;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class CustomerTest extends BaseTest{

    CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        customerDao = new CustomerDao(sessionFactory);
    }

    @After
    public void tearDown() {
        customerDao = null;
    }

    @Test
    public void save() {
        //Given
        Address address = new Address("minsk", "1111111");
        Customer customer = new Customer("sasha", "dd@gmail.com", address);
        //When
        Serializable id = customerDao.saveCustomer(customer);
        //Then
        Session session = sessionFactory.openSession();
        Customer saved = session.get(Customer.class, id);
        assertNotEquals(saved.getId(), 0);
        assertEquals(customer.getId(), saved.getId());
    }
}
