package by.vsu.sdo;

import java.net.Socket;
import java.util.List;

public class Game {
    public String userName1;
    public String userName2;
    public String LobbyName;
    private Socket user1Socket;
    private Socket user2Socket;
    int[] checkersBoard;
    private List<String> steps;
}
