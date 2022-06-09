import java.util.Scanner;

public class Game {

    public static final String RESET = "\033[0m";  // Text Reset
    //colors
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String CYAN = "\033[0;36m";    // CYAN
    public int size;
    public Game() throws InterruptedException {
        startGame();
    }

    public void startGame() throws InterruptedException {
        chooseOption();
        Board ticBoard = new Board(size);
        int choice = choosePlayer();
        HumanGamer humanPlayer = new HumanGamer();
        AIGamer AIPlayer = new AIGamer();
        boolean isWon = false;

        while(!isWon){
            if(choice==1){
                ticBoard.Helpboard(size);
                humanPlayer.makeMove(ticBoard, Mark.XTYPE);
                System.out.println("Hm... ");
                Thread.sleep(1500);
                AIPlayer.makeMove(ticBoard, Mark.OTYPE);
            }
            else {
                ticBoard.Helpboard(size);
                System.out.println("Hmm...");
                Thread.sleep(1500);
                AIPlayer.makeMove(ticBoard, Mark.OTYPE);
                humanPlayer.makeMove(ticBoard, Mark.XTYPE);
            }
        }
    }




    public int choosePlayer(){

        Scanner sc = new Scanner(System.in);
        int a = 5;
        while(a!=1 && a!=2){
            System.out.println("Who should start?");
            System.out.println("PLAYER ---> 1");
            System.out.println("COMPUTER -> 2");
            a = sc.nextInt();
        }
        return a;

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
