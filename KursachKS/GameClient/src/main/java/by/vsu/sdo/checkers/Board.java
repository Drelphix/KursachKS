package by.vsu.sdo.checkers;

import javax.swing.*;
import java.awt.*;
public class Board {
    private final static Color BLACK_COLOR = new Color(152, 89, 46);
    private final static Color WHITE_COLOR = new Color(233, 216, 159);
    public final static ImageIcon WHITE_CHECKER = new ImageIcon("./resourses/white.png");
    public final static ImageIcon BLACK_CHECKER = new ImageIcon("E:\\KursachKS\\KursachKS\\GameClient\\resourses\\black.png");
    public final static ImageIcon WHITE_QUEEN = new ImageIcon("./src/main/java/by/vsu/sdo/checkers/resourses/white_queen.png");
    public final static ImageIcon BLACK_QUEEN = new ImageIcon("./src/main/java/by/vsu/sdo/checkers/resourses/black_queen.png");
    private JLayeredPane layeredPane;
    private JPanel chessBoard;
    private JLabel checkers;

    public void DrawBoard() {
    JFrame board = new JFrame("Checkers");
    board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension boardSize = new Dimension(800,800);
    board.setVisible(true);
    board.setResizable(false);
    board.setPreferredSize(boardSize);
    for (int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            JLabel label = new JLabel("Test label");
        }
    }
    board.getContentPane().add(label);
    board.pack();
    board.setLocationRelativeTo(null);
    }

    public void PutChekers(){

    }
}
