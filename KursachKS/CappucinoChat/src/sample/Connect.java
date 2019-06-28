package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Connect implements Runnable {

    private static final String HOST = "localhost"; // адрес сервера 192.168.137.1
    private static final int PORT = 4444; // порт
    public static String userName;
    public Socket clientSocket; // клиентский сокет
    DataOutputStream outData;
    DataInputStream inData;
    private Scanner inMessage;

    @Override

    public void run() {
        Waiting();
    }

    public boolean Connecting() {
        try {
            clientSocket = new Socket(HOST, PORT); // подключаемся к серверу
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения");
            return false;
        }
        return true;
    }

    public void Close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean Authorization(String login, String password) throws IOException {
        return Authorization(login, password, null);
    }

    public boolean Authorization(String login, String password, String email) throws IOException {
        if (Connecting()) {
            outData = new DataOutputStream(clientSocket.getOutputStream());
            inData = new DataInputStream(clientSocket.getInputStream());
            if (email != null) {
                outData.writeByte(2);
                outData.writeUTF(email);
            } else {
                outData.writeByte(1);
            }

            outData.writeUTF(login);
            outData.writeUTF(password);
            System.out.println(login + password);
            outData.flush();
            while (true) {
                Byte answer = inData.readByte();
                if (answer == 1) {
                    System.out.println("Логин неверен");

                    return false;
                } else if (answer == 0) {
                    System.out.println("Логин успешен");
                    this.userName = login;
                    return true;
                }
            }
        } else {
            System.out.println("Сервер недоступен");
            return false;
        }

    }

    public boolean SendMessage(String message) {
        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM/HH:mm");
            outData.writeByte(5);
            outData.writeUTF(formatter.format(date));
            outData.writeUTF(this.userName);
            outData.writeUTF(message);
            outData.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> GetList(int i) {
        Byte wait;
        List<String> list = new ArrayList<>();
        try {
            outData.writeByte(i);
            outData.flush();
            while (true) {
                wait = inData.readByte();
                if (wait == i) {
                    String line = inData.readUTF();
                    while (true) {
                        if (!line.equalsIgnoreCase("end")) {
                            System.out.println(line);
                            list.add(line);
                            line = inData.readUTF();
                        } else return list;

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String Waiting() {
        Byte wait = null;
        String message = null;
        try {
                wait = inData.readByte();
                if (wait == 5) {
                    message = inData.readUTF();
                    System.out.println(message);
                }
                if (wait==4){
                    message="update";
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;

    }
}
