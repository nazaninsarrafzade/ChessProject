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

    void isLegalMove(int pickedPiece,int fromY,int fromX,int toY,int toX){

    }
}
