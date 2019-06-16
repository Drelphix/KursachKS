package by.vsu.sdo.checkers;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private final static Color BLACK_COLOR = new Color(152, 89, 46);
    private final static Color WHITE_COLOR = new Color(233, 216, 159);
    public final static ImageIcon WHITE_CHECKER = new ImageIcon("./resourses/white.png");
    public final static ImageIcon BLACK_CHECKER = new ImageIcon("E:\\KursachKS\\KursachKS\\GameClient\\resourses\\black.png");
    public final static ImageIcon WHITE_QUEEN = new ImageIcon("./src/main/java/by/vsu/sdo/checkers/resourses/white_queen.png");
    public final static ImageIcon BLACK_QUEEN = new ImageIcon("./src/main/java/by/vsu/sdo/checkers/resourses/black_queen.png");

    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    JScrollPane scrollPane;

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
        JFrame frame = new Board();
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
                    this.chessPiece = new JLabel(WHITE_CHECKER);
                }   else if (mas[j]==2){
                    this.chessPiece = new JLabel(BLACK_CHECKER);
                } else if(mas[j]==3){
                    this.chessPiece = new JLabel(WHITE_QUEEN);
                } else if(mas[j]==4) {
                    this.chessPiece = new JLabel(BLACK_QUEEN);
                }
                else break loop;
                JPanel panel = (JPanel) chessBoard.getComponent(j);
                panel.add(this.chessPiece);
            }
        }
        scrollPane.revalidate();
    }

    @Override
    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    @Override
    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }

    public JPanel getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(JPanel chessBoard) {
        this.chessBoard = chessBoard;
    }

    public JLabel getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(JLabel chessPiece) {
        this.chessPiece = chessPiece;
    }


}
