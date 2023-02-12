package com.mohibur.mongocrud.controller;

import com.mohibur.mongocrud.dto.GroceryItemDto;
import com.mohibur.mongocrud.model.GroceryItem;
import com.mohibur.mongocrud.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groceryItem")
public class GroceryItemController {

    @Autowired
    GroceryItemService groceryItemService;

    // create
    @PostMapping("")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItemDto groceryItemDto) {
        return groceryItemService.addGroceryItem(groceryItemDto);
    }

    // read -> find by id
    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItem(@PathVariable("id") String id) {
        return groceryItemService.getGroceryItem(id);
    }

    // read -> all
    @GetMapping("/all")
    public ResponseEntity<List<GroceryItem>> getGroceryItems() {
        return groceryItemService.getGroceryItems();
    }

    // read -> find by name
    @GetMapping("/by")
    public ResponseEntity<GroceryItem> findByName(@RequestParam("name") String name) {
        return groceryItemService.findByName(name);
    }

    // read -> filter by category and/or name
    @GetMapping("")
    public ResponseEntity<List<GroceryItem>> filterGroceries(@RequestParam(value = "category", required = false) String category,
                                                             @RequestParam(value = "name", required = false) String name) {
        return groceryItemService.filterGroceries(category.trim(), name.trim());
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable("id") String id, @RequestBody GroceryItemDto groceryItemDto) {
        return groceryItemService.updateGroceryItem(id, groceryItemDto);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroceryItem(@PathVariable("id") String id) {
        return groceryItemService.deleteGroceryItem(id);
    }

}
