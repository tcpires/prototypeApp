package application;

import application.network.Firebase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class Principal extends Application {

    private static Stage stage;

    private static Scene regMembers;
    private static Scene regPastors;
    private static Scene logon;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Church Control v-1.0");
        stage = primaryStage;

        URL urlLogon = new File("src/main/java/application/logon.fxml").toURI().toURL();
        Parent fxmlLogon = FXMLLoader.load(urlLogon);
        logon = new Scene(fxmlLogon, 700, 400);

        URL urlCadMembers = new File("src/main/java/application/cadMembers/cadMembers.fxml").toURI().toURL();
        Parent fxmlCadMembers = FXMLLoader.load(urlCadMembers);
        regMembers = new Scene(fxmlCadMembers, 700, 400);

        URL urlCadPastors = new File("src/main/java/application/register/register.fxml").toURI().toURL();
        Parent fxmlCadPastors = FXMLLoader.load(urlCadPastors);
        regPastors = new Scene(fxmlCadPastors, 700, 400);

        primaryStage.setScene(logon);
        primaryStage.show();
        Firebase.getFirebaseInstance().initFirebase();
        Firebase.getAuthInstance();
    }

    public static void changeScreen(String scr){
        switch (scr){
            case "regMembers":
                stage.setScene(regMembers);
                break;

            case "regPastors":
                stage.setScene(regPastors);
                break;
        }
    }
}
