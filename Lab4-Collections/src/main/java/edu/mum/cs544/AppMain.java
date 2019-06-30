package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab4-collections");

        createAndPersistEmployee(entityManagerFactory);

        createFlightAndPersist(entityManagerFactory);

        createSchoolStudentTest(entityManagerFactory);

        entityManagerFactory.close();
    }

    private static void createSchoolStudentTest(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        School school = new School();
        school.setSchoolName("MUM");
        school.setAddresse("1000 N 4th, FF, IA");

        Student student = new Student();
        student.setName("Quy");

        Student student1 = new Student();
        student1.setName("Nguyen");

        // TODO



        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void createFlightAndPersist(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Passenger passenger1 = new Passenger();
        passenger1.setName("Quy");
        passenger1.setPassportNr("C1234567");

        Passenger passenger2 = new Passenger();
        passenger2.setName("Nguyen");
        passenger2.setPassportNr("C3456789");

        Flight flight = new Flight();
        flight.setFlightNr("UA1234");
        flight.setDeparturePlace("Narita-JP");
        flight.setArrivePlace("Houston-TX");
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);

        entityManager.persist(flight);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void createAndPersistEmployee(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee emp = new Employee();
        emp.setName("QuyNguyen");

        Laptop win = new Laptop();
        win.setCategory("LG-Gram");
        emp.addLaptop(win);

        Laptop mac = new Laptop();
        mac.setCategory("MacBook Pro");
        emp.addLaptop(mac);

        entityManager.persist(emp);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
