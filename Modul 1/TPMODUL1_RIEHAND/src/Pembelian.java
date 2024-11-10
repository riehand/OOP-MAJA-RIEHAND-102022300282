import java.util.ArrayList;
import java.util.Scanner;

class Penerbangan {
    private String nomorPenerbangan;
    private String bandaraKeberangkatan;
    private String bandaraTujuan;
    private String waktuKeberangkatan;
    private String waktuKedatangan;
    private float hargaTiket;

    public Penerbangan(String nomorPenerbangan, String bandaraKeberangkatan, String bandaraTujuan, String waktuKeberangkatan, String waktuKedatangan, float hargaTiket) {
        this.nomorPenerbangan = nomorPenerbangan;
        this.bandaraKeberangkatan = bandaraKeberangkatan;
        this.bandaraTujuan = bandaraTujuan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.hargaTiket = hargaTiket;
    }

    public String getNomorPenerbangan() {
        return nomorPenerbangan;
    }

    public String getBandaraKeberangkatan() {
        return bandaraKeberangkatan;
    }

    public String getBandaraTujuan() {
        return bandaraTujuan;
    }

    public String getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public float getHargaTiket() {
        return hargaTiket;
    }

    public void tampilDaftarPenerbangan() {
        sysout
        System.out.println("Nomor Penerbangan: " + nomorPenerbangan);
        System.out.println("Bandara Keberangkatan: " + bandaraKeberangkatan);
        System.out.println("Bandara Tujuan: " + bandaraTujuan);
        System.out.println("Waktu Keberangkatan: " + waktuKeberangkatan);
        System.out.println("Waktu Kedatangan: " + waktuKedatangan);
        System.out.println("Harga Tiket: " + hargaTiket);
    }
}

class Penumpang {
    private String NIK;
    private String namaDepan;
    private String namaBelakang;

    public Penumpang(String NIK, String namaDepan, String namaBelakang) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public void tampilDaftarPenumpang() {
        System.out.println("NIK: " + NIK);
        System.out.println("Nama Depan: " + namaDepan);
        System.out.println("Nama Belakang: " + namaBelakang);
    }
}

public class Pembelian {
    private ArrayList<Penerbangan> daftarPenerbangan;
    private Penerbangan penerbanganTerpilih;
    private Penumpang penumpang;
    private Scanner scanner;

    public Pembelian() {
        daftarPenerbangan = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void tambahPenerbangan() {
        daftarPenerbangan.add(new Penerbangan("GA100", "Jakarta", "Bali", "10:00", "12:00", 1500000));
        daftarPenerbangan.add(new Penerbangan("GA200", "Jakarta", "Surabaya", "14:00", "16:00", 1200000));
        daftarPenerbangan.add(new Penerbangan("GA300", "Jakarta", "Yogyakarta", "18:00", "20:00", 1000000));
    }

    public void tampilkanDaftarPenerbangan() {
        if (daftarPenerbangan.isEmpty()) {
            System.out.println("Pembelian Tiket tidak ada.");
        } else {
            System.out.println("Daftar Penerbangan:");
            for (int i = 0; i < daftarPenerbangan.size(); i++) {
                System.out.println("[" + (i+1) + "] ");
                daftarPenerbangan.get(i).tampilDaftarPenerbangan();
                System.out.println("---------------------------");
            }
        }
    }

    public void beliTiket() {
        tampilkanDaftarPenerbangan();
        System.out.print("Pilih nomor penerbangan yang ingin Anda pesan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();  

        if (pilihan > 0 && pilihan <= daftarPenerbangan.size()) {
            penerbanganTerpilih = daftarPenerbangan.get(pilihan - 1);
            System.out.print("Masukkan NIK: ");
            String NIK = scanner.nextLine();
            System.out.print("Masukkan Nama Depan: ");
            String namaDepan = scanner.nextLine();
            System.out.print("Masukkan Nama Belakang: ");
            String namaBelakang = scanner.nextLine();

            penumpang = new Penumpang(NIK, namaDepan, namaBelakang);
            System.out.println("Tiket berhasil dipesan!");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public void tampilkanPesananTiket() {
        if (penumpang == null || penerbanganTerpilih == null) {
            System.out.println("Belum ada tiket yang dipesan.");
        } else {
            System.out.println("==== Detail Tiket Penerbangan ====");
            penumpang.tampilDaftarPenumpang();
            penerbanganTerpilih.tampilDaftarPenerbangan();
        }
    }

    public static void main(String[] args) {
        Pembelian pembelian = new Pembelian();
        pembelian.tambahPenerbangan(); 
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("==== EAD Ticket Booking System ====");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  

            switch (pilihan) {
                case 1:
                    pembelian.tampilkanDaftarPenerbangan();
                    break;
                case 2:
                    pembelian.beliTiket();
                    break;
                case 3:
                    pembelian.tampilkanPesananTiket();
                    break;
                case 4:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
        scanner.close();
    }
}
