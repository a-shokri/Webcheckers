package com.webcheckers.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
import org.hibernate.annotations.OptimisticLockType;
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true, optimisticLock = OptimisticLockType.DIRTY)
@Table(name = "Player")
public class HumanPlayer implements Player, GameViewer, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;

    public static final String ATTRIB_ID = "id";
    public static final String ATTRIB_USERNAME = "username";
    public static final String ATTRIB_PASSWORD = "password";
    public static final String ATTRIB_EMAIL = "email";


    public void updateView() {
        //TODO: must be implemented
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
