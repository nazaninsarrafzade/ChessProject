import javax.swing.*;

/**
 * Created by nazanin-sarrafzadeh on 5/31/2017.
 */

public class Bishop extends Piece {
    Bishop(boolean white){
        if(white)
        {
            super.id=3;
            super.Image=new ImageIcon("wbishop.gif");
        }
        else
        {
            super.id=9;
            super.Image=new ImageIcon("bbishop.gif");
        }
    }


    boolean isLegalMove(int pickedPiece, int fromY, int fromX, int toY, int toX,int[][] chessBoard) {

        switch (id) {
            case 3:


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
            case 9:
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
        }
        return true;
    }



}