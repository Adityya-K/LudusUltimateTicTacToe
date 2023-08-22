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

/**
 *
 * @author gaudium
 */
public class UltimateTicTacToeAIFrame extends javax.swing.JFrame implements ActionListener {

    UltTTT ultBoard;
    
    public void setGameProperties (String difficulty, String ai, String player) {
        lblComputerIs.setText("Computer is: " + ai + " ( " + difficulty.toUpperCase() + " difficulty )");
        lblPlayerIs.setText("You are: " + player);
        
        ultBoard = new UltTTT(btnArray, player, difficulty);
        
        if (ultBoard.getPlayerPiece().equals("O")) // ai goes first
        {
            ultBoard.moveAI();
        }
    }
    
    /**
     * Creates new form UltimateTicTacToeFrame
     */
    public UltimateTicTacToeAIFrame() {
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

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
        ultBoard.resetBoard();
        enableButtons();
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // TODO add your handling code here:
        MainMenuFrame frmMainMenu = new MainMenuFrame();
        frmMainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnToMainMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(CurrentUser.getUser() == null) {
            LoginFrame frmLogin = new LoginFrame();
            frmLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowOpened

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
                    break;
                }
            }
            if (!result.equals(""))
            {
                break;
            }
        }
        
        if (result.equals("MoveMade"))
        {
            ultBoard.moveAI();
            result = ultBoard.getGameResult();
        }
        
        if (!(result.equals("MoveMade") || result.equals("Invalid") || result.equals("undecided"))) {
            JOptionPane.showMessageDialog(this, result.equals("draw") ? "It was a draw" : result + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            disableButtons();
            if (result.equals(ultBoard.getPlayerPiece()) && !result.equals("draw")) {
                CurrentUser.getUser().addWin();
            }
            else {
                CurrentUser.getUser().addLoss();
            }
            
            System.out.println(CurrentUser.getUser().getWins() + " " + CurrentUser.getUser().getLosses());
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
    // Creating an array for cleaner code (So we don't have to create 86 seperate buttons)
    private JButton[][] btnArray = new JButton[9][9];
}
