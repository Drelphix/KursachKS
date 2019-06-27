package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController {
    Parent blah = null;
    Connect connect = Main.connect;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton CreateAccount;

    @FXML
    private ImageView PasswordFieldReg1;

    @FXML
    private TextField LoginField;

    @FXML
    private JFXButton BackLoginForm;

    @FXML
    private PasswordField PasswordField1;

    @FXML
    private TextField EmailField;

    @FXML
    private AnchorPane UsernameUse;

    @FXML
    void ClickMessageUsernameUse(MouseEvent event) {
        UsernameUse.setVisible(false);
    }

    @FXML
    void BackLoginForm(ActionEvent event) {
        Main.primaryStage.show();
        Stage stage = (Stage) BackLoginForm.getScene().getWindow();
        stage.close();

    }

    @FXML
    void CreateAccount(ActionEvent event) {
        try {
            if (connect.Authorization(LoginField.getText(), PasswordField1.getText(), EmailField.getText())) {
                blah = FXMLLoader.load(getClass().getResource("Form/ChatMain.fxml"));
                Scene scene = new Scene(blah, 600, 400);
                LoginController.NewScene(scene);
            } else {
                UsernameUse.setVisible(true);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    void initialize() {
        assert CreateAccount != null : "fx:id=\"CreateAccount\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldReg1 != null : "fx:id=\"PasswordFieldReg1\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert EmailField != null : "fx:id=\"EmailField\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert LoginField != null : "fx:id=\"LoginField\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert BackLoginForm != null : "fx:id=\"BackLoginForm\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordField1 != null : "fx:id=\"PasswordField1\" was not injected: check your FXML file 'RegisterForm.fxml'.";

    }
}


