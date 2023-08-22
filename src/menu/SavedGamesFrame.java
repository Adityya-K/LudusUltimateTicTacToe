/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;

import authentication_frames.LoginFrame;
import java.util.ArrayList;
import javax.swing.JFrame;
import user.User;
import user.UserDatabase;
import java.awt.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import normal_tic_tac_toe.NormalTicTacToeAIFrame;
import user.CurrentUser;
import user.SavedGame;

/**
 *
 * @author gaudium
 */
public class SavedGamesFrame extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public SavedGamesFrame() {
        setSize(938, 788);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        initComponents();
    }
    
    public void displaySavedGames() {
        ArrayList <SavedGame> gamesPlayed = CurrentUser.getUser().getGames();
        
        // new model for the leaderbaord table
        DefaultTableModel model = (DefaultTableModel) tblSavedGames.getModel();
        
        // display either smaller of the size of the top players arraylist or the PLAYERS_TO_DISPLAY
        // loop trough each element up until the numbre of playuers to display
        for (int i = 0; i < gamesPlayed.size(); i++) {
            System.out.println(gamesPlayed.get(i).getPosition());
            model.addRow(new Object[]{gamesPlayed.get(i).getGameType(), gamesPlayed.get(i).getOpponentType(), gamesPlayed.get(i).getAIDifficulty() == null ? " " : gamesPlayed.get(i).getAIDifficulty()});
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

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSavedGames = new javax.swing.JTable();
        btnGoToMain = new javax.swing.JButton();
        lblDescription = new javax.swing.JLabel();
        btnClearSavedGames = new javax.swing.JButton();
        btnLoadGame = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(938, 788));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Saved Games");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 150, 940, 50);

        tblSavedGames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type of Game", "Opponent", "AI Difficulty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSavedGames.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSavedGames);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 230, 740, 350);

        btnGoToMain.setBackground(new java.awt.Color(0, 102, 255));
        btnGoToMain.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnGoToMain.setForeground(new java.awt.Color(255, 255, 255));
        btnGoToMain.setText("Go To Main Menu");
        btnGoToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToMainActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoToMain);
        btnGoToMain.setBounds(620, 600, 220, 40);

        lblDescription.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setText("Select a game an press \"Load Game\" to resume play!");
        getContentPane().add(lblDescription);
        lblDescription.setBounds(0, 200, 940, 26);

        btnClearSavedGames.setBackground(new java.awt.Color(0, 102, 255));
        btnClearSavedGames.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnClearSavedGames.setForeground(new java.awt.Color(255, 255, 255));
        btnClearSavedGames.setText("Clear Saved Games");
        btnClearSavedGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSavedGamesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearSavedGames);
        btnClearSavedGames.setBounds(350, 600, 240, 40);

        btnLoadGame.setBackground(new java.awt.Color(0, 102, 255));
        btnLoadGame.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLoadGame.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadGame.setText("Load Game");
        btnLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoadGame);
        btnLoadGame.setBounds(100, 600, 210, 40);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_assets/leaderboard-background.png"))); // NOI18N
        lblBackground.setText("jLabel1");
        lblBackground.setMaximumSize(new java.awt.Dimension(940, 788));
        lblBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        lblBackground.setName(""); // NOI18N
        lblBackground.setPreferredSize(new java.awt.Dimension(940, 850));
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 940, 788);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadGameActionPerformed
        // TODO add your handling code here:
        int rowSelected = tblSavedGames.getSelectedRow();
        
        if (rowSelected != -1) {
            ArrayList <SavedGame> gamesPlayed = CurrentUser.getUser().getGames();
            String gameType = gamesPlayed.get(rowSelected).getGameType();
            String opponentType = gamesPlayed.get(rowSelected).getOpponentType();
            if (gameType.equals("NORMAL")) {
                if (opponentType.equals("AI")) {
                    String[] board = gamesPlayed.get(rowSelected).getPosition().split(":");
                    System.out.println(gamesPlayed.get(rowSelected).getPosition());
                    NormalTicTacToeAIFrame frmTicTacToeAI = new NormalTicTacToeAIFrame();
                    frmTicTacToeAI.setGameProperties(gamesPlayed.get(rowSelected).getAIDifficulty().toLowerCase(), gamesPlayed.get(rowSelected).getPlayer1Piece().equals("X") ? "O" : "X", gamesPlayed.get(rowSelected).getPlayer1Piece(), board);
                    frmTicTacToeAI.setVisible(true);
                    this.dispose();
                }
                else {

                }
            }
            else {
                if (opponentType.equals("AI")) {

                }
                else {

                }
            } 
        }
        else {
            JOptionPane.showMessageDialog(this, "Select a single row", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnLoadGameActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(CurrentUser.getUser() == null) {
            LoginFrame frmLogin = new LoginFrame();
            frmLogin.setVisible(true);
            this.dispose();
        }
        else {
            UserDatabase.loadDatabase();
            displaySavedGames();
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnGoToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToMainActionPerformed
        // TODO add your handling code here:
        MainMenuFrame frmMainMenu = new MainMenuFrame(); 
        frmMainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGoToMainActionPerformed

    private void btnClearSavedGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSavedGamesActionPerformed
        // TODO add your handling code here:
        CurrentUser.getUser().clearGames();
        displaySavedGames();
    }//GEN-LAST:event_btnClearSavedGamesActionPerformed

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
            java.util.logging.Logger.getLogger(SavedGamesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavedGamesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavedGamesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavedGamesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new SavedGamesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearSavedGames;
    private javax.swing.JButton btnGoToMain;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblSavedGames;
    // End of variables declaration//GEN-END:variables
}
