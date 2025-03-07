package com.example.restful_api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponse {
    private String message;
    private List<Item> result = null;

    public ItemResponse(String message) {
        this.message = message;
    }

    public ItemResponse(String message, Item item){
        if (this.result == null) {
            this.result = new ArrayList<Item>();
        }
        this.result.add(item);
        this.message = message;
    }

    public String getmessage() {
        return message;
    }


    public void setmessage(String message) {
        this.message = message;
    }

    public List<Item> getresult() {
        return result;
    }

    public void setresult(List<Item> result) {
        this.result = result;
    }
}
