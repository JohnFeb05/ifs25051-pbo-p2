package domain.repository;

import domain.entity.Item;
import java.util.List;
import java.util.Optional;

/**
 * Port (kontrak) penyimpanan data barang.
 */
public interface IItemRepository {
    List<Item> findAll();
    Optional<Item> findById(int id);
    Item save(String name, int quantity, String category);
    boolean deleteById(int id);
    void update(Item item);
}