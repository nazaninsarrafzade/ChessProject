import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */

public class Bishop extends Piece {
    Bishop(boolean white){
        if(white)
        {
            super.id=3;
            super.Image=new ImageIcon("wbishop.gif");
        }
        else
        {
            super.id=9;
            super.Image=new ImageIcon("bbishop.gif");
        }
    }

    void isLegalMove(int pickedPiece,int fromY,int fromX,int toY,int toX){

    }
}
