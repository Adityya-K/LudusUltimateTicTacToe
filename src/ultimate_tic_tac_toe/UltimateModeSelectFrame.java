/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ultimate_tic_tac_toe;

import menu.*;
import javax.swing.JFrame;

/**
 *
 * @author gaudium
 */
public class UltimateModeSelectFrame extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public UltimateModeSelectFrame() {
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
        btnPVE = new javax.swing.JButton();
        btnToMainMenu = new javax.swing.JButton();
        btnPVP = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(938, 788));
        getContentPane().setLayout(null);

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("MODE SELECT (ULTIMATE)");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 220, 940, 50);

        btnPVE.setBackground(new java.awt.Color(0, 102, 255));
        btnPVE.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnPVE.setForeground(new java.awt.Color(255, 255, 255));
        btnPVE.setText("Play Against The Computer");
        btnPVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPVEActionPerformed(evt);
            }
        });
        getContentPane().add(btnPVE);
        btnPVE.setBounds(260, 400, 430, 60);

        btnToMainMenu.setBackground(new java.awt.Color(0, 102, 255));
        btnToMainMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnToMainMenu.setText("Go To Main Menu");
        btnToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToMainMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnToMainMenu);
        btnToMainMenu.setBounds(260, 490, 430, 60);

        btnPVP.setBackground(new java.awt.Color(0, 102, 255));
        btnPVP.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnPVP.setForeground(new java.awt.Color(255, 255, 255));
        btnPVP.setText("Player Vs Player (Local Game)");
        btnPVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPVPActionPerformed(evt);
            }
        });
        getContentPane().add(btnPVP);
        btnPVP.setBounds(260, 310, 430, 60);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_assets/select-mode-background.png"))); // NOI18N
        lblBackground.setText("jLabel1");
        lblBackground.setMaximumSize(new java.awt.Dimension(940, 788));
        lblBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        lblBackground.setName(""); // NOI18N
        lblBackground.setPreferredSize(new java.awt.Dimension(940, 788));
        getContentPane().add(lblBackground);
        lblBackground.setBounds(-2, -10, 950, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPVEActionPerformed
        // TODO add your handling code here:
        UltimateComputerSelectFrame frmComputerSelect = new UltimateComputerSelectFrame();
        frmComputerSelect.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPVEActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // TODO add your handling code here:
        MainMenuFrame frmMainMenu = new MainMenuFrame();
        frmMainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnToMainMenuActionPerformed

    private void btnPVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPVPActionPerformed
        // TODO add your handling code here:
        UltimateTicTacToeFrame frmUltimateTicTacToe = new UltimateTicTacToeFrame();
        frmUltimateTicTacToe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPVPActionPerformed

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
            java.util.logging.Logger.getLogger(UltimateModeSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UltimateModeSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UltimateModeSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UltimateModeSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UltimateModeSelectFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPVE;
    private javax.swing.JButton btnPVP;
    private javax.swing.JButton btnToMainMenu;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
