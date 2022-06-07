public interface Gamer {

//    void makeMove(Board board, Sign sign);
//    void makeMove(Board board, Sign sign, int x, int y);
     static final String RESET = "\033[0m";  // Text Reset
    //colors
     static final String BLACK = "\033[0;30m";   // BLACK
     static final String RED = "\033[0;31m";     // RED
     static final String GREEN = "\033[0;32m";   // GREEN
     static final String YELLOW = "\033[0;33m";  // YELLOW
     static final String BLUE = "\033[0;34m";    // BLUE
     static final String PURPLE = "\033[0;35m";  // PURPLE
     static final String CYAN = "\033[0;36m";    // CYAN
     static final String WHITE = "\033[0;37m";   // WHITE

    void makeMove(Board ticBoard, int size);
}
