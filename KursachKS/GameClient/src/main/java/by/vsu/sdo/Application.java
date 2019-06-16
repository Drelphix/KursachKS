package by.vsu.sdo;



import by.vsu.sdo.exchange.ClientSide;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        int[] mas = new int[]{1, 0, 1, 0, 1, 0, 1, 0,
                0, 1, 0, 1, 0, 1, 0, 1,
                1, 0, 1, 0, 1, 0, 1, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 2, 0, 2, 0, 2, 0, 2,
                2, 0, 2, 0, 2, 0, 2, 0,
                0, 2, 0, 2, 0, 2, 0, 2};
      ClientSide client = new ClientSide();
      System.out.println("1.List,2.NewGame,3.Quit");
      Scanner in = new Scanner(System.in);
      loop:
      switch (in.nextInt()){
          case 1:{
              client.ConnectToLobby();
              break loop;
          }
          case 2:{
              client.CreateNewLobby();
          }
          case 3:{
              System.exit(0);
          }
          default:break loop;

      }
    }
}
