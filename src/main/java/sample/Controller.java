package sample;

import com.google.firebase.database.DatabaseReference;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.List;

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
    private List<Courses> coursesList;


    @FXML
    void inicialize() {
        reference = Firebase.getInstance().getDatabaseReference();



        btRegister.setOnAction(actionEvent -> {
            System.out.println("Botão Registro selecionado");
            Courses courses = new Courses(cbCtl.isSelected(), cbMaturidade.isSelected(), cbCeifeiros.isSelected());
            MemberShip memberShip = getMemberShip(courses);

            reference.child("Membro").child(memberShip.getName())
                    .setValue(memberShip, ((databaseError, databaseReference) ->
                    System.out.println("\n\ndone writhing firebase")));
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

    private void clearForm(){
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

}
