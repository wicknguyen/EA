package edu.mum.cs544;

import java.util.List;

public interface IBookDao {

    List<Book> getAll();
    void add(Book book);
    Book get(int bookId);
    void update(Book book);
    void delete(int bookId);
}
