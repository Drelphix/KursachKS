package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Chat {
    private String userName;
    private PrintWriter outMessage;
    private Scanner inMessage;

    Controller controller = new Controller();

    public void SendMessage(String message){

    }
    public void SendPicture(){


    }
    public void SendSmile(){

    }
    public void Waiting(List<String> messages){
        ObservableList<String> list = FXCollections.observableArrayList("Mark","fdsfsdafdfaifjdasfjdasfdasfdasf","dsakfbdfashuhdafsuhfdasuhdfhudfasuhfdauhdfsahufdsahufdshuafdhsuahufdsahufsad");
    while (true){
        if(inMessage.hasNext()){
            String message = inMessage.nextLine();
            messages.add(message);
            controller.ListViewMessage.setItems(list);
        }
    }
    }

}
