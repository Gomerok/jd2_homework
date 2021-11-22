package by.academy.it.data;

import by.academy.it.entities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class OrderDao {

    private final SessionFactory sessionFactory;

    public OrderDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    public OrderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable saveOrder(Order order) {
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            Serializable id = session.save(order);
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
