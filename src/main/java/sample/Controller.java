package sample;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    Button btRegister;

    @FXML
    TextField tfName;

    @FXML
    TextField tfLastName;

    @FXML
    TextField tfPhone;

    @FXML
    void inicialize() {
        btRegister.setOnAction(actionEvent -> {
            System.out.println("Botão Registro selecionado");
            MemberShip memberShip = new MemberShip();
            memberShip.setName(tfName.toString());

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            ref.child("Membro").setValue(memberShip, ((databaseError, databaseReference) ->
                    System.out.println("\n\ndone writhing firebase")));
        });
    }

}
