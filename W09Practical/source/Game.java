import java.util.Scanner;

public class Game {

    // The following five constants were defined in the starter code (kt54)
    private static String WHITEPLAYS_MSG    = "White plays. Enter move:";
    private static String BLACKPLAYS_MSG    = "Black plays. Enter move:";
    private static String ILLEGALMOVE_MSG   = "Illegal move!";
    private static String WHITEWINS_MSG     = "White wins!";
    private static String BLACKWINS_MSG     = "Black wins!";

    private Board gameBoard;
    private int boardSize;

    // Minimal constructor. Expand as needed (kt54)
    public Game() {
        gameBoard = new Board();
    }

    // Build on this method to implement game logic.
    public void play() {

        Scanner reader = new Scanner(System.in);

        gameBoard = new Board();

        boolean gameOver = false;
        boolean isBlackTurn = true;
        String command = "";

        //to decide which column I will take the char from the user input (max of 26 columns)
        //code taken from https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet

        char[] whichCol= "abcdefghijklmnopqrstuvwxyz".toCharArray();


        //the char will be converted into an index for the column part of the array

        int [] colIndex = new int[whichCol.length];
        for(int i=0;i<colIndex.length;i++){
            colIndex[i] = i;
        }
        
        do{
            gameBoard.printBoard();
            boardSize = gameBoard.getDefaultSize();
            
            System.out.println("Enter command move or quit");
            command = reader.nextLine();

            if(command.equals("move")) {
                if(gameOver)
                    System.out.println("Game over - cannot move!");
                else if(isBlackTurn){
            
                System.out.println(BLACKPLAYS_MSG);
                    //finds where the piece is
                    String pos1 = reader.nextLine().trim();
                    //-97 used to convert from ascii value to equivalent on board
                    char startColAsChar = pos1.charAt(0);
                    int startCol = (int) startColAsChar - 97;
                    
                    
                    char startRowAsChar = pos1.charAt(1);
                    int startRow  = Character.getNumericValue(startRowAsChar)-1;                   
                   
                    if(startCol < boardSize && startRow < boardSize){
                        gameBoard.checkStartIsBlack(startCol, startRow);
                    }
                    else{
                        System.out.println("Illegal Move!");
                        play();
                    
                    }

                    String pos2 = reader.nextLine().trim();

                    char endColAsChar = pos2.charAt(0);
                    int endCol = (int) endColAsChar - 97;
                    
                    char endRowAsChar = pos2.charAt(1);
                    int endRow  = Character.getNumericValue(endRowAsChar)-1; 


                    gameBoard.isMoveLegal(startCol, startRow, endCol, endRow);

                    if(endCol < boardSize && endRow < boardSize){
                        gameBoard.checkEndIsFree(endCol, endRow);
                    }
                    else{
                        System.out.println("Illegal Move!");
                        play();
                    
                    }

            
                        
                }
               
            else {
                System.out.println(WHITEPLAYS_MSG);
                

                String pos1 = reader.nextLine().trim();
                String pos2 = reader.nextLine().trim();
                
            }
           
            // This is just demonstration code, so we immediately let white win
            // to avoid unnecessary violence.
            System.out.println(BLACKWINS_MSG);

            //done = true;

            isBlackTurn = !isBlackTurn;
            
            }
        }while(!(command.equals("quit")));
    }

    
    

      
}