package application.register;

import application.model.Pastor;
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

    private Boolean verifyPassword(){
        if (tfRegPassword.getText().equals(tfRegConfirmPassword.getText())){
            return true;
        }else {
            return false;
        }
    }

    @FXML
    private void registerPastor(){

    }

    private Pastor getPastor(){
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
