package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.util.EntityManagerHelper;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JPAAccountDAO implements IAccountDAO {
    @Override
    public void saveAccount(Account account) {
        EntityManager entityManager = EntityManagerHelper.getCurrent();
        entityManager.persist(account);
    }

    @Override
    public void updateAccount(Account account) {
        EntityManager entityManager = EntityManagerHelper.getCurrent();
        entityManager.merge(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {
        EntityManager entityManager = EntityManagerHelper.getCurrent();
        EntityGraph<Account> graph = entityManager.createEntityGraph(Account.class);
        graph.addAttributeNodes("customer");
        graph.addAttributeNodes("entryList");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", graph);
        return entityManager.find(Account.class, accountnumber, properties);
    }

    @Override
    public Collection<Account> getAccounts() {
        EntityManager entityManager = EntityManagerHelper.getCurrent();
        return entityManager.createQuery("select distinct a from Account a join fetch a.entryList join fetch a.customer", Account.class).getResultList();
    }
}
