// Dipinsa Marasini
// JavaFX Music Store — MavTunes
// Advanced Application Development | UT Arlington

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("javatunes.fxml"));
        Scene scene = new Scene(loader.load(), 800, 390);
        primaryStage.setTitle("Mav Tunes");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
