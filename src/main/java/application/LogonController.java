package application;

import application.network.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogonController {

    @FXML
    Button btLogon;
    @FXML
    Label lbInitReg;
    @FXML
    TextField tfLogin;
    @FXML
    TextField tfPassword;

    private FirebaseAuth firebaseAuth;
    private UserRecord pastor;

    @FXML
    void logon() {
        btLogon.setOnAction(actionEvent -> {

           firebaseAuth =  Firebase.getAuthInstance();
            try {
                pastor = firebaseAuth.getUser(tfLogin.getText());

            } catch (FirebaseAuthException e) {
                e.printStackTrace();
            }

            Principal.changeScreen("regMembers");
        });
    }

    @FXML
    void register(){
        lbInitReg.setOnMouseClicked(mouseEvent -> {
            Principal.changeScreen("regPastors");
        });

    }
}
