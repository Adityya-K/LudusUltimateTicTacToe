/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludusultimatetictactoe;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author oweny
 */
public class UltTTT {
    private NormalTTT[] gameBoard = new NormalTTT[9];
    private String[] playerArray = {"X", "O"};
    private int totalTurnNumber = 0;
    private NormalTTT currentSection;
    
    final private NormalTTT goAnywhere = new NormalTTT();
    
    public UltTTT(JButton[] btnArray) 
    {
        // setup array of normal ttt
        int[] groupStarts = {0, 3, 6, 27, 30, 33, 54, 57, 60};
        for (int i = 0; i < 9; i++)
        {
            int start = groupStarts[i];
            JButton[] subBtnArray = new JButton[9];
            int arraySize = 0;
            
            for (int rowOffset = 0; rowOffset <= 18; rowOffset += 9)
            {
                for (int columnOffset = 0; columnOffset < 3; columnOffset++)
                {
                    subBtnArray[arraySize] = btnArray[start + rowOffset + columnOffset];
                    arraySize++;
                }
            }
            
            gameBoard[i] = new NormalTTT(subBtnArray);
        }
        
        currentSection = gameBoard[6]; // start bottom left
    }
    
    public void calcNextSection(int i)
    {
        // target section's game has already ended
        if (!gameBoard[i].getGameResult().equals("undecided"))
        {
            currentSection = goAnywhere; // put a blank ttt board to symbolize you can go anywhere
            return;
        }
        
        currentSection = gameBoard[i];
    }
        
    // this method's contents are basically repeated twice
    // but im too braindead to fix it rn
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

                        btnArray[j].setText("" + playerArray[totalTurnNumber%2]);
                        // update total turn number
                        totalTurnNumber++;

                        //update subsection turn number
                        checkSection.setTurnNumber(checkSection.getTurnNumber() + 1);

                        //TODO: Highlight section to show that the player has won the section

                        calcNextSection(j);

                        madeMove = true;
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

                    btnArray[i].setText("" + playerArray[totalTurnNumber%2]);
                    // update total turn number
                    totalTurnNumber++;

                    //update subsection turn number
                    currentSection.setTurnNumber(currentSection.getTurnNumber() + 1);

                    //TODO: Highlight section to show that the player has won the section

                    calcNextSection(i);
                    
                    break;
                }
            }
        }
        
        String gameResult = getGameResult();
        
        if (!gameResult.equals("undecided"))
        {
            System.out.println(gameResult);
            resetBoard();
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
        
        if (draw == true && totalTurnNumber == 81) {
            gameResult = "-";
        }
        
        return gameResult;
    }
    
    public String[] getAllLines() {
        // Initializes the array of lines (3 vertical, 3 horizontal, 2 diagonal)
        String[] lines = new String[8];

        // Initializes the array of squares (9 squares on the board)
        String[] squares = new String[9];

        // Iterates through all of the squares on the board, putting them into the array
        for (int i = 0; i < gameBoard.length; i++) {
            squares[i] = gameBoard[i].getGameResult();
        }

        // Setting the horizontal lines
        lines[0] = squares[0] + squares[1] + squares[2];
        lines[1] = squares[3] + squares[4] + squares[5];
        lines[2] = squares[6] + squares[7] + squares[8];

        // Setting the vertical lines
        lines[3] = squares[0] + squares[3] + squares[6];
        lines[4] = squares[1] + squares[4] + squares[7];
        lines[5] = squares[2] + squares[5] + squares[8];

        // Setting the diagonal lines
        lines[6] = squares[0] + squares[4] + squares[8];
        lines[7] = squares[2] + squares[4] + squares[6];

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