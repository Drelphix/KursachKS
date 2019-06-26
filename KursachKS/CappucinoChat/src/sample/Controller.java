package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public JFXListView<String> ListViewMessage;

    @FXML
    public JFXListView<String> ListViewUser;

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
    void SendMessageButton(ActionEvent event) {

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
