package org.example.bytequanta.controller;

import org.example.bytequanta.dto.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class WelcomeController {
    private final List<Item> items = new ArrayList<>();

    @GetMapping
    public List<Item> getAllItems() {
        return items;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return items.stream()
                .filter(item -> item.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        items.add(item);
        return ResponseEntity.created(null).body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id().equals(id)) {
                items.set(i, new Item(id, updatedItem.name()));
                return ResponseEntity.ok(updatedItem);
            }
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        items.removeIf(item -> item.id().equals(id));
        return ResponseEntity.noContent().build();
    }

}
