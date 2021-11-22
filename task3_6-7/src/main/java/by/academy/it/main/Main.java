package by.academy.it.main;

import by.academy.it.data.CustomerDao;
import by.academy.it.data.OrderDao;
import by.academy.it.data.PasswordDao;
import by.academy.it.entities.Address;
import by.academy.it.entities.Customer;
import by.academy.it.entities.Order;
import by.academy.it.entities.Password;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Запуск программы: java -jar D:\work\task3_6-7\target\Main.jar
        final CustomerDao customerDao = new CustomerDao();
        final OrderDao orderDao = new OrderDao();
        final PasswordDao passwordDao = new PasswordDao();
        Address address = new Address("minsk", "1111111");
        Customer customer = new Customer("sasha", "dd@gmail.com", address);
        customerDao.saveCustomer(customer);
        System.out.println(customer.getId());

        Order order = new Order("sasha", new Date());
        orderDao.saveOrder(order);
        System.out.println(order.getId());

        Password password = new Password("12345");
        passwordDao.savePassword(password);
        System.out.println(password.getId());


    }
}
