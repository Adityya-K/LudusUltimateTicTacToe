/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ludusultimatetictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author gaudium
 */
public class NormalTicTacToeFrame extends javax.swing.JFrame implements ActionListener{

    // Turn number variable that is incremented every time a button is pressed
    int turnNumber = 0;
    
    // Array that stores the X and O characters. Used with turnNumber to reflect player change
    String[] playerArray = {"X", "O"};
    
    /**
     * Creates new form NormalTicTacToeFrame
     */
    public NormalTicTacToeFrame() {
        initComponents();
        
        // Creates all the buttons
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = new JButton((i + 1) + "");
            btnArray[i].setActionCommand("" + i);
            btnArray[i].addActionListener(this);
            panButtons.add(btnArray[i]);
        }
    }

    // Handles a button click
    public void actionPerformed(ActionEvent ae) {
        
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
            java.util.logging.Logger.getLogger(NormalTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalTicTacToeFrame().setVisible(true);
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
            btnArray[i].setText("" + (i+1));
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

    // Returns an array of strings that represent all the lines on the board
    private String[] getAllLines() {
        
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
}
