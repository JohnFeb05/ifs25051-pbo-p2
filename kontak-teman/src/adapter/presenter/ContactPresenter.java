package adapter.presenter;

import domain.entity.Contact;
import java.util.List;

/**
 * Presenter yang memformat data dari use case menjadi output layar.
 */
public class ContactPresenter {

    private String format(Contact contact) {
        return String.format("%d | %s | %s | %s",
                contact.getId(), contact.getName(), contact.getPhone(), contact.getEmail());
    }

    public void showContacts(List<Contact> contacts) {
        System.out.println("Daftar Kontak:");
        if (contacts.isEmpty()) {
            System.out.println("- Data kontak belum tersedia!");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(format(contact));
        }
    }

    public void showSearchResults(List<Contact> contacts, String keyword) {
        System.out.println("Hasil Pencarian: \"" + keyword + "\"");
        if (contacts.isEmpty()) {
            System.out.println("- Kontak tidak ditemukan!");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(format(contact));
        }
    }

    public void showSortedContacts(List<Contact> contacts) {
        System.out.println("Daftar Kontak (Terurut):");
        if (contacts.isEmpty()) {
            System.out.println("- Data kontak belum tersedia!");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(format(contact));
        }
    }

    public void showAddSuccess(Contact contact) {
        System.out.println("Berhasil menambah kontak: " + format(contact));
    }

    public void showUpdateSuccess() {
        System.out.println("Berhasil mengubah kontak.");
    }

    public void showUpdateFailed(int id) {
        System.out.println("[!] Gagal mengubah kontak dengan ID: " + id + ".");
    }

    public void showRemoveSuccess() {
        System.out.println("Berhasil menghapus kontak.");
    }

    public void showRemoveFailed(int id) {
        System.out.println("[!] Gagal menghapus kontak dengan ID: " + id + ".");
    }

    public void showInvalidChoice() {
        System.out.println("[!] Pilihan tidak dimengerti.");
    }

    public void showInvalidId() {
        System.out.println("[!] ID tidak valid!");
    }

    public void showInvalidSortOption() {
        System.out.println("[!] Pilihan tidak valid!");
    }
}