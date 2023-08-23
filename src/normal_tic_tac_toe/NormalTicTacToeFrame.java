/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to allow the user to play the 2-player version of normal Tic-Tac-Toe
 * 
 */

package normal_tic_tac_toe;

// Imports LoginFrame
import authentication_frames.LoginFrame;

// Imports Color, Font, ActionEvent and ActionListener from java.awt
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Imports JButton and JOptionPane from javax.swing
import javax.swing.JButton;
import javax.swing.JOptionPane;

// Imports MainMenuFrame from the menu package
import menu.MainMenuFrame;

// Imports the CurrentUser and SavedGames classes from the user package
import user.CurrentUser;
import user.SavedGame;


public class NormalTicTacToeFrame extends javax.swing.JFrame implements ActionListener{

    // Turn number variable that is incremented every time a button is pressed
    int turnNumber = 0;
    
    // Array that stores the X and O characters. Used with turnNumber to reflect player change
    String[] playerArray = {"X", "O"};
    
    // Sets the turn number and board if the game has been loaded
    public void setGameProperties (String currentTurn, String[] board) {
        
        // Sets the turn number
        turnNumber = Integer.parseInt(currentTurn);
        
        // Iterates through all of the indices in the button array
        for (int i = 0; i < btnArray.length; i++) {
            
            // Sets the color
            btnArray[i].setForeground(new Color(0,102,255));
            
            // Sets the text
            btnArray[i].setText(board[i].equals("e") ? " " : board[i]);
            
        }
        
    }
    
    
    /**
     * Creates new form NormalTicTacToeFrame
     */
    public NormalTicTacToeFrame() {
        
        // Displays the JFrame at the center position of the screen
        setSize(940, 788);
        setLocationRelativeTo(null);
        initComponents();
        
        // Creates all the buttons
        for (int i = 0; i < btnArray.length; i++) {
            
            // Sets the text
            btnArray[i] = new JButton(" ");
            
            // Sets the background color
            btnArray[i].setBackground(new Color(128, 176, 247));
            
            // Sets the font
            btnArray[i].setFont(new Font("SansSerif", Font.BOLD, 50));
            
            // Sets the action command
            btnArray[i].setActionCommand("" + i);
            
            // Sets the action listener
            btnArray[i].addActionListener(this);
            
            // Adds the button to the panel
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
                
                // Sets the color
                btnArray[i].setForeground(turnNumber%2 == 1 ? Color.white : Color.black);
                
                // Sets the button text to the correct player using the parity of the turn number
                btnArray[i].setText("" + playerArray[turnNumber%2]);
                
                // Displays the appropriate player's turn
                lblTurn.setText(turnNumber%2 == 1 ? "X's Turn" : "O's Turn");
                
                // Increments the turn number
                turnNumber++;
                
                // Stores the game result
                String gameResult = getGameResult(getAllLines());
                
                // Checks if the game has been decided
                if (gameResult.equals("undecided") == false) {
                    
                    // Outputs the game result
                    JOptionPane.showMessageDialog(this, gameResult, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    lblTurn.setText(gameResult);
                    
                    // Disables all of the buttons
                    for (int j = 0; j < btnArray.length; j++) {
                        btnArray[j].setEnabled(false);
                    }
                    
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

        jPanel2 = new javax.swing.JPanel();
        btnRestart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panButtons = new javax.swing.JPanel();
        btnToMainMenu = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        lblTurn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(940, 788));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 35, 82));
        jPanel2.setMinimumSize(new java.awt.Dimension(940, 788));
        jPanel2.setPreferredSize(new java.awt.Dimension(940, 788));

        btnRestart.setBackground(new java.awt.Color(0, 102, 255));
        btnRestart.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnRestart.setForeground(new java.awt.Color(255, 255, 255));
        btnRestart.setText("Restart");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NORMAL TIC TAC TOE");

        jPanel1.setBackground(new java.awt.Color(0, 35, 82));
        jPanel1.setForeground(new java.awt.Color(0, 102, 255));

        panButtons.setBackground(new java.awt.Color(0, 102, 255));
        panButtons.setMinimumSize(new java.awt.Dimension(100, 100));
        panButtons.setPreferredSize(new java.awt.Dimension(500, 500));
        panButtons.setLayout(new java.awt.GridLayout(3, 3));
        jPanel1.add(panButtons);

        btnToMainMenu.setBackground(new java.awt.Color(0, 102, 255));
        btnToMainMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnToMainMenu.setText("To Main Menu");
        btnToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToMainMenuActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new java.awt.Color(0, 102, 255));
        btnHelp.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        lblTurn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTurn.setForeground(new java.awt.Color(255, 255, 255));
        lblTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurn.setText("X's turn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblTurn)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestart)
                    .addComponent(btnToMainMenu)
                    .addComponent(btnHelp))
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Saves the game
    private void saveGame() {
        
        // Initializes a counter for the amount of moves
        int movesPresent = 0;
        
        // Increments the move conuter accordingly
        for (int i = 0; i < btnArray.length; i++) {
            if (!btnArray[i].getText().isBlank()) {
                movesPresent++;
            }
        }
        
        // Returns nothing if there are no moves
        if(movesPresent < 1) {
            return;
        }
        
        // Asks the user to confirm
        if (JOptionPane.showConfirmDialog(this, "Would you like to save your current game?", "Save Game?",JOptionPane.YES_NO_OPTION) == 0) {
            
            // Reads the board into a string
            String boardString = "";
            for (int i = 0; i < btnArray.length; i++) {
                boardString += btnArray[i].getText() + ":";
            }
            
            // Saves the game, passing information about the game
            SavedGame currentGame = new SavedGame(CurrentUser.getUser().getUsername(), "X", "normal", "player", Integer.toString(turnNumber), boardString);
            CurrentUser.getUser().saveGame(currentGame);
            System.out.print(currentGame); // DELETE
            
        }
        
    }
    
    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
        
        // Resets the board to an empty one
        resetBoard();
        
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // TODO add your handling code here:
        
        // Asks the user to confirm
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {    
            
            // Saves the game and displays the main menu
            saveGame();
            MainMenuFrame frmMainMenu = new MainMenuFrame();
            frmMainMenu.setVisible(true);
            this.dispose();
            
        }
        
    }//GEN-LAST:event_btnToMainMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        // Displays the login page if the current user is null when the window is opened
        if(CurrentUser.getUser() == null) {
            
            LoginFrame frmLogin = new LoginFrame();
            frmLogin.setVisible(true);
            this.dispose();
            
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        // Saves the game
        saveGame();
        
    }//GEN-LAST:event_formWindowClosing

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        
        // Displays the help page
        NormalHelpFrame frmNormalHelp = new NormalHelpFrame();
        frmNormalHelp.setVisible(true);
        
    }//GEN-LAST:event_btnHelpActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalTicTacToeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnToMainMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JPanel panButtons;
    // End of variables declaration//GEN-END:variables
    
    // Creates an array of 9 buttons
    private JButton[] btnArray = new JButton[9];

    // Resets the board
    private void resetBoard() {
        
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setText(" "); 
            btnArray[i].setEnabled(true);
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
                gameResult = "X won!";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
            
            // Runs if O won
            } else if (line.equals("OOO")) {
                
                // Sets the result string
                gameResult = "O won!";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
                
            }
        }
        
        // Sets the game result to a draw if the board is full and there are no 3-in-a-rows
        if (draw == true && turnNumber == 9) {
            gameResult = "It's a draw!";
        }
        
        // Returns the game result
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
