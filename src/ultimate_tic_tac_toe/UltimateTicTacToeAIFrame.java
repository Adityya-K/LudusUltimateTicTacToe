/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to allow the user to play ultimate Tic-Tac-Toe against the computer
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

public class UltimateTicTacToeAIFrame extends javax.swing.JFrame implements ActionListener {
    UltTTT ultBoard; // create new ult board
    final Color SAVE_COLOR = new Color(0,102,255);
    final Color DEFAULT_COLOR = new Color(128, 176, 247);
    
    // edit game's difficulty, ai and player piece
    public void setGameProperties (String difficulty, String ai, String player) {
        // update ui to give game info
        lblComputerIs.setText("Computer is: " + ai + " ( " + difficulty.toUpperCase() + " difficulty )");
        lblPlayerIs.setText("You are: " + player);
        
        // create new ultimate ttt board with all passed in parameters
        ultBoard = new UltTTT(btnArray, player, difficulty);
        
        if (ultBoard.getPlayerPiece().equals("O")) // ai goes first
        {
            ultBoard.moveAI(); // ai move
        }
    }
    
    // method overload and edit game's difficulty, ai, player piece, board and current section 
    public void setGameProperties (String difficulty, String player, String ai, String[][] board, int currentSectionIndex) {
        // update ui to give game info
        lblComputerIs.setText("Computer is: " + ai + " ( " + difficulty.toUpperCase() + " difficulty )");
        lblPlayerIs.setText("You are: " + player);
        
        // create new ultimate ttt board with all passed in parameters
        ultBoard = new UltTTT(btnArray, player, difficulty);
        
        // get the current game board
        NormalTTT[] gameBoard = ultBoard.getGameBoard();
        ultBoard.setCurrentSectionIndex(currentSectionIndex); // update the current section
        ultBoard.setCurrentPlayer(player);
        
        // loop through game board
        for (int i = 0; i < gameBoard.length; i++) {
            // loop through sub boards
            for (int j = 0; j < gameBoard[i].getBoard().length; j++) {
                // if index is empty then make it null, otherwise set it to the correct value
                gameBoard[i].getBoard()[j] = board[i][j].equals("e") ? null : board[i][j];
                
                // set button colour and text depending on if it's in board
                btnArray[i][j].setForeground(SAVE_COLOR);
                btnArray[i][j].setText(board[i][j].equals("e") ? " " : board[i][j]);
            }
        }
        
        gameBoard[currentSectionIndex].highlightButtons(); // highlight the current section
        
        String result = ultBoard.getGameResult(); // check game result
        
        winBehavior(result);
    }
    
