package by.academy.it.service;

import org.springframework.stereotype.Component;

@Component("friendMessage")
public class FriendMessageDao implements MessageDao{

    @Override
    public String getMessage() {
        return "friend message";
    }
}
