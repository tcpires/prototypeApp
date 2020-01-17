package sample;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        FileInputStream serviceAccount = null;
        FirebaseOptions options = null;

        try {
            serviceAccount = new FileInputStream( "churchcontrol-f48b1-firebase-adminsdk-x9y7u-eb7d609a0e.json");
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://churchcontrol-f48b1.firebaseio.com/")
                    .build();
        }catch (IOException e){
            e.printStackTrace();
        }
        FirebaseApp.initializeApp(Objects.requireNonNull(options));
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/sample/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


}
