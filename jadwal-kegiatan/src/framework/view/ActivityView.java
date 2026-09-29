package framework.view;

import adapter.presenter.ActivityPresenter;
import domain.entity.SortOption;
import framework.util.InputUtil;
import usecase.ActivityUseCase;

/**
 * Tampilan konsol aplikasi jadwal kegiatan.
 */
public class ActivityView {
    private final ActivityUseCase useCase;
    private final ActivityPresenter presenter;

    public ActivityView(ActivityUseCase useCase, ActivityPresenter presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    public void show() {
        boolean running = true;
        while (running) {
            presenter.showActivities(useCase.getAllActivities());
            printMenu();

            String choice = InputUtil.input("Pilih");
            switch (choice) {
                case "1" -> addActivity();
                case "2" -> updateActivity();
                case "3" -> searchActivity();
                case "4" -> sortActivities();
                case "5" -> removeActivity();
                case "x" -> running = false;
                default -> presenter.showInvalidChoice();
            }

            if (running) {
                System.out.println();
            }
        }
    }

    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah");
        System.out.println("2. Ubah");
        System.out.println("3. Cari");
        System.out.println("4. Urutkan");
        System.out.println("5. Hapus");
        System.out.println("x. Keluar");
    }

    private void addActivity() {
        System.out.println("[Menambah Kegiatan]");
        String title = InputUtil.input("Judul (x Jika Batal)");
        if (title.equals("x")) return;

        String day = InputUtil.input("Hari (x Jika Batal)");
        if (day.equals("x")) return;

        String time = InputUtil.input("Waktu (x Jika Batal)");
        if (time.equals("x")) return;

        presenter.showAddSuccess(useCase.addActivity(title, day, time));
    }

    private void updateActivity() {
        System.out.println("[Mengubah Kegiatan]");
        String strId = InputUtil.input("ID Kegiatan yang diubah (x Jika Batal)");
        if (strId.equals("x")) return;

        Integer id = parseId(strId);
        if (id == null) return;

        String newTitle = InputUtil.input("Judul Baru (Kosongkan jika tidak ingin mengubah)");
        String newDay = InputUtil.input("Hari Baru (Kosongkan jika tidak ingin mengubah)");
        String newTime = InputUtil.input("Waktu Baru (Kosongkan jika tidak ingin mengubah)");

        String title = newTitle.isBlank() ? null : newTitle;
        String day = newDay.isBlank() ? null : newDay;
        String time = newTime.isBlank() ? null : newTime;

        if (useCase.updateActivity(id, title, day, time)) {
            presenter.showUpdateSuccess();
        } else {
            presenter.showUpdateFailed(id);
        }
    }

    private void searchActivity() {
        System.out.println("[Mencari Kegiatan]");
        String keyword = InputUtil.input("Kata Kunci (x Jika Batal)");
        if (keyword.equals("x")) return;

        presenter.showSearchResults(useCase.searchActivities(keyword), keyword);
    }

    private void sortActivities() {
        System.out.println("[Mengurutkan Kegiatan]");
        System.out.println("Pilihan Pengurutan:");
        System.out.println("1. Hari (Senin -> Minggu)");
        System.out.println("2. Waktu (Awal -> Akhir)");
        System.out.println("3. Judul (A-Z)");
        System.out.println("4. Judul (Z-A)");
        System.out.println("x. Batal");

        String choice = InputUtil.input("Pilih");
        if (choice.equals("x")) return;

        SortOption option = mapSortOption(choice);
        if (option == null) {
            presenter.showInvalidSortOption();
            return;
        }

        presenter.showSortedActivities(useCase.sortActivities(option));
    }

    private void removeActivity() {
        System.out.println("[Menghapus Kegiatan]");
        String strId = InputUtil.input("[ID Kegiatan] yang dihapus (x Jika Batal)");
        if (strId.equals("x")) return;

        Integer id = parseId(strId);
        if (id == null) return;

        if (useCase.removeActivity(id)) {
            presenter.showRemoveSuccess();
        } else {
            presenter.showRemoveFailed(id);
        }
    }

    private Integer parseId(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            presenter.showInvalidId();
            return null;
        }
    }

    /**
     * Memetakan pilihan menu (1-4) ke {@link SortOption} domain.
     * Hanya 4 opsi yang ditampilkan sesuai expected output.
     */
    private SortOption mapSortOption(String input) {
        return switch (input) {
            case "1" -> SortOption.DAY_ASC;    // Hari (Senin -> Minggu)
            case "2" -> SortOption.TIME_ASC;   // Waktu (Awal -> Akhir)
            case "3" -> SortOption.TITLE_ASC;  // Judul (A-Z)
            case "4" -> SortOption.TITLE_DESC; // Judul (Z-A)
            default -> null;
        };
    }
}