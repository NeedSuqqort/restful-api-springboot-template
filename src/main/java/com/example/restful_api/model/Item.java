package com.example.restful_api.model;

public class Item {
    private static Long currentid = 1L;

    private Long id; 
    private String name;
    private String description;

    public Item(){
        this.id = currentid++;
        this.name = String.format("Item %d", currentid);
        this.description = "No description";
    }

    public Item(String name, String description){
        this.id = currentid++;
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
}
