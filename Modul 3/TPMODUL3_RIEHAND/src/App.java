import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        showLoginPage();
    }

    public static void showLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Login.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Zeppeli's Listening Barr");
        primaryStage.show();
    }

    public static void showInventoryPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("Inventory.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Zeppeli's Listening Barr");
        primaryStage.show();
    }
}
