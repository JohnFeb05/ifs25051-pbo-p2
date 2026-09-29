package domain.entity;

/**
 * Entity inti yang merepresentasikan satu tamu.
 * Berada di layer domain — tidak bergantung pada tampilan maupun penyimpanan.
 */
public class Guest {
    /** ID unik tamu, tidak boleh diubah setelah dibuat. */
    private final int id;

    /** Nama tamu. */
    private String name;

    /** Tujuan kunjungan. */
    private String purpose;

    public Guest(int id, String name, String purpose) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPurpose() { return purpose; }

    // Setter disediakan jika di masa depan ada fitur ubah data tamu
    public void changeName(String name) { this.name = name; }
    public void changePurpose(String purpose) { this.purpose = purpose; }
}