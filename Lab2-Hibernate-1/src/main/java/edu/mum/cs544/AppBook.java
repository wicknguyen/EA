package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppBook {

    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create 3 books and save them to the database
        Book book1 = new Book("Pro Spring", "SDA231", "Chris Schaefer", 45.5, new Date());
        em.persist(book1);
        Book book2 = new Book("Spring Microservices", "HOO100", "Rajesh RV", 50.3, new Date());
        em.persist(book2);
        Book book3 = new Book("High Performance Java Persistence", "HOO100", "Vlad Mihalcea", 70.3, new Date());
        em.persist(book3);

        em.getTransaction().commit();
        em.close();

        // Retrieve all books and put to the console
        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all books
        List<Book> books = getAllBooks(em);
        for (Book book : books) {
            printToConsole(book);
        }
        em.getTransaction().commit();
        em.close();

        //Change title and price one book and delete another one.
        em = emf.createEntityManager();
        em.getTransaction().begin();

        books = getAllBooks(em);
        Iterator<Book> iterator = books.iterator();

        Book modifiedBook = iterator.next();
        modifiedBook.setTitle("Getting Started With Spring Framework");
        modifiedBook.setPrice(77.7);

        Book deletedBook = iterator.next();
        em.remove(deletedBook);

        em.getTransaction().commit();
        em.close();


        // retieve all books
        em = emf.createEntityManager();
        em.getTransaction().begin();
        books = getAllBooks(em);
        for (Book book : books) {
            printToConsole(book);
        }
        em.getTransaction().commit();
        em.close();

    }

    private static void printToConsole(Book book) {
        System.out.println("title= " + book.getTitle() + ", author= "
                + book.getAuthor() + ", price= " + book.getPrice());
    }

    private static List<Book> getAllBooks(EntityManager em) {
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        return query.getResultList();
    }
}
