


public class MiniMax {

    private static final int MAX_DEPTH = 12;

    public MiniMax() {
    }


    public static int miniMax(Board board, int depth, int alpha, int beta,
                              boolean isMax) {
        int boardVal = evaluateBoard(board);

        // Terminal node (win/lose/draw) or max depth reached.
        if (Math.abs(boardVal) == 10 || depth == 0
                || !board.anyMovesAvailable()) {
            return boardVal;
        }




        // Maximise player
        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            int g = 1;
            for (int row = 0; row < board.size; row++) {
                for (int col = 0; col < board.size; col++) {
                    if (!board.isTaken(g, board.getTicBoard())) {
                        board.updateBoard(g,board.getTicBoard(), board.size, Mark.XTYPE);
                        highestVal = Math.max(highestVal, miniMax(board,
                                depth - 1, alpha, beta, false));
                        board.updateBoard(g,board.getTicBoard(), board.size, Mark.BLANK);
                        alpha = Math.max(alpha, highestVal);
                        if (alpha >= beta) {
                            return highestVal;
                        }
                    }
                    g++;
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            int g = 1;
            for (int row = 0; row < board.size; row++) {
                for (int col = 0; col < board.size; col++) {
                    if (!board.isTaken(g, board.getTicBoard())) {
                        board.updateBoard(g,board.getTicBoard(), board.size, Mark.OTYPE);
                        lowestVal = Math.min(lowestVal, miniMax(board,
                                depth - 1, alpha, beta, true));
                        board.updateBoard(g,board.getTicBoard(), board.size, Mark.BLANK);
                        beta = Math.min(beta, lowestVal);
                        if (beta <= alpha) {
                            return lowestVal;
                        }
                    }
                    g++;
                }
            }
            return lowestVal;
        }
    }


    public static int[] getBestMove(Board board) {
        int[] bestMove = new int[]{-1, -1};
        int bestValue = Integer.MIN_VALUE;
        int g=1;
        for (int row = 0; row < board.size; row++) {
            for (int col = 0; col < board.size; col++) {
                if (!board.isTaken(g, board.getTicBoard())) {
                    board.updateBoard(g,board.getTicBoard(), board.size, Mark.XTYPE);
                    int moveValue = miniMax(board, MAX_DEPTH, Integer.MIN_VALUE,
                            Integer.MAX_VALUE, false);
                    board.updateBoard(g,board.getTicBoard(), board.size, Mark.BLANK);
                    if (moveValue > bestValue) {
                        bestMove[0] = g;
                        bestValue = moveValue;
                    }
                }
                g++;
            }
        }
        return bestMove;
    }


    private static int evaluateBoard(Board board) {
        int rowSum = 0;


        for (int row = 0; row < board.size; row++) {
            int counter = 1;
            for (int col = 0; col < board.size - 1; col++) {
                if (board.getTicBoard()[row][col] == board.getTicBoard()[row][col + 1] && board.getTicBoard()[row][row] != Mark.BLANK) {
                    counter += 1;
                }
                if (counter == board.size) {
                    if (board.getTicBoard()[row][col] == Mark.XTYPE) {
                        return 10;
                    } else return -10;
                }
            }
        }


        for (int i = 0; i < board.size; i++) {
            int counter = 1;
            for (int j = 0; j < board.size - 1; j++) {
                if ((board.getTicBoard()[j][i] == board.getTicBoard()[j + 1][i]) && (board.getTicBoard()[i][i] != Mark.BLANK)) {
                    counter++;
                }
                if (counter == board.size) {
                    if (board.getTicBoard()[j][i] == Mark.XTYPE) {
                        return 10;
                    } else return -10;
                }
            }

        }


        int counter = 1;
        for (int i = 0; i < board.size - 1; i++) {
            if (board.getTicBoard()[i][i] == board.getTicBoard()[i + 1][i + 1] && board.getTicBoard()[i][i] != Mark.BLANK) {
                counter++;
            }
            if (counter == board.size) {
                if (board.getTicBoard()[i][i] == Mark.XTYPE) {
                    return 10;
                } else return -10;
            }
        }


        //must check from rear to front

        int xcounter = 0;
        int ocounter = 0;
        for (int i = 0; i < board.size; i++) {

            for (int j = 0; j < board.size; j++) {
                if (i + j == board.size - 1 && board.getTicBoard()[i][j] == Mark.XTYPE) {
                    xcounter++;
                }
                if (i + j == board.size - 1 && board.getTicBoard()[i][j] == Mark.OTYPE) {
                    ocounter++;
                }
                if (ocounter == board.size || xcounter == board.size) {
                    if (board.getTicBoard()[i][j] == Mark.XTYPE) {
                        return 10;
                    } else return -10;
                }
            }


        }
        return 0;
    }}
