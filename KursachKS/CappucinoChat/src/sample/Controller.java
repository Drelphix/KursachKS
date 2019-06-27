package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public JFXTextArea ListViewMessage;
    @FXML
    public JFXTextArea SendMessageTextArea;
    Parent blah = null;
    @FXML
    private JFXButton ExitLoginForm;
    @FXML
    private JFXButton AboutForm;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private JFXListView<String> ListViewUser;
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
        try {
            blah = FXMLLoader.load(getClass().getResource("Form/About.fxml"));
            Scene scene = new Scene(blah, 450, 420);
            LoginController.NewScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ExitLoginForm(ActionEvent event) {
        Main.connect.Close();
        Main.primaryStage.show();
        Stage stage = (Stage) ExitLoginForm.getScene().getWindow();
        stage.close();
    }


    @FXML
    void SendMessageButton(ActionEvent event) {
        String message = SendMessageTextArea.getText();

        if (Main.connect.SendMessage(message)) {
            message = Main.connect.Waiting();
            ListViewMessage.appendText(message);
        } else ListViewMessage.appendText("!!!Сообщение не было отправлено!!!" + "\n" + message);

    }

    @FXML
    public void GetChatList() {
        ObservableList<String> observableList = FXCollections.observableList(Main.connect.GetList(4));
        ListViewUser.setItems(observableList);
    }
    @FXML
    public void GetMessageList(){
        List<String> messageList =(Main.connect.GetList(8));

        for(String message:messageList){
            ListViewMessage.appendText(message+"\n");
        }
    }

    void GetNewMessage(String message) {
        SendMessageTextArea.setText("Добро пожаловать в чат");
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
        GetChatList();
        GetMessageList();
    }
}