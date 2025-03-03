package com.example.restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.restful_api.model.Item;

@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>();

    public List<Item> getEveryItem(){
        return items;
    }

    public String addItem(Item item){
        try{
            items.add(item);
            return "ok";
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
