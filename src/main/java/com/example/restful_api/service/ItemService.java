package com.example.restful_api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.restful_api.model.Item;

@Service
public class ItemService {
    private final HashMap<Long,Item> items = new HashMap<>();
    private final HashMap<String,Long> nameToID = new HashMap<>();

    public List<Item> getEveryItem(){
        return new ArrayList<>(items.values());
    }

    public Item getItem(String name){
        Long id = nameToID.getOrDefault(name, null);
        if (id == null){
            return null;
        }
        return items.get(id);
    }

    public String addItem(Item item){
        try{
            if (nameToID.containsKey(item.getName())) {
                return "Item with the same name already exists";
            } else {
                items.put(item.getID(), item);
                nameToID.put(item.getName(), item.getID());
                return "ok";
            }
        } catch (Exception e){
            return e.getMessage();
        }
    }

    public int deleteItem(String name){
        try{
            Long id = nameToID.getOrDefault(name, null);
            if (id == null){
                return 0;
            }
            items.remove(id);
            nameToID.remove(name);
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
