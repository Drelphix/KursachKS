package by.vsu.sdo.server;

import by.vsu.sdo.sql.SQL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Clients implements Runnable {
    private String HOST = "localhost";
    private int PORT = 4444;
    private static int clients_count = 0;
    private Server server;
    private DataInputStream auth;
    private DataOutputStream authMsg;
    private Socket clientSocket = null;
    private SQL sqlServer;
    private User user;

    // конструктор, который принимает клиентский сокет и сервер
    public Clients(Socket socket, Server server) {
        try {
            this.sqlServer = new SQL();
            sqlServer.StartSQL();
            this.user = new User();
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
            this.auth = new DataInputStream(socket.getInputStream());
            this.authMsg = new DataOutputStream(socket.getOutputStream());
            System.out.println("Новый клиент присоединился");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Byte wait;
            while (true) {
                wait = auth.readByte();
                if (wait == 1) {
                    String login = auth.readUTF();
                    String password = auth.readUTF();
                    System.out.println(login+" Пытается подклчиться");
                    List<String> list =  sqlServer.Authorization(login, password);
                    if (list!=null) {
                        user.userName = list.get(0);
                        user.idUser = Integer.valueOf(list.get(1));
                        authMsg.write(0);
                        authMsg.flush();
                        break;
                    } else {
                        authMsg.write(1);
                        authMsg.flush();
                        close();
                    }
                    // Новый пользователь
                }
                if (wait == 2) {
                    String newEmail = auth.readUTF();
                    String newLogin = auth.readUTF();
                    String newPassword = auth.readUTF();
                    if (sqlServer.NewUser(newLogin, newPassword, newEmail)) {
                        System.out.println("Новый пользователь создан");
                        sqlServer.Authorization(newLogin, newPassword);
                        authMsg.write(0);
                        authMsg.flush();
                        break;
                    } else {System.out.println("Ошибка при создании пользователя");
                    authMsg.write(1);
                    authMsg.flush();
                    close();}
                }}
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
                wait = auth.readByte();
                if (wait==5) {
                    String clientMessage = auth.readUTF()+" "+auth.readUTF()+": "+auth.readUTF();
                    System.out.println("Получено сообщение:");
                    System.out.println(clientMessage);
                    sqlServer.SaveMessage(user.idUser, user.idChat, clientMessage);
                    Thread.sleep(100);
                    server.sendMessageToAllClients(clientMessage);
                    }
                if (wait==6) {
                    break;
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Клиент разорвал соединение");
        } /*catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Чат не найден");
        } */ finally {
            this.close();
        }
    }


    // отправляем сообщение
    public void sendMsg(String msg) {
        try {
            authMsg.writeByte(5);
            authMsg.writeUTF(msg+"\n");
            authMsg.flush();
            System.out.println("Сообщение \\ "+msg+" // было отправлено к "+user.userName);
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