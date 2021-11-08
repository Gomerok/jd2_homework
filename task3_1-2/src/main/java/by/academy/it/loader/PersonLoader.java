package by.academy.it.loader;

import by.academy.it.dao.PersonDao;
import by.academy.it.pojos.Person;
import by.academy.it.util.HibernateUtil;

import javax.persistence.EntityManager;

public class PersonLoader {
    public static void main(String[] args) {
        //Task1
        Person person = new Person("Petrov", "Ivan", 35);
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        HibernateUtil.close();


        //Task2
        Person pr1 = new Person("Name1", "Surname1", 20);
        Person pr2 = new Person("Name2", "Surname2", 21);
        Person pr3 = new Person("Name3", "Surname3", 22);
        PersonDao personDao = new PersonDao();
        personDao.savePerson(pr1);
        personDao.savePerson(pr2);
        personDao.savePerson(pr3);
        personDao.deletePerson(pr2);

        Person personGet = personDao.getPerson(1);
        Person personGetNull = personDao.getPerson(100);
        Person personLoad = personDao.loadPerson(1);
        Person personLoadNull = personDao.loadPerson(100);
        System.out.println("personGetId = "+personGet);
        System.out.println("personGetNullId = "+personGetNull);

    }
}
