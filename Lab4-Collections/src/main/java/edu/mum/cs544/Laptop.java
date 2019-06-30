package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Laptop {

    @Id
    @GeneratedValue
    private Long id;
    private String category;

    @ManyToOne
    private Employee owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return getId().equals(laptop.getId()) &&
                getCategory().equals(laptop.getCategory()) &&
                getOwner().equals(laptop.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getOwner());
    }
}
