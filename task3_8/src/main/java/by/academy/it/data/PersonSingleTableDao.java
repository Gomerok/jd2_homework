package by.academy.it.data;

import by.academy.it.entities.personSingleTable.EmployeeST;
import by.academy.it.entities.personSingleTable.PersonST;
import by.academy.it.entities.personSingleTable.StudentST;
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

    public Serializable savePersonST(PersonST person) {
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

    public Serializable saveEmployeeST(EmployeeST employee) {
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

    public Serializable saveStudentST(StudentST student) {
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

    public PersonST getPersonST(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            PersonST getPerson = session.get(PersonST.class, id);
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

    public EmployeeST getEmployee(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            EmployeeST getEmployee = session.get(EmployeeST.class, id);
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

    public StudentST getStudentST(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            StudentST getStudent = session.get(StudentST.class, id);
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
