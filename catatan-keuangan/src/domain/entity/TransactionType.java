package domain.entity;

/**
 * Tipe transaksi keuangan.
 * Setiap tipe membawa label tampilannya sendiri agar logika format
 * tidak tersebar di presenter/view.
 */
public enum TransactionType {
    INCOME("Pemasukan"),
    EXPENSE("Pengeluaran");

    private final String label;

    TransactionType(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}