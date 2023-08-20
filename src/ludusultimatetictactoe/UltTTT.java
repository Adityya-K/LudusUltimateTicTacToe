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
    private int turnNumber = 0;
    private NormalTTT currentSection = gameBoard[6]; // bottom left
    
    public UltTTT(JButton[] btnArray) 
    {
        // setup array of normal ttt
        int[] groupStarts = {1, 4, 7, 28, 31, 34, 55, 58, 61};
        for (int i = 0; i < 9; i++)
        {
            int start = groupStarts[i];
            JButton[] subBtnArray = new JButton[9];
            
            for (int rowOffset = 0; rowOffset <= 18; rowOffset += 9)
            {
                for (int columnOffset = 0; columnOffset < 3; columnOffset++)
                {
                    subBtnArray[subBtnArray.length] = btnArray[start + rowOffset + columnOffset];
                }
            }
            
            gameBoard[gameBoard.length] = new NormalTTT(subBtnArray);
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        JButton[] btnArray = currentSection.getBtnArray();
        // (this is a linear search) Iterates through the array of buttons
        for (int i = 0; i < btnArray.length; i++) {
            // Runs if the button was clicked
            if (ae.getActionCommand().equals("" + i)) {

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
                String gameResult = currentSection.getGameResult(turnNumber);

                // Checks if the game has been decided
                if (gameResult.equals("undecided") == false) {

                    // TODO output game result on gui instead of console
                    // Prints out the game result
                    System.out.println(gameResult);

                    // TODO reset the board by clicking button instead of automatically
                    // Resets the board
                    currentSection.resetBoard();

                    // Resets the turn number
                    turnNumber = 0;

                }

                // Stops the search for a button click
                break;
            }
        }
    }
}