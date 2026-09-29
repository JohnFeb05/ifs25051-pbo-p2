package adapter.presenter;

import domain.entity.Item;
import java.util.List;

/**
 * Presenter yang memformat data dari use case menjadi output layar.
 */
public class ItemPresenter {

    private String format(Item item) {
        return String.format("%d | %s | %d | %s",
                item.getId(), item.getName(), item.getQuantity(), item.getCategory());
    }

    public void showItems(List<Item> items) {
        System.out.println("Daftar Barang:");
        if (items.isEmpty()) {
            System.out.println("- Data barang belum tersedia!");
            return;
        }
        for (Item item : items) {
            System.out.println(format(item));
        }
    }

    public void showSearchResults(List<Item> items, String keyword) {
        System.out.println("Hasil Pencarian: \"" + keyword + "\"");
        if (items.isEmpty()) {
            System.out.println("- Barang tidak ditemukan!");
            return;
        }
        for (Item item : items) {
            System.out.println(format(item));
        }
    }

    public void showSortedItems(List<Item> items) {
        System.out.println("Daftar Barang (Terurut):");
        if (items.isEmpty()) {
            System.out.println("- Data barang belum tersedia!");
            return;
        }
        for (Item item : items) {
            System.out.println(format(item));
        }
    }

    public void showAddSuccess(Item item) {
        System.out.println("Berhasil menambah barang: " + format(item));
    }

    public void showUpdateSuccess() {
        System.out.println("Berhasil mengubah stok barang.");
    }

    public void showUpdateFailed(int id) {
        System.out.println("[!] Gagal mengubah stok barang dengan ID: " + id + ".");
    }

    public void showRemoveSuccess() {
        System.out.println("Berhasil menghapus barang.");
    }

    public void showRemoveFailed(int id) {
        System.out.println("[!] Gagal menghapus barang dengan ID: " + id + ".");
    }

    public void showInvalidChoice() {
        System.out.println("[!] Pilihan tidak dimengerti.");
    }

    public void showInvalidId() {
        System.out.println("[!] ID tidak valid!");
    }

    public void showInvalidQuantity() {
        System.out.println("[!] Jumlah stok tidak valid!");
    }

    public void showInvalidSortOption() {
        System.out.println("[!] Pilihan tidak valid!");
    }
}