/**
 * Created by nazanin-sarrafzadeh on 6/18/2017.
 */
public class Code {
    public static String encodeBoard(ChessBoard cb) {
        String str = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (cb.chessBoard[i][j]) {
                    case 0:
                        str = str + "A"; break;
                    case 1:
                        str = str + "B"; break;
                    case 2:
                        str = str + "C"; break;
                    case 3:
                        str = str + "D"; break;
                    case 4:
                        str = str + "E"; break;
                    case 5:
                        str = str + "F"; break;
                    case 6:
                        str = str + "G"; break;
                    case 7:
                        str = str + "H"; break;
                    case 8:
                        str = str + "I"; break;
                    case 9:
                        str = str + "J"; break;
                    case 10:
                        str = str + "K"; break;
                    case 11:
                        str = str + "L"; break;
                    case 12:
                        str = str + "M";
                }
            }
        }
        return str;
    }
    public static void decodeBoard(String coded, ChessBoard cb) {
        if (coded.length() < 64)
            return;
        for(int m = 0; m < 64; m++){
            int i = m / 8;
            int j = m % 8;
            int k = coded.charAt(m);

            switch (k) {
                case 65:
                    cb.chessBoard[i][j] = 0; break;
                case 66:
                    cb.chessBoard[i][j] = 1; break;
                case 67:
                    cb.chessBoard[i][j] = 2; break;
                case 68:
                    cb.chessBoard[i][j] = 3; break;
                case 69:
                    cb.chessBoard[i][j] = 4; break;
                case 70:
                    cb.chessBoard[i][j] = 5; break;
                case 71:
                    cb.chessBoard[i][j] = 6; break;
                case 72:
                    cb.chessBoard[i][j] = 7; break;
                case 73:
                    cb.chessBoard[i][j] = 8; break;
                case 74:
                    cb.chessBoard[i][j] = 9; break;
                case 75:
                    cb.chessBoard[i][j] = 10; break;
                case 76:
                    cb.chessBoard[i][j] = 11; break;
                case 77:
                    cb.chessBoard[i][j] = 12;
            }
        }
    }
}
