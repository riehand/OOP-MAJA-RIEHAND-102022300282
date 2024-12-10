import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainAppController {

    @FXML
    private TableView<Task> taskTable; // Tabel untuk menampilkan daftar tugas
    @FXML
    private TableColumn<Task, String> titleCol, priorityCol, statusCol; // Kolom untuk judul, prioritas, dan status tugas
    @FXML
    private TableColumn<Task, LocalDate> dueDateCol; // Kolom untuk tanggal jatuh tempo
    @FXML
    private TextField titleField; // Field untuk memasukkan judul tugas
    @FXML
    private ComboBox<String> priorityBox; // ComboBox untuk memilih prioritas
    @FXML
    private DatePicker dueDatePicker; // DatePicker untuk memilih tanggal jatuh tempo

    private ObservableList<Task> taskList; // Daftar tugas yang dapat diamati

    @FXML
    public void initialize() {
        taskList = FXCollections.observableArrayList(TaskFileManager.loadTasks());

        // Konfigurasi kolom tabel
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        priorityCol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Atur lebar kolom
        titleCol.setPrefWidth(150);
        priorityCol.setPrefWidth(100);
        dueDateCol.setPrefWidth(150);
        statusCol.setPrefWidth(100);

        taskTable.setItems(taskList);

        // Tambahkan pilihan prioritas ke ComboBox
        priorityBox.getItems().addAll("High", "Medium", "Low");
    }

    @FXML
    private void addTask() {
        try {
            if (titleField.getText().isEmpty() || priorityBox.getValue() == null || dueDatePicker.getValue() == null) {
                throw new MissingFieldException("All fields must be filled!");
            }

            if (dueDatePicker.getValue().isBefore(LocalDate.now())) {
                throw new InvalidDateException("The due date cannot be in the past!");
            }

            // Buat objek Task baru
            Task task = new Task(
                titleField.getText(),
                priorityBox.getValue(),
                "Incomplete",
                dueDatePicker.getValue()
            );

            // Tambahkan task ke daftar
            taskList.add(task);
            clearData();
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        } catch (MissingFieldException | InvalidDateException e) {
            showError(e.getMessage());
        }
    }

    private void clearData() {
        titleField.clear();
        priorityBox.getSelectionModel().clearSelection();
        dueDatePicker.setValue(null);
    }

    @FXML
    private void deleteTask() {
        try {
            Task selected = taskTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new TaskNotSelectedException("No task selected for deletion!");
            }

            taskList.remove(selected);
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        } catch (TaskNotSelectedException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void markTaskComplete() {
        try {
            Task selected = taskTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new TaskNotSelectedException("No task selected to mark as complete!");
            }

            selected.setStatus("Completed");
            taskTable.refresh();
            TaskFileManager.saveTasks(new ArrayList<>(taskList));
        } catch (TaskNotSelectedException e) {
            showError(e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    // Custom Exceptions
    class MissingFieldException extends Exception {
        public MissingFieldException(String message) {
            super(message);
        }
    }

    class InvalidDateException extends Exception {
        public InvalidDateException(String message) {
            super(message);
        }
    }

    class TaskNotSelectedException extends Exception {
        public TaskNotSelectedException(String message) {
            super(message);
        }
    }
}