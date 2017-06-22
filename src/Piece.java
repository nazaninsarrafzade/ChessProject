import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public abstract class Piece {
    Piece(){}

    int id;
    boolean white;
    ImageIcon Image;
    abstract boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX, int chessboard[][]);
}
