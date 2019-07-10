package edu.mum.cs544;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDao implements IBookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getAll() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    @Override
    public void add(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book get(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void delete(int bookId) {
        entityManager.remove(entityManager.getReference(Book.class, bookId));
    }
}
