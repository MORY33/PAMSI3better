import java.util.Scanner;

public class HumanGamer implements Gamer{
    @Override
    public void makeMove(Board ticBoard, int size) {
        Scanner sc = new Scanner(System.in);
        int choice = 420;
            int counterx = 0;
            while(choice!=ticBoard.availableMove(ticBoard.getTicBoard(), ticBoard.size, choice)){
                System.out.println("Player's 1 turn (x)");
                choice = sc.nextInt();
                if(ticBoard.isTaken(choice, ticBoard.getTicBoard())){
                    System.out.println("Make sure, that your move is legal!");
                }
                if (counterx == 3) {
                    System.out.println( "Ee, you'd better watch anime..." );
                    System.exit(420);
                }

                counterx++;
            }


            ticBoard.updateBoard(choice, 1, ticBoard.getTicBoard(), ticBoard.size);
            ticBoard.printBoard();



            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), size) || ticBoard.leftRightDiagonalWin(ticBoard.getTicBoard(), size)
                    || ticBoard.horizontalWin(ticBoard.getTicBoard(), size) || ticBoard.verticalWin(ticBoard.getTicBoard(), size)) {
                System.exit(0);
            }
    }
}
