package by.academy.it.loader;

import by.academy.it.pojos.Person;
import by.academy.it.util.HibernateUtil;

import javax.persistence.EntityManager;

public class PersonLoader {
    public static void main(String[] args){
        Person person = new Person(null, 35,"Petrov","Ivan");
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        HibernateUtil.close();
    }
}
