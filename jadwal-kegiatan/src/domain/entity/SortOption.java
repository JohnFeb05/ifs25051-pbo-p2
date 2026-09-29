package domain.entity;

import java.util.Comparator;
import java.util.Map;

/**
 * Kriteria pengurutan kegiatan.
 * Untuk pengurutan berdasarkan hari, waktu digunakan sebagai tie-breaker
 * agar urutan tetap konsisten ketika beberapa kegiatan berada di hari yang sama.
 */
public enum SortOption {
    DAY_ASC(Comparator.comparingInt((Activity a) -> dayOrder(a.getDay()))
            .thenComparing(Activity::getTime)),
    DAY_DESC(Comparator.comparingInt((Activity a) -> dayOrder(a.getDay()))
            .reversed()
            .thenComparing(Activity::getTime)),
    TIME_ASC(Comparator.comparing(Activity::getTime)),
    TIME_DESC(Comparator.comparing(Activity::getTime).reversed()),
    TITLE_ASC(Comparator.comparing(Activity::getTitle, String.CASE_INSENSITIVE_ORDER)),
    TITLE_DESC(Comparator.comparing(Activity::getTitle, String.CASE_INSENSITIVE_ORDER).reversed());

    private static final Map<String, Integer> DAY_MAP = Map.of(
            "Senin", 1, "Selasa", 2, "Rabu", 3, "Kamis", 4,
            "Jumat", 5, "Sabtu", 6, "Minggu", 7
    );

    private final Comparator<Activity> comparator;

    SortOption(Comparator<Activity> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Activity> comparator() {
        return comparator;
    }

    private static int dayOrder(String day) {
        return DAY_MAP.getOrDefault(day, 8);
    }
}