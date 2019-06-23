package by.vsu.sdo.server;

import by.vsu.sdo.sql.SQL;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class Clients implements Runnable {
    private static final String HOST = "localhost";
    private static final int PORT = 4444;
    private static int clients_count = 0;
    private Server server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private DataInputStream auth;
    private Socket clientSocket = null;
    private SQL sqlServer;
    private User user;

    // конструктор, который принимает клиентский сокет и сервер
    public Clients(Socket socket, Server server) {
        try {
            this.sqlServer = new SQL();
            this.user = new User();
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
            this.auth = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Переопределяем метод run(), который вызывается когда
    // мы вызываем new Thread(client).start();
    @Override
    public void run() {
        try {

            while (true) {
                //Авторизация
                if (auth.readByte() == 1) {
                    String login = auth.readUTF();
                    String password = auth.readUTF();

                    if (user.auth(login, password)) {
                        server.sendMessageToAllClients(login + " вошёл в чат!");
                        server.sendMessageToAllClients("Клиентов в чате = " + clients_count);
                        break;
                    } else {
                        sendMsg("Login failed");
                        close();
                    }
                    // Новый пользователь
                } else if (auth.readByte() == 2) {
                    String newLogin = auth.readUTF();
                    String newPassword = auth.readUTF();
                    String newEmail = auth.readUTF();
                    if (sqlServer.NewUser(newLogin, newPassword, newEmail)) {
                        System.out.println("Новый пользователь создан");
                        user.auth(newLogin, newPassword);
                        break;
                    } else System.out.println("Ошибка при создании пользователя");
                }
            }
            //Получение списка чатов
           /* while (true) {
                if (auth.readByte() == 3) {
                    String chatName = auth.readUTF();
                    user.idChat = sqlServer.GetChatListDB(chatName).getInt(0);
                    auth.close();
                    break;
                    //Создание нового чата
                } else if (auth.readByte() == 4) {
                    String chatName = auth.readUTF();
                    user.idChat = sqlServer.newChat(chatName);
                    auth.close();
                    break;
                }

            }
*/
            while (true) {
                // Если от клиента пришло сообщение
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();

                    if (clientMessage.equalsIgnoreCase("##session##end##")) {
                        break;
                    }
                    sqlServer.SaveMessage(user.idUser, user.idChat, clientMessage);
                    System.out.println(clientMessage);
                    server.sendMessageToAllClients(clientMessage);
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Чат не найден");
        } */
        finally {
            this.close();
        }
    }

    // отправляем сообщение
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // клиент выходит из чата
    public void close() {
        server.removeClient(this);
        clients_count--;
        server.sendMessageToAllClients("Клиентов в чате = " + clients_count);
    }
}