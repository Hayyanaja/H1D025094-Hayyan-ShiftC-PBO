public class DispenserManual extends DispenserPakan {
    private boolean tombolDitekan;

    public DispenserManual(String idAlat, String namaHewan) {
        super(idAlat, namaHewan);
        this.tombolDitekan = false;
    }

    public void tekanTombol() {
        this.tombolDitekan = true;
        System.out.println("Tombol dipencet");
    }

    @Override
    public void cekKondisiDanJalan() {
        if (this.tombolDitekan && !apakahPakanHabis()) {
            int pakanBaru = getsisaPakanGram() - 40;
            setsisaPakanGram(pakanBaru);
            System.out.println("Dispenser manual: berhasil mengeluarkan 40g pakan. ");
            this.tombolDitekan = false;
        } else if (apakahPakanHabis()) {
            System.out.println("Dispenser manual: oops gagal keluar, ditangki abis jir");
        } else {
            System.out.println("Dispenser manual: blom dipencet kunyuk, pakan ga kluar nih");
        }
    }
}