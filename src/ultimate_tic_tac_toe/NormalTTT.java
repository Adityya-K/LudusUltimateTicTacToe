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

    private JButton[] btnArray = new JButton[9]; // all the buttons in the board
    private String[] board = new String[9]; // current board state
    
    // set color consts
    private final Color WIN_COLOR = new Color(51, 136, 0);
    private final Color DEFAULT_COLOR = new Color(128, 176, 247);
    private final Color HIGHLIGHT_COLOR = new Color(255, 105, 97);
    
    // constructor, sets button array
    public NormalTTT(JButton[] btnArray)
    {
        this.btnArray = btnArray;
    }
    
    /*
     * Takes in a index and the letter of the current player making the move.
     * Then, it makes sure the index is valid and places the piece, afterwards
     * checking if the game has ended and returning if the move was valid.
     */
    public boolean setMove(int index, String player) {
        // making sure space is empty and board isn't completed
        if (board[index] == null && getGameResult().equals("undecided")) {
            board[index] = player;// set move in board
            
            // update the ui to show move
            btnArray[index].setForeground(player.equals("X") ? Color.black : Color.white);
            btnArray[index].setText(player);
            
            if (!getGameResult().equals("undecided")) { // if game has completed
                if (getGameResult().equals("X")) {
                    setButtonsX(); // show that x won
                }
                else if (getGameResult().equals("O")) {
                    setButtonsO(); // show that o won
                }
                else {
                    setButtonsDraw(); // show that it's a draw
                }
            }
            return true; // valid move
        }
        else {
            return false; // invalid move
        }
    }
    
    // reset the board by setting all indexes to null and resetting the ui to default
    public void resetBoard() {
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            board[i] = null; // reset index
            
            // reset the ui to original state
            btnArray[i].setText("");
            btnArray[i].setBackground(DEFAULT_COLOR);
        }
    }
    
    // set all buttons in board to display a big o
    public void setButtonsO () {
        for (int i = 0; i < btnArray.length; i++) // loop through all buttons
        {
            if (i != 4) // if not center button
            {
                btnArray[i].setBackground(WIN_COLOR); // set win color
            }
        }
    }
    
    // set all buttons in board to display a big o
    public void setButtonsX () {
        // loop through every other button to make an x
        for (int i = 0; i < btnArray.length; i+=2)
        {
            btnArray[i].setBackground(WIN_COLOR); // set win color
        }
    }
    
    // set all buttons in board to one color to show a draw
    public void setButtonsDraw() {
        for (int i = 0; i < btnArray.length; i++) { // loop through all buttons
            btnArray[i].setBackground(WIN_COLOR);
        }
    }
    
    // set all buttons to highlight color
    public void highlightButtons() {
        for (int i = 0; i < btnArray.length; i++) { // loop through all buttons
            btnArray[i].setBackground(HIGHLIGHT_COLOR);
        }
    }
    
    // set all buttons to the default color, unhighlighting the highlight
    public void unHighlightButtons() {
        for (int i = 0; i < btnArray.length; i++) { // loop through all buttons
            btnArray[i].setBackground(DEFAULT_COLOR);
        }
    }
    
    // enable all the buttons on the board
    public void enableButtons () {
        for (int i = 0; i < btnArray.length; i++) { // loop through all buttons
            btnArray[i].setEnabled(true); // enable button at index
        }
    }

    // Returns a string with the winner, if there is a draw or if the game is undecided.
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
        
        // loop through and find any empty spots
        for( int i = 0; i < board.length; i++ ) {
            if (board[i] == null) { // if there's an empty spot, it cannot be a draw
                draw = false;
                break; // early exit since cannot be a draw
            }
        }
        
        if (draw) { // if there's a draw
            return "draw";
        }
        
        return gameResult; // otherwise return X, O or undecided
    }
            
    /*
     * This method calculates all places where a three in a row could happen
     * and returns the String at that index (X, O or null)
     */
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
    
    /*
     * This method checks the board if there is a position where 
     * you could win in one move, and if there is, it returns it
     */
    public int findWin(String p) { // p = piece
        int moveIndex = -1; // the index where winning move is
        int winningLineIndex = -1; // index where winning line is
        
        String winningLine = ""; // winning line in string form
        
        String [] lines = getAllLines(); // all the possible lines of 3
        
        // corresponding global index when indexed with relative winning line index
        String [] indicesInLines = {"012", "345", "678", "036", "147", "258", "048", "246"};
        
        // loop through all lines and find if there's a winning line
        for (int i = 0; i < lines.length; i++) {
            // use given piece and check all three possible win positions
            if (lines[i].equals(p + p + "null") || lines[i].equals(p + "null" + p) || lines[i].equals("null" + p + p)) {
                winningLineIndex = i; // set winning line index
                winningLine = lines[i]; // set winning line
                break;
            }
        }
        
        // if there's a valid winning index
        if (winningLineIndex != -1) {
            if (winningLine.equals(p + p + "null")) { // XX-
                // set corresponding global moveindex
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(2)));
            } else if (winningLine.equals(p + "null" + p)) { // X-X
                // set corresponding global moveindex
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(1)));
            } else { // -XX
                // set corresponding global moveindex
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(0)));
            }
        }
        
        return moveIndex; // return moveIndex
    }
    
    // getter for game board
    public String[] getBoard() {
        return board;
    }
    
    // getter for String at index of board
    public String getIndex(int i)
    {
        return board[i];
    }
}
