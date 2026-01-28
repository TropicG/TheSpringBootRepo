package com.tropic.model.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMain {

    public static void main(String[] args) {

        // reading information from hibernate.cfg.xml, Hibernate finds the database URL, password and username
        // It scans the Student class, sees the annotations and checks if the database scheme matches (or creates it if hbm2ddl.auto is set)
        // It creates a Connection Pool to the database
        // Creation Pool is a cache of database connections that are kop open and ready to use, since connecting to database is a expensive operation
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        saveDataToDatabase(sessionFactory);
        loadDataFromDatabase(sessionFactory);
        updateDataFromDatabase(sessionFactory);
        deleteDataFromDatabase(sessionFactory);

        sessionFactory.close();
    }

    private static void saveDataToDatabase(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession()) {
            Student studentO = Student.builder()
                    .setSname("koko")
                    .setsAge(24)
                    .setRollNo(82128)
                    .build();

            // Since communication with the database is expensive operation
            // CRUD operations are saved in a buffer space (transaction) and after that are send to the database as a whole
            Transaction transaction = session.beginTransaction();
            // adds the object to LV1 cache, if it is not in the database yet
            session.persist(studentO);
            // Flushes every operation done in this session as one SQL query
            transaction.commit();
        }
    }

    private static void loadDataFromDatabase(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession()) {
            // first checks LV1 cache, to see is this object loaded already, if it is not there it generates an SQL query
            // After that Hibernate takes it and generates it into Java Object
            Student student = session.find(Student.class, 82128);
            System.out.println(student);
        }
    }

    private static void updateDataFromDatabase(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.find(Student.class, 24052006);
            student.setsAge(3);
            session.merge(student);
            transaction.commit();
        }
    }

    private static void deleteDataFromDatabase(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student studentToRemove = session.find(Student.class, 82128);
            session.remove(studentToRemove);
            transaction.commit();
        }
    }
}
