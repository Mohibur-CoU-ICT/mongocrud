package com.mohibur.mongocrud.service;

import com.mohibur.mongocrud.dto.GroceryItemDto;
import com.mohibur.mongocrud.model.Fruit;
import com.mohibur.mongocrud.model.GroceryItem;
import com.mohibur.mongocrud.repository.GroceryItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
@EnableScheduling
public class GroceryItemService {

    private static final Logger logger = LoggerFactory.getLogger(GroceryItemService.class);

    @Autowired
    GroceryItemRepository groceryItemRepository;

    // scheduler
//    @Scheduled(cron = "@hourly")
//    @Scheduled(cron = "${cron.delay}")
    public void runScheduler() {
        logger.info("Saving scheduled data");
        List<GroceryItem> groceryItems = groceryItemRepository.findAll();
        groceryItems.forEach(item -> logger.info(item.toString()));
    }

    // create
    public ResponseEntity<GroceryItem> addGroceryItem(GroceryItemDto groceryItemDto) {
        GroceryItem groceryItem = new GroceryItem();
        BeanUtils.copyProperties(groceryItemDto, groceryItem);
        groceryItem = groceryItemRepository.save(groceryItem);
        return ResponseEntity.ok(groceryItem);
    }

    // read -> find by id
    public ResponseEntity<GroceryItem> getGroceryItem(String id) {
        Optional<GroceryItem> groceryItemOptional = groceryItemRepository.findById(id);
        if (groceryItemOptional.isPresent()) {
            GroceryItem groceryItem = groceryItemOptional.get();
            return ResponseEntity.ok(groceryItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // read -> all
    public ResponseEntity<List<GroceryItem>> getGroceryItems() {
        List<GroceryItem> groceryItemList = groceryItemRepository.findAll();
        return ResponseEntity.ok(groceryItemList);
    }

    // read -> find by name
    public ResponseEntity<GroceryItem> findByName(String name) {
        Optional<GroceryItem> groceryItemOptional = groceryItemRepository.findByNameIgnoreCase(name);
        if (groceryItemOptional.isPresent()) {
            GroceryItem groceryItem = groceryItemOptional.get();
            return ResponseEntity.ok(groceryItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // read -> filter by category and/or name
    public ResponseEntity<List<GroceryItem>> filterGroceries(String category, String name) {
        List<GroceryItem> groceryItems;
        if (category.length() > 0 && name.length() > 0) {
            groceryItems = groceryItemRepository.findAllByCategoryIgnoreCaseAndNameIgnoreCase(category, name);
        } else if (category.length() > 0) {
            groceryItems = groceryItemRepository.findAllByCategoryIgnoreCase(category);
        } else if (name.length() > 0) {
            groceryItems = groceryItemRepository.findAllByNameIgnoreCase(name);
        } else {
            groceryItems = groceryItemRepository.findAll();
        }
        return ResponseEntity.ok(groceryItems);
    }

    // update
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable("id") String id, @RequestBody GroceryItemDto groceryItemDto) {
        Optional<GroceryItem> groceryItemOptional = groceryItemRepository.findById(id);
        if (groceryItemOptional.isPresent()) {
            GroceryItem groceryItem = groceryItemOptional.get();
            BeanUtils.copyProperties(groceryItemDto, groceryItem);
            groceryItemRepository.save(groceryItem);
            return ResponseEntity.ok(groceryItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    public ResponseEntity<?> deleteGroceryItem(@PathVariable("id") String id) {
        Optional<GroceryItem> groceryItemOptional = groceryItemRepository.findById(id);
        if (groceryItemOptional.isPresent()) {
            groceryItemRepository.deleteById(id);
            return ResponseEntity.ok("Item with id " + id + " deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Async
    public CompletableFuture<String> addRandomGroceryItems(Integer count) {
        if (count > 1e5) {
            throw new RuntimeException("Count value should be less than or equal to 100000.");
        }
        try {
            List<Fruit> fruits = Fruit.getFruits();
            for (int i = 0; i < count; i++) {
                Random random = new Random();
                int index = random.nextInt(fruits.size());
                Fruit fruit1 = fruits.get(index);
                GroceryItem groceryItem = new GroceryItem();
                groceryItem.setName(fruit1.getName());
                groceryItem.setCategory(fruit1.getCategory());
                groceryItem.setQuantity(index);
                groceryItemRepository.save(groceryItem);
            }
            return CompletableFuture.completedFuture(count + " random grocery items added.");
        } catch (Exception e) {
            return CompletableFuture.completedFuture(e.getMessage());
        }
    }

    public ResponseEntity<List<?>> sortFruits() {
        Fruit fruit = new Fruit();
        List<Fruit> fruits = Fruit.getFruits();
        fruits.sort((f1, f2) -> {
            int nameComparison = f1.getName().compareTo(f2.getName());
            if (nameComparison != 0) {
                return nameComparison;
            } else {
                return f1.getCategory().compareTo(f2.getCategory());
            }
        });
//        fruits.forEach(fruit1 -> System.out.println("new Fruit(\"" + fruit1.getName() + "\", \"" + fruit1.getCategory() + "\"),"));
        return ResponseEntity.ok(fruits);
    }
}
