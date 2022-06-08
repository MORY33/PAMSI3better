public interface Gamer {

     static final String RESET = "\033[0m";  // Text Reset
     static final String RED = "\033[0;31m";     // RED
     static final String YELLOW = "\033[0;33m";  // YELLOW

//    void makeMove(Board ticBoard);
    void makeMove(Board ticBoard, Mark sign);
}
