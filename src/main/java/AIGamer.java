import java.util.Scanner;

import static java.lang.Math.abs;


public class AIGamer implements Gamer{

//    @Override
//    public void makeMove(Board ticBoard, Mark sign) {
//            Scanner sc = new Scanner(System.in);
//            int choice2 = 420;
//            int counter = 0;
//            while(choice2!=ticBoard.availableMove(ticBoard.getTicBoard(), ticBoard.size, choice2)){
//                if (counter!=3) System.out.println("Player's 2 turn: "+sign);
//                if (counter == 3) {
//                    System.out.println(RED + "Ee, you'd better watch anime..." + RESET);
//                    System.exit(420);
//                }
//                choice2 = sc.nextInt();
//                counter++;
//                if(ticBoard.isTaken(choice2, ticBoard.getTicBoard())&& counter!=3){
//                    System.out.println(YELLOW + "Make sure, that your move is legal! \nTRY AGAIN " + abs(counter-3) + " attempts left" + RESET );
//                }
//            }
//
//            ticBoard.updateBoard(choice2, ticBoard.getTicBoard(), ticBoard.size, sign);
//            ticBoard.printBoard();
//
//
//            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), ticBoard.size) || ticBoard.leftRightDiagonalWin(ticBoard.getTicBoard(), ticBoard.size)
//                    || ticBoard.horizontalWin(ticBoard.getTicBoard(), ticBoard.size) || ticBoard.verticalWin(ticBoard.getTicBoard(), ticBoard.size)
//                    || ticBoard.checkDraw(ticBoard.getTicBoard(),ticBoard.size)) {
//                System.exit(0);
//            }
//    }



    @Override
    public void makeMove(Board board, Mark sign) {

        int[] choice = MiniMax.getBestMove(board);
        System.out.println(choice[0]);

        board.updateBoard(choice[0], board.getTicBoard(), board.size, sign);
        board.printBoard();
        if (board.rightLeftDiagonalWin(board.getTicBoard(), board.size) || board.leftRightDiagonalWin(board.getTicBoard(), board.size)
                    || board.horizontalWin(board.getTicBoard(), board.size) || board.verticalWin(board.getTicBoard(), board.size)
                    || board.checkDraw(board.getTicBoard(),board.size)) {
                System.exit(0);
            }

    }





}



