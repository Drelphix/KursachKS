package by.vsu.sdo.server;


import by.vsu.sdo.sql.SQL;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 4444;
    private ArrayList<Clients> clients = new ArrayList<Clients>();
    public Server() {
        SQL sqlServer = new SQL();
        Socket clientSocket = null;
        // серверный сокет
        ServerSocket serverSocket = null;
        try {
            // создаём серверный сокет
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");
            sqlServer.StartSQL();
            while (true) {
                clientSocket = serverSocket.accept();
                // создаём обработчик клиента, который подключился к серверу
                Clients client = new Clients(clientSocket, this);

                clients.add(client);
                // каждое подключение клиента обрабатываем в новом потоке
                new Thread(client).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // закрываем подключение
                clientSocket.close();
                System.out.println("Сервер остановлен");
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // отправляем сообщение всем клиентам
    public void sendMessageToAllClients(String msg) {
        for (Clients man : clients) {
            man.sendMsg(msg);
        }

    }

    // удаляем клиента из коллекции при выходе из чата
    public void removeClient(Clients client) {
        clients.remove(client);
    }
}