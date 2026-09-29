package domain.repository;

import domain.entity.Guest;
import java.util.List;
import java.util.Optional;

/**
 * Port (kontrak) penyimpanan data tamu.
 * Interface ini berada di domain agar use case tidak bergantung pada
 * implementasi konkret maupun struktur data yang dipakai untuk menyimpan.
 */
public interface IGuestRepository {
    /** Mengambil semua data tamu. */
    List<Guest> findAll();

    /** Mencari satu tamu berdasarkan ID. */
    Optional<Guest> findById(int id);

    /**
     * Menyimpan tamu baru. Implementasi bertanggung jawab memberi ID unik.
     */
    Guest save(String name, String purpose);

    /** Menghapus tamu berdasarkan ID. Mengembalikan true jika berhasil. */
    boolean deleteById(int id);
} 