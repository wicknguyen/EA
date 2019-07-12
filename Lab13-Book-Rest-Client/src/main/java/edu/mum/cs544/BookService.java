package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookService implements IBookService {

    @Autowired
    private RestTemplate restTemplate;

    private final String ONE_BOOK_URL = "http://localhost:8080/books/{id}";
    private final String ALL_BOOK_URL = "http://localhost:8080/books";


    @Override
    public Book get(Long id) {
        return restTemplate.getForObject(ONE_BOOK_URL, Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        ResponseEntity<List<Book>> response =
                restTemplate.exchange(ALL_BOOK_URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Book>>() {});
        return response.getBody();
    }

    @Override
    public Long add(Book b) {
        URI uri = restTemplate.postForLocation(ALL_BOOK_URL, b);
        if (uri == null) {
            return null;
        }
        Matcher m = Pattern.compile(".*/books/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
    }

    @Override
    public void update(Book b) {
        restTemplate.put(ONE_BOOK_URL, b, b.getId());
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(ONE_BOOK_URL, id);
    }
}
