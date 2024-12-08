import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Album {
    private final SimpleStringProperty albumName;
    private final SimpleStringProperty artist;
    private final SimpleIntegerProperty total;
    private final SimpleIntegerProperty available;
    private final SimpleIntegerProperty rented;

    public Album(String albumName, String artist, int total, int available, int rented) {
        this.albumName = new SimpleStringProperty(albumName);
        this.artist = new SimpleStringProperty(artist);
        this.total = new SimpleIntegerProperty(total);
        this.available = new SimpleIntegerProperty(available);
        this.rented = new SimpleIntegerProperty(rented);
    }

    public String getAlbumName() { return albumName.get(); }
    public void setAlbumName(String albumName) { this.albumName.set(albumName); }
    public SimpleStringProperty albumNameProperty() { return albumName; }

    public String getArtist() { return artist.get(); }
    public void setArtist(String artist) { this.artist.set(artist); }
    public SimpleStringProperty artistProperty() { return artist; }

    public int getTotal() { return total.get(); }
    public void setTotal(int total) { this.total.set(total); }
    public SimpleIntegerProperty totalProperty() { return total; }

    public int getAvailable() { return available.get(); }
    public void setAvailable(int available) { this.available.set(available); }
    public SimpleIntegerProperty availableProperty() { return available; }

    public int getRented() { return rented.get(); }
    public void setRented(int rented) { this.rented.set(rented); }
    public SimpleIntegerProperty rentedProperty() { return rented; }
}
