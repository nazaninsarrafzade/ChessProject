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

    void isLegalMove(int pickedPiece,int fromY,int fromX,int toY,int toX){

    }
}
