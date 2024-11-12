class Komputer {
    // To do: Buatlah 3 variable sesuai ketentuan
    protected int JumlahKomputer;
    protected String NamaWarnet;
    protected float HargaPerJam;

    // To do: Buatlah constructor pada class Komputer
    public Komputer (int JumlahKomputer, String NamaWarnet, float HargaPerJam) {
        this.JumlahKomputer = JumlahKomputer;
        this.NamaWarnet = NamaWarnet;
        this.HargaPerJam = HargaPerJam;
    }
    
    // To do: Buatlah Method Informasi dengan isi yang sesuai dengan ketentuan 

    public void Informasi (){
        System.out.println("Informasi Komputer: ");
        System.out.println("Jumlah Komputer:" + JumlahKomputer + ", Nama Warnet:" + NamaWarnet +", Harga Per Jam" + HargaPerJam);


    }
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)

}