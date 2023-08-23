/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to create an ultimate Tic-Tac-Toe class
 * 
 */

package ultimate_tic_tac_toe;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

public class UltTTT {
    // initialize variables
    private NormalTTT[] gameBoard = new NormalTTT[9]; // init board made up of 9 normal boards
    private String currentPlayer = "X"; // who's turn it is
    private int totalTurnNumber = 0; // how many total turns have occured
    private int currentSectionIndex = -1; // section where current player must go
    
    private String playerPiece; // local player's piece
    private String ai; // AI difficulties: None, Easy, Medium
        
    // constructor
    public UltTTT(JButton[][] btnArray, String playerPiece, String ai) 
    {
        // create game board made up of 9 normal ttt boards
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = new NormalTTT(btnArray[i]);
        }
        
        // set local user's piece and ai difficulty
        this.playerPiece = playerPiece;
        this.ai = ai;
    }
    
    /*
     * This method checks the valid subBoard(s) and collects all the blank spaces
     * where the current player could go and chooses one at random
     */
    public int[] moveValidRandom()
    {
        Random rand = new Random(); // create new random object
         
        NormalTTT subBoard; // sub board where random index is being chosen
        int boardIndex; // sub board's index
        
        // if it's first turn or if target section is completed, could be any valid subBoard
        if (currentSectionIndex == -1 || !gameBoard[currentSectionIndex].getGameResult().equals("undecided"))
        {
            ArrayList<NormalTTT> availableBoards = new ArrayList<>(); // arraylist of available boards
            for (int i = 0; i < gameBoard.length; i++) // loop through all subBoards
            {
                if (gameBoard[i].getGameResult().equals("undecided")) // if it's valid
                {
                    availableBoards.add(gameBoard[i]); // add to availableBoards
                }
            }
            
            boardIndex = rand.nextInt(availableBoards.size()); // choose random index for subBoard
            subBoard = availableBoards.get(boardIndex); // get random subBoard
        }
        else // must go in one section
        {
            boardIndex = currentSectionIndex; // boardIndex is in currentSection
            subBoard = gameBoard[boardIndex]; // get subBoard at index
        }
        
        // find all valid places to go in subBoard
        ArrayList<Integer> blankIndexes = new ArrayList<>();

        for (int i = 0; i < 9; i++) // loop through all indexes in subBoard
        {
            if (subBoard.getIndex(i) == null) // if index in subBoard is valid move
            {
                blankIndexes.add(i); // add to valid index
            }
        }
        
        //get a valid index from subBoard
        int subIndex = blankIndexes.get(rand.nextInt(blankIndexes.size()));
        return new int[]{boardIndex, subIndex}; // return the board index and the valid sub index in the baord
    }
    
    /*
     * This method searches all the indexes in the gameBoard where the player could
     * go and sees if there's a way for the player to win that subBoard.
     */
    public int[] findWinningIndex()
    {        
        // if can go anywhere because it's first move or current section is already completed
        if (currentSectionIndex == -1 || !gameBoard[currentSectionIndex].getGameResult().equals("undecided"))
        {
            for (int i = 0; i < 9; i++) // loop through all the game boards
            {
                int winIndex = gameBoard[i].findWin(currentPlayer); // check if subBoard is one winnable
                
                // if instantly winnable, then return the location
                if (gameBoard[i].getGameResult().equals("undecided") && winIndex != -1)
                {
                    return new int[]{i, winIndex}; // subBoard index and win index in subBoard
                }
            }
        }
        else // only one section to move in
        {
            int winIndex = gameBoard[currentSectionIndex].findWin(currentPlayer); // check if you can win 
            
            // if you can win
            if (winIndex != -1)
            {
                return new int[]{currentSectionIndex, winIndex};
            }
        }
        
        return new int[]{-1, -1}; // can't win in one move, return {-1, -1}
    }
    
    /*
     * This method makes a move according to the ai difficulty
     */
    public void moveAI()
    {
        int[] boardAndIndex = {-1, -1}; // move to go
        
        if (ai.equals("Medium")) // if medium ai
        {
            boardAndIndex = findWinningIndex(); // see if there's winning index
        }
        
        // if there's no winning index or difficulty is easy
        if (ai.equals("Easy") || boardAndIndex[0] == -1) {
            boardAndIndex = moveValidRandom(); // go random move
        }
        
        NormalTTT subBoard = gameBoard[boardAndIndex[0]]; // get sub board of move
        int index = boardAndIndex[1]; // get index of sub board

        subBoard.setMove(index, currentPlayer); // play move
        currentSectionIndex = index; // update current section index
        
        // new subBoard is valid place to go, highlight to inform user
        if (gameBoard[currentSectionIndex].getGameResult().equals("undecided")) {
            gameBoard[currentSectionIndex].highlightButtons();
        }
        
        currentPlayer = currentPlayer.equals("X") ? "O" : "X"; //update turn
    }
    
    /*
     * This method takes in the subBoard number and the index inside the board
     * where the player wants to go, and attempts to play a move there.
     */
    
    public String movePlayer (int boardNumber, int boardIndex) {      
        // make sure it's the player's turn
        if (!currentPlayer.equals(playerPiece) && !ai.equals("None"))
        {
            return "NotYourTurn"; // not player's turn
        }
        
        //if can go anywhere (first move)
        if (currentSectionIndex == -1) {
            gameBoard[boardNumber].setMove(boardIndex, currentPlayer); // set move on subBoard
            
            currentPlayer = "O"; // update turn
            currentSectionIndex = boardIndex; // new section
            
            // if no ai then you can highlight where to go next (for other player)
            if (ai.equals("None")) {
                gameBoard[currentSectionIndex].highlightButtons();
            }
            
            return "MoveMade"; // return success
        }
        
        // if the move is valid
        if (((currentSectionIndex == boardNumber) || !gameBoard[currentSectionIndex].getGameResult().equals("undecided")) && 
                (gameBoard[boardNumber].setMove(boardIndex, currentPlayer))) {
            
            currentPlayer = currentPlayer.equals("X") ? "O" : "X"; // update turn
            
            // if current section is still valid then unhighlight it
            if (gameBoard[currentSectionIndex].getGameResult().equals("undecided")) {
                gameBoard[currentSectionIndex].unHighlightButtons();
            }
            
            currentSectionIndex = boardIndex; // move pointer to next section
            
            // if next section is valid then highlight it to show user
            if (gameBoard[currentSectionIndex].getGameResult().equals("undecided") && ai.equals("None")) {
                gameBoard[currentSectionIndex].highlightButtons();
            }
            
            
            // check if anyone has won on the main board
            if (!getGameResult().equals("undecided")) {
                return getGameResult(); // if someone won
            }
            
            return "MoveMade"; // valid move
        } 
        
        return "Invalid"; // target move isn't valid
    }
    
    // Returns a string with the winner, if there is a draw or if the game is undecided
    public String getGameResult() {
        String[] lines = getAllLines(); // get all 3 lines
        String gameResult = "undecided"; // current game result
        
        Boolean draw = true; // is it a draw
        
        for (String line : lines) {
            // Runs if X won
            if (line.equals("XXX")) {                
                gameResult = "X"; // winner
                draw = false; // not draw
                break;
            
            // Runs if O won
            } else if (line.equals("OOO")) {                
                gameResult = "O"; // winner
                draw = false; // not draw 
                break;
            }
        }
        
        // loop through game board and check if there's a valid place to go which would make it not draw
        for( int i = 0; i < gameBoard.length; i++ ) {
            if (gameBoard[i].getGameResult().equals("undecided")) { // found valid place to go
                draw = false; // not draw
                break; // early break
            }
        }
        
        if (draw) { // if it's a draw, return it
            return "draw";
        }
        
        return gameResult; // return X, O or undecided
    }
    
    /*
     * This method calculates all places where a three in a row could happen
     * on the game board and returns the String at that index (X, O or null)
     */
    private String[] getAllLines() {
        // Initializes the array of lines (3 vertical, 3 horizontal, 2 diagonal)
        String[] lines = new String[8];

        // Setting the horizontal lines
        lines[0] = gameBoard[0].getGameResult() + gameBoard[1].getGameResult() + gameBoard[2].getGameResult();
        lines[1] = gameBoard[3].getGameResult() + gameBoard[4].getGameResult() + gameBoard[5].getGameResult();
        lines[2] = gameBoard[6].getGameResult() + gameBoard[7].getGameResult() + gameBoard[8].getGameResult();

        // Setting the vertical lines
        lines[3] = gameBoard[0].getGameResult() + gameBoard[3].getGameResult() + gameBoard[6].getGameResult();
        lines[4] = gameBoard[1].getGameResult() + gameBoard[4].getGameResult() + gameBoard[7].getGameResult();
        lines[5] = gameBoard[2].getGameResult() + gameBoard[5].getGameResult() + gameBoard[8].getGameResult();

        // Setting the diagonal lines
        lines[6] = gameBoard[0].getGameResult() + gameBoard[4].getGameResult() + gameBoard[8].getGameResult();
        lines[7] = gameBoard[2].getGameResult() + gameBoard[4].getGameResult() + gameBoard[6].getGameResult();

        // Returns the lines
        return lines;
    }
    
    // Resets the board
    public void resetBoard() {
        // Iterates through every index in the array and resets the text and enables the buttons
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i].resetBoard();
            gameBoard[i].enableButtons();
        }
    }
    
    // getter for ai type
    public String getAi() {
        return ai;
    }

    // getter for player piece
    public String getPlayerPiece() {
        return playerPiece;
    }
    
    // getter for current player
    public String getCurrentPlayer() {
        return currentPlayer;
    }
    
    // setter for current player
    public void setCurrentPlayer(String a) {
        this.currentPlayer = a;
    }
    
    // getter for game board
    public NormalTTT[] getGameBoard() {
        return gameBoard;
    }
    
    //getter for current section 
    public int getCurrentSectionIndex() {
        return currentSectionIndex;
    } 
    
    // setter for current section
    public void setCurrentSectionIndex (int a) {
        this.currentSectionIndex = a;
    }
}