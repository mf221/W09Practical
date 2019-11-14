public class Board {

    // The following four constants were defined in the starter code (kt54)
    private static final int  DEFAULT_SIZE = 8;
    private static final char FREE         = '.';
    private static final char WHITE_MAN    = '⛀';
    private static final char BLACK_MAN    = '⛂';

    // The following constants are needed for Part 4
    private static final char WHITE_KING   = '⛁';
    private static final char BLACK_KING   = '⛃';

    

    private int boardsize;
    private char[][] board;

    // Default constructor was provided by the starter code. Extend as needed (kt54) 
    public Board() {
        this.boardsize = DEFAULT_SIZE;

        board = new char[boardsize][boardsize];

        // Clear all playable fields
        for(int x=0; x<boardsize; x++)
            for(int y=0; y<boardsize; y++)
                board[x][y] = FREE;

        // Initialises the board
        for(int i = 0; i<boardsize; i+=2){
            board[i+1][0] = BLACK_MAN;
            board[i][1]   = BLACK_MAN;
            board[i+1][2] = BLACK_MAN;
            
            board[i][boardsize-3]  = WHITE_MAN;
            board[i+1][boardsize-2]= WHITE_MAN;
            board[i][boardsize-1]  = WHITE_MAN;
        }
    }
  
    // Prints the board. This method was provided with the starter code. Better not modify to ensure
    // output consistent with the autochecker (kt54)
    public void printBoard() {

        // Print the letters at the top
        System.out.print(" ");
        for(int x=0; x<boardsize; x++) 
            System.out.print(" " + (char)(x + 'a'));
        System.out.println();

        for(int y=0; y<boardsize; y++)
        {
            // Print the numbers on the left side
            System.out.print(y+1);

            // Print the actual board fields
            for(int x=0; x<boardsize; x++) {
                System.out.print(" ");
                char value = board[x][y];
                if(value == FREE) {
                    System.out.print(".");
                } else if(value == WHITE_MAN  || value == BLACK_MAN ||
                          value == WHITE_KING || value == BLACK_KING) {
                    System.out.print(value);
                } else {
                    System.out.print("X");
                }
            }
            // Print the numbers on the right side
            System.out.println(" " + (y+1));
        }

        // Print the letters at the bottom
        System.out.print(" ");
        for(int x=0; x<boardsize; x++) 
            System.out.print(" " + (char)(x + 'a'));
        System.out.print("\n\n");
    }

    //Can a move be made?
    public boolean isMoveLegal(int startCol, int startRow, int endCol, int endRow){
        if(startCol < 0 || startCol >= DEFAULT_SIZE || startRow < 0|| startRow >= DEFAULT_SIZE ||
           endCol < 0 || endCol >= DEFAULT_SIZE || endRow < 0|| endRow >= DEFAULT_SIZE){
               System.out.println("Illegal Move!");
           
            return false;
           }
        return true;
    }


    public boolean checkStartIsBlack(int startCol, int startRow){
        if(board[startCol][startRow] != BLACK_MAN){
            System.out.println("Illegal Move!");
            return false;
        }
    return true;
    }
    
    public boolean checkStartIsWhite(int startCol, int startRow){
        if(board[startCol][startRow] != WHITE_MAN)
            return false;
    return true;
    }

    public boolean checkEndIsFree(int endCol, int endRow){
        if(board[endCol][endRow]== FREE){
            return true;
        }
        System.out.println("Illegal Move!");
        return false;
    }

    public boolean makeMove(char startCol, int startRow, char endCol, int endRow, char piece){
        if(isMoveLegal(startCol, startRow,endCol,endRow)){
            board[endCol][endRow] = piece;
            return true;
        }
        return false;
    }

    public int getDefaultSize(){
        return DEFAULT_SIZE;
    }
}