import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class InventoryController {
    @FXML
    private TableView<Album> tableView;
    @FXML
    private TableColumn<Album, String> columnAlbumName;
    @FXML
    private TableColumn<Album, String> columnArtist;
    @FXML
    private TableColumn<Album, Integer> columnTotal;
    @FXML
    private TableColumn<Album, Integer> columnAvailable;

    @FXML
    private TextField txtAlbumName;
    @FXML
    private TextField txtArtist;
    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtAvailable;

    private ObservableList<Album> albumList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        columnAlbumName.setCellValueFactory(data -> data.getValue().albumNameProperty());
        columnArtist.setCellValueFactory(data -> data.getValue().artistProperty());
        columnTotal.setCellValueFactory(data -> data.getValue().totalProperty().asObject());
        columnAvailable.setCellValueFactory(data -> data.getValue().availableProperty().asObject());

        tableView.setItems(albumList);
    }

    @FXML
    private void handleAdd() {
        try {
            String albumName = txtAlbumName.getText();
            String artist = txtArtist.getText();
            int total = Integer.parseInt(txtTotal.getText());
            int available = Integer.parseInt(txtAvailable.getText());

            if (total < 0 || available < 0 || available > total) {
                showError("Jumlah tidak boleh negatif atau stok tersedia melebihi total.");
                return;
            }

            Album album = new Album(albumName, artist, total, available, total - available);
            albumList.add(album);
            showAlert("Album \"" + albumName + "\" berhasil ditambahkan.");
            clearTextFields();
        } catch (NumberFormatException e) {
            showError("Masukkan angka yang valid untuk jumlah total dan stok tersedia.");
        }
    }

    @FXML
    private void handleDelete() {
        Album selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            albumList.remove(selected);
            showAlert("Album berhasil dihapus.");
            clearTextFields();
        } else {
            showError("Pilih album yang ingin dihapus.");
        }
    }

    @FXML
    private void handleUpdate() {
        Album selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                String albumName = txtAlbumName.getText();
                String artist = txtArtist.getText();
                int total = Integer.parseInt(txtTotal.getText());
                int available = Integer.parseInt(txtAvailable.getText());

                if (total < 0 || available < 0 || available > total) {
                    showError("Input jumlah tidak valid. Pastikan tidak ada nilai negatif.");
                    return;
                }

                selected.setAlbumName(albumName);
                selected.setArtist(artist);
                selected.setTotal(total);
                selected.setAvailable(available);
                tableView.refresh();
                showAlert("Album \"" + albumName + "\" berhasil diperbarui.");
                clearTextFields();
            } catch (NumberFormatException e) {
                showError("Pastikan semua data yang dimasukkan sesuai format.");
            }
        } else {
            showError("Pilih album yang ingin diperbarui.");
        }
    }

    @FXML
    private void handleTableClick(MouseEvent event) {
        Album selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txtAlbumName.setText(selected.getAlbumName());
            txtArtist.setText(selected.getArtist());
            txtTotal.setText(String.valueOf(selected.getTotal()));
            txtAvailable.setText(String.valueOf(selected.getAvailable()));
        }
    }

    private void clearTextFields() {
        txtAlbumName.clear();
        txtArtist.clear();
        txtTotal.clear();
        txtAvailable.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    private void handleRent(ActionEvent event) {
        Album selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            int available = selected.getAvailable();
            if (available > 0) {
                selected.setAvailable(available - 1);
                tableView.refresh();
                showAlert("Album berhasil dipinjamkan.");
            } else {
                showError("Stok album habis.");
            }
        } else {
            showError("Pilih album yang ingin dipinjamkan.");
        }
    }
}
