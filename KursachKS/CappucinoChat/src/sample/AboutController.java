package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GmailDrelphix;

    @FXML
    private Button InstagramDrelphix;

    @FXML
    private Button VKDrelphix;

    @FXML
    private Button GmailFaustMont;

    @FXML
    private Button InstagramFaustMont;

    @FXML
    private Button VKFaustMont;

    @FXML
    private Button BackMainForm;


    @FXML
    void GmailDrelphix(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().mail(new URI("mailto:alexeydemeshko@gmail.com"));

    }

    @FXML
    void GmailFaustMont(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().mail(new URI("mailto:slavyn21@gmail.com"));
    }

    @FXML
    void InstagramDrelphix(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://instagram.com/Drelphix"));
    }

    @FXML
    void InstagramFaustMont(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://instagram.com/FaustMont"));
    }

    @FXML
    void VKDrelphix(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://vk.com/Drelphix"));
    }

    @FXML
    void VKFaustMont(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://vk.com/FaustMont"));
    }

    @FXML
    void BackMainForm(ActionEvent event) {
        Main.primaryStage.show();
        Stage stage = (Stage) BackMainForm.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert GmailDrelphix != null : "fx:id=\"GmailDrelphix\" was not injected: check your FXML file 'About.fxml'.";
        assert InstagramDrelphix != null : "fx:id=\"InstagramDrelphix\" was not injected: check your FXML file 'About.fxml'.";
        assert VKDrelphix != null : "fx:id=\"VKDrelphix\" was not injected: check your FXML file 'About.fxml'.";
        assert GmailFaustMont != null : "fx:id=\"GmailFaustMont\" was not injected: check your FXML file 'About.fxml'.";
        assert InstagramFaustMont != null : "fx:id=\"InstagramFaustMont\" was not injected: check your FXML file 'About.fxml'.";
        assert VKFaustMont != null : "fx:id=\"VKFaustMont\" was not injected: check your FXML file 'About.fxml'.";

    }
}
