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

    void isLegalMove(int pickedPiece,int fromY,int fromX,int toY,int toX){

    }

}