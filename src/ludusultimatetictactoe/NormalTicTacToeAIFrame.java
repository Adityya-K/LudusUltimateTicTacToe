/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ludusultimatetictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

/**
 *
 * @author Eks and Adityya
 */
public class NormalTicTacToeAIFrame extends javax.swing.JFrame implements ActionListener{

    // Board
    String[] board = new String[9];
    
    String difficulty = "easy";
    String ai = "X";
    String player = "O";
    
    
    /**
     * Creates new form NormalTicTacToeFrame
     */
    public NormalTicTacToeAIFrame() {
        initComponents();
        
        // Creates all the buttons
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = new JButton(" ");
            btnArray[i].setActionCommand("" + i);
            btnArray[i].addActionListener(this);
            panButtons.add(btnArray[i]);
        }
        
        if (ai.equals("X")) {
            moveAI();
        }
    }
    
    private void moveEasyComputer() {
        int moveIndex;
        do {
            moveIndex = (int) (Math.random() * 9);
        } while (board[moveIndex] != null);
        board[moveIndex] = ai;
        btnArray[moveIndex].setText(ai);
    }
    
    private void moveAI() {
        Double bestMoveScore = Double.NEGATIVE_INFINITY;
        int moveIndex = -1;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == null) {
                board[i] = ai;
                double moveScore = minimax(board, 0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, false);
                board[i] = null;
                if (moveScore > bestMoveScore) {
                    bestMoveScore = moveScore;
                    moveIndex = i;
                }
            }
        }
        
        board[moveIndex] = ai;
        btnArray[moveIndex].setText(ai);
        
    }
    
    private double minimax(String[] board, int depth, double alpha, double beta, boolean isMaximizing) {
        String gameResult = getGameResult(getAllLines());
        if (gameResult.equals(ai)) {
            return 10;
        }
        if (gameResult.equals(player)) {
            return -10;
        }
        if (gameResult.equals("draw")) {
            return 0;
        }
        if (isMaximizing) {
            double maxEval = Double.NEGATIVE_INFINITY; 
            for (int i = 0; i < board.length; i++) {
                if (board[i] == null) {
                    board[i] = ai;
                    maxEval = Math.max(maxEval, minimax(board, depth + 1, alpha, beta, false));
                    board[i] = null;
                    alpha = Math.max(alpha, maxEval);
                    if (beta <= alpha) {
                        break;
                    }
                }

            }
            return maxEval;
        }
        else  {
            double minEval = Double.POSITIVE_INFINITY;
            for (int i = 0; i < board.length; i++) {
                if (board[i] == null) {
                    board[i] = player;
                    minEval = Math.min(minEval, minimax(board, depth + 1, alpha, beta, true));
                    board [i] = null;
                    beta = Math.min(beta, minEval);
                    if (beta <= alpha) {
                        break;
                    }
                }

            }
            return minEval;
        }
    }

    // Handles a button click
    public void actionPerformed(ActionEvent ae) {
        
        // (this is a linear search) Iterates through the array of buttons
        for (int i = 0; i < btnArray.length; i++) {
            
            // Runs if the button was clicked
            if (ae.getActionCommand().equals("" + i) && board[i] == null) {
                // Board stuff
                board[i] = player;
                // Sets the button text to the correct player using the parity of the turn number
                btnArray[i].setText(player);
                
                if (difficulty.equals("easy")) {
                    moveEasyComputer();
                } else if (difficulty.equals("hard")) {
                    moveAI();
                }
                
                // Stores the game result
                String gameResult = getGameResult(getAllLines());
                
                // Checks if the game has been decided
                if (!gameResult.equals("undecided")) {
                    
                    // TODO output game result on gui instead of console
                    // Prints out the game result
                    System.out.println(gameResult);
                    
                    // TODO reset the board by clicking button instead of automatically
                    // Resets the board
                    resetBoard();
                    
                    if (difficulty.equals("easy")) {
                        moveEasyComputer();
                    } else if (difficulty.equals("hard")) {
                        moveAI();
                    }
                    
                }
                
                // Stops the search for a button click
                break;
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panButtons = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panButtons.setLayout(new java.awt.GridLayout(3, 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalTicTacToeAIFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panButtons;
    // End of variables declaration//GEN-END:variables
    private JButton[] btnArray = new JButton[9];

    // Resets the board
    private void resetBoard() {
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setText(" ");
            board[i] = null;
        }
    }

    // Returns a string with the winner, if there is a draw or if the game is undecided
    private String getGameResult(String[] lines) {
        
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
        
        if (draw == true) {
            gameResult = "draw";
            for (int i = 0; i < board.length; i++) {
                if (board[i] == null) {
                    gameResult = "undecided";
                }
            }
        }
        
        return gameResult;
    }

    // Returns an array of strings that represent all the lines on the board
    private String[] getAllLines() {
        
        // Initializes the array of lines (3 vertical, 3 horizontal, 2 diagonal)
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
