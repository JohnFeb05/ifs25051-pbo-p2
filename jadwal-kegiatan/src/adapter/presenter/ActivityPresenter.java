package adapter.presenter;

import domain.entity.Activity;
import java.util.List;

/**
 * Presenter yang memformat data dari use case menjadi output layar.
 */
public class ActivityPresenter {

    private String format(Activity activity) {
        return String.format("%d | %s | %s | %s",
                activity.getId(), activity.getTitle(), activity.getDay(), activity.getTime());
    }

    public void showActivities(List<Activity> activities) {
        System.out.println("Daftar Kegiatan:");
        if (activities.isEmpty()) {
            System.out.println("- Data kegiatan belum tersedia!");
            return;
        }
        for (Activity activity : activities) {
            System.out.println(format(activity));
        }
    }

    public void showSearchResults(List<Activity> activities, String keyword) {
        System.out.println("Hasil Pencarian: \"" + keyword + "\"");
        if (activities.isEmpty()) {
            System.out.println("- Kegiatan tidak ditemukan!");
            return;
        }
        for (Activity activity : activities) {
            System.out.println(format(activity));
        }
    }

    public void showSortedActivities(List<Activity> activities) {
        System.out.println("Daftar Kegiatan (Terurut):");
        if (activities.isEmpty()) {
            System.out.println("- Data kegiatan belum tersedia!");
            return;
        }
        for (Activity activity : activities) {
            System.out.println(format(activity));
        }
    }

    public void showAddSuccess(Activity activity) {
        System.out.println("Berhasil menambah kegiatan: " + format(activity));
    }

    public void showUpdateSuccess() {
        System.out.println("Berhasil mengubah kegiatan.");
    }

    public void showUpdateFailed(int id) {
        System.out.println("[!] Gagal mengubah kegiatan dengan ID: " + id + ".");
    }

    public void showRemoveSuccess() {
        System.out.println("Berhasil menghapus kegiatan.");
    }

    public void showRemoveFailed(int id) {
        System.out.println("[!] Gagal menghapus kegiatan dengan ID: " + id + ".");
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