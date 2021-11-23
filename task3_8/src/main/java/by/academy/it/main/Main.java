package by.academy.it.main;

import by.academy.it.data.PersonJoinedDao;
import by.academy.it.entities.personJoined.Person;

public class Main {
    public static void main(String[] args) {
        //Запуск программы: java -jar D:\work\task3_6-7\target\Main.jar
        final PersonJoinedDao personJoinedDao = new PersonJoinedDao();

        Person person = new Person("name","email");

        personJoinedDao.savePerson(person);
        System.out.println(person.getId());
        Person saved = personJoinedDao.getPerson(person.getId());
        System.out.println(saved.getId()+" "+saved.getName());
    }
}
