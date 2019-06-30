import edu.mum.cs544.Appointment;
import edu.mum.cs544.Doctor;
import edu.mum.cs544.Patient;
import edu.mum.cs544.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Doctor doctor = new Doctor();
        doctor.setDoctortype("Eyes");
        doctor.setFirstname("John");
        doctor.setLastname("Wick");

        Patient patient = new Patient();
        patient.setName("Tony Stark");
        patient.setStreet("1000 N 4th");
        patient.setCity("Fairfield, IA");
        patient.setZip("52556");

        Payment payment = new Payment();
        payment.setPaydate("07/07/2019");
        payment.setAmount(777.7);

        Appointment appointment = new Appointment();
        appointment.setAppdate("07/29/2019");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setPayment(payment);
        entityManager.persist(appointment);
        entityManager.getTransaction().commit();

        // Retrieve appointment
        entityManager.getTransaction().begin();
        TypedQuery<Appointment> query = entityManager.createQuery("from Appointment", Appointment.class);
        Appointment persistedAppointment = query.getSingleResult();
        System.out.println(persistedAppointment);
        entityManager.getTransaction().commit();


        entityManagerFactory.close();
    }

}
