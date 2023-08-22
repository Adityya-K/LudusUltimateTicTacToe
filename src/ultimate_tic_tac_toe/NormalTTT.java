/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultimate_tic_tac_toe;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author oweny
 */
public class NormalTTT {

    private JButton[] btnArray = new JButton[9];
    private String[] board = new String[9];
    private Color winColor = new Color(51, 136, 0);
    
    
    public NormalTTT(JButton[] btnArray)
    {
        this.btnArray = btnArray;
    }
    
    public boolean setMove(int index, String player) {
        if (board[index] == null && getGameResult().equals("undecided")) {
            board[index] = player;
            btnArray[index].setForeground(player.equals("X") ? Color.black : Color.white);
            btnArray[index].setText(player);
            if (!getGameResult().equals("undecided")) {
                if (getGameResult().equals("X")) {
                    setButtonsX();
                }
                else if (getGameResult().equals("O")) {
                    setButtonsO();
                }
                else {
                    setButtonsDraw();
                }
            }
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
            btnArray[i].setBackground(new Color(128, 176, 247));
        }
    }
    
    public void setButtonsO () {
        btnArray[0].setBackground(winColor);
        btnArray[1].setBackground(winColor);
        btnArray[2].setBackground(winColor);
        btnArray[3].setBackground(winColor);
        btnArray[4].setBackground(new Color(128, 176, 247));
        btnArray[5].setBackground(winColor);
        btnArray[6].setBackground(winColor);
        btnArray[7].setBackground(winColor);
        btnArray[8].setBackground(winColor);
    }
    
    public void setButtonsX () {
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setBackground(new Color(128, 176, 247));
        }
        btnArray[0].setBackground(winColor);
        btnArray[2].setBackground(winColor);
        btnArray[4].setBackground(winColor);
        btnArray[6].setBackground(winColor);
        btnArray[8].setBackground(winColor);
    }
    
    public void setButtonsDraw() {
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setBackground(winColor);
        }
    }
    
    public void highlightButtons() {
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setBackground(new Color(255, 105, 97));
        }
    }
    
    public void unHighlightButtons() {
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setBackground(new Color(128, 176, 247));
        }
    }
    
    public void enableButtons () {
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setEnabled(true);
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
    
    public int findWin(String p) {
        int moveIndex = -1;
        String [] lines = getAllLines();
        int winningLineIndex = -1;
        String winningLine = "";
        String [] indicesInLines = {"012", "345", "678", "036", "147", "258", "048", "246"};
                
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals(p + p + "null") || lines[i].equals(p + "null" + p) || lines[i].equals("null" + p + p)) {
                winningLineIndex = i;
                winningLine = lines[i];
                break;
            }
        }
        
        if (winningLineIndex != -1) {
            if (winningLine.equals(p + p + "null")) {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(2)));
            } else if (winningLine.equals(p + "null" + p)) {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(1)));
            } else {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(0)));
            }
        }
        
        return moveIndex;
    }
    
    public String[] getBoard() {
        return board;
    }
    
    public String getIndex(int i)
    {
        return board[i];
    }

}
