class KomputerVIP extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    private boolean vipcard;

    
    
    // To do: Buatlah constructor pada class KomputerVIP
    public KomputerVIP(int JumlahKomputer, String NamaWarnet, float HargaPerJam) {
        super(JumlahKomputer, NamaWarnet, HargaPerJam);
    }
    

    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    @Override
    public void Informasi(){
        if (vipcard == true){
            System.out.println("Informasi Komputer:");
            System.out.println("Jumlah Komputer:" + JumlahKomputer);
            System.out.println(" Nama Warnet:" + NamaWarnet);
            System.out.println("Harga Per Jam:" + HargaPerJam);
            System.out.println("Status: Member VIP\n");
        

        }
        else {
        System.out.println("Informasi Komputer:");
        System.out.println("Jumlah Komputer:" + JumlahKomputer);
        System.out.println(" Nama Warnet:" + NamaWarnet);
        System.out.println("Harga Per Jam:" + HargaPerJam);
        System.out.println("Status: Member Jelata\n");
        }

    }

    
    // To do: Buatlah method Login sesuai dengan ketentuan
    
    // To do: Buatlah method Bermain sesuai dengan ketentuan
    
    // To do: Buatlah method Bermain memakai Polymorphism Overloading sesuai dengan ketentuan

}