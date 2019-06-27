package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect{
    private static final String HOST = "localhost"; // адрес сервера 192.168.137.1
    private static final int PORT = 4444; // порт
    public Socket clientSocket; // клиентский сокет


    public boolean Connecting(){
        try {
            clientSocket = new Socket(HOST, PORT); // подключаемся к серверу
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения");
            return false;
        }
        return true;
    }

    public void Close(){
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean Authorization(String login, String password) throws IOException {
    return Authorization(login,password,null);
    }
    public boolean Authorization(String login, String password, String email) throws IOException {
        if(Connecting()) {
            DataOutputStream outData = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream inData = new DataInputStream(clientSocket.getInputStream());
            if (email != null) {
                outData.writeByte(2);
            } else {
                outData.writeByte(1);
            }

            outData.writeUTF(login);
            outData.writeUTF(password);
            System.out.println(login+password);
            outData.flush();
            while (true) {
                if (inData.readByte() == 1) {
                    System.out.println("Логин неверен");
                    return false;
                } else if (inData.readByte() == 0) {
                    System.out.println("Логин успешен");
                    return true;
                }
            }
        } else {System.out.println("Сервер недоступен");
        return false;}

    }


}
