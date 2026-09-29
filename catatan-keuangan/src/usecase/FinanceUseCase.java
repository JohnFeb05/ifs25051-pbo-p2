package usecase;

import domain.entity.SortOption;
import domain.entity.Transaction;
import domain.entity.TransactionType;
import domain.repository.ITransactionRepository;
import java.util.List;

/**
 * Use case yang menangani logika bisnis aplikasi catatan keuangan.
 * Tidak melakukan I/O — hanya memproses data dan mengembalikan hasil
 * ke layer presenter/view.
 */
public class FinanceUseCase {
    /** Port repository yang di-inject dari luar (Dependency Inversion). */
    private final ITransactionRepository repository;

    public FinanceUseCase(ITransactionRepository repository) {
        this.repository = repository;
    }

    /** Mengambil semua transaksi. */
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    /** Menambah transaksi pemasukan. */
    public Transaction addIncome(String description, long amount) {
        return repository.save(description, amount, TransactionType.INCOME);
    }

    /** Menambah transaksi pengeluaran. */
    public Transaction addExpense(String description, long amount) {
        return repository.save(description, amount, TransactionType.EXPENSE);
    }

    /** Menghapus transaksi berdasarkan ID. */
    public boolean remove(int id) {
        return repository.deleteById(id);
    }

    /** Mencari transaksi yang keterangan-nya mengandung kata kunci (case-insensitive). */
    public List<Transaction> search(String keyword) {
        String lower = keyword.toLowerCase();
        return repository.findAll().stream()
                .filter(t -> t.getDescription().toLowerCase().contains(lower))
                .toList();
    }

    /** Mengurutkan transaksi sesuai kriteria {@link SortOption}. */
    public List<Transaction> sort(SortOption option) {
        return repository.findAll().stream()
                .sorted(option.comparator())
                .toList();
    }

    /** Menghitung saldo = total pemasukan − total pengeluaran. */
    public long getBalance() {
        return repository.findAll().stream()
                .mapToLong(t -> t.getType() == TransactionType.INCOME ? t.getAmount() : -t.getAmount())
                .sum();
    }
}