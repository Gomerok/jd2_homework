package by.academy.it.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryHolder {

    private static SessionFactory sessionFactory;

    private SessionFactoryHolder() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry reg =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml") // hibernate-test.cfg.xml
                            .build();
            sessionFactory = new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}

