package by.vsu.sdo;




import by.vsu.sdo.checkers.ChessBoard;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.Scanner;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Application {

    public static void main(String[] args) throws IOException {
        ChessBoard board=new ChessBoard();
        int[] mas =new int[]{1,0,1,0,1,0,1,0,
                             0,1,0,1,0,1,0,1,
                             1,0,1,0,1,0,1,0,
                             0,0,0,0,0,0,0,0,
                             0,0,0,0,0,0,0,0,
                             0,2,0,2,0,2,0,2,
                             2,0,2,0,2,0,2,0,
                             0,2,0,2,0,2,0,2};
        board.DrawBoard();
       board.PutCheckers(mas);


    }}
