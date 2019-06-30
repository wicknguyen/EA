package edu.mum.cs544.exercise_a;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    private String deptName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public boolean addEmployee(Employee employee) {
        if (this.employees.add(employee)) {
            employee.setDepartment(this);
            return true;
        }
        return false;
    }

    public boolean removeEmployee(Employee employee) {
        if (this.employees.remove(employee)) {
            employee.setDepartment(null);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
