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
        return bookDao.getAll();
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public Book get(int bookId) {
        return bookDao.get(bookId);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(int bookId) {
        bookDao.delete(bookId);
    }
}
