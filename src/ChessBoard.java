import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class ChessBoard extends JPanel
        implements ImageObserver, MouseListener, MouseMotionListener {
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
    Piece pieces[]=new Piece[16];
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
    Rook rookw=new Rook(true);
    Rook rookb=new Rook(false);
    Knight knightw=new Knight(true);
    Knight knightb=new Knight(false);
    Bishop bishopw=new Bishop(true);
    Bishop bishopb=new Bishop(false);
    King kingw=new King(true);
    King kingb=new King(false);
    Queen queenw=new Queen(true);
    Queen queenb=new Queen(false);
    Pawn pawnw=new Pawn(true);
    Pawn pawnb=new Pawn(false);
    //}

    private void setBoard() {
        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
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

        for(int k = 0; k < 8; k++){
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
    public boolean imageUpdate(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5){
        return true;
    }

    @Override
    public void paint(Graphics paramGraphics){
        Graphics2D localGraphics2D = (Graphics2D)paramGraphics;
        drawOffscreen();
        localGraphics2D.drawImage(image_buffer, 0, 0, this);
    }

    private void drawOffscreen(){
        Graphics2D localGraphics2D = image_buffer.createGraphics();
        renderChessBoard(localGraphics2D);
        if(pickedPiece != 12) {
            localGraphics2D.drawImage(getPiece(pickedPiece).Image.getImage(), x - 22, y - 22, this);
        }
    }

    private void renderChessBoard(Graphics2D paramGraphics2D){
        int i = 0, j = 0;
        int k = 0;

        for(int m = 0; m < 8; m++) {
            i = 0;
            k = m % 2 == 0 ? 1 : 0;
            for(int n = 0; n < 8; n++) {
                if(k != 0) {
                    paramGraphics2D.setColor(Color.white);
                } else {
                    paramGraphics2D.setColor(Color.BLUE);
                }
                k = k == 0 ? 1 : 0;
                paramGraphics2D.fillRect(i, j, 50, 50);
                paintChessPiece(this.chessBoard[m][n], i, j, paramGraphics2D);
                i += 50;
            }
            j += 50;
        }
    }

    private void paintChessPiece(int paramInt1, int paramInt2, int paramInt3, Graphics2D paramGraphics2D) {
        if((paramInt1 < 0) || (paramInt1 >= 12))
            return;

        paramGraphics2D.drawImage(getPiece(paramInt1).Image.getImage(), paramInt2 + 2, paramInt3 + 2, this);
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
    public void mouseReleased(MouseEvent paramMouseEvent){
        if(pickedPiece == 12)
            return;

        toY = (paramMouseEvent.getY() / 50);
        toX = (paramMouseEvent.getX() / 50);

        if((toY < 0) || (toY > 7) || (toX < 0) || (toX > 7)){
            chessBoard[fromY][fromX] = pickedPiece;
            pickedPiece = 12;
            repaint();
            return;
        }

        if(((fromY == toY) && (fromX == toX)) ||
                (!isLegalMove(pickedPiece, fromY, fromX, toY, toX))){
            chessBoard[fromY][fromX] = pickedPiece;
            pickedPiece = 12;
            repaint();
            return;
        }

        if(isLegalMove(pickedPiece, fromY, fromX, toY, toX)) {
            chessBoard[toY][toX] = pickedPiece;
        }
        else {
            chessBoard[fromY][fromX] = pickedPiece;
        }
        pickedPiece = 12;
        repaint();
        String str = Code.encodeBoard(this);
        this.serverconnection.send(str);
        this.serverconnection.send("@TOKEN");
        this.myTurn = false;
    }

    @Override
    public void mouseDragged(MouseEvent paramMouseEvent){
        if (this.pickedPiece == 12)
            return;
        this.x = paramMouseEvent.getX();
        this.y = paramMouseEvent.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent paramMouseEvent)
    {
    }
//in tabe bool return kone va jahayi ke getpiecetype hast ye is empty ham ezafe konim

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

    boolean isLegalMove(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {

        if(getPieceType(paramInt1) == getPieceType(this.chessBoard[paramInt4][paramInt5])) {
            return false;
        }
        switch(paramInt1) {

            case 0:return kingw.isLegalMove( paramInt1,  paramInt2,  paramInt3, paramInt4, paramInt5,chessBoard);


            case 6:return kingb.isLegalMove( paramInt1,paramInt2,  paramInt3, paramInt4,  paramInt5,chessBoard);


            case 1:return queenw.isLegalMove(paramInt1,  paramInt2,  paramInt3,  paramInt4, paramInt5,chessBoard);


            case 7:return queenb.isLegalMove( paramInt1, paramInt2,  paramInt3, paramInt4, paramInt5,chessBoard);

            case 2:return rookw.isLegalMove( paramInt1, paramInt2,  paramInt3, paramInt4, paramInt5,chessBoard);



            case 8:return rookb.isLegalMove( paramInt1,  paramInt2,  paramInt3,  paramInt4,  paramInt5,chessBoard);



            case 3:return bishopw.isLegalMove(paramInt1, paramInt2, paramInt3,  paramInt4, paramInt5,chessBoard);


            case 9:return bishopb.isLegalMove( paramInt1,  paramInt2,paramInt3, paramInt4,  paramInt5,chessBoard);


            case 4:return knightw.isLegalMove(paramInt1, paramInt2,  paramInt3,  paramInt4,  paramInt5,chessBoard);


            case 10:return knightb.isLegalMove( paramInt1,  paramInt2,  paramInt3,  paramInt4,  paramInt5,chessBoard);



            case 5:return pawnw.isLegalMove( paramInt1,  paramInt2,  paramInt3,  paramInt4,  paramInt5,chessBoard);


            case 11:return pawnb.isLegalMove(paramInt1, paramInt2,  paramInt3, paramInt4, paramInt5,chessBoard);


        }
        return true;
    }
    public synchronized void receiveData(String paramString) {
        if(paramString.charAt(0) == '@') {
            processCommand(paramString);
            return;
        }
        Code.decodeBoard(paramString,this);
        repaint();
    }

    private void processCommand(String paramString) {
        if(paramString.compareTo("@BLACK") == 0) {
            this.myColor = 13;
            this.Player.setTitle("PLAYER BLACK");
            resetBoard();
        }
        else if(paramString.compareTo("@WHITE") == 0) {
            this.myColor = 14;
            this.Player.setTitle("PLAYER WHITE");
            resetBoard();
            this.myTurn = true;
        }
        if(paramString.compareTo("@RESET") == 0) {
            if(myColor == 14){
                this.myTurn = true;
            }
        }
        else if(paramString.compareTo("@TOKEN") == 0) {
            this.myTurn = true;
        }
    }
    public Piece getPiece(int id){

        switch (id){
            case 0:return kingw;
            case 1:return queenw;
            case 2:return rookw;
            case 3:return bishopw;
            case 4:return knightw;
            case 5:return pawnw;
            case 6:return kingb;
            case 7:return queenb;
            case 8:return rookb;
            case 9:return bishopb;
            case 10:return knightb;
            case 11:return pawnb;
            default: return chosenPiece;
        }
    }


}