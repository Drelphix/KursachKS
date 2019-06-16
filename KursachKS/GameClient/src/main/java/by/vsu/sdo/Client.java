package by.vsu.sdo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

            System.out.println("Welcome to Client side");
            System.out.println("Please input server ip");
    Scanner input = new Scanner(System.in);
    String ip = input.next();
        System.out.println("Connecting to... "+ ip);
    Socket fromserver = new Socket(ip,4444);
    BufferedReader in  = new
            BufferedReader(new
            InputStreamReader(fromserver.getInputStream()));
    PrintWriter out = new
            PrintWriter(fromserver.getOutputStream(),true);
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
            input.close();
            inu.close();
            fromserver.close();
}
}
