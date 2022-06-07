import java.util.Scanner;

public class Game {

    public static final String RESET = "\033[0m";  // Text Reset
    //colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public int size;
    public Game() throws InterruptedException {
        startGame();
    }

    public void startGame() throws InterruptedException {
        chooseOption();
        Board ticBoard = new Board(size);
        HumanGamer humanPlayer = new HumanGamer();
        AIGamer AIPlayer = new AIGamer();
        boolean isWon = false;
//        ticBoard.Helpboard(size);
//        ticBoard.printBoard();

        Scanner sc = new Scanner(System.in);

        while(!isWon){
//            ticBoard.printBoard();
            ticBoard.Helpboard(size);
            humanPlayer.makeMove(ticBoard, size);
            AIPlayer.makeMove(ticBoard, size);



//            int choice = 420;
//            int counterx = 0;
//            while(choice!=ticBoard.availableMove(ticBoard.getTicBoard(), ticBoard.size, choice)){
//                System.out.println("Player's 1 turn (x)");
//                choice = sc.nextInt();
//                if(ticBoard.isTaken(choice, ticBoard.getTicBoard())){
//                    System.out.println("Make sure, that your move is legal!");
//                }
//                if (counterx == 3) {
//                    System.out.println(RED + "Ee, you'd better watch anime..." + RESET);
//                    System.exit(420);
//                }
//
//                counterx++;
//            }
//
//
//            ticBoard.updateBoard(choice, 1, ticBoard.getTicBoard(), ticBoard.size);
//            ticBoard.printBoard();
//
//
//
//            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), size) || ticBoard.leftRightDiagonalWin(ticBoard.getTicBoard(), size)
//                    || ticBoard.horizontalWin(ticBoard.getTicBoard(), size) || ticBoard.verticalWin(ticBoard.getTicBoard(), size)) {
//                System.exit(0);
//            }
//
//
//            int choice2 = 420;
//            int counter = 0;
//            while(choice2!=ticBoard.availableMove(ticBoard.getTicBoard(), ticBoard.size, choice2)){
//                System.out.println("Player's 2 turn (o)");
//                choice2 = sc.nextInt();
//                if(ticBoard.isTaken(choice2, ticBoard.getTicBoard())){
//                    System.out.println("Make sure, that your move is legal!");
//                }
//                if (counter == 3) {
//                    System.out.println(RED + "Ee, you'd better watch anime..." + RESET);
//                    System.exit(420);
//                }
//
//                counter++;
//            }
//
//
//
//            ticBoard.updateBoard(choice2, 2, ticBoard.getTicBoard(), ticBoard.size);
//            ticBoard.printBoard();
//
//
//
//            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), size) || ticBoard.leftRightDiagonalWin(ticBoard.getTicBoard(), size)
//                    || ticBoard.horizontalWin(ticBoard.getTicBoard(), size) || ticBoard.verticalWin(ticBoard.getTicBoard(), size)) {
//                System.exit(0);
//            }

        }

        Thread.sleep(1000);
        ticBoard.printBoard();
    }


//    public void togglePlayers(int player){
//        //player given as parameter is first player
//        Scanner sc = new Scanner(System.in);
//        if(player == 1){
//            int choice = sc.nextInt();
//            ticBoard.updateBoard(choice, 1, ticBoard.getTicBoard(), ticBoard.size);
//        }
//        else {
//
//        }
//    }
    public void choosePlayer(){

    }

    public void clearTerminal(){
        //Not exactly clearing, but looks similiar

        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
//        System.out.println("cleared hehe");
    }

    public void chooseOption(){
        System.out.println(CYAN + "Enter proper board size");
        System.out.println("press 3 for 3x3");
        System.out.println("press 4 for 4x4");
        System.out.println("press 5 for 5x5");
        System.out.println("Choose board size: " + RESET );

        Scanner sc = new Scanner(System.in);
        int a = sc.nextByte();


        switch (a){
            case 3:
                size = 3;
                break;
            case 4:
                size = 4;
                break;
            case 5:
                size = 5;
                break;
            default:
                System.out.println(YELLOW + "Oops, you mean 3x3, right?" + RESET);
                size = 3;
                break;

        }

        System.out.println(GREEN + "Great! You chose " + size + "x" + size + " board size, good choice!" + RESET );
    }








}
