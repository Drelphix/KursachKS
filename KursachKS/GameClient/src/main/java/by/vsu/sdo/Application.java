package by.vsu.sdo;



import by.vsu.sdo.exchange.ClientSide;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int[] mas = new int[]{1, 0, 1, 0, 1, 0, 1, 0,
                0, 1, 0, 1, 0, 1, 0, 1,
                1, 0, 1, 0, 1, 0, 1, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 2, 0, 2, 0, 2, 0, 2,
                2, 0, 2, 0, 2, 0, 2, 0,
                0, 2, 0, 2, 0, 2, 0, 2};
      ClientSide client = new ClientSide();
      System.out.println("List,NewGame,Quit");
      Scanner in = new Scanner(System.in);

    }
}
