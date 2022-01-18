package by.academy.it.main;

import by.academy.it.config.SpringConfig;
import by.academy.it.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(context.getBean(UserService.class).getPerson());
        System.out.println(context.getBean(UserService.class).getMessage());
        context.close();
    }
}
