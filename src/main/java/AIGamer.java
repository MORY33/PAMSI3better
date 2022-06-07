import java.util.Scanner;


public class AIGamer implements Gamer{

    @Override
    public void makeMove(Board ticBoard, int size) {
            Scanner sc = new Scanner(System.in);
            int choice2 = 420;
            int counter = 0;
            while(choice2!=ticBoard.availableMove(ticBoard.getTicBoard(), ticBoard.size, choice2)){
                System.out.println("Player's 2 turn (o)");
                choice2 = sc.nextInt();
                if(ticBoard.isTaken(choice2, ticBoard.getTicBoard())){
                    System.out.println("Make sure, that your move is legal!");
                }
                if (counter == 3) {
                    System.out.println("Ee, you'd better watch anime...");
                    System.exit(420);
                }

                counter++;
            }



            ticBoard.updateBoard(choice2, 2, ticBoard.getTicBoard(), ticBoard.size);
            ticBoard.printBoard();



            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), size) || ticBoard.leftRightDiagonalWin(ticBoard.getTicBoard(), size)
                    || ticBoard.horizontalWin(ticBoard.getTicBoard(), size) || ticBoard.verticalWin(ticBoard.getTicBoard(), size)) {
                System.exit(0);
            }
    }
}
