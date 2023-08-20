/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludusultimatetictactoe;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author oweny
 */
public class NormalTTT {

    private JButton[] btnArray = new JButton[9];
    private int turnNumber = 0;
    
    public NormalTTT() {}
    
    public NormalTTT(JButton[] btnArray)
    {
        this.btnArray = btnArray;
    }
    
    public void resetBoard() {
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setBackground(UltimateTicTacToeFrame.BACKGROUND_COLOR);
            btnArray[i].setText("" + (i+1));
        }
    }
    
    public void highlight(String piece)
    {        
        if (piece.equals("X"))
        {
            for (int i = 0; i < 9; i += 2)
            {
                btnArray[i].setBackground(Color.black);
            }
        }
        else if (piece.equals("O"))
        {
            for (int i = 0; i < 9; i++)
            {
                if (i != 4)
                {
                    btnArray[i].setBackground(Color.black);
                }
            }
        }
    }

    // Returns a string with the winner, if there is a draw or if the game is undecided
    public String getGameResult() {
        String[] lines = getAllLines();
        // Initializes the game result string
        String gameResult = "undecided";
        
        // Initializes a boolean indicating if it's a draw
        Boolean draw = true;
        
        // Iterates through every line in the array passed into this method
        for (String line : lines) {
            
            // Runs if X won
            if (line.equals("XXX")) {                
                // Sets the result string
                gameResult = "X";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
            
            // Runs if O won
            } else if (line.equals("OOO")) {                
                // Sets the result string
                gameResult = "O";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
                
            }
        }
        
        if (draw == true && turnNumber == 9) {
            gameResult = "draw";
        }
        
        return gameResult;
    }
            
    public String[] getAllLines() {
        // Initializes the array of lines (3 vertical, 3 horizontal, 2 diagonal)
        String[] lines = new String[8];

        // Initializes the array of squares (9 squares on the board)
        String[] squares = new String[9];

        // Iterates through all of the squares on the board, putting them into the array
        for (int i = 0; i < btnArray.length; i++) {
            squares[i] = btnArray[i].getText();
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
    
    public JButton[] getBtnArray() {
        return btnArray;
    }
    
    public int getTurnNumber() {
        return turnNumber;
    }
        
    public void setBtnArray(JButton[] btnArray) {
        this.btnArray = btnArray;
    }
    
    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
}
