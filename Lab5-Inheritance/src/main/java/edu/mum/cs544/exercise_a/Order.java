package edu.mum.cs544.exercise_a;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Entity(name = "\"Order\"")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean addOrderLine(OrderLine orderLine) {
        return this.orderLines.add(orderLine);
    }

    public boolean removeOrderLine(OrderLine orderLine) {
        return this.orderLines.remove(orderLine);
    }
}
