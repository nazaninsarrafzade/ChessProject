import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */
public class Queen extends Piece {
    Queen(boolean white){
        if(white)
        {
            super.id=1;
            super.Image=new ImageIcon("wqueen.gif");
        }
        else
        {
            super.id=7;
            super.Image=new ImageIcon("bqueen.gif");
        }
    }


    boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX,int[][] chessBoard) {

        switch (id) {
            case 1:
                if ((fromX == toX)) {
                    if (fromY > toY) {
                        for (int i = fromY; i > toY; --i) {
                            if (chessBoard[i][fromX] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for (int i = toY; i > fromY; --i) {
                            if (chessBoard[i][fromX] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if ((fromY == toY)) {
                    if (fromX > toX) {
                        for (int i = fromX; i > toX; --i) {
                            if (chessBoard[fromY][i] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for (int i = toX; i > fromX; --i) {
                            if (chessBoard[fromY][i] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (fromY - toY == fromX - toX) {
                    if (fromY > toY && fromX > toX) {
                        for (int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY > toY && fromX < toX) {
                        for (int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX > toX) {
                        for (int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX < toX) {
                        for (int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }

                if (fromY - toY == toX - fromX) {
                    if (fromY > toY && fromX > toX) {
                        for (int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY > toY && fromX < toX) {
                        for (int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX > toX) {
                        for (int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX < toX) {
                        for (int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }

                if (toY - fromY == fromX - toX) {
                    if (fromY > toY && fromX > toX) {
                        for (int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY > toY && fromX < toX) {
                        for (int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX > toX) {
                        for (int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX < toX) {
                        for (int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }

                if (toY - fromY == toX - fromX) {
                    if (fromY > toY && fromX > toX) {
                        for (int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY > toY && fromX < toX) {
                        for (int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX > toX) {
                        for (int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    } else if (fromY < toY && fromX < toX) {
                        for (int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j) {
                            if (chessBoard[i][j] != 12) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            case 7:
                if((fromX == toX)){
                    if(fromY > toY){
                        for(int i = fromY; i > toY; --i){
                            if(chessBoard[i][fromX] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for(int i = toY; i > fromY; --i){
                            if(chessBoard[i - 1][fromX] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if((fromY == toY)){
                    if(fromX > toX){
                        for(int i = fromX; i > toX; --i){
                            if(chessBoard[fromY][i] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else {
                        for(int i = toX; i > fromX; --i){
                            if(chessBoard[fromY][i - 1] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if(fromY - toY == fromX - toX){
                    if(fromY > toY && fromX > toX){
                        for(int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY > toY && fromX < toX){
                        for(int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX > toX){
                        for(int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX < toX){
                        for(int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }

                if(fromY - toY == toX - fromX){
                    if(fromY > toY && fromX > toX){
                        for(int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY > toY && fromX < toX){
                        for(int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX > toX){
                        for(int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX < toX){
                        for(int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }

                if(toY - fromY == fromX - toX){
                    if(fromY > toY && fromX > toX){
                        for(int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY > toY && fromX < toX){
                        for(int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX > toX){
                        for(int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX < toX){
                        for(int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }

                if(toY - fromY == toX - fromX){
                    if(fromY > toY && fromX > toX){
                        for(int i = toY + 1, j = toX + 1; i < fromY && j < fromX; ++i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY > toY && fromX < toX){
                        for(int i = toY + 1, j = toX - 1; i < fromY && j > fromX; ++i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX > toX){
                        for(int i = toY - 1, j = toX + 1; i > fromY && j < fromX; --i, ++j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    } else if(fromY < toY && fromX < toX){
                        for(int i = toY - 1, j = toX - 1; i > fromY && j > fromX; --i, --j){
                            if(chessBoard[i][j] != 12){
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;

        }
        return true;
    }

}