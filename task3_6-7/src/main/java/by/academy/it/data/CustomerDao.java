package by.academy.it.data;

import by.academy.it.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class CustomerDao {
    private final SessionFactory sessionFactory;

    public CustomerDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    public CustomerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable saveCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            Serializable id = session.save(customer);
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
}
