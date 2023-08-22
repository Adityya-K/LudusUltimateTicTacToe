/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to create a user profile page
 * 
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;


// Imports LoginFrame and CurrentUser
import authentication_frames.LoginFrame;
import user.CurrentUser;

/**
 *
 * @author gaudium
 */
public class UserProfileFrame extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public UserProfileFrame() {
        
        // Displays the JFrame at the center position of the screen
        setSize(938, 788);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        initComponents();
        
        // Gets the current user if it is null
        if (CurrentUser.getUser() != null) {
            lblUsername.setText("Username: " + CurrentUser.getUser().getUsername());
            lblWins.setText("Wins: " + CurrentUser.getUser().getWins());
            lblLosses.setText("Losses: " + CurrentUser.getUser().getLosses());
            lblStartDate.setText("Date Joined: " + CurrentUser.getUser().getDateJoined());
            lblRating.setText("Rating: " + (int)(CurrentUser.getUser().getRating()));
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
        btnGoToMain = new javax.swing.JButton();
        lblWins = new javax.swing.JLabel();
        lblLosses = new javax.swing.JLabel();
        lblRating = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
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
        lblTitle.setText("USER PROFILE");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 100, 940, 50);

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
        btnGoToMain.setBounds(470, 580, 250, 40);

        lblWins.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblWins.setForeground(new java.awt.Color(255, 255, 255));
        lblWins.setText("Wins:");
        getContentPane().add(lblWins);
        lblWins.setBounds(260, 290, 430, 33);

        lblLosses.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblLosses.setForeground(new java.awt.Color(255, 255, 255));
        lblLosses.setText("Losses:");
        getContentPane().add(lblLosses);
        lblLosses.setBounds(260, 360, 430, 33);

        lblRating.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblRating.setForeground(new java.awt.Color(255, 255, 255));
        lblRating.setText("Rating: ");
        getContentPane().add(lblRating);
        lblRating.setBounds(260, 500, 430, 33);

        lblUsername.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username:");
        getContentPane().add(lblUsername);
        lblUsername.setBounds(260, 220, 430, 33);

        lblStartDate.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblStartDate.setForeground(new java.awt.Color(255, 255, 255));
        lblStartDate.setText("Date Joined: ");
        getContentPane().add(lblStartDate);
        lblStartDate.setBounds(260, 430, 430, 33);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_assets/user-profile-background.png"))); // NOI18N
        lblBackground.setText("jLabel1");
        lblBackground.setMaximumSize(new java.awt.Dimension(940, 788));
        lblBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        lblBackground.setName(""); // NOI18N
        lblBackground.setPreferredSize(new java.awt.Dimension(940, 850));
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 940, 788);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToMainActionPerformed
        // TODO add your handling code here:
        
        // Displays the main menu
        MainMenuFrame frmMainMenu = new MainMenuFrame(); 
        frmMainMenu.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnGoToMainActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        // Displays the login page if the current user is null when the window is opened
        if(CurrentUser.getUser() == null) {
            LoginFrame frmLogin = new LoginFrame();
            frmLogin.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(UserProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UserProfileFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoToMain;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblLosses;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWins;
    // End of variables declaration//GEN-END:variables
}
