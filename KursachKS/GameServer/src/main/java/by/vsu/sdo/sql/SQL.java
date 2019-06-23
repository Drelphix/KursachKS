package by.vsu.sdo.sql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQL {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/Chat?serverTimezone=UTC";
    private final static String ROOT = "root";
    private final static String PASSWORD = "root";
    //sql
    private final static String SELECT_DIALOG = "SELECT * FROM Chat Where idChat==";
    java.sql.Connection connection;
    private List<String> chatList;
    private List<String[]> chat;

    //подключение
    public void StartSQL() {
        connection = connect(DRIVER, CONNECTION_STRING, ROOT, PASSWORD);
    }

    private java.sql.Connection connect(String Class, String URL, String USERNAME, String PASSWORD) {
        try {
            java.lang.Class.forName(Class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection error");
            System.exit(0);
        }

        return this.connection;
    }


    //сохранение чата в риал-тайме
    public void SaveMessage(int idUser, int idChat, String message) {
        try {
            connection.createStatement().executeQuery("INSERT INTO messages (message,idUser,idChat) VALUES (" + message + "," + idUser + "," + idChat + ")");
        } catch (SQLException e) {
            System.out.println("SaveDialogError");
            e.printStackTrace();
        }
    }


    //новый чат
    public int newChat(String chatName) {
        int id = 0;
        try {
            connection.createStatement().executeQuery("INSERT INTO chat (chatName) VALUES (" + chatName + ")");
            id = GetChatListDB(chatName).getInt(0);
        } catch (SQLException e) {
            System.out.println("NewChatError");
            e.printStackTrace();
        }
        return id;
    }

    //получение id чата по имени
    public ResultSet GetChatListDB(String chatName) {

        ResultSet rsGetChatList = null;
        try {
            rsGetChatList = connection.createStatement().executeQuery("SELECT * from chat where chatName = " + chatName);

        } catch (SQLException e) {
            System.out.println("getIdError");
            e.printStackTrace();
        }
        return rsGetChatList;

    }


    // проверка входа
    public List<String> Authorization(String login, String password) {
        ResultSet rsAuth = null;
        List<String> user = null;
        try {
            rsAuth = connection.createStatement().executeQuery("SELECT * FROM authorization WHERE Login=" + login + ",Password=" + password);
            for (int i = 0; i < 5; i++) {
                user.add(rsAuth.getString(i));
            }
        } catch (SQLException e) {
            System.out.println("Auth error");
            e.printStackTrace();
        }
        return user;
    }

    //новый пользователь
    public boolean NewUser(String login, String password, String email) {

        return true;
    }

    //загрузка старого диалога
    public List<String[]> GetDialog(String chatName) {
        List<String[]> chat = new ArrayList<String[]>();
        ResultSet rsChatMessages;
        String[] message = new String[3];
        try {
            rsChatMessages = connection.createStatement().executeQuery("SELECT * FROM messages LEFT JOIN authorization messages.idUser=authorization.idUser" +
                    " WHERE (idChat=" + GetChatListDB(chatName).getInt(0));
            do {
                // Сообщенька
                message[0] = rsChatMessages.getString(1);
                // Пользователь
                message[1] = rsChatMessages.getString(6);
                // Время
                message[2] = rsChatMessages.getString(5);
                rsChatMessages.next();
            } while (!rsChatMessages.last());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chat;
    }

    //список доступных чатов
    public List<String> GetChatList() {
        List<String> chatList = new ArrayList<String>();
        ResultSet rsChatList = null;
        try {
            rsChatList = connection.createStatement().executeQuery("SELECT * FROM chat");
            do {
                chatList.add(rsChatList.getString("chatName"));
                rsChatList.next();
            } while ((!rsChatList.isLast()));
        } catch (SQLException e) {
            System.out.println("GetChatListError");
            e.printStackTrace();
        }
        return chatList;
    }
}
