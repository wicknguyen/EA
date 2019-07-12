package edu.mum.cs544;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "\"user\"")
//public class User implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(nullable = false, unique = true)
//    private String username;
//
//    private String password;
//
//    private LocalDateTime dateCreated;
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "user_authority",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
//    private Set<Authority> authorities = new HashSet<>();
//
//    public void addAutority(Authority authority){
//        authorities.add(authority);
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public LocalDateTime getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDateTime dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public User() {
//    }
//}
