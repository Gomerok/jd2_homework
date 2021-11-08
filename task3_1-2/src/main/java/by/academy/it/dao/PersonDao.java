package by.academy.it.dao;

import by.academy.it.pojos.Person;
import by.academy.it.util.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.FlushModeType;
import java.io.Serializable;

public class PersonDao {
    private final SessionFactory sessionFactory;

    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) {
            session.flush();
        }
        session.setFlushMode(FlushModeType.AUTO);
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public void deletePerson(Person person) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        session.setFlushMode(FlushModeType.AUTO);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public Person loadPerson(int id) {
        Session session = sessionFactory.openSession();
        try {
            if (session.isDirty()) session.flush();
            session.setFlushMode(FlushModeType.AUTO);
            Person loadPerson = session.load(Person.class, id);
            if (loadPerson != null) {
                return loadPerson;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Person getPerson(int id) {
        Session session = sessionFactory.openSession();
        try {
            if (session.isDirty()) session.flush();
            session.setFlushMode(FlushModeType.AUTO);
            Person getPerson = session.get(Person.class, id);
            if (getPerson != null) {
                return getPerson;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
