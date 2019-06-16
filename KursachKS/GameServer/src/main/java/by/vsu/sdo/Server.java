package by.vsu.sdo;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<String[]> lobbyList=new ArrayList<>();
    Socket fromClient;

    private static final int PORT = 4444;
    public void StartServer() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        this.fromClient = server.accept();
        Waiting();
    }
    private void Waiting() throws IOException {
        DataInputStream in = new DataInputStream(fromClient.getInputStream());
        DataOutputStream out = new DataOutputStream(fromClient.getOutputStream());
                byte line = in.readByte();
                switch (line) {
                    case 1: {
                        byte[] mas = in.readAllBytes();
                        for (int i : mas) {
                            System.out.println(mas[i]);
                        }
                    }
                    case 2: {
                        String[] lobbyName = new String[2];
                        lobbyName[0] = in.readUTF();
                        lobbyName[1] = in.readUTF();
                        lobbyList.add(lobbyName);
                    }
                    case 3: {
                        out.writeByte(3);
                        String[] test = new String[2];
                        test[0] = "String";
                        test[1] = "ip";
                        lobbyList.add(test);
                        for (String[] lobbyName : lobbyList) {
                            out.writeUTF(lobbyName[0]);
                            out.writeUTF(lobbyName[1]);
                        }
                        out.writeChar('/');
                        out.flush();

            }
        } in.close();
                out.close();
                fromClient.close();
                StartServer();
    }

}
