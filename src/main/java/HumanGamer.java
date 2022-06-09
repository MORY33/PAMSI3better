import java.util.Scanner;

import static java.lang.Math.abs;

public class HumanGamer implements Gamer {
    @Override
    public void makeMove(Board ticBoard, Mark sign) {
        Scanner sc = new Scanner(System.in);
        int choice = 420;
        int counterx = 0;
        while (choice != ticBoard.availableMove(ticBoard.getTicBoard(), ticBoard.size, choice)) {

            if (counterx != 3) System.out.println("Player's 1 turn: " + sign);
            if (counterx == 3) {
                System.out.println(RED + "Ee, you'd better watch anime..." + RESET);
                System.exit(420);
            }
            choice = sc.nextInt();
            counterx++;
            if (ticBoard.isTaken(choice, ticBoard.getTicBoard()) && counterx != 3) {
                System.out.println(YELLOW + "Make sure, that your move is legal! \nTRY AGAIN " + abs(counterx - 3) + " attempts left" + RESET);
            }
        }


        ticBoard.updateBoard(choice, ticBoard.getTicBoard(), ticBoard.size, sign);
        ticBoard.printBoard();


        if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), ticBoard.size) || ticBoard.leftRightDiagonalWin(ticBoard.getTicBoard(), ticBoard.size)
                || ticBoard.horizontalWin(ticBoard.getTicBoard(), ticBoard.size) || ticBoard.verticalWin(ticBoard.getTicBoard(), ticBoard.size)
                || ticBoard.checkDraw(ticBoard.getTicBoard(), ticBoard.size)) {
            System.exit(0);
        }
    }
}

