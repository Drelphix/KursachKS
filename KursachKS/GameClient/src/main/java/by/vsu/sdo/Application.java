package by.vsu.sdo;


import by.vsu.sdo.checkers.Board;
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
        Scanner in = new Scanner(System.in);
       if(client.Connection(in.next())){

        }

    }
}
