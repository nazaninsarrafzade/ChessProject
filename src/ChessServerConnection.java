/**
 * Created by nazanin-sarrafzadeh on 6/18/2017.
 */


import java.io.*;
import java.net.*;

public class ChessServerConnection{
    private static final int PORT = 5000;
    private static final String HOST = "localhost";
    private byte[] input = {(byte)192, (byte)168, (byte)1, (byte)3};
    InputHandlerThread inputhandler;
    ChessBoard chessboard;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChessServerConnection(ChessBoard paramChessBoard) {
        this.chessboard = paramChessBoard;
        try {
            this.socket = new Socket(InetAddress.getLocalHost(), PORT);
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            this.inputhandler = new InputHandlerThread(this, this.in);
            this.inputhandler.start();
        }
        catch(IOException localException){
            System.err.println(localException);
        }
    }

    public void send(String paramString) {
        this.out.println(paramString);
    }

    public synchronized void reply(String paramString) {
        this.chessboard.receiveData(paramString);
    }
}
