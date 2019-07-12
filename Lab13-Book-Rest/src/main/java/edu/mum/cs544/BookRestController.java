package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id) {
        Book b =  bookService.get(id);
        b.getAuthor();
        return b;
    }

    @PostMapping("/books")
    public RedirectView add(@RequestBody Book book) {
        bookService.add(book);
        return new RedirectView("/books/" + book.getId());
    }

    @PutMapping("/books/{id}")
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

}
