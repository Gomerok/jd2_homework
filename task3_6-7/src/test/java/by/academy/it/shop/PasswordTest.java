package by.academy.it.shop;

import by.academy.it.data.PasswordDao;
import by.academy.it.entities.Customer;
import by.academy.it.entities.Password;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PasswordTest extends BaseTest{

    PasswordDao passwordDao;

    @Before
    public void setUp() throws Exception {
        passwordDao = new PasswordDao(sessionFactory);
    }

    @After
    public void tearDown() {
        passwordDao = null;
    }

    @Test
    public void save() {
        //Given
        Password password = new Password("12345");
        //When
        Serializable id = passwordDao.savePassword(password);
        //Then
        Session session = sessionFactory.openSession();
        Password saved = session.get(Password.class, id);
        assertNotNull(saved.getId());
        assertEquals(password.getId(), saved.getId());
    }
}
