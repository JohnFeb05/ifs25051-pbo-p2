package adapter.repository;

import domain.entity.Item;
import domain.repository.IItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementasi repository menggunakan penyimpanan in-memory berbasis {@link List}.
 */
public class ItemRepository implements IItemRepository {
    private final List<Item> data = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Item> findById(int id) {
        return data.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    @Override
    public Item save(String name, int quantity, String category) {
        Item item = new Item(nextId(), name, quantity, category);
        data.add(item);
        return item;
    }

    @Override
    public boolean deleteById(int id) {
        return data.removeIf(item -> item.getId() == id);
    }

    @Override
    public void update(Item item) {
        // Entity mutable & disimpan by-reference, perubahan otomatis tercermin.
    }

    private int nextId() {
        return ++idCounter;
    }
}