package usecase;

import domain.entity.Guest;
import domain.repository.IGuestRepository;
import java.util.List;

/**
 * Use case yang menangani logika bisnis aplikasi buku tamu.
 * Tidak melakukan I/O — hanya memproses data dan mengembalikan hasil
 * ke layer presenter/view.
 */
public class GuestUseCase {
    private final IGuestRepository repository;

    public GuestUseCase(IGuestRepository repository) {
        this.repository = repository;
    }

    /** Mengambil semua tamu yang terdaftar. */
    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    /** Mendaftarkan tamu baru. */
    public Guest registerGuest(String name, String purpose) {
        return repository.save(name, purpose);
    }

    /** Menghapus tamu berdasarkan ID. */
    public boolean removeGuest(int id) {
        return repository.deleteById(id);
    }

    /** Mencari tamu yang namanya mengandung kata kunci (case-insensitive). */
    public List<Guest> searchGuests(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return repository.findAll().stream()
                .filter(guest -> guest.getName().toLowerCase().contains(lowerKeyword))
                .toList();
    }
}   