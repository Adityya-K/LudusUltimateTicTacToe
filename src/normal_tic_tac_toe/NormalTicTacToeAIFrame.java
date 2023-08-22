/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package normal_tic_tac_toe;

import authentication_frames.LoginFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import menu.MainMenuFrame;
import user.CurrentUser;
import user.SavedGame;

/**
 *
 * @author Eks and Adityya
 */
public class NormalTicTacToeAIFrame extends javax.swing.JFrame implements ActionListener{

    // Board
    String[] board = new String[9];
    
    String difficulty = "medium";
    String ai = "O";
    String player = "X";
    
    public void setGameProperties (String difficulty, String ai, String player) {
        this.ai = ai;
        this.player = player;
        this.difficulty = difficulty;
        
        lblComputerIs.setText("Computer is: " + ai + " ( " + difficulty.toUpperCase() + " difficulty )");
        lblPlayerIs.setText("You are: " + player);
        
        if (ai.equals("X")) {
            if (difficulty.equals("easy")) {
                    moveEasyComputer();
            } else if (difficulty.equals("medium")) {
                moveMediumComputer();
            } else if (difficulty.equals("hard")) {
                moveAI();
            }
        }
    }
    
    public void setGameProperties (String difficulty, String ai, String player, String[] board) {
        this.ai = ai;
        this.player = player;
        this.difficulty = difficulty;
        this.board = board;
        
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setForeground(new Color(0,102,255));
            btnArray[i].setText(board[i].equals("e") ? " " : board[i]);
            this.board[i] = board[i].equals("e") ? null : board[i];
        }
        
        lblComputerIs.setText("Computer is: " + ai + " ( " + difficulty.toUpperCase() + " difficulty )");
        lblPlayerIs.setText("You are: " + player);
        
        if (ai.equals("X")) {
            if (difficulty.equals("easy")) {
                    moveEasyComputer();
            } else if (difficulty.equals("medium")) {
                moveMediumComputer();
            } else if (difficulty.equals("hard")) {
                moveAI();
            }
        }
        
        String gameResult = getGameResult(getAllLines());
                
        // Checks if the game has been decided
        if (!gameResult.equals("undecided")) {

            // TODO output game result on gui instead of console
            // Prints out the game result
            JOptionPane.showMessageDialog(this, gameResult.equals("draw") ? "It was a draw" : gameResult + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            
            for (int i = 0; i < btnArray.length; i++) {
                btnArray[i].setEnabled(false);
            }
        }
    }
    
