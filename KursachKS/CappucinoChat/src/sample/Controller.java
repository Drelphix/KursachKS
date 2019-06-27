package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import java.io.IOException;
import java.net.URL;
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
        Chat chat = new Chat();
        String message = SendMessageTextArea.getText();
        String text = ListViewMessage.getText();
        if(chat.SendMessage(message)){
         GetNewMessage(message);
        } else ListViewMessage.setText(text+"/n"+"!!!Сообщение не было отправлено!!!"+"/n"+message);

    }

    void GetNewMessage(String message){
        String text = ListViewMessage.getText();
        ListViewMessage.setText(text+"/n"+message);
    }

    @FXML
    void initialize() {
        assert ListViewMessage != null : "fx:id=\"ListViewMessage\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert ListViewUser != null : "fx:id=\"ListViewUser\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert SendMessageTextArea != null : "fx:id=\"SendMessageTextArea\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert ClearMessageButton != null : "fx:id=\"ClearMessageButton\" was not injected: check your FXML file 'ChatMain.fxml'.";
        assert SendMessageButton != null : "fx:id=\"SendMessageButton\" was not injected: check your FXML file 'ChatMain.fxml'.";

    }
}
