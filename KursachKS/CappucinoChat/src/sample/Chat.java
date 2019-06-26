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

    private Scanner inMessage;
    Connect connect = new Connect();

    Controller controller = new Controller();

    public boolean SendMessage(String message){
        try {
            PrintWriter outMessage = new PrintWriter(connect.clientSocket.getOutputStream());
            outMessage.println(message);
            outMessage.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void SendPicture(){


    }
    public void SendSmile(){

    }
    public void Waiting(){
    while (true){
        if(inMessage.hasNext()){
            String message = inMessage.next();
            controller.GetNewMessage(message);
        }
    }
    }

}