    /**
     * Creates new form UltimateTicTacToeFrame
     */
    public UltimateTicTacToeAIFrame() {
        setSize(940, 820); // set window sizes
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        initComponents();
        
        // all the panels
        JPanel[] panels = {panTTTB1, panTTTB2, panTTTB3, panTTTB4, panTTTB5, panTTTB6, panTTTB7, panTTTB8, panTTTB9};
        
        // add buttons to panel
        for (int i = 0; i < panels.length; i++)
        {
            addButtonsToPanel(panels[i], btnArray[i], i);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblComputerIs = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
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
        lblPlayerIs = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(0, 35, 82));
        jPanel1.setMaximumSize(new java.awt.Dimension(940, 788));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 788));
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 788));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ULTIMATE TIC TAC TOE");

        lblComputerIs.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblComputerIs.setForeground(new java.awt.Color(255, 255, 255));
        lblComputerIs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComputerIs.setText("Computer is: X ( HARD difficulty )");

        jPanel2.setBackground(new java.awt.Color(0, 35, 82));

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

        jPanel2.add(panButtons);

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

        lblPlayerIs.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblPlayerIs.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayerIs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerIs.setText("You are: O");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblComputerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPlayerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComputerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlayerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestart)
                    .addComponent(btnToMainMenu)
                    .addComponent(btnHelp))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
     * Check for win and update rating
     */
    private void winBehavior (String result) {
        // if move not made or invalid or undecided
        if (!(result.equals("MoveMade") || result.equals("Invalid") || result.equals("undecided"))) {
            // display corresponding popup
            JOptionPane.showMessageDialog(this, result.equals("draw") ? "It was a draw" : result + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            
            disableButtons(); // disable buttons
            
            // if user won and not a draw
            if (result.equals(ultBoard.getPlayerPiece()) && !result.equals("draw")) {
                CurrentUser.getUser().addWin(); // add win to user
                switch (ultBoard.getAi()) { // do corresponding according to ai
                    case "Easy": // if ai was easy
                        CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 10); // add 10 rating
                        break;
                    case "Medium": // if ai was medium
                        CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 20); // add 20 rating
                        break;
                }
            }
            // if player lost and not draw
            else if (!result.equals(ultBoard.getPlayerPiece()) && !result.equals("draw")) {
                CurrentUser.getUser().addLoss(); // add loss to user
                switch (ultBoard.getAi()) { // do corresponding according to ai
                    case "Easy": // if ai was easy
                        // subtract 20 rating unless it would make it negative, where you would make it 0
                        CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 20 ? CurrentUser.getUser().getRating() - 20 : 0);
                        break;
                    case "Medium": // if ai was medium
                        // subtract 10 rating unless it would make it negative, where you would make it 0
                        CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 10 ? CurrentUser.getUser().getRating() - 10 : 0);
                        break;
                }
            }
            
        }
    }
    
    /*
     * Save the current game
     */
    private void saveGame() {
        int movesPresent = 0; // tracks how many moves
        NormalTTT[] gameBoard = ultBoard.getGameBoard(); // get the current game board
        
       // loop through all indexes
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].getBoard().length; j++) {
                // if there's a piece played there then a move was played
                if (gameBoard[i].getIndex(j) != null) {
                    movesPresent++; // incremenet moves played
                }
            }
        }
        
        // if less than 2 moves then don't save
        if(movesPresent < 2) {
            return;
        }
        
        // prompt user to save current game
        if (JOptionPane.showConfirmDialog(this, "Would you like to save your current game?", "Save Game?",JOptionPane.YES_NO_OPTION) == 0) {
            String boardString = ""; // board in string form
            // loop through each index in gameBoard
            for (int i = 0; i < ultBoard.getGameBoard().length; i++) {
                for (int j = 0; j < ultBoard.getGameBoard()[i].getBoard().length; j++) {
                    // add to saved board string
                    boardString += (ultBoard.getGameBoard()[i].getIndex(j) == null ? "e" : ultBoard.getGameBoard()[i].getIndex(j)) + ":";
                }
            }
            // add on the current section to the board string
            boardString += Integer.toString(ultBoard.getCurrentSectionIndex());
            
            // create a new game save
            SavedGame currentGame = new SavedGame(CurrentUser.getUser().getUsername(), ultBoard.getPlayerPiece(), "ultimate", "computer", ultBoard.getAi(), ultBoard.getPlayerPiece(), boardString);
            CurrentUser.getUser().saveGame(currentGame);
        }
    }
    
    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // restart the game
        ultBoard.resetBoard(); // reset the board
        ultBoard.setCurrentPlayer("X"); // make the current player x
        ultBoard.setCurrentSectionIndex(-1); // go anywhere
        enableButtons(); // enable the buttons
        if (ultBoard.getPlayerPiece().equals("O")) // ai goes first
        {
            ultBoard.moveAI(); // ai move
        }
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // ask if user wants to go back to main menu
        if (JOptionPane.showConfirmDialog(this, "Do you want to quit mid-game?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {   
            saveGame(); // save the game
            MainMenuFrame frmMainMenu = new MainMenuFrame(); // create main menu frame
            frmMainMenu.setVisible(true); // show main menu frame
            this.dispose(); // close current window
        }
    }//GEN-LAST:event_btnToMainMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(CurrentUser.getUser() == null) { // if no current user
            LoginFrame frmLogin = new LoginFrame(); // open login screen
            frmLogin.setVisible(true); // make visible
            this.dispose(); // close this window
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saveGame(); // save the game
    }//GEN-LAST:event_formWindowClosing

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        UltimateHelpFrame frmUltimateHelp = new UltimateHelpFrame(); // create new help frame
        frmUltimateHelp.setVisible(true); // make it visible
    }//GEN-LAST:event_btnHelpActionPerformed

    /*
     * This method adds all the buttons passed in to the JPanel
     */
    private void addButtonsToPanel(JPanel panel, JButton[] btnArray, int index) {
        for (int i = 0; i < 9; i++) {
            // Instantiate the button with a label (in this case i+1)
            btnArray[i] = new JButton();
            // Set an action command that the action performed function will
            // recieve (in this case it is i again)
            btnArray[i].setActionCommand(index + "" + i);
            // Add the frame as the actionlistener (i.e. where the action happens)
            btnArray[i].addActionListener(this);
            
            btnArray[i].setBackground(DEFAULT_COLOR); // set button color
            btnArray[i].setFont(new Font("SansSerif", Font.BOLD, 25)); // set button font
            
            panel.add(btnArray[i]); // add the button to the panel
        }
    }
    
    // disable all the buttons
    private void disableButtons() {
        // loop through all buttons
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                btnArray[i][j].setEnabled(false); // disable button
            }
        }
    }
    
    // enable all the buttons
    private void enableButtons() {
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                btnArray[i][j].setEnabled(true); // enable button
            }
        }
    }
    
    // Handles a button click
    public void actionPerformed(ActionEvent ae) {
        String result = ""; // result of button click (NotYourTurn, Invalid, MoveMade)
        
        // loop through all buttons
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                if (ae.getActionCommand().equals(i + "" + j)) { // if found corresponding button
                    result = ultBoard.movePlayer(i, j); // attempt to move player
                    break;
                }
            }
            // if did something, no need to check further
            if (!result.equals(""))
            {
                break;
            }
        }
        
        if (result.equals("MoveMade")) // if made a move
        {
            ultBoard.moveAI(); // make an ai move
            result = ultBoard.getGameResult(); // check the game result after ai move
        }
        
        winBehavior(result); // do corresponding behaviour according to board state
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
            java.util.logging.Logger.getLogger(UltimateTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UltimateTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UltimateTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UltimateTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UltimateTicTacToeAIFrame().setVisible(true);
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
    private javax.swing.JLabel lblComputerIs;
    private javax.swing.JLabel lblPlayerIs;
    private javax.swing.JPanel panButtons;
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
    // Creating an array for cleaner code (So we don't have to create 81 seperate buttons)
    private JButton[][] btnArray = new JButton[9][9];
}
