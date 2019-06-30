package edu.mum.cs544;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Long id;
    private String schoolName;
    private String addresse;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKeyColumn(name = "studentId")
    private Map<Long, Student> students = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(Student student) {
        students.remove(student.getId());
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", addresse='" + addresse + '\'' +
                ", students=" + students +
                '}';
    }
}
