package by.academy.it.data;

import by.academy.it.pojo.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.List;

public class PersonDaoTest {
    PersonDao personDao;

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void savePerson() {
        Person person = new Person();
        person.setId(1001);
        person.setName("Sergey");
        person.setSecondName("Anochin");

        //When
        Serializable id = personDao.savePerson(person);

        //Then
        assertEquals(1001L, id);
        List<Person> list = personDao.readPersons();
        assertEquals(list.size(), 1);
        personDao.deletePersons(list.get(0));


    }
}