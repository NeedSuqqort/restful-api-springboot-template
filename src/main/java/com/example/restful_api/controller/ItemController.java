package com.example.restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restful_api.model.Item;
import com.example.restful_api.service.ItemService;

@RestController
@RequestMapping
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/api/getEveryItem")
    public List<Item> getEveryItem(){
        return itemService.getEveryItem();
    }

    @PostMapping("/api/addItem")
    public String addItem(@RequestParam("name") String name, @RequestParam("description") String description){
        String response = itemService.addItem(new Item(name, description));
        if (response == "ok") {
            return "Item added successfully";
        } else {
            return String.format("Failed to add item due to following error: \n %s", response);
        }
    }
}