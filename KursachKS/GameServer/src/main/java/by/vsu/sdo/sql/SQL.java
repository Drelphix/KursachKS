package by.vsu.sdo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQL {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/Chat?serverTimezone=UTC";
    private final static String ROOT = "Drelphix";
    private final static String PASSWORD = "q5J5HBsr10i1vlPu";
    //sql
    private final static String SELECT_DIALOG = "SELECT * FROM Chat Where idChat==";
    java.sql.Connection connection;
    private List<String> chatList;
    private List<String[]> chat;

    //подключение
    public void StartSQL() {
        try {
            this.connection = connect(DRIVER, CONNECTION_STRING, ROOT, PASSWORD);
        }
        catch (NullPointerException e){
            System.out.println("Database connection error");
        }
    }

    private java.sql.Connection connect(String Class, String URL, String USERNAME, String PASSWORD) {
        java.sql.Connection con=null;
        try {
            java.lang.Class.forName(Class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection error");
            System.exit(0);
        }
       return con;
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
    public boolean Authorization(String login, String password) {
        System.out.println(login+" "+password);
        try {
            ResultSet rsAuth = this.connection.createStatement().executeQuery("SELECT Login,Password FROM authorization WHERE Login='" + login+"'");
            rsAuth.next();
            String dbLogin = rsAuth.getString("Login").toLowerCase();
            String dbPassword = rsAuth.getString("Password");

            if((login.equalsIgnoreCase(dbLogin))&&(password.equals(dbPassword))){
                System.out.println(dbLogin+", вход успешен");
            return true;}
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
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
