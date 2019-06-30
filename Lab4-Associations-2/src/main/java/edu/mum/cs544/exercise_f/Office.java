package edu.mum.cs544.exercise_f;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Office {

    @Id
    @GeneratedValue
    private Long id;
    private String officeName;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public boolean addEmployee(Employee employee) {
        if (employees.add(employee)) {
            employee.setOffice(this);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(Employee employee) {
        if (employees.remove(employee)) {
            employee.setOffice(null);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", officeName='" + officeName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
