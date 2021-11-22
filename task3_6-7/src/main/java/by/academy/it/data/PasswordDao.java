package by.academy.it.data;

import by.academy.it.entities.Password;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PasswordDao {
    private final SessionFactory sessionFactory;

    public PasswordDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    public PasswordDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable savePassword(Password password) {
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            Serializable id = session.save(password);
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
