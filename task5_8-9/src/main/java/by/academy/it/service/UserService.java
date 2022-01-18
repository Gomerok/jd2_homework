package by.academy.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao useDao;

    @Autowired
    @Qualifier("friendMessage")
    MessageDao messageDao;

    public String getPerson(){
        return useDao.getUser();
    }

    public String getMessage(){
        return messageDao.getMessage();
    }
}
