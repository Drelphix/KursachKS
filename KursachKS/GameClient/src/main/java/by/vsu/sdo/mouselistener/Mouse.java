package by.vsu.sdo.mouselistener;

import by.vsu.sdo.checkers.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Mouse {
    int xAdjustment;
    int yAdjustment;
    MouseEvent e;
    private Board board = new Board();

    public void mousePressed(MouseEvent me) {

        JLabel piece = null;
        JPanel panel = board.getChessBoard();
        JLayeredPane layeredPane = board.getLayeredPane();
        Component c = panel.findComponentAt(me.getX(), me.getY());

        if (c instanceof JPanel) return;
        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        piece = (JLabel) c;
        panel.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
        panel.setSize(panel.getWidth(), panel.getHeight());
        layeredPane.add(piece, JLayeredPane.DRAG_LAYER);
        board.setChessPiece(piece);
        board.setChessBoard(panel);
        board.setLayeredPane(layeredPane);
        e = me;
    }

    public void mouseDragged(MouseEvent me) {
        JLabel chessPiece = board.getChessPiece();
        JPanel panel = board.getChessBoard();
        Component c = panel.findComponentAt(e.getX(), e.getY());
        if (chessPiece == null) return;
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    public void mouseReleased(MouseEvent e) {
        JLabel chessPiece = board.getChessPiece();
        JPanel chessBoard = board.getChessBoard();
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
