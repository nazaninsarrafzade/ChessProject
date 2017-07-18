/**
 * Created by nazanin-sarrafzadeh on 6/18/2017.
 */


import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    private Socket clientSock;
    private String cliAddr;
    private Server server;

    public ClientHandler(Socket paramSocket, String paramString, Server paramChessServer){
        this.clientSock = paramSocket;
        this.cliAddr = paramString;
        System.out.println("Client connection from " + paramString);
        this.server = paramChessServer;
    }

    @Override
    public void run() {
        try {
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.clientSock.getInputStream()));
            PrintWriter localPrintWriter = new PrintWriter(this.clientSock.getOutputStream(), true);
            processClient(localBufferedReader, localPrintWriter);
            this.clientSock.close();
            System.out.println("Client (" + this.cliAddr + ") connection closed\n");
            this.server.removeClient(this.clientSock);
        }
        catch (IOException localException) {
            System.err.println(localException);
        }
    }

    private void processClient(BufferedReader paramBufferedReader, PrintWriter paramPrintWriter) {
        int i = 0;
        try {
            while(i == 0) {
                String str;
                if((str = paramBufferedReader.readLine()) == null) {
                    i = 1;
                } else {
                 //   System.out.println(str);
                    this.server.broadcastLine(this.clientSock, str);
                }
            }
        }
        catch(IOException localIOException) {
            System.err.println(localIOException);
        }
    }
}
