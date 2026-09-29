package domain.entity;

/**
 * Entity inti yang merepresentasikan satu transaksi keuangan.
 * Berada di layer domain — tidak bergantung pada tampilan maupun penyimpanan.
 */
public class Transaction {
    /** ID unik transaksi, tidak boleh diubah setelah dibuat. */
    private final int id;

    /** Keterangan/deskripsi transaksi. */
    private String description;

    /** Nominal transaksi (selalu positif). */
    private long amount;

    /** Tipe transaksi: Pemasukan atau Pengeluaran. */
    private TransactionType type;

    public Transaction(int id, String description, long amount, TransactionType type) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public long getAmount() { return amount; }
    public TransactionType getType() { return type; }

    public void changeDescription(String description) { this.description = description; }
    public void changeAmount(long amount) { this.amount = amount; }
    public void changeType(TransactionType type) { this.type = type; }
}