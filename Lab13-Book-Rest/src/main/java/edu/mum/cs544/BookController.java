package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


//@Controller
//public class BookController {
//
//    @Autowired
//    private IBookService bookService;
//
//    @GetMapping("/")
//    public String redirectRoot() {
//        return "redirect:/books";
//    }
//
//    @GetMapping("/books")
//    public String getBookList(Model model) {
//        model.addAttribute("books", bookService.getAll());
//        return "bookList";
//    }
//
//    @GetMapping("book/add")
//    public String viewAddPage(Model model) {
//        if (!model.containsAttribute("book")) {
//            model.addAttribute("book", new Book());
//        }
//        model.addAttribute("msg", "Add");
//        return "bookDetail";
//    }
//
//    @PostMapping("book")
//    public String add(@Valid Book book, BindingResult result, RedirectAttributes redirectAttributes) {
////        if (result.hasErrors()) {
////           return "bookDetail";
////        }
//        if (result.hasErrors()) {
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
//            redirectAttributes.addFlashAttribute("book", book);
//            return "redirect:/book/add";
//        }
//        bookService.add(book);
//        return "redirect:/books";
//    }
//
//    @GetMapping("book/{id}")
//    public String get(@PathVariable int id, Model model) {
//        if (!model.containsAttribute("book")) {
//            model.addAttribute("book", bookService.get(id));
//        }
//        model.addAttribute("msg", "Update");
//        return "bookDetail";
//    }
//
//    @PostMapping("book/{id}")
//    public String update(@Valid Book book, BindingResult result, @PathVariable int id, RedirectAttributes redirectAttributes) {
////        if (result.hasErrors()) {
////            return "bookDetail";
////        }
//        if (result.hasErrors()) {
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
//            redirectAttributes.addFlashAttribute("book", book);
//            return "redirect:/book/{id}";
//        }
//        bookService.update(book);
//        return "redirect:/books";
//    }
//
//    @PostMapping(value="/book/delete")
//    public String delete(int bookId) {
//        bookService.delete(bookId);
//        return "redirect:/books";
//    }



//}
