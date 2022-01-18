package by.academy.it.service;

import by.academy.it.data.dao.UserDao;
import by.academy.it.data.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(User user) {
        userDao.create(user);
    }

    public User getUser(Long id) {
        return userDao.read(id).orElseThrow(RuntimeException::new);
    }

    public List<User> readAllUsers() {
        return userDao.readAll();
    }

    public User updateUser(User user) {
        userDao.update(user);
        return getUser(user.getId());
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
