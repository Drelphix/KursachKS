package sample.Form;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {

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
    private JFXButton SignUP;

    @FXML
    private JFXCheckBox CheckRememberMe;

    @FXML
    void LoginInServer(ActionEvent event) {

    }

    @FXML
    void ShowSignUP(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert PasswordField != null : "fx:id=\"PasswordField\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert LoginField != null : "fx:id=\"LoginField\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert SignUP != null : "fx:id=\"SignUP\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert CheckRememberMe != null : "fx:id=\"CheckRememberMe\" was not injected: check your FXML file 'LoginForm.fxml'.";

    }
}
