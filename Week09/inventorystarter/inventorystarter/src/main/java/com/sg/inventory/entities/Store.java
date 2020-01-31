package com.sg.inventory.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Boone
 */
@Entity //marks this object class as a relation
public class Store {

    
    @GeneratedValue(strategy=GenerationType.IDENTITY) //auto incrementation
    @Id //marks this attribute as a primary key
    private int id;
    
    @Column(nullable = false) //marks as a column (not nullable)
    private String name;
    
    @Column //marks as a column (nullable)
    private String location;
    
    @Column //marks as a column (nullable)
    private String manager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
    
    
    
}
