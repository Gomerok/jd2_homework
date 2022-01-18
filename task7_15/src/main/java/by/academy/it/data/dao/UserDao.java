package by.academy.it.data.dao;

import by.academy.it.data.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void create(User user);

    Optional<User> read(Long id);

    List<User> readAll();

    void update(User user);

    void delete(User user);
}
