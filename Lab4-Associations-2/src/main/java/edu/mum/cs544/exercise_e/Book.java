package edu.mum.cs544.exercise_e;

import javax.persistence.*;

@Entity(name = "BookE")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String bookName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Reservation reservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", reservation=" + reservation +
                '}';
    }
}
