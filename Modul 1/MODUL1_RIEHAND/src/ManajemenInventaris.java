// Don't delete any comments below!!!
// Todo : Import Arraylist and Scanner
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenInventaris {
    // Todo : Create ArrayList of MakananKering (daftarMakananKering) and MakananBasah (daftarMakananBasah) to store items
    ArrayList<MakananKering> daftarMakananKering = new ArrayList<>();
    ArrayList<MakananBasah> daftarMakananBasah = new ArrayList<>();

    static Scanner Scanner = new Scanner (System.in);
}


    public void tambahMakananKering() {
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Brand Makanan
        System.out.println("Masukan Nama Makanan: ");
        String NamaMakanan = Scanner.nextLine ();
        System.out.println("Masukan Jumlah Makanan: ");
        int JumlahMakanan = Scanner.nextInt();
        System.out.println("Masukan Harga Makanan: ");
        Scanner.nextLine()
        int HargaMakanan = Scanner.nextInt();
        System.out.println("Masukan Brand Makanan: ");
        String BrandMakanan = Scanner.nextLine ();


        // Todo : Create a new object for MakananKering
        
        // Todo : Create Print Notifitaction "Makanan kering berhasil ditambahkan"
        
    }

    public void tambahMakananBasah() {
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Bahan Makanan

        // Todo : Create a new object for MakananBasah
        
        // Todo :Create Print Notifitaction "Makanan Basah berhasil ditambahkan"
    }

    public void tampilkanSemuaMakanan() {
        if (daftarMakananKering.isEmpty() && daftarMakananBasah.isEmpty()) {
            // Todo : Create Print Notification "Tidak ada makanan disini"
        } else {
            // Todo : Create print notification for Makanan Kering  
            for 
            }
            // Todo : Create print notification for  Makanan Basah
            for 
            }
        }
    }
}
