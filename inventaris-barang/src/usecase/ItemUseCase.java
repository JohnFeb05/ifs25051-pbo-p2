package usecase;

import domain.entity.Item;
import domain.entity.SortOption;
import domain.repository.IItemRepository;
import java.util.List;
import java.util.Optional;

/**
 * Use case yang menangani logika bisnis aplikasi inventaris barang.
 */
public class ItemUseCase {
    private final IItemRepository repository;

    public ItemUseCase(IItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item addItem(String name, int quantity, String category) {
        return repository.save(name, quantity, category);
    }

    /**
     * Mengubah stok barang. Parameter {@code quantity} bernilai {@code null}
     * berarti stok tidak diubah.
     *
     * @return true jika barang ditemukan dan berhasil diperbarui
     */
    public boolean updateStock(int id, Integer quantity) {
        Optional<Item> found = repository.findById(id);
        if (found.isEmpty()) {
            return false;
        }

        Item item = found.get();
        if (quantity != null) {
            item.changeQuantity(quantity);
        }
        repository.update(item);
        return true;
    }

    public List<Item> searchItems(String keyword) {
        String lower = keyword.toLowerCase();
        return repository.findAll().stream()
                .filter(item -> item.getName().toLowerCase().contains(lower))
                .toList();
    }

    public List<Item> sortItems(SortOption option) {
        return repository.findAll().stream()
                .sorted(option.comparator())
                .toList();
    }

    public boolean removeItem(int id) {
        return repository.deleteById(id);
    }
}