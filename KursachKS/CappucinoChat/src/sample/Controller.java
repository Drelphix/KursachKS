package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {

    Parent blah = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton ExitLoginForm;

    @FXML
    private JFXButton AboutForm;

    @FXML
    private JFXTextArea ListViewMessage;

    @FXML
    private JFXListView<?> ListViewUser;

    @FXML
    private JFXTextArea SendMessageTextArea;

    @FXML
    private JFXButton ClearMessageButton;

    @FXML
    private JFXButton SendMessageButton;

    @FXML
    void ClearMessageButton(ActionEvent event) {
        SendMessageTextArea.clear();
    }

    @FXML
    void AboutForm(ActionEvent event) {

    }

    @FXML
    void ExitLoginForm(ActionEvent event) {
        try {
            blah = FXMLLoader.load(getClass().getResource("Form/LoginForm.fxml"));
            Scene scene = new Scene(blah, 400, 350);
            LoginController.NewScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SendMessageButton(ActionEvent event) {
        String message = SendMessageTextArea.getText();

        if(Main.connect.SendMessage(message)){
        } else ListViewMessage.appendText("!!!Сообщение не было отправлено!!!"+"\n"+message);

    }

    void GetNewMessage(String message){
            ListViewMessage.setText("Добро пожаловать в чат");
            ListViewMessage.appendText(message);


    }

    @FXML
    void initialize() {
        assert ExitLoginForm != null : "fx:id=\"ExitLoginForm\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert AboutForm != null : "fx:id=\"AboutForm\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert ListViewMessage != null : "fx:id=\"ListViewMessage\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert ListViewUser != null : "fx:id=\"ListViewUser\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert SendMessageTextArea != null : "fx:id=\"SendMessageTextArea\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert ClearMessageButton != null : "fx:id=\"ClearMessageButton\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert SendMessageButton != null : "fx:id=\"SendMessageButton\" was not injected: check your FXML file 'ChatMain.fxml'.";

    }
}