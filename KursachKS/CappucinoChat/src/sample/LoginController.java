package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton Login;

    @FXML
    private JFXButton SignUP;

    @FXML
    private JFXCheckBox CheckRememberMe;

    @FXML
    private TextField LoginField;

    @FXML
    private TextField PasswordField;

    @FXML
    void LoginInServer(ActionEvent event) {

    }

    @FXML
    void ShowSignUP(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert SignUP != null : "fx:id=\"SignUP\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert CheckRememberMe != null : "fx:id=\"CheckRememberMe\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert LoginField != null : "fx:id=\"LoginField\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert PasswordField != null : "fx:id=\"PasswordField\" was not injected: check your FXML file 'LoginForm.fxml'.";

    }
}
