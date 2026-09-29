package adapter.presenter;

import domain.entity.Transaction;
import java.util.List;

/**
 * Presenter yang memformat data dari use case menjadi output layar.
 * Memisahkan logika tampilan dari entity, use case, dan view.
 */
public class FinancePresenter {

    /** Memformat satu transaksi menjadi baris teks. */
    public String format(Transaction t) {
        return String.format("%d | %s | Rp %d | %s",
                t.getId(), t.getDescription(), t.getAmount(), t.getType().label());
    }

    /** Menampilkan daftar semua transaksi. */
    public void showAllTransactions(List<Transaction> transactions) {
        System.out.println("Daftar Transaksi:");
        if (transactions.isEmpty()) {
            System.out.println("- Belum ada transaksi!");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(format(t));
        }
    }

    /** Menampilkan hasil pencarian berdasarkan kata kunci. */
    public void showSearchResults(List<Transaction> transactions, String keyword) {
        System.out.println("Hasil Pencarian: \"" + keyword + "\"");
        if (transactions.isEmpty()) {
            System.out.println("- Transaksi tidak ditemukan!");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(format(t));
        }
    }

    /** Menampilkan daftar transaksi yang sudah diurutkan. */
    public void showSortedTransactions(List<Transaction> transactions) {
        System.out.println("Daftar Transaksi (Terurut):");
        if (transactions.isEmpty()) {
            System.out.println("- Belum ada transaksi!");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(format(t));
        }
    }

    /** Menampilkan saldo (ditampilkan di tiap awal iterasi menu). */
    public void showBalance(long balance) {
        System.out.println("Saldo: Rp " + balance);
    }

    /** Menampilkan saldo saat ini (menu "Lihat Saldo"). */
    public void showCurrentBalance(long balance) {
        System.out.println("Saldo saat ini: Rp " + balance);
    }

    /** Pesan sukses menambah transaksi. */
    public void showAddSuccess(Transaction t) {
        System.out.println("Berhasil menambah transaksi: " + format(t));
    }

    /** Pesan sukses menghapus transaksi. */
    public void showRemoveSuccess() {
        System.out.println("Berhasil menghapus transaksi.");
    }

    /** Pesan gagal menghapus transaksi. */
    public void showRemoveFailed(int id) {
        System.out.println("[!] Gagal menghapus transaksi dengan ID: " + id + ".");
    }

    /** Pesan pilihan menu tidak dikenali. */
    public void showInvalidChoice() {
        System.out.println("[!] Pilihan tidak dimengerti.");
    }

    /** Pesan ID tidak valid (bukan angka). */
    public void showInvalidId() {
        System.out.println("[!] ID tidak valid!");
    }

    /** Pesan jumlah tidak valid (bukan angka atau ≤ 0). */
    public void showInvalidAmount() {
        System.out.println("[!] Jumlah tidak valid!");
    }

    /** Pesan opsi urutkan tidak valid. */
    public void showInvalidSortOption() {
        System.out.println("[!] Pilihan tidak valid!");
    }
}