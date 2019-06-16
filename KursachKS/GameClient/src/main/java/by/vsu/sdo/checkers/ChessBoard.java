package by.vsu.sdo.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ChessBoard extends JFrame implements MouseListener, MouseMotionListener {
    public final static String WHITE_CHECKER = "./src/main/java/by/vsu/sdo/checkers/resourses/white.png";
    public final static String BLACK_CHECKER = "./src/main/java/by/vsu/sdo/checkers/resourses/black.png";
    public final static String WHITE_QUEEN = "./src/main/java/by/vsu/sdo/checkers/resourses/white_queen.png";
    public final static String BLACK_QUEEN = "./src/main/java/by/vsu/sdo/checkers/resourses/black_queen.png";
    private final static Color BLACK_COLOR = new Color(152, 89, 46);
    private final static Color WHITE_COLOR = new Color(233, 216, 159);
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;

    public ChessBoard() {
        Dimension boardSize = new Dimension(800, 800);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);


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
                    final JScrollPane scrollPane = new JScrollPane(panel);
                    panel.add(this.chessPiece);

                    scrollPane.revalidate();
                }
            }

        }


    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel) return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel) c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    }

    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;

        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    public void mouseReleased(MouseEvent e) {
        if (chessPiece == null) return;

        chessPiece.setVisible(false);
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(chessPiece);
        } else {
            Container parent = (Container) c;
            parent.add(chessPiece);
        }

        chessPiece.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}