package by.vsu.sdo.checkers;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private final static Color BLACK_COLOR = new Color(152, 89, 46);
    private final static Color WHITE_COLOR = new Color(233, 216, 159);
    public final static String WHITE_CHECKER = "./src/main/java/by/vsu/sdo/checkers/resourses/white.png";
    public final static String BLACK_CHECKER = "./src/main/java/by/vsu/sdo/checkers/resourses/black.png";
    public final static String WHITE_QUEEN = "./src/main/java/by/vsu/sdo/checkers/resourses/white_queen.png";
    public final static String BLACK_QUEEN = "./src/main/java/by/vsu/sdo/checkers/resourses/black_queen.png";
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    JScrollPane checkersUpdate;

    public Board() {
        Dimension boardSize = new Dimension(800, 800);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground(i % 2 == 0 ? WHITE_COLOR : BLACK_COLOR);

            else
                square.setBackground(i % 2 == 0 ? BLACK_COLOR : WHITE_COLOR);

        }
    }
    public void DrawBoard(){
        JFrame frame = new ChessBoard();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void PutCheckers (int[] mas){

        for (int i=0;i<8;i++){
            loop:
            for (int j=0;j<8;j++){
                if (mas[j]==1){
                    this.chessPiece = new JLabel(new ImageIcon(WHITE_CHECKER));
                }   else if (mas[j]==2){
                    this.chessPiece = new JLabel(new ImageIcon(BLACK_CHECKER));
                } else if(mas[j]==3){
                    this.chessPiece = new JLabel(new ImageIcon(WHITE_QUEEN));
                } else if(mas[j]==4) {
                    this.chessPiece = new JLabel(new ImageIcon(BLACK_QUEEN));
                }
                else break loop;
                JPanel panel = (JPanel) chessBoard.getComponent(j);
                panel.add(this.chessPiece);

            }
        }
        checkersUpdate.revalidate();
    }
}
