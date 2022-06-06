public class Board implements Cloneable{

    public Mark[][] ticBoard;
    public Mark winner;
    public int size;

    public Board(int size){
        this.size = size;
        ticBoard = new Mark[size][size];
//        Mark.BLANK = Mark.valueOf("\uD83D\uDD33");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++){
                ticBoard[row][col] = Mark.BLANK;
            }
        }


    }


    public void updateBoard(int position, int player, Mark[][] gameBoard, int size){
        Mark character;
        if (player == 1){
            character = Mark.XTYPE;
        }
        else{
            character = Mark.OTYPE;
        }

        int g = 1 ;
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                if (position == g) {
                    gameBoard[row][col] = character;
                }
                g+=1;
            }
        }
    }

//    public void setChoice(int x, int y, Sign sign){
//
//        boardArray[x][y] = sign;
//
//    }


    public Mark[][] getTicBoard() {
        return ticBoard;
    }

    public void printBoard() {


        for (int i = 0; i < ticBoard.length; i++) {
            for (int j = 0; j < ticBoard[i].length; j++) {

                switch(ticBoard[i][j]){
                    case XTYPE:
                        System.out.print("  x  ");
                        break;
                    case OTYPE:
                        System.out.print("  o  ");
                        break;
                    case BLANK:
                        System.out.print("  _  "); //🔳
                        break;
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }



    public boolean horizontalWin(Mark[][] board, int size) {

        for (int row = 0; row < size; row++) {
            int counter = 1;
            for (int col = 0; col < size - 1; col++) {
                if (board[row][col] == board[row][col + 1] && board[row][row] != Mark.BLANK) {
                    counter += 1;
                }
                if (counter == size) {
                    if (board[row][col] == Mark.XTYPE) {
                        winner = Mark.XTYPE;
                    } else winner = Mark.OTYPE;
                    System.out.println("And the winner is " + winner);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean verticalWin(Mark[][] board, int size) {
        for (int i = 0; i < size; i++) {
            int counter = 1;
            for (int j = 0; j < size - 1; j++) {
                if ((board[j][i] == board[j+1][i]) && (board[i][i] != Mark.BLANK)) {
                    counter++;
                }
                if (counter == size) {
                    if (board[j][i] == Mark.XTYPE) {
                        winner = Mark.XTYPE;
                    } else winner = Mark.OTYPE;
                    System.out.println("And the winner is " + winner);
                    return true;
                }
            }

        }
        return false;
    }


    public boolean leftRightDiagonalWin(Mark[][] board, int size){

        int counter=1;
        for (int i = 0; i < size-1; i++) {
            if(board[i][i] == board[i+1][i+1] && board[i][i]!=Mark.BLANK){
                counter++;
            }
            if (counter==size){
                if (board[i][i] == Mark.XTYPE) {
                    winner = Mark.XTYPE;
                } else winner = Mark.OTYPE;
                System.out.println("And the winner is " + winner);
                return true;
            }
        }
        return false;
    }


    //must check from rear to front
    public boolean rightLeftDiagonalWin(Mark[][] board, int size){

        for (int row = 0; row < size-1; row++) {
            int counter=1;
            for (int col = 0; col < size+1; col++){
                if ((board[row][col] == board[row+1][col-1]) && (board[row][row] != Mark.BLANK)) {
                    counter++;
                }
//                if(col+row == size-1 && board[row][row]!=Mark.BLANK){
//                    counter++;
//                }
                if (counter==size){
                    if (board[row][col] == Mark.XTYPE) {
                        winner = Mark.XTYPE;
                    } else winner = Mark.OTYPE;
                    System.out.println("And the winner is " + winner);
                    return true;
                }

            }
            }
        return false;
    }



    public void Helpboard(int size){
        int board[][] = new int[size][size];
        int g = 1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = g;
                g += 1;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] < 10 ) {
                    System.out.print(board[i][j] + "  ");
                }
                else{
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

