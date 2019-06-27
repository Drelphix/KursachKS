package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    public static Stage primaryStage;
    public Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Form/ChatMain.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Cappucino Chat");
        Scene scene = new Scene(new Group(root), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
