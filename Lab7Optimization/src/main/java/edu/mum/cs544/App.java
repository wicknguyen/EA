package edu.mum.cs544;

import java.util.List;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
//        TypedQuery<Owner> query = em.createQuery("select o from Owner o " +
//                "join fetch o.pets", Owner.class);

        EntityGraph<Owner> entityGraph = em.createEntityGraph(Owner.class);
        entityGraph.addAttributeNodes("pets");
        query.setHint("javax.persistence.fetchgraph",entityGraph);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);

        // Without optimizer 228594 milliseconds.
        // @LazyCollection 229503 milliseconds.
        // BatchSize 5 - 53389 milliseconds, 10 - 30129 milliseconds, 50 - 13651 milliseconds.
        // FetchMode.SUBSELECT 10182 milliseconds.
        // Join fetch 13803 milliseconds.
        // Entity Graph 15780 milliseconds.
        //==> SubSelect, BatchSIze(50) and JoinFetch  are OK
    }

}
