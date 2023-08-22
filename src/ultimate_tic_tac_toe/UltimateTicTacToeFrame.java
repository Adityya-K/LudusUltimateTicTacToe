/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ultimate_tic_tac_toe;

import authentication_frames.LoginFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import menu.MainMenuFrame;
import user.CurrentUser;
import user.SavedGame;

/**
 *
 * @author gaudium
 */
public class UltimateTicTacToeFrame extends javax.swing.JFrame implements ActionListener {

    UltTTT ultBoard;
    
    /**
     * Creates new form UltimateTicTacToeFrame
     */
    public UltimateTicTacToeFrame() {
        setSize(940, 820);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        initComponents();
        addButtonsToPanel(panTTTB1, btnArray[0], 0);
        addButtonsToPanel(panTTTB2, btnArray[1], 1);
        addButtonsToPanel(panTTTB3, btnArray[2], 2);
        addButtonsToPanel(panTTTB4, btnArray[3], 3);
        addButtonsToPanel(panTTTB5, btnArray[4], 4);
        addButtonsToPanel(panTTTB6, btnArray[5], 5);
        addButtonsToPanel(panTTTB7, btnArray[6], 6);
        addButtonsToPanel(panTTTB8, btnArray[7], 7);
        addButtonsToPanel(panTTTB9, btnArray[8], 8);
        
        ultBoard = new UltTTT(btnArray, "X", "None");
    }
    
    public void setGameProperties ( String player, String[][] board, int currentSectionIndex, String currentPlayer) {
        
        ultBoard = new UltTTT(btnArray, player, "None");
        NormalTTT[] gameBoard = ultBoard.getGameBoard();
        ultBoard.setCurrentSectionIndex(currentSectionIndex);
        ultBoard.setCurrentPlayer(currentPlayer);
        lblTurn.setText(currentPlayer + "'s turn");
        
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].getBoard().length; j++) {
                gameBoard[i].getBoard()[j] = board[i][j].equals("e") ? null : board[i][j];
                btnArray[i][j].setForeground(new Color(0,102,255));
                btnArray[i][j].setText(board[i][j].equals("e") ? " " : board[i][j]);
            }
        }
        
        String result = ultBoard.getGameResult();
        
        if (!result.equals("undecided")) {
            JOptionPane.showMessageDialog(this, result.equals("draw") ? "It was a draw" : result + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
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

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
        ultBoard.resetBoard();
        enableButtons();
        lblTurn.setText("X's turn");
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Going to main menu will discard the current game, are you sure?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {    
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
        if (JOptionPane.showConfirmDialog(this, "Would you like to save your current game?", "Save Game?",JOptionPane.YES_NO_OPTION) == 0) {
            String boardString = "";
            for (int i = 0; i < ultBoard.getGameBoard().length; i++) {
                for (int j = 0; j < ultBoard.getGameBoard()[i].getBoard().length; j++) {
                    boardString += (ultBoard.getGameBoard()[i].getBoard()[j] == null ? "e" : ultBoard.getGameBoard()[i].getBoard()[j]) + ":";
                }
            }
            boardString += Integer.toString(ultBoard.getCurrentSectionIndex());
            SavedGame currentGame = new SavedGame(CurrentUser.getUser().getUsername(), "X", "ultimate", "player", ultBoard.getCurrentPlayer(), boardString);
            CurrentUser.getUser().saveGame(currentGame);
            System.out.print(currentGame);
        }
    }//GEN-LAST:event_formWindowClosing

    private void addButtonsToPanel(JPanel panel, JButton[] btnArray, int index) {
        for (int i = 0; i < 9; i++) {
            // Instantiate the button with a label (in this case i+1)
            btnArray[i] = new JButton();
            // Set an action command that the action performed function will
            // recieve (in this case it is i again)
            btnArray[i].setActionCommand(index + "" + i);
            // Add the frame as the actionlistener (i.e. where the action happens)
            btnArray[i].addActionListener(this);
            
            btnArray[i].setBackground(new Color(128, 176, 247));
            btnArray[i].setFont(new Font("SansSerif", Font.BOLD, 25));
            
            panel.add(btnArray[i]);
        }
    }
    
    private void disableButtons() {
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                btnArray[i][j].setEnabled(false);
            }
        }
    }
    
    private void enableButtons() {
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                btnArray[i][j].setEnabled(true);
            }
        }
    }
        
    // Handles a button click
    public void actionPerformed(ActionEvent ae) {
        String result = "";
        
        for (int i = 0; i < btnArray.length; i++) {
            for (int j = 0; j < btnArray[i].length; j++) {
                if (ae.getActionCommand().equals(i + "" + j)) {
                    result = ultBoard.movePlayer(i, j);
                    lblTurn.setText(ultBoard.getCurrentPlayer().equals("X") ? "X's Turn" : "O's Turn");
                    break;
                }
            }
            if (!result.equals("")) {
                break;
            }
        }
        
        if (!(result.equals("MoveMade") || result.equals("Invalid"))) {
            JOptionPane.showMessageDialog(this, result.equals("draw") ? "It was a draw" : result + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            lblTurn.setText(result.equals("draw") ? "It was a draw" : result + " won!");
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
