import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public class Rook extends Piece {
    Rook(boolean white){
        if(white)
        {
            super.id=2;
            super.Image=new ImageIcon("wrook.gif");
        }
        else
        {
            super.id=8;
            super.Image=new ImageIcon("brook.gif");
        }
    }


    boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX,int [][]chessBoard) {

        King kingw=new King(true);
        switch (id) {
            case 2:
                if ((fromX == toX)) {
                    if (fromY > toY) {
                        for (int i = fromY; i > toY; --i) {
                            if (chessBoard[i][fromX] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for (int i = toY; i > fromY; --i) {
                            if (chessBoard[i][fromX] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if ((fromY == toY)) {
                    if (fromX > toX) {
                        for (int i = fromX; i > toX; --i) {
                            if (chessBoard[fromY][i] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for (int i = toX; i > fromX; --i) {
                            if (chessBoard[fromY][i] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }

                return false;
            case 8:
                if((fromX == toX)){
                    if(fromY > toY){
                        for(int i = fromY; i > toY; --i){
                            if(chessBoard[i][fromX] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for(int i = toY; i > fromY; --i){
                            if(chessBoard[i - 1][fromX] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if((fromY == toY)){
                    if(fromX> toX){
                        for(int i = fromX; i > toX; --i){
                            if(chessBoard[fromY][i] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for(int i = toX; i > fromX; --i){
                            if(chessBoard[fromY][i - 1] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
        }
        return true;
    }
}
