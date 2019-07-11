package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    @Override
    public void add(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book get(int bookId) {
        return bookDao.findById(bookId).get();
        // this cause EXCEPTION: org.hibernate.LazyInitializationException: could not initialize proxy [edu.mum.cs544.Book#1] - no Session
        // ==> there is no session to load data for book because getOne return proxy book.
//        return bookDao.getOne(bookId);
    }

    @Override
    public void update(Book book) {
        bookDao.save(book);
    }

    @Override
    public void delete(int bookId) {
        bookDao.deleteById(bookId);
    }
}
