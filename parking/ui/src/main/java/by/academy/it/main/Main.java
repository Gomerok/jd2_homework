package by.academy.it.main;

import by.academy.it.controller.Printer;
import by.academy.it.data.Ticket;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
       Ticket ticket = printer.printTicket("ddd","ddd");
        System.out.println(ticket);
        System.out.println(ticket);
        System.out.println(ticket);


    }

}
