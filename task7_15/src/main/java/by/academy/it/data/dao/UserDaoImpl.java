package by.academy.it.data.dao;

import by.academy.it.data.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("taskSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    @Transactional
    public Optional<User> read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Optional<User> optionalUser;
        User user = session.get(User.class, id);
        if (user != null) {
            optionalUser = Optional.of(user);
        } else {
            throw new RuntimeException("user with this id does not exist");
        }
        return optionalUser;
    }

    @Override
    @Transactional
    public List<User> readAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User", User.class).list();
    }

    @Override
    @Transactional
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }
}
