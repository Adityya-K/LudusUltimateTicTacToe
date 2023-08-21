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
    private String[] board = new String[9];
    
    
    public NormalTTT(JButton[] btnArray)
    {
        this.btnArray = btnArray;
    }
    
    public boolean setMove(int index, String player) {
        if (board[index] == null && getGameResult().equals("undecided")) {
            board[index] = player;
            btnArray[index].setText(player);
            return true;
        }
        else {
            return false;
        }
    }
    
    public void resetBoard() {
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            board[i] = null;
            btnArray[i].setText("");
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
        
        for( int i = 0; i < board.length; i++ ) {
            if (board[i] == null) {
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
        
        String[] lines = new String[8];

        // Setting the horizontal lines
        lines[0] = board[0] + board[1] + board[2];
        lines[1] = board[3] + board[4] + board[5];
        lines[2] = board[6] + board[7] + board[8];

        // Setting the vertical lines
        lines[3] = board[0] + board[3] + board[6];
        lines[4] = board[1] + board[4] + board[7];
        lines[5] = board[2] + board[5] + board[8];

        // Setting the diagonal lines
        lines[6] = board[0] + board[4] + board[8];
        lines[7] = board[2] + board[4] + board[6];

        // Returns the lines
        return lines;

    }
}
