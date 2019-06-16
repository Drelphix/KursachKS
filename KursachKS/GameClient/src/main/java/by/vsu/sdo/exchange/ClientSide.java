package by.vsu.sdo.exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    public String ipServer;
    public final static int DEFAULT_PORT = 4444;
    public int port;
    Socket connection;

    public boolean Connection(String ipServer, int port){
        try {
            connection = new Socket(ipServer,port);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Host is not correct");
            return false;
        }

    }
    public boolean Connection(String ipServer){
         return Connection(ipServer,DEFAULT_PORT);
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
