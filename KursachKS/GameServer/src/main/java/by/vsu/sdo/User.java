package by.vsu.sdo;

import by.vsu.sdo.sql.SQL;

import java.util.List;

public class User {
    public int idChat;
    public int idUser;
    public String userName;
    public String rights;
    private String password;
    public String email;

    public boolean auth(String login, String password){
        SQL sqlClient = new SQL();
        try {
            List<String> users = sqlClient.Authorization(login,password);
            this.idUser = Integer.valueOf(users.get(0));
            this.userName = users.get(1);
            this.password = users.get(2);
            this.email = users.get(3);
            this.rights = users.get(4);
        } catch (NullPointerException e){
            return false;
        }
        return true;
    }


}
