package adapter.presenter;

import domain.entity.Guest;
import java.util.List;

/**
 * Presenter yang memformat data dari use case menjadi output layar.
 */
public class GuestPresenter {

    private String format(Guest guest) {
        return String.format("%d | %s | %s", guest.getId(), guest.getName(), guest.getPurpose());
    }

    public void showGuests(List<Guest> guests) {
        System.out.println("Daftar Tamu:");
        if (guests.isEmpty()) {
            System.out.println("- Data tamu belum tersedia!");
            return;
        }
        for (Guest guest : guests) {
            System.out.println(format(guest));
        }
    }

    public void showSearchResults(List<Guest> guests, String keyword) {
        System.out.println("Hasil Pencarian: \"" + keyword + "\"");
        if (guests.isEmpty()) {
            System.out.println("- Tamu tidak ditemukan!");
            return;
        }
        for (Guest guest : guests) {
            System.out.println(format(guest));
        }
    }

    public void showRegisterSuccess(Guest guest) {
        System.out.println("Berhasil mendaftarkan tamu: " + format(guest));
    }

    public void showRemoveSuccess() {
        System.out.println("Berhasil menghapus tamu.");
    }

    public void showRemoveFailed(int id) {
        System.out.println("[!] Gagal menghapus tamu dengan ID: " + id + ".");
    }

    public void showInvalidChoice() {
        System.out.println("[!] Pilihan tidak dimengerti.");
    }

    public void showInvalidId() {
        System.out.println("[!] ID tidak valid!");
    }
}