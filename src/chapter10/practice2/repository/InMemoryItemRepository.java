package chapter10.practice2.repository;

import chapter10.practice2.entity.Item;

import java.util.HashSet;
import java.util.Set;

public class InMemoryItemRepository implements ItemRepository {
    private Set<Item> items = new HashSet<>();

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(String itemId) {
        Item target = null;

        for (Item item : items){  // 제거할 아이템 찾아오기 >> Set은 인덱스값을 건내는것이 아닌 구조 자체를 건내어 remove 함
            if (item.getId().equals(itemId)) {
                target = item;
                break;
            }
        }

        if (target != null) {
            items.remove(target);
        }
    }

    @Override
    public Item findById(String itemId) {

        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public Set<Item> findAll() {
        return new HashSet<>(items); // 다운캐스팅 대체  :   Set -> HashSet
    }
}
