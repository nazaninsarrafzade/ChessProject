

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import javax.swing.*;

public class Client extends JFrame {
    private static ChessBoard board;
    private BorderLayout layout;
    private JMenuBar bar = new JMenuBar();
    private JMenu gameMenu = new JMenu("Game Menu");
    private JMenuItem resetItem = new JMenuItem("Reset");
    private JMenuItem exitItem = new JMenuItem("Exit");

    public Client() {
        super("Chess");
        Container container = getContentPane();

        this.layout = new BorderLayout(1, 1);
        container.setLayout(this.layout);

        this.board = new ChessBoard(this);
        container.add(this.board, "Center");


        setJMenuBar(this.bar);

        this.gameMenu.add(this.resetItem);
        this.gameMenu.add(this.exitItem);

        this.bar.add(this.gameMenu);

        this.exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                System.exit(0);
            }
        });

        this.resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                Client.this.board.resetBoard();
            }
        });
        setResizable(false);
        setSize(400, 450);
    }

    public static void main(String[] paramArrayOfString){
        Client client = new Client();
        client.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent paramAnonymousWindowEvent){
                System.exit(0);
            }
        });

        client.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - client.getWidth())/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - client.getHeight())/2);
        client.show();

    }


}