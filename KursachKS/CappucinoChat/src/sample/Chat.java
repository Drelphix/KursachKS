package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Chat {
    private String userName;
    Socket socket;

    private Scanner inMessage;
    Connect connect = new Connect();

    Controller controller = new Controller();

    public void SendMessage(String message){
        try {
            PrintWriter outMessage = new PrintWriter(socket.getOutputStream());
            outMessage.println(message);
            outMessage.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SendPicture(){


    }
    public void SendSmile(){

    }
    public void Waiting(List<String> messages){
        ObservableList<String> list = FXCollections.observableArrayList("Mark","fdsfsdafdfaifjdasfjdasfdasfdasf","dsakfbdfashuhdafsuhfdasuhdfhudfasuhfdauhdfsahufdsahufdshuafdhsuahufdsahufsad");
    while (true){
        if(inMessage.hasNext()){

        }
    }
    }

}
