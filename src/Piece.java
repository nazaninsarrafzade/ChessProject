import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public abstract class Piece {
    Piece(){}
    //    Piece(boolean white,String img,int id){
//            this.white=white;
//            this.id=id;
//            this.Image=new ImageIcon(img);
//    }
    int id;
    boolean white;
    ImageIcon Image;
    abstract boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX);
}
