package edu.mum.cs544;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Laptop> laptops = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addLaptop(Laptop laptop) {
        if (laptops.add(laptop)) {
            laptop.setOwner(this);
            return true;
        }
        return false;
    }

    public boolean removeLaptop(Laptop laptop) {
        if(laptops.remove(laptop)) {
            laptop.setOwner(null);
            return true;
        }
        return false;
    }
}
