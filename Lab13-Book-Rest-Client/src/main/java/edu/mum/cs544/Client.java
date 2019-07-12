package edu.mum.cs544;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Client implements CommandLineRunner {
    @Autowired
    private IBookService bookService;

    public void run(String... args) {
        // get all()
        System.out.println(bookService.getAll());

        Book b = new Book();
        b.setAuthor("Josh Long");
        b.setISBN("978-0-306-40615-7");
        b.setPrice(77.7);
        b.setTitle("Spring");
        b.setPublishedDate(new Date());
        bookService.add(b);
        System.out.println(bookService.getAll());
        b.setAuthor("updated");
        bookService.update(b);
        bookService.delete(1L);
        System.out.println(bookService.getAll());
        System.out.println(bookService.get(2L));
    }
}
