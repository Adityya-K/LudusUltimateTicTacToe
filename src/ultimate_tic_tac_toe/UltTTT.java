/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultimate_tic_tac_toe;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author oweny
 */
public class UltTTT {
    private NormalTTT[] gameBoard = new NormalTTT[9];
    private String currentPlayer = "X";
    private int totalTurnNumber = 0;
    private int currentSectionIndex = -1;
    
    private String playerPiece;
    private String ai; // None, Easy, Medium
        
    public UltTTT(JButton[][] btnArray, String playerPiece, String ai) 
    {
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = new NormalTTT(btnArray[i]);
        }
        
        this.playerPiece = playerPiece;
        this.ai = ai;
    }
    
    public int[] moveValidRandom()
    {
        Random rand = new Random();
         
        NormalTTT subBoard;
        int boardIndex;
        
        if (currentSectionIndex == -1 || !gameBoard[currentSectionIndex].getGameResult().equals("undecided"))
        {
            ArrayList<NormalTTT> availableBoards = new ArrayList<>();
            for (int i = 0; i < 9; i++)
            {
                if (gameBoard[i].getGameResult().equals("undecided"))
                {
                    availableBoards.add(gameBoard[i]);
                }
            }
            
            boardIndex = rand.nextInt(availableBoards.size());
            subBoard = availableBoards.get(boardIndex);
        }
        else
        {
            boardIndex = currentSectionIndex;
            subBoard = gameBoard[boardIndex];
        }
        
        ArrayList<Integer> blankIndexes = new ArrayList<>();

        for (int i = 0; i < 9; i++)
        {
            if (subBoard.getBoard()[i] == null)
            {
                blankIndexes.add(i);
            }
        }
        
        int subIndex = blankIndexes.get(rand.nextInt(blankIndexes.size()));
        
        return new int[]{boardIndex, subIndex};
    }
    
        public int[] findWinningIndex()
    {
        int[] boardAndIndex = {-1, -1};
        
        if (currentSectionIndex == -1 || !gameBoard[currentSectionIndex].getGameResult().equals("undecided"))
        {
            for (int i = 0; i < 9; i++)
            {
                int winIndex = gameBoard[i].findWin(currentPlayer);
                
                if (gameBoard[i].getGameResult().equals("undecided") && winIndex != -1)
                {
                    return new int[]{i, winIndex};
                }
            }
        }
        else
        {
            int winIndex = gameBoard[currentSectionIndex].findWin(currentPlayer);
            
            if (winIndex != -1)
            {
                return new int[]{currentSectionIndex, winIndex};
            }
        }
        
        return boardAndIndex;
    }
        
    public void moveAI()
    {
        int[] boardAndIndex = {-1, -1};
        
        if (ai.equals("Medium"))
        {
            boardAndIndex = findWinningIndex();
            System.out.println("Winning board " + boardAndIndex[0]);
        }
        
        if (ai.equals("Easy") || boardAndIndex[0] == -1) {
            boardAndIndex = moveValidRandom();
        }
        
        NormalTTT subBoard = gameBoard[boardAndIndex[0]];
        int index = boardAndIndex[1];

        subBoard.setMove(index, currentPlayer);
        currentSectionIndex = index;
        gameBoard[currentSectionIndex].highlightButtons();
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }
    
    public String movePlayer (int boardNumber, int boardIndex) {        
        if (!currentPlayer.equals(playerPiece) && !ai.equals("None"))
        {
            return "NotYourTurn";
        }
        
        if (currentSectionIndex == -1) {
            gameBoard[boardNumber].setMove(boardIndex, currentPlayer);
            currentPlayer = "O";
            currentSectionIndex = boardIndex;
            if (ai.equals("None")) {
                gameBoard[currentSectionIndex].highlightButtons();
            }
            return "MoveMade";
        }
        
        if (((currentSectionIndex == boardNumber) || !gameBoard[currentSectionIndex].getGameResult().equals("undecided")) && 
                (gameBoard[boardNumber].setMove(boardIndex, currentPlayer))) {
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            if (gameBoard[currentSectionIndex].getGameResult().equals("undecided")) {
                gameBoard[currentSectionIndex].unHighlightButtons();
            }
            currentSectionIndex = boardIndex;
            
            if (gameBoard[currentSectionIndex].getGameResult().equals("undecided") && ai.equals("None")) {
                gameBoard[currentSectionIndex].highlightButtons();
            }
            System.out.println(currentSectionIndex);
            if (!getGameResult().equals("undecided")) {
                return getGameResult();
            }
            return "MoveMade";
        } 
        else {
            return "Invalid";
        }
    }
    
    // Returns a string with the winner, if there is a draw or if the game is undecided
    public String getGameResult() {
        String[] lines = getAllLines();
        String gameResult = "undecided";
        
        Boolean draw = true;
        
        for (String line : lines) {
            // Runs if X won
            if (line.equals("XXX")) {                
                gameResult = "X";
                draw = false;
                break;
            
            // Runs if O won
            } else if (line.equals("OOO")) {                
                gameResult = "O";
                draw = false;
                break;
            }
        }
        
        for( int i = 0; i < gameBoard.length; i++ ) {
            if (gameBoard[i].getGameResult().equals("undecided")) {
                draw = false;
                break;
            }
        }
        
        if (draw) {
            return "draw";
        }
        
        return gameResult;
    }
    
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
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i].resetBoard();
            gameBoard[i].enableButtons();
        }
    }
    
    public String getAi() {
        return ai;
    }

    public String getPlayerPiece() {
        return playerPiece;
    }
    
    public String getCurrentPlayer() {
        return currentPlayer;
    }
    
    public void setCurrentPlayer(String a) {
        this.currentPlayer = a;
    }
    
    public NormalTTT[] getGameBoard() {
        return gameBoard;
    }
    
    public int getCurrentSectionIndex() {
        return currentSectionIndex;
    } 
    
    public void setCurrentSectionIndex (int a) {
        this.currentSectionIndex = a;
    }
            
}