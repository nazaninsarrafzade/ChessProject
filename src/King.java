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

    void isLegalMove(int pickedPiece,int fromY,int fromX,int toY,int toX){

    }

}