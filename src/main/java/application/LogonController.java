package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LogonController {

    @FXML
    Button btLogon;

    @FXML
    Label lbInitReg;

    @FXML
    void logon() {

        btLogon.setOnAction(actionEvent -> {
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
