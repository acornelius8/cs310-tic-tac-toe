package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        for(int i = 0; i < width; i++)                                          //Initialize Rows
        {
           for(int j = 0; j < width; j++)                                       //Initialize Columns
           {
               grid[i][j] = Mark.EMPTY;
           }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */

        int r = row;
        int c = col;   

        if (isValidSquare(r, c) && getMark(r, c) == Mark.EMPTY)          
        {
           if (isXTurn() == true)
           {
              grid[r][c] = Mark.X;
              xTurn = false;
              return true;
           }
           else
           {
              grid[r][c] = Mark.O;
              xTurn = true;
              return true;
           }
        }
        else
           return false;
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        int r = row;
        int c = col;

        if (r > getWidth() || c > getWidth())
        {
           return false;
        }
        else if (r < 0 || c < 0)                      
        {
           return false;
        }
        else
           return true;
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        int r = row;
        int c = col;      

        if (getMark(r, c) == Mark.X || getMark(r, c) == Mark.O )
           return true;
        else
           return false; 
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        int r = row;
        int c = col;

        if (isValidSquare(r, c))
	{
           Mark square = grid[r][c];
           return square;
        }
        else
           return null;                                        
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */      

        if (isMarkWin(Mark.X))                                   
           return Result.X;
        else if (isMarkWin(Mark.O))
           return Result.O;
        else if (isTie())
           return Result.TIE;
        else
           return Result.NONE;

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */

        Mark m = mark;

        boolean winner = true;
        
        for (int c = 0; c < width; c++)                                                                                                
        {
           winner = true;

           for (int r = 0; r < width; r++)
           {
              if (grid[r][c] != m)                              
                 winner = false;
           }
           if (winner)
              return true;
        }

        for (int r = 0; r < width; r++)                                                              
        {
           winner = true;

           for (int c = 0; c < width; c++)
           {
              if (grid[r][c] != m)
                 winner = false;
           }

           if (winner)
              return true;
        }
   
        winner = true;

        for (int i = 0; i < width; i++)                      
        {
           if (grid[i][i] != m)
              winner = false;
        }
        if (winner)
           return true;

        winner = true;

        for (int i = 0; i < width; i++)                              
        {
           if (grid[i][width-i-1] != m)
              winner = false;
           //if (winner)
             // return true;
        } 

        if (winner)
           return true;

        return false; 

        //Is grid[r][c] == mark?
        //If not, winner = false
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        for (int i = 0; i < getWidth(); i++)
        {
           for (int j = 0; j < getWidth(); j++)
           {
              if (grid[i][j] == Mark.EMPTY)
                 return false;
           }
        }

        if (isMarkWin(Mark.X))
	   return false;
        else if (isMarkWin(Mark.O))
           return false;
        else 
           return true;
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();                          
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}