package edu.mum.cs544;

import java.util.List;

public interface IBookService {
    Book get(Long id);
    List<Book> getAll();
    Long add(Book p);
    void update(Book p);
    void delete(Long id);
}
