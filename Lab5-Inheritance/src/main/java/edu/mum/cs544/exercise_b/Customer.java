package edu.mum.cs544.exercise_b;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean addOrder(Order order) {
        if (this.orders.add(order)) {
            order.setCustomer(this);
            return true;
        }
        return false;
    }

    public boolean removeOrder(Order order) {
        if (this.orders.remove(order)) {
            order.setCustomer(null);
            return true;
        }
        return false;
    }
}
