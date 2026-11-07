import java.awt.desktop.SystemSleepEvent;

public class DispenserPintar extends DispenserPakan implements BisaBeriMakan, BisaKonek{
    private boolean terhubungWifi;

    public DispenserPintar(String idAlat, String namaHewan) {
        super(idAlat, namaHewan);
        this.terhubungWifi = true;
    }

    @Override
    public void keluarkanPakan(int gram) {
        if(!apakahPakanHabis()) {
            int pakanSisa = getsisaPakanGram() - gram;
            setsisaPakanGram(pakanSisa);
            System.out.println("Dispenser pintar: yeay kluar " + gram + "g secara otomatis");
        }
    }

    @Override
    public void kirimNotif(String pesan) {
        System.out.println("[NOTIF HP] " + pesan);
    }

    @Override
    public boolean cekKoneksi() {
        return this.terhubungWifi;
    }

    @Override
    public void cekKondisiDanJalan() {
        if (cekKoneksi() && getsisaPakanGram() < 50 && !apakahPakanHabis()) {
            int sisaSebelum = getsisaPakanGram(); // Simpan angka sisa awal (misal 40g)
            keluarkanPakan(sisaSebelum); // Dikeluarkan habis 40g
            kirimNotif("Sisa pakan menipis (" + sisaSebelum + "g), otomatis ngeluarin " + sisaSebelum + "g buat Baginda: " + getnamaHewan());
        } else if (apakahPakanHabis()) {
            kirimNotif("WOII!! pakan buat Baginda: " + getnamaHewan() + " habis total, segera refill!!!");
        } else {
            System.out.println("Sisa pakan masih cukup (" + getsisaPakanGram() + "g), dispenser pintar belum perlu ngeluarin pakan.");
        }
    }
    @Override
    public void tampilkanStatus() {
        super.tampilkanStatus();
        System.out.println("Status Koneksi: " + (terhubungWifi ? "Online" : "Offline"));
    }
}
