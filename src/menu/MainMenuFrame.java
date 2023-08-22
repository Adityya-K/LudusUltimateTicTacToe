/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;

import javax.swing.JFrame;
import normal_tic_tac_toe.NormalModeSelectFrame;
import ultimate_tic_tac_toe.UltimateModeSelectFrame;

/**
 *
 * @author gaudium
 */
public class MainMenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public MainMenuFrame() {
        setSize(938, 788);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        initComponents();
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
        btnUTTT = new javax.swing.JButton();
        btnLoginOut = new javax.swing.JButton();
        btnLeaderboard = new javax.swing.JButton();
        btnNTTT = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(938, 788));
        getContentPane().setLayout(null);

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("MENU");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 180, 940, 50);

        btnUTTT.setBackground(new java.awt.Color(0, 102, 255));
        btnUTTT.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnUTTT.setForeground(new java.awt.Color(255, 255, 255));
        btnUTTT.setText("Play Ultimate Tic Tac Toe");
        btnUTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTTTActionPerformed(evt);
            }
        });
        getContentPane().add(btnUTTT);
        btnUTTT.setBounds(260, 360, 430, 40);

        btnLoginOut.setBackground(new java.awt.Color(0, 102, 255));
        btnLoginOut.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLoginOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginOut.setText("Log Out");
        getContentPane().add(btnLoginOut);
        btnLoginOut.setBounds(260, 510, 430, 40);

        btnLeaderboard.setBackground(new java.awt.Color(0, 102, 255));
        btnLeaderboard.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLeaderboard.setForeground(new java.awt.Color(255, 255, 255));
        btnLeaderboard.setText("Leaderboard");
        btnLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnLeaderboard);
        btnLeaderboard.setBounds(260, 440, 430, 40);

        btnNTTT.setBackground(new java.awt.Color(0, 102, 255));
        btnNTTT.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnNTTT.setForeground(new java.awt.Color(255, 255, 255));
        btnNTTT.setText("Play Normal Tic Tac Toe");
        btnNTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNTTTActionPerformed(evt);
            }
        });
        getContentPane().add(btnNTTT);
        btnNTTT.setBounds(260, 280, 430, 40);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_assets/main-menu-background.png"))); // NOI18N
        lblBackground.setText("jLabel1");
        lblBackground.setMaximumSize(new java.awt.Dimension(940, 788));
        lblBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        lblBackground.setName(""); // NOI18N
        lblBackground.setPreferredSize(new java.awt.Dimension(940, 788));
        getContentPane().add(lblBackground);
        lblBackground.setBounds(-2, -10, 950, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNTTTActionPerformed
        // TODO add your handling code here:
        NormalModeSelectFrame frmNTTModeSelect = new NormalModeSelectFrame();
        frmNTTModeSelect.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNTTTActionPerformed

    private void btnUTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTTTActionPerformed
        // TODO add your handling code here:
        UltimateModeSelectFrame frmUTTModeSelect = new UltimateModeSelectFrame();
        frmUTTModeSelect.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUTTTActionPerformed

    private void btnLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaderboardActionPerformed
        // TODO add your handling code here:
        LeaderboardFrame frmLeaderboard = new LeaderboardFrame();
        frmLeaderboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLeaderboardActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeaderboard;
    private javax.swing.JButton btnLoginOut;
    private javax.swing.JButton btnNTTT;
    private javax.swing.JButton btnUTTT;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
