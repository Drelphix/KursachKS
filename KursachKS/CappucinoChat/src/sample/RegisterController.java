package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private ImageView PasswordFieldReg2;

    @FXML
    private ImageView PasswordFieldRegDone1;

    @FXML
    private ImageView PasswordFieldRegDone2;

    @FXML
    private TextField LoginField;

    @FXML
    private JFXButton BackLoginForm;

    @FXML
    private PasswordField PasswordField1;

    @FXML
    private PasswordField PasswordField2;


    @FXML
    void BackLoginForm(ActionEvent event) {
        Main.primaryStage.show();
        Stage stage = (Stage) BackLoginForm.getScene().getWindow();
        stage.close();

    }

    @FXML
    void CreateAccount(ActionEvent event) {
        try {
            if(connect.Authorization(LoginField.getText(), PasswordField1.getText(),PasswordField2.getText())){
                blah = FXMLLoader.load(getClass().getResource("Form/ChatMain.fxml"));
                Scene scene = new Scene(blah, 600, 400);
                LoginController.NewScene(scene);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert CreateAccount != null : "fx:id=\"CreateAccount\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldReg1 != null : "fx:id=\"PasswordFieldReg1\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldReg2 != null : "fx:id=\"PasswordFieldReg2\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldRegDone1 != null : "fx:id=\"PasswordFieldRegDone1\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordFieldRegDone2 != null : "fx:id=\"PasswordFieldRegDone2\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert LoginField != null : "fx:id=\"LoginField\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert BackLoginForm != null : "fx:id=\"BackLoginForm\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordField2 != null : "fx:id=\"PasswordField2\" was not injected: check your FXML file 'RegisterForm.fxml'.";
        assert PasswordField1 != null : "fx:id=\"PasswordField1\" was not injected: check your FXML file 'RegisterForm.fxml'.";

    }
}

