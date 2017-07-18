/**
 * Created by nazanin-sarrafzadeh on 6/18/2017.
 */


import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 5000;
    Vector client_socks = new Vector(1);

    public Server(){
        try {
            ServerSocket localServerSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client...");
                Socket localSocket = localServerSocket.accept();
                if(this.client_socks.size() >= 2) {
                    localSocket.close();
                } else {
                    this.client_socks.addElement(localSocket);
                    sendIdentity();
                    String str = localSocket.getInetAddress().getHostAddress();
                    new ClientHandler(localSocket, str, this).start();
                }
            }
        }
        catch (IOException localException){
            System.err.println(localException);
        }
    }

    private void sendIdentity() {
        System.out.println(this.client_socks.size());
        Socket localSocket;
        PrintWriter localPrintWriter;
        if(this.client_socks.size() == 1) {
            localSocket = (Socket)this.client_socks.get(0);
            try {
                localPrintWriter = new PrintWriter(localSocket.getOutputStream(), true);
                localPrintWriter.println("@WHITE");
                localPrintWriter.flush();
            }
            catch (IOException localException1) {
                System.err.println(localException1);
            }
        }

        if(this.client_socks.size() == 2) {
            localSocket = (Socket)this.client_socks.get(1);
            try {
                localPrintWriter = new PrintWriter(localSocket.getOutputStream(), true);
                localPrintWriter.println("@BLACK");
                localPrintWriter.flush();
            }
            catch(IOException localException2) {
                System.err.println(localException2);
            }
        }
    }

    public synchronized void broadcastLine(Socket paramSocket, String paramString) {
        Enumeration localEnumeration = this.client_socks.elements();

        while (localEnumeration.hasMoreElements()) {
            Socket localSocket = (Socket)localEnumeration.nextElement();
            if(localSocket != paramSocket) {
                try {
                    PrintWriter localPrintWriter = new PrintWriter(localSocket.getOutputStream(), true);
                    localPrintWriter.println(paramString);
                    localPrintWriter.flush();
                }
                catch(IOException localException){
                    System.err.println(localException);
                }
            }
        }
    }

    public synchronized void removeClient(Socket paramSocket) {
        this.client_socks.removeElement(paramSocket);
    }

    public static void main(String[] paramArrayOfString) {
        new Server();
    }
}