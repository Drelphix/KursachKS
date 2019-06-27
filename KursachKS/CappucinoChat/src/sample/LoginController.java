package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class LoginController {

    public static boolean Mode = true;
    Parent blah = null;
    Connect connect = Main.connect;

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
    private AnchorPane ConnectionMessage;

    @FXML
    void ClickMessageConnection(MouseEvent event) {
        //ConnectionMessage.setVisible(false);
    }

    @FXML
    void LoginInServer(ActionEvent event) {

        try {
            if(connect.Authorization(LoginField.getText(), PasswordField.getText())){
                blah = FXMLLoader.load(getClass().getResource("Form/ChatMain.fxml"));
                Scene scene = new Scene(blah, 600, 400);
                NewScene(scene);
            }
        } catch (Exception e) {
            e.printStackTrace();
            connect.Close();
        }
        //ConnectionMessage.setVisible(true);
    }

    static void NewScene(Scene scene){
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            Main.primaryStage.hide();
            stage.show();
        }

    @FXML
    void ShowSignUP(ActionEvent event) {
        try {
            blah = FXMLLoader.load(getClass().getResource("Form/RegisterForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(blah, 400, 350);
        NewScene(scene);
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