    /**
     * Creates new form NormalTicTacToeFrame
     */
    public NormalTicTacToeAIFrame() {
        setSize(940, 788);
        setLocationRelativeTo(null);
        initComponents();
        
        // Creates all the buttons
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = new JButton(" ");
            btnArray[i].setBackground(new Color(128, 176, 247));
            btnArray[i].setFont(new Font("SansSerif", Font.BOLD, 50));
            btnArray[i].setActionCommand("" + i);
            btnArray[i].addActionListener(this);
            panButtons.add(btnArray[i]);
        }
    }
    
    private void moveEasyComputer() {
        int moveIndex;
        do {
            moveIndex = (int) (Math.random() * 9);
        } while (board[moveIndex] != null);
        board[moveIndex] = ai;
        btnArray[moveIndex].setForeground(ai.equals("X") ? Color.black : Color.white);
        btnArray[moveIndex].setText(ai);
    }
    
    private void moveMediumComputer() {
        int moveIndex = findWin();
        if (moveIndex == -1) {
            do {
                moveIndex = (int) (Math.random() * 9);
            } while (board[moveIndex] != null);
        }
        board[moveIndex] = ai;
        btnArray[moveIndex].setForeground(ai.equals("X") ? Color.black : Color.white);
        btnArray[moveIndex].setText(ai);
    }
    
    private int findWin() {
        int moveIndex = -1;
        String [] lines = getAllLines();
        int winningLineIndex = -1;
        String winningLine = "";
        String [] indicesInLines = {"012", "345", "678", "036", "147", "258", "048", "246"};
        
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("XXnull") || lines[i].equals("XnullX") || lines[i].equals("nullXX")) {
                winningLineIndex = i;
                winningLine = lines[i];
                break;
            }
        }
        
        if (winningLineIndex != -1) {
            if (winningLine.equals("XXnull")) {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(2)));
            } else if (winningLine.equals("XnullX")) {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(1)));
            } else {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(0)));
            }
        }
        
        return moveIndex;
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
        btnArray[moveIndex].setForeground(ai.equals("X") ? Color.black : Color.white);
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

    private void saveGame() {
        int movesPresent = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] != null) {
                movesPresent++;
            }
        }
        
        if(movesPresent < 2) {
            return;
        }
        
        if (JOptionPane.showConfirmDialog(this, "Would you like to save your current game?", "Save Game?",JOptionPane.YES_NO_OPTION) == 0) {
            String boardString = "";
            for (int i = 0; i < board.length; i++) {
                boardString += (board[i] == null ? "e" : board[i]) + ":";
            }
            SavedGame currentGame = new SavedGame(CurrentUser.getUser().getUsername(), player, "normal", "computer", difficulty, player, boardString);
            CurrentUser.getUser().saveGame(currentGame);
            System.out.print(currentGame);
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
                
                btnArray[i].setForeground(player.equals("X") ? Color.black : Color.white);
                // Sets the button text to the correct player using the parity of the turn number
                btnArray[i].setText(player);
                
                // Stores the game result
                String gameResult = getGameResult(getAllLines());
                
                if (gameResult.equals("undecided")) {
                    if (difficulty.equals("easy")) {
                        moveEasyComputer();
                    } else if (difficulty.equals("medium")) {
                        moveMediumComputer();
                    } else if (difficulty.equals("hard")) {
                        moveAI();
                    }
                }
                
                gameResult = getGameResult(getAllLines());
                
                // Checks if the game has been decided
                if (!gameResult.equals("undecided")) {
                    
                    // TODO output game result on gui instead of console
                    // Prints out the game result
                    JOptionPane.showMessageDialog(this, gameResult.equals("draw") ? "It was a draw" : gameResult + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    
                    if (gameResult.equals(player)) {
                        CurrentUser.getUser().addWin();
                        switch (difficulty) {
                            case "easy":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 5);
                                break;
                            case "medium":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 10);
                                break;
                            case "hard":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 20);
                                break;
                        }
                    }
                    else if (gameResult.equals(ai)) {
                        CurrentUser.getUser().addLoss();
                        switch (difficulty) {
                            case "easy":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 20 ? CurrentUser.getUser().getRating() - 20 : 0);
                                break;
                            case "medium":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 10 ? CurrentUser.getUser().getRating() - 10 : 0);
                                break;
                            case "hard":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 5 ? CurrentUser.getUser().getRating() - 5 : 0);
                                break;
                        }
                    }
                    
                    for (int j = 0; j < btnArray.length; j++) {
                        btnArray[j].setEnabled(false);
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

        panRootBackground = new javax.swing.JPanel();
        btnRestart = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblPlayerIs = new javax.swing.JLabel();
        panBackground = new javax.swing.JPanel();
        panButtons = new javax.swing.JPanel();
        btnToMainMenu = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        lblComputerIs = new javax.swing.JLabel();

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
        panRootBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        panRootBackground.setPreferredSize(new java.awt.Dimension(940, 788));

        btnRestart.setBackground(new java.awt.Color(0, 102, 255));
        btnRestart.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnRestart.setForeground(new java.awt.Color(255, 255, 255));
        btnRestart.setText("Restart");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("NORMAL TIC TAC TOE (COMPUTER OPPONENT)");

        lblPlayerIs.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblPlayerIs.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayerIs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerIs.setText("You are: O");

        panBackground.setBackground(new java.awt.Color(0, 35, 82));
        panBackground.setForeground(new java.awt.Color(0, 102, 255));

        panButtons.setBackground(new java.awt.Color(0, 102, 255));
        panButtons.setMinimumSize(new java.awt.Dimension(100, 100));
        panButtons.setPreferredSize(new java.awt.Dimension(500, 500));
        panButtons.setLayout(new java.awt.GridLayout(3, 3));
        panBackground.add(panButtons);

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

        lblComputerIs.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblComputerIs.setForeground(new java.awt.Color(255, 255, 255));
        lblComputerIs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComputerIs.setText("Computer is: X");

        javax.swing.GroupLayout panRootBackgroundLayout = new javax.swing.GroupLayout(panRootBackground);
        panRootBackground.setLayout(panRootBackgroundLayout);
        panRootBackgroundLayout.setHorizontalGroup(
            panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRootBackgroundLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRootBackgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblComputerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lblPlayerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panRootBackgroundLayout.setVerticalGroup(
            panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRootBackgroundLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerIs)
                    .addComponent(lblComputerIs))
                .addGap(18, 18, 18)
                .addComponent(panBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestart)
                    .addComponent(btnToMainMenu)
                    .addComponent(btnHelp))
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRootBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRootBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
        resetBoard();
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {    
            saveGame();
            MainMenuFrame frmMainMenu = new MainMenuFrame();
            frmMainMenu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnToMainMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(CurrentUser.getUser() == null) {
            LoginFrame frmLogin = new LoginFrame();
            frmLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        saveGame();
    }//GEN-LAST:event_formWindowClosing

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnToMainMenu;
    private javax.swing.JLabel lblComputerIs;
    private javax.swing.JLabel lblPlayerIs;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panBackground;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panRootBackground;
    // End of variables declaration//GEN-END:variables
    private JButton[] btnArray = new JButton[9];

    // Resets the board
    private void resetBoard() {
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setText(" ");
            btnArray[i].setEnabled(true);
            board[i] = null;
        }
        
        if (ai.equals("X")) {
            if (difficulty.equals("easy")) {
                moveEasyComputer();
            } else if (difficulty.equals("medium")) {
                moveMediumComputer();
            } else if (difficulty.equals("hard")) {
                moveAI();
            }
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
