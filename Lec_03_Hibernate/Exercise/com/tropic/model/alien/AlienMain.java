package com.tropic.model.alien;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AlienMain {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(com.tropic.model.alien.Alien.class)
                .addAnnotatedClass(com.tropic.model.alien.Laptop.class)
                .addAnnotatedClass(com.tropic.model.alien.Car.class)
                .configure()
                .buildSessionFactory();

        createAlienTableToDataBase(sessionFactory);
        loadAlienFromDatabase(sessionFactory);
        //deleteAlienFromDatabase(sessionFactory);
    }

    private static void createAlienTableToDataBase(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession()) {
            Laptop laptopOne = new Laptop(1, "acer", "nitro v5", 16);
            Laptop laptopTwo = new Laptop(2, "asus", "republic of gamers", 8);

            Car car = new Car(1,"honda");
            Alien alien = Alien.builder()
                    .setAid(2)
                    .setAname("koki")
                    .setTech("programming")
                    .setCar(car)
                    .setLaptops(List.of(laptopOne, laptopTwo))
                    .build();

            laptopOne.setAlien(alien);
            laptopTwo.setAlien(alien);

            Transaction transaction = session.beginTransaction();
            session.persist(alien);
            session.persist(car);
            session.persist(laptopOne);
            session.persist(laptopTwo);
            transaction.commit();
        }
    }

    private static void deleteAlienFromDatabase(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Alien alienToBeDeleted = session.find(Alien.class, 2);
            session.remove(alienToBeDeleted);
            transaction.commit();
        }
    }

    private static void loadAlienFromDatabase(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession()) {
            Alien loadedAlien = session.find(Alien.class, 2);
            System.out.println(loadedAlien);
        }
    }
}
