package by.academy.it.data;

import by.academy.it.entities.personTablePerClass.EmployeeTPC;
import by.academy.it.entities.personTablePerClass.PersonTPC;
import by.academy.it.entities.personTablePerClass.StudentTPC;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PersonTablePerClassDao {

    private final SessionFactory sessionFactory;

    public PersonTablePerClassDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonTablePerClassDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable savePersonTPC(PersonTPC person) {
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

    public Serializable saveEmployeeTPC(EmployeeTPC employee) {
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

    public Serializable saveStudentTPC(StudentTPC student) {
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

    public PersonTPC getPerson(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            PersonTPC getPerson = session.get(PersonTPC.class, id);
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

    public EmployeeTPC getEmployeeTPC(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            EmployeeTPC getEmployee = session.get(EmployeeTPC.class, id);
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

    public StudentTPC getStudentTPC(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            StudentTPC getStudent = session.get(StudentTPC.class, id);
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
