package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */

        int count = 0;
        int countTwo = 0;

        System.out.print("   ");
 
        for(int i = 0; i < model.getWidth(); i++)
        {
           System.out.print(count + " ");                     //prints the row of digits
           count++;
        }

        System.out.print("\n");
 
        for(int j = 0; j < model.getWidth(); j++)
        {
           System.out.print(countTwo + " ");             //prints the column of digits & row of "-"s
 
              for(int k = 0; k < model.getWidth(); k++)
                 if (model.getMark(j, k) == TicTacToeModel.Mark.EMPTY)
                    System.out.print(" -");
                 else if (model.getMark(j, k) == TicTacToeModel.Mark.X)
                    System.out.print(" X");
                 else if (model.getMark(j, k) == TicTacToeModel.Mark.O)
                    System.out.print(" O"); 
            
           countTwo++;

           System.out.print("\n");
        }

         /*Board looks like this:
                  0 1 2
                0 X - O
                1 O X O
                2 - X X          */

         /* Known bugs/issues to be fixed:
            1) TicTacToeController is not properly showing the error message when non-integer input is entered (The program is giving an inputMisMatchException)
            2) If "0 2" is entered, the game is instantly won for that player...
          */
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        if(model.isXTurn() == true)                                   
        {
           System.out.println("Player 1 (X) Move:");
        }
        else
        {
           System.out.println("Player 2 (O) Move:");
        }

        System.out.print("Enter the Row and Column Numbers, separated by a space: ");
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("Error. Invalid Input.");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}