package com.mohibur.mongocrud.repository;

import com.mohibur.mongocrud.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {
    Optional<GroceryItem> findByNameIgnoreCase(String name);

    List<GroceryItem> findAllByNameIgnoreCase(String name);
    
    @Query("{quantity: '?0'}")
    List<GroceryItem> findByQuantity(Integer quantity);

    //    @Query(value = "{category: '?0'}", fields = "{'name': 1, 'quantity': 1}")
    List<GroceryItem> findAllByCategoryIgnoreCase(String category);

    List<GroceryItem> findAllByCategoryIgnoreCaseAndNameIgnoreCase(String category, String name);
}
