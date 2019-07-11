package edu.mum.cs544;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao extends JpaRepository<Book, Integer> {

//    List<Book> getAll();
//    void add(Book book);
//    Book get(int bookId);
//    void update(Book book);
//    void delete(int bookId);
}
