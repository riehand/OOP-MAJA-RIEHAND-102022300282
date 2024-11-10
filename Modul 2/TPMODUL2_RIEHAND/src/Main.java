public class Main {
    public static void main(String[] args) {
        System.out.println("Detail Hewan\n");

        Kucing kucing = new Kucing("Miko", 2, "Persia");
        Burung burung = new Burung("Reza", 1, "Merah");

        // Output untuk Kucing
        System.out.println("ini adalah " + kucing.nama + " !");
        kucing.suara();
        kucing.makan();
        kucing.makan("ikan");

        System.out.println();

        // Output untuk Burung
        System.out.println("ini adalah " + burung.nama + " !");
        burung.suara();
        burung.makan();
        burung.makan("biji-bijian");

        System.out.println();

        // Informasi detail hewan
        kucing.infoHewan();
        burung.infoHewan();
    }
}