public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("=== 1. PENGUJIAN DISPENSER MANUAL             ===");
        System.out.println("=================================================");
        DispenserManual manual = new DispenserManual("ALT-01", " Dimas");
        manual.tampilkanStatus();

        System.out.println("\n[Skenario 1: Coba jalan tanpa pencet tombol]");
        manual.cekKondisiDanJalan();

        System.out.println("\n[Skenario 2: Pencet tombol lalu jalan]");
        manual.tekanTombol();
        manual.cekKondisiDanJalan();
        manual.tampilkanStatus();

        System.out.println("\n=================================================");
        System.out.println("=== 2. PENGUJIAN DISPENSER PINTAR (IOT AUTO)  ===");
        System.out.println("=================================================");
        DispenserPintar pintar = new DispenserPintar("PTR-01", "Dharma");
        pintar.tampilkanStatus();

        System.out.println("\n[Skenario 1: Sisa pakan masih banyak (150g)]");
        pintar.cekKondisiDanJalan();

        System.out.println("\n[Skenario 2: Sisa pakan menipis (Diset 40g)]");
        pintar.setsisaPakanGram(40);
        pintar.cekKondisiDanJalan(); // Otomatis ngeluarin 150g & kirim notif HP!
        pintar.tampilkanStatus();   // Sisa pakan bakal berkurang jadi 100g

        System.out.println("\n[Skenario 3: Simulasi pakan habis total (Diset 5g)]");
        pintar.setsisaPakanGram(5);
        pintar.cekKondisiDanJalan(); // Kirim notif peringatan refill

        System.out.println("\n=================================================");
        System.out.println("=== 3. PROOF POLIMORFISME INTERFACE           ===");
        System.out.println("=================================================");
        BisaBeriMakan pakanPintar = new DispenserPintar("PTR-02", "Mimi");
        pakanPintar.keluarkanPakan(40);

        BisaKonek konekPintar = new DispenserPintar("PTR-03", "Cleo");
        konekPintar.kirimNotif("Tes Koneksi Berhasil yeay!!");

        System.out.println("\n=================================================");
    }
}