package com.example.restful_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restful_api.model.Item;
import com.example.restful_api.model.ItemRequest;
import com.example.restful_api.model.ItemResponse;
import com.example.restful_api.service.ItemService;

@RestController
@RequestMapping
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/api/getEveryItem")
    @ResponseBody
    public List<Item> getEveryItem(){
        return itemService.getEveryItem();
    }

    @GetMapping("/api/getItem")
    @ResponseBody
    public ItemResponse getItem(@RequestParam(value = "name", required = true) String name){

        if (name == null || name.isEmpty()) {
            return new ItemResponse("Missing field: name.");
        }

        Item item = itemService.getItem(name);

        if (item == null) {
            return new ItemResponse("No item found with the given name.");
        } else {
            return new ItemResponse("Success",item);
        }
    }
    
    @PostMapping("/api/addItem")
    @ResponseBody
    public ItemResponse addItem(@RequestBody ItemRequest itemRequest){
        String name = itemRequest.getName();
        String description = itemRequest.getDescription();

        if (name == null || name.isEmpty()) {
            return new ItemResponse("Missing field: name.");
        } else if (description == null || description.isEmpty()) {
            return new ItemResponse("Missing field: description.");
        }

        String response = itemService.addItem(new Item(name, description));

        if ("ok".equals(response)) {
            return new ItemResponse("Item added successfully.");
        } else {
            return new ItemResponse(String.format("Failed to add item due to following error: \n %s", response));
        }
    }

    @DeleteMapping("/api/deleteItem")
    @ResponseBody
    public ItemResponse deleteItem(@RequestBody ItemRequest ItemRequest){

        String name = ItemRequest.getName();

        if (name == null || name.isEmpty()) {
            return new ItemResponse("Missing field: name.");
        }

        int response = itemService.deleteItem(name);

        if (response == 1) {
            return new ItemResponse("Item deleted successfully.");
        } else if (response == 0) {
            return new ItemResponse("No item found with the given name.");
        } else {
            return new ItemResponse("An unknown error occurred. Please retry.");
        }
    }
}