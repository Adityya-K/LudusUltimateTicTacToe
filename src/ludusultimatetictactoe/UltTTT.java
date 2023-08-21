/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludusultimatetictactoe;
import javax.swing.JButton;

/**
 *
 * @author oweny
 */
public class UltTTT {
    private NormalTTT[] gameBoard = new NormalTTT[9];
<<<<<<< HEAD
    private String currentPlayer = "X";
=======
    private final String[] PLAYER_ARRAY = {"X", "O"};
>>>>>>> main
    private int totalTurnNumber = 0;
    private int currentSectionIndex = -1;
        
    public UltTTT(JButton[][] btnArray) 
    {
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = new NormalTTT(btnArray[i]);
        }
        
<<<<<<< HEAD
=======
        currentSection = goAnywhere; // start anywhere
>>>>>>> main
    }
    
    public String movePlayer (int boardNumber, int boardIndex) {
        if (currentSectionIndex == -1) {
            gameBoard[boardNumber].setMove(boardIndex, currentPlayer);
            currentPlayer = "O";
            currentSectionIndex = boardIndex;
            return "MoveMade";
        }
        
<<<<<<< HEAD
        if (((currentSectionIndex == boardNumber) || !gameBoard[currentSectionIndex].getGameResult().equals("undecided")) && 
                (gameBoard[boardNumber].setMove(boardIndex, currentPlayer))) {
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            currentSectionIndex = boardIndex;
            System.out.println(currentSectionIndex);
            if (!getGameResult().equals("undecided")) {
                return getGameResult() + "Won";
            }
            return "MoveMade";
        } 
        else {
            return "Invalid";
=======
        currentSection = gameBoard[i];
    }
        
    public void playerTurn(JButton[] btnArray, int index)
    {
        btnArray[index].setText("" + PLAYER_ARRAY[totalTurnNumber%2]);
        // update total turn number
        totalTurnNumber++;

        //update subsection turn number
        currentSection.setTurnNumber(currentSection.getTurnNumber() + 1);

        //TODO: Highlight section to show that the player has won the section
        String winner = currentSection.getGameResult();
        currentSection.highlight(winner);

        calcNextSection(index);
    }
    
    // this method's contents are basically repeated twice
    public void actionPerformed(ActionEvent ae) {
        if (currentSection == goAnywhere)
        {
            Boolean madeMove = false;
            
            for (int i = 0; i < 9; i++)
            {
                NormalTTT checkSection = gameBoard[i];
                if (!checkSection.getGameResult().equals("undecided"))
                {
                    continue;
                }
                
                JButton[] btnArray = checkSection.getBtnArray();
                // only look at the buttons in the current array

                for (int j = 0; j < btnArray.length; j++) {
                    // Runs if the button was clicked
                    String currentText = btnArray[j].getText();
                    if (ae.getActionCommand().equals(currentText)) {
                        // Prevents the user from clicking the same button twice
                        if ("XO".contains(currentText)) {
                            break;
                        }

                        playerTurn(btnArray, j);
                        break;
                    }
                }
                
                if (madeMove)
                {
                    break;
                }
            }
        }
        else
        {
            JButton[] btnArray = currentSection.getBtnArray();
            // only look at the buttons in the current array

            for (int i = 0; i < btnArray.length; i++) {
                // Runs if the button was clicked
                String currentText = btnArray[i].getText();
                if (ae.getActionCommand().equals(currentText)) {

                    // Prevents the user from clicking the same button twice
                    if ("XO".contains(currentText)) {
                        break;
                    }

                    playerTurn(btnArray, i);
                    break;
                }
            }
        }
        
        String gameResult = getGameResult();
        
        if (!gameResult.equals("undecided"))
        {
            System.out.println(gameResult);
            //resetBoard(); // temp not reset board
>>>>>>> main
        }
    }
    
    // Returns a string with the winner, if there is a draw or if the game is undecided
    private String getGameResult() {
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
        }
    }
}