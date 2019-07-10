package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBookList(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }

    @GetMapping("book/add")
    public String viewAddPage(@ModelAttribute Book book, Model model) {
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @PostMapping("book")
    public String add(Book book) {
        bookService.add(book);
        return "redirect:/books";
    }

    @GetMapping("book/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.get(id));
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PostMapping("book/{id}")
    public String update(Book book, @PathVariable int id) {
        bookService.update(book);
        return "redirect:/books";
    }

    @PostMapping(value="/book/delete")
    public String delete(int bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }



}
