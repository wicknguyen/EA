import edu.mum.cs544.exercise_b.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        testExerciseA(entityManager);
        testExerciseB(entityManager);

        entityManagerFactory.close();
    }

    private static void testExerciseA(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        edu.mum.cs544.exercise_a.Product product = new edu.mum.cs544.exercise_a.Product();
        product.setName("LG-Monitor");
        product.setDescription("Monitor 27-inch, FullHD");

        edu.mum.cs544.exercise_a.OrderLine orderLine = new edu.mum.cs544.exercise_a.OrderLine();
        orderLine.setProduct(product);
        orderLine.setQuantity(1);

        edu.mum.cs544.exercise_a.Order order = new edu.mum.cs544.exercise_a.Order();
        order.setDate(LocalDate.now());
        order.addOrderLine(orderLine);

        edu.mum.cs544.exercise_a.Customer customer = new edu.mum.cs544.exercise_a.Customer();
        customer.addOrder(order);
        customer.setFirstName("Quy");
        customer.setLastName("Nguyen");

        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        TypedQuery<edu.mum.cs544.exercise_a.Customer> query = entityManager.createQuery("from Customer ", edu.mum.cs544.exercise_a.Customer.class);
        List<edu.mum.cs544.exercise_a.Customer> resultList = query.getResultList();
        System.out.println(resultList.size());
        entityManager.getTransaction().commit();
    }

    private static void testExerciseB(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        CD product1 = new CD();
        product1.setName("Maroon5 Album");
        product1.setDescription("Maroon 5 Album 2019");
        product1.setArtist("Maroon 5");

        OrderLine orderLine1 = new OrderLine();
        orderLine1.setProduct(product1);
        orderLine1.setQuantity(1);

        DVD product2 = new DVD();
        product2.setName("John Wick chapter 3");
        product2.setDescription("John Wick chapter 3 - 2019");
        product2.setGenre("Action");

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setProduct(product2);
        orderLine2.setQuantity(3);

        Book product3 = new Book();
        product3.setName("Enterprise Architecture book");
        product3.setDescription("High-Performance Java Persistence (Vlad Mihalcea) - 2019");
        product3.setTitle("High-Performance Java Persistence");

        OrderLine orderLine3 = new OrderLine();
        orderLine3.setProduct(product3);
        orderLine3.setQuantity(3);

        Order order = new Order();
        order.setDate(LocalDate.now());
        order.addOrderLine(orderLine1);
        order.addOrderLine(orderLine2);
        order.addOrderLine(orderLine3);

        Customer customer = new Customer();
        customer.addOrder(order);
        customer.setFirstName("Quy");
        customer.setLastName("Nguyen");

        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        TypedQuery<Customer> query = entityManager.createQuery("from Customer ", Customer.class);
        List<Customer> resultList = query.getResultList();
        System.out.println(resultList.size());
        entityManager.getTransaction().commit();
    }
}
