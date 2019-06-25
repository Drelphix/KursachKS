package by.vsu.sdo;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

class Main extends Application {
    public static Stage primaryStage;
    public static Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("ChatMain.fxml"));
        primaryStage.setTitle("Encryptor");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("Image/icon.png")));

        Scene scene = new Scene(new Group(root), 600, 400);
        //scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
