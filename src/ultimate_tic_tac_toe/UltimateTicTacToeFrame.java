/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to allow the user to play the 2-player version of normal Tic-Tac-Toe
 * 
 */

package ultimate_tic_tac_toe;

import authentication_frames.LoginFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import menu.MainMenuFrame;
import user.CurrentUser;
import user.SavedGame;

public class UltimateTicTacToeFrame extends javax.swing.JFrame implements ActionListener {

    UltTTT ultBoard;
    
    /**
     * Creates new form UltimateTicTacToeFrame
     */
    public UltimateTicTacToeFrame() {
        setSize(940, 820);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        initComponents();
        // Create an array of panels
        JPanel[] panels = {panTTTB1, panTTTB2, panTTTB3, panTTTB4, panTTTB5, panTTTB6, panTTTB7, panTTTB8, panTTTB9 };
        
        // Loop through the whole array and add each panel to the main panel
        for (int i = 0; i < panels.length; i++) {
            // Use the add function to add the panel to the main panel with all
            // the buttons
            addButtonsToPanel(panels[i], btnArray[i], 0);
        }
        
        // Create a new ultBoard that represents the ultimate Tic Tac Toe with
        ultBoard = new UltTTT(btnArray, "X", "None");
    }
    
    /**
     * A method that sets the parameters for the current game
     * @param player the player peice
     * @param board the board of the game
     * @param currentSectionIndex The index of the current section that the move can be played on
     * @param currentPlayer The current player who is playing (i.e.  "X" or "O")
     */
    public void setGameProperties ( String player, String[][] board, int currentSectionIndex, String currentPlayer) {
        // Create a new ult board
        ultBoard = new UltTTT(btnArray, player, "None");
        
        // Create an array of normal tic tac toe game boards
        NormalTTT[] gameBoard = ultBoard.getGameBoard();
        
        // Set the current section to be playing on
        ultBoard.setCurrentSectionIndex(currentSectionIndex);
        
        // Highlight the current section
        gameBoard[currentSectionIndex].highlightButtons();
        
        // Set the current player
        ultBoard.setCurrentPlayer(currentPlayer);
        
        // Set the text to reflect the current player
        lblTurn.setText(currentPlayer + "'s turn");
        
        // Loop through the entire gameboard
        for (int i = 0; i < gameBoard.length; i++) {
            // Loop through each small Tic Tac Toe board in the main board
            for (int j = 0; j < gameBoard[i].getBoard().length; j++) {
                // Set the string to null if e otherwise set it to the index of the board passed in
                gameBoard[i].getBoard()[j] = board[i][j].equals("e") ? null : board[i][j];
                // Set the foreground color of the button to be a blue to show that it loaded form a saved game
                btnArray[i][j].setForeground(new Color(0,102,255));
                
                // Set the button text to reflect the board
                btnArray[i][j].setText(board[i][j].equals("e") ? " " : board[i][j]);
            }
        }
        
        // check the result of the game
        String result = ultBoard.getGameResult();
        
        // If the result is decided
        if (!result.equals("undecided")) {
            // Tell the user
            JOptionPane.showMessageDialog(this, result.equals("draw") ? "It was a draw" : result + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            
            // Prevent the user from making further moves
            disableButtons();
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

        panRootBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTurn = new javax.swing.JLabel();
        panBackground = new javax.swing.JPanel();
        panButtons = new javax.swing.JPanel();
        panTTTB1 = new javax.swing.JPanel();
        panTTTB2 = new javax.swing.JPanel();
        panTTTB3 = new javax.swing.JPanel();
        panTTTB4 = new javax.swing.JPanel();
        panTTTB5 = new javax.swing.JPanel();
        panTTTB6 = new javax.swing.JPanel();
        panTTTB7 = new javax.swing.JPanel();
        panTTTB8 = new javax.swing.JPanel();
        panTTTB9 = new javax.swing.JPanel();
        btnHelp = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnToMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(940, 788));
        setMinimumSize(new java.awt.Dimension(940, 788));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panRootBackground.setBackground(new java.awt.Color(0, 35, 82));
        panRootBackground.setMaximumSize(new java.awt.Dimension(940, 788));
        panRootBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        panRootBackground.setPreferredSize(new java.awt.Dimension(940, 788));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ULTIMATE TIC TAC TOE");

        lblTurn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTurn.setForeground(new java.awt.Color(255, 255, 255));
        lblTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurn.setText("X's turn");

        panBackground.setBackground(new java.awt.Color(0, 35, 82));

        panButtons.setBackground(new java.awt.Color(0, 35, 82));
        panButtons.setMaximumSize(new java.awt.Dimension(550, 550));
        panButtons.setMinimumSize(new java.awt.Dimension(550, 550));
        panButtons.setPreferredSize(new java.awt.Dimension(550, 550));
        panButtons.setLayout(new java.awt.GridLayout(3, 3, 20, 20));

        panTTTB1.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB1.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB1.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB1);

        panTTTB2.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB2.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB2.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB2);

