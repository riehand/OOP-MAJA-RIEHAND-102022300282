class KomputerPremium extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    private boolean ruangpremium;

// To do: Buatlah constructor pada class KomputerPremium
public KomputerPremium(int JumlahKomputer, String NamaWarnet, float HargaPerJam, boolean ruangpremium) {
    super(JumlahKomputer, NamaWarnet, HargaPerJam);
    this.ruangpremium = ruangpremium;
    }
    
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    @Override
    public void Informasi(){
        if (ruangpremium == true){
            System.out.println("Informasi Komputer:");
            System.out.println("Jumlah Komputer:" + JumlahKomputer);
            System.out.println(" Nama Warnet:" + NamaWarnet);
            System.out.println("Harga Per Jam:" + HargaPerJam);
            System.out.println("Status: Ruang Premium\n");
        

        }
        else {
        System.out.println("Informasi Komputer:");
        System.out.println("Jumlah Komputer:" + JumlahKomputer);
        System.out.println(" Nama Warnet:" + NamaWarnet);
        System.out.println("Harga Per Jam:" + HargaPerJam);
        System.out.println("Status: Ruang Stabndar\n");
        }

    }


// To do: Buatlah method Pesan sesuai dengan ketentuan
public void Pesan (){
    if (ruangpremium == true){
        System.out.println(" Fasilitas Ruang Premium: ");
        System.out.println("- Ruangan ber AC Pribadi");
        System.out.println("- Sofa Gaming Exclusive");
        System.out.println("- Komputer Spesifikasi Tinggi");
        System.out.println("- Koneksi Internet Dedicated 100Mbps");
    }
    else {

        System.out.println("- Ruangan spek kandang sapi");
    }


// To do: Buatlah method TambahLayanan sesuai dengan ketentuan
public void TambahLayanan (string makanan){
    System.out.println(" memesan komputer no: " + JumlahKomputer);
    System.out.println(" tambah layanan makanan:"+ makanan);

}



// To do: Buatlah method TambahLayanan memakai Polymorphism Overloading sesuai dengan ketentuan
public void TambahLayanan (String makanan, String minuman){
    System.out.println(" menambah makanan: "+ makanan, "minuman: "+ minuman);
}

}
