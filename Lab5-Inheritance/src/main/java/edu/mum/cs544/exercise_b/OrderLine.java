package edu.mum.cs544.exercise_b;

import javax.persistence.*;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
