import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public class King extends Piece {
    King(boolean white){
        if(white)
        {
            super.id=0;
            super.Image=new ImageIcon("wking.gif");
        }
        else
        {
            super.id=6;
            super.Image=new ImageIcon("bking.gif");
        }
    }

    boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX,int chessBoard[][]){
        boolean castled=false;
        switch (id){
            case 0:
                if((Math.abs(fromY - toY) == 1 || fromY - toY == 0)
                        && (Math.abs(fromX - toX) == 1 || fromX - toX == 0)){
                    return true;
                }
                // castling movement
                if (fromX-toX==2 && fromY==toY){
                    if (chessBoard[fromY][fromX-1]!=12 && chessBoard[fromY][fromX-2]!=12){
                        castled=false;
                    }
                    castled=true;
                    return true;
                }
                else if (toX-fromX==2 && fromY==toY){
                    if (chessBoard[fromY][fromX+1]!=12 && chessBoard[fromY][fromX+2]!=12){
                        castled=false;
                    }
                    castled=true;
                    return true;
                }
                return false;
            case 6:
                if((Math.abs(fromY - toY) == 1 || fromY - toY == 0)
                        && (Math.abs(fromX - toX) == 1 || fromX - toX == 0)){
                    return true;
                }
                return false;
        }

        return true;
    }

}