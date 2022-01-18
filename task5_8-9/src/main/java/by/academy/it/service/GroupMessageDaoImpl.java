package by.academy.it.service;

import org.springframework.stereotype.Component;

@Component("groupMessage")
public class GroupMessageDaoImpl implements MessageDao{

    @Override
    public String getMessage() {
        return "group message";
    }
}
