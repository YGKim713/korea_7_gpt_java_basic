package chapter10.practice2.service;

import chapter10.practice2.entity.Item;

import java.util.List;

public interface InventoryService {
    void additem(Item item);
    void updateItemPrice(String itemId, int newPrice);
    void deleteItem(String itemId);
    List<Item> getItemsByCategory(String category);
}
