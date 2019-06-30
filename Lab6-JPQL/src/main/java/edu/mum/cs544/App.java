package edu.mum.cs544;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Flight;

import java.text.DateFormat;
import java.util.Locale;

import javax.persistence.*;
import javax.swing.text.DateFormatter;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // a) TODO: Flights leaving USA capacity > 500
        System.out.println("Question A:");
        List<Flight> flights = em.createQuery("select f from Flight f " +
                "inner join Airplane a on a.id = f.airplane " +
                "where a.capacity > 500", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // b) TODO: All airlines that use A380 airplanes
        System.out.println("Question B:");
        List<Airline> airlines = em.createQuery("select distinct l from Airline l " +
                "inner join Flight f on f.airline = l.id " +
                "inner join Airplane a on a.id = f.airplane " +
                "where a.model = 'A380'", Airline.class).getResultList();
        System.out.println("Airlines that use A380s:");
        for (Airline airline : airlines) {
            System.out.println(airline.getName());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // c) TODO: Flights using 747 planes that don't belong to Star Alliance
        System.out.println("Question C:");
        flights = em.createQuery("select f from Flight f " +
                "inner join Airline l on l.id = f.airline " +
                "inner join Airplane a on a.id = f.airplane " +
                "where a.model = '747' and l.name <> 'Star Alliance'", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);

        // d) TODO: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D:");
        TypedQuery<Flight> query = em.createQuery("from Flight f " +
                "where f.departureDate = :dateLeave " +
                "and f.departureTime < :timeLeave", Flight.class);
        Date dateLeave = df.parse("08/07/2009");
        Date timeLeave = tf.parse("12:00 pm");

        System.out.println(dateLeave);
        System.out.println(timeLeave);

        query.setParameter("dateLeave", dateLeave, TemporalType.DATE);
        query.setParameter("timeLeave", timeLeave, TemporalType.TIME);
        flights = query.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:","Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();
        em.getTransaction().commit();
        em.close();
    }
}
