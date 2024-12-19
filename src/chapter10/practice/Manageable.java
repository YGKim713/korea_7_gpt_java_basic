package chapter10.practice;

// 도서관리시스템에서 관리할 수 있는 동작 정의

import java.util.List;

public interface Manageable {
    void add(Item item);
    void remove(String id);
    List<Item> search(String keyword);
    List<Item> searchByCategory(String category);
    List<Item> searchByPriceRange(int minPrice, int maxPrice);
    void updateStock(String id, int quantity);
    void listAll();
}
