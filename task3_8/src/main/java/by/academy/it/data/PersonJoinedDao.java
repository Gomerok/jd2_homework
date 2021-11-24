package by.academy.it.data;

import by.academy.it.entities.personJoined.EmployeeJ;
import by.academy.it.entities.personJoined.PersonJ;
import by.academy.it.entities.personJoined.StudentJ;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PersonJoinedDao {
    private final SessionFactory sessionFactory;

    public PersonJoinedDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonJoinedDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable savePersonJ(PersonJ person) {
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

    public Serializable saveEmployeeJ(EmployeeJ employee) {
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

    public Serializable saveStudentJ(StudentJ student) {
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

    public PersonJ getPersonJ(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            PersonJ getPerson = session.get(PersonJ.class, id);
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

    public EmployeeJ getEmployeeJ(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            EmployeeJ getEmployee = session.get(EmployeeJ.class, id);
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

    public StudentJ getStudentJ(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            StudentJ getStudent = session.get(StudentJ.class, id);
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
