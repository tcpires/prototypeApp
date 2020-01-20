package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/sample/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Church Control v-1.0");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Firebase.getInstance().initFirebase();
    }


}
