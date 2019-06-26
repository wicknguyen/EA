package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("simpsons");

        // Retrieve all students
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Students> students = getAllStudents(em);
        for (Students student : students) {
            printToConsole(student);
        }
        em.getTransaction().commit();
        em.close();

        //Add an extra student
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Students newStudent = new Students(7, "QuyNguyen", "u", "p");
        em.persist(newStudent);

        em.getTransaction().commit();
        em.close();


        // retieve all students
        em = emf.createEntityManager();
        em.getTransaction().begin();
        students = getAllStudents(em);
        for (Students student : students) {
            printToConsole(student);
        }
        em.getTransaction().commit();
        em.close();

    }

    private static void printToConsole(Students students) {
        System.out.println("Student name : " + students.getName());
    }

    private static List<Students> getAllStudents(EntityManager em) {
        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        return query.getResultList();
    }
}
