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
        boolean isWon = false;
        ticBoard.Helpboard(size);
        ticBoard.printBoard();

        Scanner sc = new Scanner(System.in);

        while(!isWon){
            ticBoard.Helpboard(size);


            int choice = sc.nextInt();
            ticBoard.updateBoard(choice, 1, ticBoard.getTicBoard(), ticBoard.size);
            ticBoard.printBoard();
//            if (ticBoard.horizontalWin(ticBoard.getTicBoard(), size) ) {  //|| ticBoard.verticalWin(ticBoard.getTicBoard(), size)
//                System.exit(32);
//            }
            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), size)) {  //|| ticBoard.verticalWin(ticBoard.getTicBoard(), size)
                System.exit(32);
            }


            int choice2 = sc.nextInt();
            ticBoard.updateBoard(choice2, 2, ticBoard.getTicBoard(), ticBoard.size);
            ticBoard.printBoard();
//            if (ticBoard.horizontalWin(ticBoard.getTicBoard(), size)) { //  || ticBoard.verticalWin(ticBoard.getTicBoard(), size)
//                System.exit(32);
//            }
            if (ticBoard.rightLeftDiagonalWin(ticBoard.getTicBoard(), size)) {  //|| ticBoard.verticalWin(ticBoard.getTicBoard(), size)
                System.exit(32);
            }

//            clearTerminal();


        }





        Thread.sleep(1000);
        ticBoard.printBoard();

//        if(ticBoard.horizontalWin(ticBoard.getTicBoard(), size, 1)){
//            System.exit(32);
//        }


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

        for (int i = 0; i < 70; i++) {
            System.out.println("");
        }
        System.out.println("cleared hehe");
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
