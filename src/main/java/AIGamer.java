import java.util.Scanner;

import static java.lang.Math.abs;


public class AIGamer implements Gamer{

    @Override
    public void makeMove(Board ticBoard, int size) {
            Scanner sc = new Scanner(System.in);
            int choice2 = 420;
            int counter = 0;
            while(choice2!=ticBoard.availableMove(ticBoard.getTicBoard(), ticBoard.size, choice2)){
                if (counter!=3) System.out.println("Player's 2 turn (o)");
                if (counter == 3) {
                    System.out.println(RED + "Ee, you'd better watch anime..." + RESET);
                    System.exit(420);
                }
                choice2 = sc.nextInt();
                counter++;
                if(ticBoard.isTaken(choice2, ticBoard.getTicBoard())&& counter!=3){
                    System.out.println(YELLOW + "Make sure, that your move is legal! \nTRY AGAIN " + abs(counter-3) + " attempts left" + RESET );
                }
            }

            ticBoard.updateBoard(choice2, ticBoard.getTicBoard(), ticBoard.size, Mark.OTYPE);
            ticBoard.printBoard();


            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), size) || ticBoard.leftRightDiagonalWin(ticBoard.getTicBoard(), size)
                    || ticBoard.horizontalWin(ticBoard.getTicBoard(), size) || ticBoard.verticalWin(ticBoard.getTicBoard(), size) || ticBoard.checkDraw(ticBoard.getTicBoard(),size)) {
                System.exit(0);
            }
    }
}



