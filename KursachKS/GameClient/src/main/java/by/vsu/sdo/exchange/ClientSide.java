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
    private void SendDataToServer(byte[] mas,DataOutputStream out){
        try {
            out.writeByte(1);
            out.write(mas);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void CreateNewLobby(){
      Connection();
        try {
            DataOutputStream toServer  = new DataOutputStream(connection.getOutputStream());
            toServer.writeByte(2);
            System.out.println("Please input lobby's name");
            Scanner in = new Scanner(System.in);
            toServer.writeUTF(in.next());
            toServer.writeUTF(String.valueOf(connection.getLocalAddress()));
            toServer.flush();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ConnectToLobby() throws IOException {
        Connection();
        try {
            DataOutputStream toServer  = new DataOutputStream(connection.getOutputStream());
            toServer.writeByte(3);
            toServer.flush();
            DataInputStream dIn = new DataInputStream(connection.getInputStream());
            while (dIn.readChar()=='/') {
                System.out.println("Lobby: " + dIn.readUTF());
            }
            toServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.close();
    }
}
