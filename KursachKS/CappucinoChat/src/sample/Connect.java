package sample;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect{
    private static final String HOST = "192.168.137.1"; // адрес сервера
    private static final int PORT = 4444; // порт
    public Socket clientSocket; // клиентский сокет


    public Socket Connecting(){
        try {
            clientSocket = new Socket(HOST, PORT); // подключаемся к серверу

        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientSocket;
    }

    public void Close(){

    }

    public void Authorization(int i){

    }


}
