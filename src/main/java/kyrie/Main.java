package kyrie;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Kyrie kyrie = new Kyrie("./data");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Kyrie");
            fxmlLoader.<MainWindow>getController().setKyrie(kyrie);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}