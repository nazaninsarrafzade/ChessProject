/**
 * Created by nazanin-sarrafzadeh on 6/3/2017.
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class ChessBoard extends JPanel implements ImageObserver, MouseListener, MouseMotionListener {
    BufferedImage image_buffer;
    ChessServerConnection serverconnection;
    private int x;
    private int y;
    private Client Player;
    private int myColor;
    private boolean myTurn;
    private int pickedPiece;
    private int fromY;
    private int fromX;
    private int toY;
    private int toX;
    Piece pieces[] = new Piece[16];
    Piece chosenPiece;
    public int[][] chessBoard = new int[8][8];

    public ChessBoard(Client chessClient) {
        this.Player = chessClient;
        setSize(800, 800);
        //initPieces();
        this.image_buffer = new BufferedImage(400, 400, 1);
        addMouseListener(this);
        addMouseMotionListener(this);
        setBoard();
        this.serverconnection = new ChessServerConnection(this);
        this.pickedPiece = 12;
    }

    public void resetBoard() {
        setBoard();
        repaint();
        String str = Code.encodeBoard(this);
        this.serverconnection.send(str);
        this.serverconnection.send("@RESET");
    }

    //public void initPieces(){
    Rook rookw = new Rook(true);
    Rook rookb = new Rook(false);
    Knight knightw = new Knight(true);
    Knight knightb = new Knight(false);
    Bishop bishopw = new Bishop(true);
    Bishop bishopb = new Bishop(false);
    King kingw = new King(true);
    King kingb = new King(false);
    Queen queenw = new Queen(true);
    Queen queenb = new Queen(false);
    Pawn pawnw = new Pawn(true);
    Pawn pawnb = new Pawn(false);
    //}

    private void setBoard() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessBoard[i][j] = 12;
            }
        }
        this.chessBoard[0][0] = rookb.id;
        this.chessBoard[0][1] = knightb.id;
        this.chessBoard[0][2] = bishopb.id;
        this.chessBoard[0][3] = queenb.id;
        this.chessBoard[0][4] = kingb.id;
        this.chessBoard[0][5] = bishopb.id;
        this.chessBoard[0][6] = knightb.id;
        this.chessBoard[0][7] = rookb.id;

        for (int k = 0; k < 8; k++) {
            this.chessBoard[1][k] = 11;
            this.chessBoard[6][k] = 5;
        }

        this.chessBoard[7][0] = rookw.id;
        this.chessBoard[7][1] = knightw.id;
        this.chessBoard[7][2] = bishopw.id;
        this.chessBoard[7][3] = queenw.id;
        this.chessBoard[7][4] = kingw.id;
        this.chessBoard[7][5] = bishopw.id;
        this.chessBoard[7][6] = kingw.id;
        this.chessBoard[7][7] = rookw.id;
    }

    @Override
    public void mouseClicked(MouseEvent paramMouseEvent)
    {
    }

    @Override
    public void mouseEntered(MouseEvent paramMouseEvent)
    {
    }

    @Override
    public void mouseExited(MouseEvent paramMouseEvent)
    {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        fromY = (mouseEvent.getY() / 50);
        fromX = (mouseEvent.getX() / 50);

        if((fromY < 0) || (fromY > 7))
            return;
        if((fromX < 0) || (fromX > 7))
            return;

        pickedPiece = chessBoard[fromY][fromX];
//mycolor bool mishe va tabdile id be piecce ye tabe mishe
        if(pickedPiece!=12){
            if((getPieceType(pickedPiece) != myColor) || (!myTurn)) {
                pickedPiece = 12;
                return;
            }
        }

        chessBoard[fromY][fromX] = 12;
        x = mouseEvent.getX();
        y = mouseEvent.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent paramMouseEvent) {
        if (pickedPiece == 12)
            return;

        toY = (paramMouseEvent.getY() / 50);
        toX = (paramMouseEvent.getX() / 50);

        if ((toY < 0) || (toY > 7) || (toX < 0) || (toX > 7)) {
            chessBoard[fromY][fromX] = pickedPiece;
            pickedPiece = 12;
            repaint();
            return;
        }

        if (((fromY == toY) && (fromX == toX)) ||
                (!isLegalMove(pickedPiece, fromY, fromX, toY, toX))) {
            chessBoard[fromY][fromX] = pickedPiece;
            pickedPiece = 12;
            repaint();
            return;
        }
    }
        public int getPieceType(int paramInt){
            switch(paramInt) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return 14;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    return 13;
            }
            return 12;
        }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}