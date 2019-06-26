package sample.Form;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField PasswordField;

    @FXML
    private JFXTextField LoginField;

    @FXML
    private JFXButton Login;

    @FXML
    private JFXTextField PasswordField1;

    @FXML
    private ImageView PasswordFieldReg1;

    @FXML
    private ImageView PasswordFieldReg2;

    @FXML
    private ImageView PasswordFieldRegDone1;

    @FXML
    private ImageView PasswordFieldRegDone2;

    @FXML
    void CreateAccount(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert PasswordField != null : "fx:id=\"PasswordField\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert LoginField != null : "fx:id=\"LoginField\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordField1 != null : "fx:id=\"PasswordField1\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldReg1 != null : "fx:id=\"PasswordFieldReg1\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldReg2 != null : "fx:id=\"PasswordFieldReg2\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldRegDone1 != null : "fx:id=\"PasswordFieldRegDone1\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldRegDone2 != null : "fx:id=\"PasswordFieldRegDone2\" was not injected: check your FXML file 'RegisterForm.fxml'.";

    }
}
