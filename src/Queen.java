import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public class Queen extends Piece {
    Queen(boolean white){
        if(white)
        {
            super.id=1;
            super.Image=new ImageIcon("wqueen.gif");
        }
        else
        {
            super.id=7;
            super.Image=new ImageIcon("bqueen.gif");
        }
    }

    void isLegalMove(int pickedPiece,int fromY,int fromX,int toY,int toX){

    }

}
