public interface Gamer {

     String RESET = "\033[0m";  // Text Reset
     String RED = "\033[0;31m";     // RED
     String YELLOW = "\033[0;33m";  // YELLOW

//    void makeMove(Board ticBoard);
    void makeMove(Board ticBoard, Mark sign);
}
