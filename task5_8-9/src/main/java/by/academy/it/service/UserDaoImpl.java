package by.academy.it.service;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public String getUser() {
        return "User";
    }
}
