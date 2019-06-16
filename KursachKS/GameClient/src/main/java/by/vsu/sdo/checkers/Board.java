package by.vsu.sdo.checkers;

import javax.swing.*;
import java.awt.*;

public class Board {
    public final static ImageIcon WHITE_CHECKER = new ImageIcon("./resourses/white.png");
    public final static ImageIcon BLACK_CHECKER = new ImageIcon("./resourses/black.png");
    public final static ImageIcon WHITE_QUEEN = new ImageIcon("./resourses/white_queen.png");
    public final static ImageIcon BLACK_QUEEN = new ImageIcon("./resourses/black_queen.png");
    private final static Color BLACK_COLOR = new Color(152, 89, 46);
    private final static Color WHITE_COLOR = new Color(233, 216, 159);

    public void DrawBoard() {
        JFrame window = new JFrame("Checkers");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension boardSize = new Dimension(800, 900);
        window.setLayout(new GridLayout(8, 8));
        window.setVisible(true);
        window.setResizable(false);
        window.setPreferredSize(boardSize);
        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            window.add(square);
            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground(i % 2 == 0 ? WHITE_COLOR : BLACK_COLOR);
            else
                square.setBackground(i % 2 == 0 ? BLACK_COLOR : WHITE_COLOR);
        }
        window.pack();
        window.setLocationRelativeTo(null);
    }

    public void PutChekers() {

    }
}
