package edu.mum.cs544;

import edu.mum.cs544.exercise_a.Department;
import edu.mum.cs544.exercise_a.Employee;
import edu.mum.cs544.exercise_b.Book;
import edu.mum.cs544.exercise_b.Publisher;
import edu.mum.cs544.exercise_c.Course;
import edu.mum.cs544.exercise_c.Student;
import edu.mum.cs544.exercise_d.Customer;
import edu.mum.cs544.exercise_f.Office;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab4-association-2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        testExerciseA(entityManager);
        testExerciseB(entityManager);
        testExerciseC(entityManager);
        testExerciseD(entityManager);
        testExerciseE(entityManager);
        testExerciseF(entityManager);

        entityManagerFactory.close();
    }

    private static void testExerciseF(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Office office = new Office();
        office.setOfficeName("IT");
        edu.mum.cs544.exercise_f.Employee emp1 = new edu.mum.cs544.exercise_f.Employee();
        emp1.setName("Quy");
        edu.mum.cs544.exercise_f.Employee emp2 = new edu.mum.cs544.exercise_f.Employee();
        emp2.setName("Nguyen");

        office.addEmployee(emp1);
        office.addEmployee(emp2);

        entityManager.persist(emp1);
        entityManager.persist(emp2);
        entityManager.getTransaction().commit();

        // Retrieve
        entityManager.getTransaction().begin();
        Office result = entityManager.createQuery("from Office", Office.class).getSingleResult();
        System.out.println(result);
        entityManager.getTransaction().commit();
    }

    private static void testExerciseE(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        edu.mum.cs544.exercise_e.Reservation reservation = new edu.mum.cs544.exercise_e.Reservation();
        reservation.setReservationNr("111");

        edu.mum.cs544.exercise_e.Book book1 = new edu.mum.cs544.exercise_e.Book();
        book1.setBookName("Pro Spring");
        book1.setReservation(reservation);
        edu.mum.cs544.exercise_e.Book book2 = new edu.mum.cs544.exercise_e.Book();
        book2.setBookName("Spring Microservices");
        book2.setReservation(reservation);
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.getTransaction().commit();
        // Retrieve
        entityManager.getTransaction().begin();
        List<edu.mum.cs544.exercise_e.Book> books = entityManager.createQuery("from BookE", edu.mum.cs544.exercise_e.Book.class).getResultList();
        books.forEach(b -> {
            System.out.println(b);
        });
        entityManager.getTransaction().commit();
    }

    private static void testExerciseD(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Customer customer = new Customer();
        customer.setName("Quy");
        edu.mum.cs544.exercise_d.Reservation reservation = new edu.mum.cs544.exercise_d.Reservation();
        reservation.setReservationNr("RE-1");
        customer.addReservation(reservation);
        edu.mum.cs544.exercise_d.Reservation reservation2 = new edu.mum.cs544.exercise_d.Reservation();
        reservation2.setReservationNr("RE-2");
        customer.addReservation(reservation2);
        entityManager.persist(customer);

        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        System.out.println(entityManager.createQuery("from Customer", Customer.class).getSingleResult());
        entityManager.getTransaction().commit();
    }

    private static void testExerciseC(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Student student1 = new Student();
        student1.setName("Quy");

        Student student2 = new Student();
        student2.setName("Wick");

        Course ea = new Course();
        ea.setCourseName("Enterprise Architecture");

        Course ml = new Course();
        ml.setCourseName("Machine Learning");

        student1.addCourse(ea);
        student1.addCourse(ml);

        student2.addCourse(ml);

        entityManager.persist(student1);
        entityManager.persist(student2);

        entityManager.getTransaction().commit();

        // Retrieve
        entityManager.getTransaction().begin();
        List<Student> students = entityManager.createQuery("from Student", Student.class).getResultList();
        students.forEach(s -> {
            System.out.println(s);
        });
        entityManager.getTransaction().commit();
    }

    private static void testExerciseB(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Book book1 = new Book();
        book1.setTitle("Pro Spring");
        book1.setISBN("1234");
        book1.setPrice(77.7);
        entityManager.persist(book1);

        Book book2 = new Book();
        book2.setTitle("Spring Microservices");
        book2.setISBN("777777");
        book2.setPrice(777.7);

        Publisher publisher = new Publisher();
        publisher.setName("Quy Nguyen");
        book2.setPublisher(publisher);

        entityManager.persist(book2);
        entityManager.getTransaction().commit();

        // Retrieve
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("from Book", Book.class).getResultList();
        books.forEach(b -> {
            System.out.println(b);
        });
        entityManager.getTransaction().commit();
    }

    private static void testExerciseA(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Department department = new Department();
        department.setDeptName("IT Help desk");

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setName("Wick Nguyen");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        // Retrieve
        entityManager.getTransaction().begin();
        System.out.println(entityManager.createQuery("from Employee", Employee.class).getSingleResult());
        entityManager.getTransaction().commit();
    }
}
