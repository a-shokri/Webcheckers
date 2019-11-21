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
    private Integer ID;
    @Column(name = "USERNAME")
    private String USERNAME;
    @Column(name = "PASSWORD")
    private String PASSWORD;
    @Column(name = "EMAIL")
    private String EMAIL;
    

    public void updateView() {
        //TODO: must be implemented
    }


    public Integer getID() {
        return ID;
    }


    public void setID(Integer ID) {
        this.ID = ID;
    }


    public String getUSERNAME() {
        return USERNAME;
    }


    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }


    public String getPASSWORD() {
        return PASSWORD;
    }


    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }


    public String getEMAIL() {
        return EMAIL;
    }


    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
