import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public class Pawn extends Piece {
    Pawn(boolean white){
        if(white)
        {
            super.id=5;
            super.Image=new ImageIcon("wpawn.gif");
        }
        else
        {
            super.id=11;
            super.Image=new ImageIcon("bpawn.gif");
        }
    }

    
    boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX,ChessBoard[][] chessBoard) {
       
        switch (id) {
            case 5:
                if ((fromY - toY == 1) && (fromX == toX) && (chessBoard[toY][toX] == 12)) {
                    return true;
                }
                if ((fromY - toY == 2) && (fromY == 6) && (fromX == toX) && (chessBoard[toY][toX] == 12)) {
                    return true;
                }
                if ((fromY - toY == 1) && (chessBoard[toY][toX] != 12) && (fromX != toX)) {
                    return true;
                }
                return false;
            case 11:
                if((fromY - toY == -1) && (fromX == toX) && (chessBoard[toY][toX] == 12)) {
                    return true;
                }
                if((fromY - toY == -2) && (fromY == 1) && (fromX == toX) && (chessBoard[toY][toX] == 12)){
                    return true;
                }
                if((fromY - toY == -1) && (chessBoard[toY][toX] != 12) && (fromX != toX)){
                    return true;
                }
                return false;

        }
        return true;
    }

}
