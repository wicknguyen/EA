package edu.mum.main;


import java.util.List;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;

//@Component
public class Main {

    public static void main(String[] args) {
        // Use xml to config
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:context/applicationContext.xml");
        // Use Annotation to config.
//        ApplicationContext context = new AnnotationConfigApplicationContext(Persistence.class);
        UserService userService = context.getBean("userServiceImpl", UserService.class);

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setAdmin(true);
        user.setEmail("test@mum.edu");
        user.setRating(7);
        userService.save(user);
        System.out.println("User inserted!");

        List<User> list = userService.findAll();
        System.out.println("User count: " + list.size());

        System.out.println();
        System.out.println("        *********  USER **********");
        User readUser = list.get(0);
        System.out.println("User Name: " + readUser.getFirstName() + " " + readUser.getLastName());


        // Exercise the Merge capability
        try {
            userService.tryMergeCapability();
            EntityManagerFactory entityManagerFactory = context.getBean("entityManagerFactory", EntityManagerFactory.class);
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("###### LOAD USER ########");
            User persistedUser = entityManager.find(User.class, user.getId());
            System.out.println("###### MODIFY USER ########");
            persistedUser.setFirstName("QUY");
            System.out.println("###### UPDATE USER ########");
            persistedUser = entityManager.merge(persistedUser);
            System.out.println("###### MODIFY VERSION OF USER ########");
            entityManager.detach(persistedUser);
            persistedUser.setVersion(7);
            persistedUser = entityManager.merge(persistedUser);
            System.out.println("###### COMMIT DATA ########");
            entityManager.getTransaction().commit();
        } catch (OptimisticLockException ex) {
            // EXPECTED ERROR
            System.out.println("~~~~~~~~~ OOPS--- THERE WAS AN ERROR");
            System.out.println(ex.getCause().toString());
        }


        // Exercise the Flush/Refresh capability.
        EntityManagerFactory entityManagerFactory = context.getBean("entityManagerFactory", EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("###### LOAD USER ########");
        User persistedUser = entityManager.find(User.class, user.getId());
        System.out.println("###### MODIFY USER ########");
        persistedUser.setLastName("NGUYEN");
        System.out.println("###### FLUSH USER ########");
        entityManager.flush();
        System.out.println("###### MODIFY USER EMAIL ########");
        persistedUser.setEmail("nh.nguyen@mum.edu");
        System.out.println(persistedUser.getEmail());
        System.out.println("###### REFRESH USER ########");
        entityManager.refresh(persistedUser);
        // expect email is "test@mum.edu"
        System.out.println(persistedUser.getEmail());
        entityManager.getTransaction().commit();

    }

}
