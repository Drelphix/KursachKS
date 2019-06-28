package by.vsu.sdo.server;

import by.vsu.sdo.sql.SQL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Clients implements Runnable {
    private static int clients_count = 0;
    public User user;
    private String HOST = "localhost";
    private int PORT = 4444;
    private Server server;
    private DataInputStream auth;
    private DataOutputStream authMsg;
    private Socket clientSocket = null;
    private SQL sqlServer;

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
                    System.out.println(login + " Пытается подключиться");
                    List<String> list = sqlServer.Authorization(login, password);
                    if (list != null) {
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
                        List<String> list = sqlServer.Authorization(newLogin, newPassword);
                        if (list != null) {
                            user.userName = list.get(0);
                            user.idUser = Integer.valueOf(list.get(1));
                            authMsg.write(0);
                            authMsg.flush();
                            break;
                        }
                    } else {
                        System.out.println("Ошибка при создании пользователя");
                        authMsg.write(1);
                        authMsg.flush();
                        close();
                    }
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

                wait = auth.readByte();
                if (wait == 4) sendUserList();
                if (wait == 5) {
                    String clientMessage = auth.readUTF() + " " + auth.readUTF() + ": " + auth.readUTF();
                    System.out.println("Получено сообщение:");
                    System.out.println(clientMessage);
                    sqlServer.SaveMessage(user.idUser, clientMessage);
                    Thread.sleep(100);
                    server.sendMessageToAllClients(clientMessage);
                }
                if (wait == 6) {
                    break;
                }
                if(wait==8){
                    List<String> chat = sqlServer.GetDialog();
                    authMsg.writeByte(8);
                    System.out.println("Отправка списка сообщений:");
                    for(String line:chat){
                        authMsg.writeUTF(line);
                        System.out.println(line);
                        authMsg.flush();
                    }
                    System.out.println("Конец списка");
                    authMsg.writeUTF("end");
                    authMsg.flush();

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
            authMsg.writeUTF(msg + "\n");
            authMsg.flush();
            System.out.println("Сообщение \\ " + msg + " // было отправлено к " + user.userName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // клиент выходит из чата
    public void close() {
        server.removeClient(this);
    }

    public void sendUserList() {
        List<String> list = server.SendUserList();
        System.out.println("Отправка списка пользователей");
        try {
            authMsg.writeByte(4);
            for (String line : list) {
                authMsg.writeUTF(line);
                System.out.println(line);
            }
            System.out.println("Количество пользователей: " + list.size());
            authMsg.writeUTF("end");
            authMsg.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}