        panTTTB3.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB3.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB3.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB3);

        panTTTB4.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB4.setMinimumSize(new java.awt.Dimension(0, 0));
        panTTTB4.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB4.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB4);

        panTTTB5.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB5.setMinimumSize(new java.awt.Dimension(0, 0));
        panTTTB5.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB5.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB5);

        panTTTB6.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB6.setMinimumSize(new java.awt.Dimension(0, 0));
        panTTTB6.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB6.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB6);

        panTTTB7.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB7.setMinimumSize(new java.awt.Dimension(0, 0));
        panTTTB7.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB7.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB7);

        panTTTB8.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB8.setMinimumSize(new java.awt.Dimension(0, 0));
        panTTTB8.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB8.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB8);

        panTTTB9.setBackground(new java.awt.Color(0, 102, 255));
        panTTTB9.setMinimumSize(new java.awt.Dimension(0, 0));
        panTTTB9.setPreferredSize(new java.awt.Dimension(100, 100));
        panTTTB9.setLayout(new java.awt.GridLayout(3, 3));
        panButtons.add(panTTTB9);

        panBackground.add(panButtons);

        btnHelp.setBackground(new java.awt.Color(0, 102, 255));
        btnHelp.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnRestart.setBackground(new java.awt.Color(0, 102, 255));
        btnRestart.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnRestart.setForeground(new java.awt.Color(255, 255, 255));
        btnRestart.setText("Restart");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        btnToMainMenu.setBackground(new java.awt.Color(0, 102, 255));
        btnToMainMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnToMainMenu.setText("To Main Menu");
        btnToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRootBackgroundLayout = new javax.swing.GroupLayout(panRootBackground);
        panRootBackground.setLayout(panRootBackgroundLayout);
        panRootBackgroundLayout.setHorizontalGroup(
            panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
            .addComponent(panBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panRootBackgroundLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panRootBackgroundLayout.setVerticalGroup(
            panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRootBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestart)
                    .addComponent(btnToMainMenu)
                    .addComponent(btnHelp))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRootBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRootBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * A method that saves the game
     */
    private void saveGame() {
        // Create a move counter
        int movesPresent = 0;
        
        // Get the game board of the ultBoard
        NormalTTT[] gameBoard = ultBoard.getGameBoard();
        
        // Loop through the entire game board
        for (int i = 0; i < gameBoard.length; i++) {
            // Loop through each mini Tic Tac Toe board in the game board
            for (int j = 0; j < gameBoard[i].getBoard().length; j++) {
                // Check if the current index is null
                if (gameBoard[i].getIndex(j) != null) {
                    // Add to the move counter as a move was played
                    movesPresent++;
                }
            }
        }
        
        // If less than one move was played
        if(movesPresent < 1) {
            // Return out of the function as we don't want to save an empty game
            return;
        }
        
        // Ask the user if the want to save the game
        if (JOptionPane.showConfirmDialog(this, "Would you like to save your current game?", "Save Game?",JOptionPane.YES_NO_OPTION) == 0) {
            // Declare a string representation of the board
            String boardString = "";
            // Loop through the gameBoard
            for (int i = 0; i < ultBoard.getGameBoard().length; i++) {
                // Loop through the each tiny Tic Tac Toe board in the game board
                for (int j = 0; j < ultBoard.getGameBoard()[i].getBoard().length; j++) {
                    // If the element if null assign e otherwise assign the letter seperated by colons
                    boardString += (ultBoard.getGameBoard()[i].getIndex(j) == null ? "e" : ultBoard.getGameBoard()[i].getIndex(j)) + ":";
                }
            }
            // Use the 81st index to store the currentSection that is being played on
            boardString += Integer.toString(ultBoard.getCurrentSectionIndex());
            
            // Create a new SaveGame object with the respective parameters
            SavedGame currentGame = new SavedGame(CurrentUser.getUser().getUsername(), "X", "ultimate", "player", ultBoard.getCurrentPlayer(), boardString);
            
            // Add the current game to an arrayList of saved games stored in the
            // database with the saveGame() method.
            CurrentUser.getUser().saveGame(currentGame);
        }
    }
    
    
    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // Reset the ultimate tic tac toe board
        ultBoard.resetBoard();
        // Enable the buttons if they were disabled from the win
        enableButtons();
        // Set the turn so that X goes first
        lblTurn.setText("X's turn");
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // Ask the user if they want to quit
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {    
            // Ask if they want to save game
            saveGame();
            // Create main menu frame
            MainMenuFrame frmMainMenu = new MainMenuFrame();
            // Make it visible
            frmMainMenu.setVisible(true);
            // Dispose the current frame
            this.dispose();
        }
    }//GEN-LAST:event_btnToMainMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // On startup check if the current user is null
        if(CurrentUser.getUser() == null) {
            // Create a new login frame
            LoginFrame frmLogin = new LoginFrame();
            // Make it visible
            frmLogin.setVisible(true);
            // Dispose the current frame
            this.dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Ask for save game if the window is closed
        saveGame();
    }//GEN-LAST:event_formWindowClosing

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // Create the help create help frame
        UltimateHelpFrame frmUltimateHelp = new UltimateHelpFrame();
        // Make it visible
        frmUltimateHelp.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void addButtonsToPanel(JPanel panel, JButton[] btnArray, int index) {
        //Loop through all the buttons
        for (int i = 0; i < 9; i++) {
            // Instantiate the button with a label (in this case i+1)
            btnArray[i] = new JButton();
            // Set an action command that the action performed function will
            // recieve (in this case it is i again)
            btnArray[i].setActionCommand(index + "" + i);
            // Add the frame as the actionlistener (i.e. where the action happens)
            btnArray[i].addActionListener(this);
            // Set the background to the color
            btnArray[i].setBackground(new Color(128, 176, 247));
            // Set the font and size of the text of the button
            btnArray[i].setFont(new Font("SansSerif", Font.BOLD, 25));
            // Add the button to the panel
            panel.add(btnArray[i]);
        }
    }
    
    /**
     * A method that disables all buttons
     */
    private void disableButtons() {
        // Loop through the 2D array of buttons using a nested for loop
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                // Disable the button
                btnArray[i][j].setEnabled(false);
            }
        }
    }
    
    private void enableButtons() {
        // Loop through the 2D array of buttons using a nested for loop
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                // Enable the button
                btnArray[i][j].setEnabled(true);
            }
        }
    }
        
    // Handles a button click
    public void actionPerformed(ActionEvent ae) {
        // Set a result to an empty string
        String result = "";
        
        // Use a nested for loop through loop through the 2D button array
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                // Check if the button clicked is the current button
                if (ae.getActionCommand().equals(i + "" + j)) {
                    // Set the result the return of movePlayer
                    result = ultBoard.movePlayer(i, j);
                    // Change whose turn it is using the ternary operatory
                    lblTurn.setText(ultBoard.getCurrentPlayer().equals("X") ? "X's Turn" : "O's Turn");
                    break;
                }
            }
            // If the result is not empty, break
            if (!result.equals("")) {
                break;
            }
        }
        
        // Check if the result is not movemade or invalid
        if (!(result.equals("MoveMade") || result.equals("Invalid"))) {
            // Show a win/loss/draw to the user
            JOptionPane.showMessageDialog(this, result.equals("draw") ? "It was a draw" : result + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            // Set the text of the label as well
            lblTurn.setText(result.equals("draw") ? "It was a draw" : result + " won!");
            // Disable all buttons so the game doesn't continue
            disableButtons();
        }
    }
    
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
            java.util.logging.Logger.getLogger(UltimateTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UltimateTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UltimateTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UltimateTicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UltimateTicTacToeFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnToMainMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JPanel panBackground;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panRootBackground;
    private javax.swing.JPanel panTTTB1;
    private javax.swing.JPanel panTTTB2;
    private javax.swing.JPanel panTTTB3;
    private javax.swing.JPanel panTTTB4;
    private javax.swing.JPanel panTTTB5;
    private javax.swing.JPanel panTTTB6;
    private javax.swing.JPanel panTTTB7;
    private javax.swing.JPanel panTTTB8;
    private javax.swing.JPanel panTTTB9;
    // End of variables declaration//GEN-END:variables
    // Creating an array for cleaner code (So we don't have to create 86 seperate buttons)
    private JButton[][] btnArray = new JButton[9][9];
}
