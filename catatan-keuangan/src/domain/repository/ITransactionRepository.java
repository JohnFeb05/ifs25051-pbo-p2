package domain.repository;

import domain.entity.Transaction;
import domain.entity.TransactionType;
import java.util.List;
import java.util.Optional;

/**
 * Port (kontrak) penyimpanan data transaksi.
 * Interface ini berada di domain agar use case tidak bergantung pada
 * implementasi konkret maupun struktur data yang dipakai untuk menyimpan.
 */
public interface ITransactionRepository {
    /** Mengambil semua data transaksi. */
    List<Transaction> findAll();

    /** Mencari satu transaksi berdasarkan ID. */
    Optional<Transaction> findById(int id);

    /**
     * Menyimpan transaksi baru. Implementasi bertanggung jawab memberi ID unik.
     */
    Transaction save(String description, long amount, TransactionType type);

    /** Menghapus transaksi berdasarkan ID. Mengembalikan true jika berhasil. */
    boolean deleteById(int id);
}