package by.academy.it.dao;

import by.academy.it.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.junit.*;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonDaoTest {
    static SessionFactory sessionFactory;
    PersonDao personDao;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.test.cfg.xml") // hibernate-test.cfg.xml
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDao(sessionFactory);
    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
    }

    @Test
    public void savePersonTest() {
        //Given
        Person person = new Person("Sergey", "Anochin", 27);

        //When
        Serializable id = personDao.savePerson(person);

        //Then
        assertEquals(1, id);
        personDao.deletePerson(person);
    }

    @Test
    public void deletePersonTest() {
        Person person = new Person("Vasy", "Pupkin", 25);
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        Person deletePerson = null;
        try {
            tr = session.beginTransaction();
            personDao.savePerson(person);
            List<Person> personList =
                    session.createQuery("from Person", Person.class).list();
            deletePerson = personList.get(personList.size() - 1);
            session.delete(deletePerson);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        }
        Assert.assertNull(session.get(Person.class, person.getId()));
    }

    @Test
    public void loadPerson() {
        Person person = new Person("Name", "Surname", 21);
        personDao.savePerson(person);
        Person personLoad =  personDao.loadPerson(3);
        personDao.deletePerson(person);
        Assert.assertNotNull(personLoad);
    }

    @Test
    public void getPerson() {
        Person person = new Person("Ivan", "Ivanov", 24);
        personDao.savePerson(person);
        Person personGet = personDao.getPerson(4);
        personDao.deletePerson(person);
        Assert.assertEquals(person, personGet);
    }
}