import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public class Knight extends Piece {
    Knight(boolean white){
        if(white)
        {
            super.id=4;
            super.Image=new ImageIcon("wknight.gif");
        }
        else
        {
            super.id=10;
            super.Image=new ImageIcon("bknight.gif");
        }
    }

    boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX,int[][] chessBoard) {
        switch (id) {
            case 4:
                if (fromY - toY == 1) {
                    if (Math.abs(fromX - toX) == 2) {
                        return true;
                    }
                }
                if (fromY - toY == -1) {
                    if (Math.abs(fromX - toX) == 2) {
                        return true;
                    }
                }
                if (fromY - toY == 2) {
                    if (Math.abs(fromX - toX) == 1) {
                        return true;
                    }
                }
                if (fromY - toY == -2) {
                    if (Math.abs(fromX - toX) == 1) {
                        return true;
                    }
                }
                return false;
            case 10:
                if(fromY - toY == 1){
                    if(Math.abs(fromX - toX) == 2){
                        return true;
                    }
                }
                if(fromY - toY == -1){
                    if(Math.abs(fromX - toX) == 2){
                        return true;
                    }
                }
                if(fromY - toY == 2){
                    if(Math.abs(fromX - toX) == 1){
                        return true;
                    }
                }
                if(fromY - toY == -2){
                    if(Math.abs(fromX - toX) == 1){
                        return true;
                    }
                }
                return false;
        }
        return true;
    }
}