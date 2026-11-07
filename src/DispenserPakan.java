public abstract class DispenserPakan {
    public static final int KAPASITAS_MAKSIMAL = 150;
    private final String idAlat;
    private String namaHewan;
    private int sisaPakanGram;

    public DispenserPakan(String idAlat, String namaHewan) {
        this.idAlat = idAlat;
        this.namaHewan = namaHewan;
        this.sisaPakanGram = KAPASITAS_MAKSIMAL;
    }

    public DispenserPakan(String idAlat, String namaHewan, int sisaPakanGram) {
        this.idAlat = idAlat;
        this.namaHewan = namaHewan;
        this.sisaPakanGram = sisaPakanGram;
    }

    public abstract void cekKondisiDanJalan();

    public void tampilkanStatus() {
        System.out.println(idAlat + " | Baginda | " + namaHewan + " Sisa: | " + sisaPakanGram + " g ");
    }

    public boolean apakahPakanHabis() {
        return this.sisaPakanGram <= 10;
    }

    public String getIdAlat() {
        return idAlat;
    }

    public String getnamaHewan() {
        return namaHewan;
    }

    public void setnamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    public int getsisaPakanGram() {
        return sisaPakanGram;
    }

    public void setsisaPakanGram(int sisaPakanGram) {
        this.sisaPakanGram = sisaPakanGram;
    }
}