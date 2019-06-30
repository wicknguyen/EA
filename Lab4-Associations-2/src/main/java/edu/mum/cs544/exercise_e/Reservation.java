package edu.mum.cs544.exercise_e;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "ReservationE")
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String reservationNr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationNr() {
        return reservationNr;
    }

    public void setReservationNr(String reservationNr) {
        this.reservationNr = reservationNr;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationNr='" + reservationNr + '\'' +
                '}';
    }
}
