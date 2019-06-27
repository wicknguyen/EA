package edu.mum.domain;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity(name = "users")

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Basic
    @Column(nullable = false)
    private String firstName;
    @Basic
    @Column(nullable = false)
    private String lastName;
    @Basic
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int rating = 0;
    @Column(name = "IS_ADMIN", length = 1)
//    @Type(type = "true_false")
    private boolean admin;

    @Version
    @Column(nullable = false)
    private int version;
    @Temporal(TemporalType.DATE)
    @Column
    private Date lastLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}
