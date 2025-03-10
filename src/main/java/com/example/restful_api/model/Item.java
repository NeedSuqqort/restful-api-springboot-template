package com.example.restful_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Item {
    private static Long currentid = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name;
    private String description;

    @Version
    private Long version;

    public Item(){
        this.id = Item.currentid++;
        this.name = String.format("Item %d", currentid);
        this.description = "No description";
    }

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Long getID(){
        return id;
    }

    public void setID(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("Item[id=%d, Name='%s', Description='%s']", id, name, description);
    }
}
