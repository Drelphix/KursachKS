package by.vsu.sdo.exchange;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    public final static String IP_SERVER = "127.0.0.1" ;
    public final static int DEFAULT_PORT = 4444;
    public int port;
    Socket connection;
    private Socket Connection(){
        try {
            this.connection = new Socket(IP_SERVER,DEFAULT_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.connection;
    }
    private void SendToServer(){

    }
    public void CreateNewLobby(){
      Connection();
        DataOutputStream SendToServer  = new DataOutputStream(connection.getOutputStream());

// Send first message
        dOut.writeByte(1);
        dOut.writeUTF("This is the first type of message.");
        dOut.flush(); // Send off the data

// Send the second message
        dOut.writeByte(2);
        dOut.writeUTF("This is the second type of message.");
        dOut.flush(); // Send off the data

// Send the third message
        dOut.writeByte(3);
        dOut.writeUTF("This is the third type of message (Part 1).");
        dOut.writeUTF("This is the third type of message (Part 2).");
        dOut.flush(); // Send off the data

// Send the exit message
        dOut.writeByte(-1);
        dOut.flush();

        dOut.close();
    }

    public void ConnectToLobby(){

    }
    public void SendToServer(int mas[]) throws IOException {
    BufferedReader in  = new
            BufferedReader(new
            InputStreamReader(connection.getInputStream()));
    PrintWriter out = new
            PrintWriter(connection.getOutputStream(),true);
    BufferedReader inu = new
            BufferedReader(new InputStreamReader(System.in));

    String fuser,fserver;

            while ((fuser = inu.readLine())!=null) {
        out.println(fuser);
        fserver = in.readLine();
        System.out.println(fserver);
        if (fuser.equalsIgnoreCase("close")) break;
        if (fuser.equalsIgnoreCase("exit")) break;
    }


            out.close();
            in.close();
            inu.close();
            connection.close();}
}
