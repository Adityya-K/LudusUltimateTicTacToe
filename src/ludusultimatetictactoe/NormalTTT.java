/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludusultimatetictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author oweny
 */
public class NormalTTT {
    private int turnNumber = 0;
    private String[] playerArray = {"X", "O"};
    private JButton[] btnArray = new JButton[81];
    
    public void actionPerformed(ActionEvent ae) {
        // (this is a linear search) Iterates through the array of buttons
        for (int i = 0; i < btnArray.length; i++) {
            // Runs if the button was clicked
            if (ae.getActionCommand().equals("" + i)) {
                System.out.println(i + 1);

                // Gets the button's text
                String currentText = btnArray[i].getText();

                // Prevents the user from clicking the same button twice
                if ("XO".contains(currentText)) {
                    break;
                }

                // Sets the button text to the correct player using the parity of the turn number
                btnArray[i].setText("" + playerArray[turnNumber%2]);

                // Increments the turn number
                turnNumber++;

                // Stores the game result
                String gameResult = getGameResult(getAllLines());

                // Checks if the game has been decided
                if (gameResult.equals("undecided") == false) {

                    // TODO output game result on gui instead of console
                    // Prints out the game result
                    System.out.println(gameResult);

                    // TODO reset the board by clicking button instead of automatically
                    // Resets the board
                    resetBoard();

                    // Resets the turn number
                    turnNumber = 0;

                }

                // Stops the search for a button click
                break;
            }
        }
    }
    
    // Resets the board
    public void resetBoard() {
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setText("" + (i+1));
        }
    }

    // Returns a string with the winner, if there is a draw or if the game is undecided
    public String getGameResult(String[] lines) {
        
        // Initializes the game result string
        String gameResult = "undecided";
        
        // Initializes a boolean indicating if it's a draw
        Boolean draw = true;
        
        // Iterates through every line in the array passed into this method
        for (String line : lines) {
            
            // Runs if X won
            if (line.equals("XXX")) {
                
                // Resets the board
                resetBoard();
                
                // Sets the result string
                gameResult = "X won!";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
            
            // Runs if O won
            } else if (line.equals("OOO")) {
                
                // Resets the board
                resetBoard();
                
                // Sets the result string
                gameResult = "O won!";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
                
            }
        }
        
        if (draw == true && turnNumber == 9) {
            gameResult = "It's a draw!";
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
    
    public int getTurnNumber() {
        return turnNumber;
    }

    public String[] getPlayerArray() {
        return playerArray;
    }

    public JButton[] getBtnArray() {
        return btnArray;
    }
    
    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public void setPlayerArray(String[] playerArray) {
        this.playerArray = playerArray;
    }

    public void setBtnArray(JButton[] btnArray) {
        this.btnArray = btnArray;
    }
}
