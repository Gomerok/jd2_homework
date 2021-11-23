package by.academy.it.data;

import by.academy.it.entities.personSingleTable.Employee;
import by.academy.it.entities.personSingleTable.Person;
import by.academy.it.entities.personSingleTable.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PersonSingleTableDao {
    private final SessionFactory sessionFactory;

    public PersonSingleTableDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonSingleTableDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            Serializable id = session.save(person);
            transaction.commit();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Serializable saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            Serializable id = session.save(employee);
            transaction.commit();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Serializable saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            Serializable id = session.save(student);
            transaction.commit();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Person getPerson(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
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

    public Person getEmployee(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            Person getEmployee = session.get(Employee.class, id);
            if (getEmployee != null) {
                return getEmployee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Person getStudent(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            Person getStudent = session.get(Student.class, id);
            if (getStudent != null) {
                return getStudent;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

}
