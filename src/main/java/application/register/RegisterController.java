package application.register;

import application.model.Pastor;
import application.network.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    TextField tfRegName;
    @FXML
    TextField tfRegLastName;
    @FXML
    TextField tfRegEmail;
    @FXML
    TextField tfRegCellphone;
    @FXML
    TextField tfRegChurch;
    @FXML
    TextField tfRegUserName;
    @FXML
    TextField tfRegPassword;
    @FXML
    TextField tfRegConfirmPassword;
    @FXML
    Button btRegister;

    private FirebaseAuth auth;

    private Boolean verifyPassword() {
        if (tfRegPassword.getText().equals(tfRegConfirmPassword.getText())) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void registerPastor() {

        btRegister.setOnAction(actionEvent -> {

            auth = Firebase.getAuthInstance();
            Pastor pastor = getPastor();
            UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest();
            createRequest.setUid(pastor.getUsername());
            createRequest.setEmail(pastor.getEmail());
            createRequest.setDisplayName(pastor.getName());
            createRequest.setPassword(pastor.getPassword());
            createRequest.setPhoneNumber(pastor.getCellPhone());

            try {
                auth.createUser(createRequest);
                System.out.println("Pastor Registrado: " + pastor.getName());

            } catch (FirebaseAuthException e) {
                e.printStackTrace();
            }
        });
    }

    private Pastor getPastor() {
        Pastor pastor = new Pastor();
        pastor.setName(tfRegName.getText());
        pastor.setLastName(tfRegLastName.getText());
        pastor.setEmail(tfRegEmail.getText());
        pastor.setCellPhone(tfRegCellphone.getText());
        pastor.setChurch(tfRegChurch.getText());
        pastor.setUsername(tfRegUserName.getText());
        pastor.setPassword(tfRegPassword.getText());

        return pastor;
    }
}
