package by.vsu.sdo;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

        public static void main(String[] args) throws IOException {

            System.out.println("Welcome to Server side");
            Server server = new Server();
            server.StartServer();
        }
}
