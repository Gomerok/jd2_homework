package by.academy.it.main;

import by.academy.it.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);
        System.out.println("Bicycle exclude: " + Arrays.stream(beanNames).noneMatch(name -> name.equals("bicycle")));
        context.close();
    }
}
