package application.cadMembers;

import application.model.Courses;
import application.network.Firebase;
import application.model.MemberShip;
import application.util.Toast;
import com.google.firebase.database.DatabaseReference;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class CadMembersController {

    @FXML
    Button btRegister;
    @FXML
    TextField tfName;
    @FXML
    TextField tfLastName;
    @FXML
    TextField tfPhone;
    @FXML
    TextField tfAddress;
    @FXML
    TextField tfMembershipLeader;
    @FXML
    TextField tfEmail;
    @FXML
    TextField tfMembershipDiscipleship;
    @FXML
    CheckBox cbMaturidade;
    @FXML
    CheckBox cbCtl;
    @FXML
    CheckBox cbCeifeiros;


    private DatabaseReference reference;


    @FXML
    void inicialize() {
        reference = Firebase.getFirebaseInstance().getDatabaseReference();


        btRegister.setOnAction(actionEvent -> {
            String name = tfName.getText().toString();
            System.out.println("Botão Registro selecionado");
            Courses courses = new Courses(cbCtl.isSelected(), cbMaturidade.isSelected(), cbCeifeiros.isSelected());
            if (Objects.deepEquals(name, " ") || Objects.deepEquals(name, "")) {
                showToast("O Nome do Membro é um campo Obrigatório");
            } else {
                MemberShip memberShip = getMemberShip(courses);
                reference.child("Membro").child(reference.push().getKey())
                        .setValue(memberShip, ((databaseError, databaseReference) ->
                                System.out.println("\n\ndone writhing firebase")));
            }

            clearForm();
        });
    }

    private MemberShip getMemberShip(Courses courses) {
        MemberShip memberShip = new MemberShip();
        memberShip.setName(tfName.getText());
        memberShip.setLastName(tfLastName.getText());
        memberShip.setPhone(tfPhone.getText());
        memberShip.setAddress(tfAddress.getText());
        memberShip.setLeader(tfMembershipLeader.getText());
        memberShip.setDiscipleship(tfMembershipDiscipleship.getText());
        memberShip.setCourses(courses);
        return memberShip;
    }

    private void clearForm() {
        tfName.clear();
        tfAddress.clear();
        tfLastName.clear();
        tfMembershipDiscipleship.clear();
        tfMembershipLeader.clear();
        tfPhone.clear();
        tfEmail.clear();
        cbCeifeiros.setSelected(false);
        cbCtl.setSelected(false);
        cbMaturidade.setSelected(false);
    }

    public static void showToast(String toastMsg) {
        Stage stage = new Stage();
        int toastMsgTime = 750;
        int fadeInTime = 500;
        int fadeOutTime = 500;
        Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
    }

}
