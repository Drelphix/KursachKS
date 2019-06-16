package by.vsu.sdo;




import by.vsu.sdo.checkers.Board;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        int[] mas =new int[]{1,0,1,0,1,0,1,0,
                0,1,0,1,0,1,0,1,
                1,0,1,0,1,0,1,0,
                0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,
                0,2,0,2,0,2,0,2,
                2,0,2,0,2,0,2,0,
                0,2,0,2,0,2,0,2};

       Board board = new Board();
       board.DrawBoard();

    }}
