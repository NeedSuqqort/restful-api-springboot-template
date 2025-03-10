package com.example.restful_api.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.restful_api.model.Item;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item,Long>{

    // need to use exact field name in Item class
    List<Item> findByName(String name);

    Item findById(long id);

    List<Item> findByDescription(String description);
}