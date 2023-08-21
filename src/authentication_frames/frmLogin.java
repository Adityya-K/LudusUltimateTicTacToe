/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package authentication_frames;

import javax.swing.JFrame;

/**
 *
 * @author gaudium
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        setSize(940, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
        initComponents();
        String createAccount = "<HTML>Don't have an account? <u>Create one!</u></HTML>";
        String forgotPassword = "<HTML><u>Forgot Password?</u></HTML>";
        lblForgotPassword.setText(forgotPassword);
        lblCreateAccount.setText(createAccount);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblForgotPassword = new javax.swing.JLabel();
        lblCreateAccount = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(940, 850));
        setMinimumSize(new java.awt.Dimension(940, 788));
        setPreferredSize(new java.awt.Dimension(940, 788));
        getContentPane().setLayout(null);

        lblForgotPassword.setBackground(new java.awt.Color(255, 255, 255));
        lblForgotPassword.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblForgotPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblForgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForgotPassword.setText("Forgot Password?");
        lblForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lblForgotPassword);
        lblForgotPassword.setBounds(0, 580, 940, 26);

        lblCreateAccount.setBackground(new java.awt.Color(255, 255, 255));
        lblCreateAccount.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblCreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblCreateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateAccount.setText("Create an account");
        lblCreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lblCreateAccount);
        lblCreateAccount.setBounds(0, 540, 940, 26);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(260, 400, 430, 50);
        getContentPane().add(txtUsername);
        txtUsername.setBounds(260, 270, 430, 50);

        lblPassword.setBackground(new java.awt.Color(255, 255, 255));
        lblPassword.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password:");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(260, 340, 150, 33);

        lblUsername.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username:");
        getContentPane().add(lblUsername);
        lblUsername.setBounds(260, 220, 150, 33);

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("LOGIN");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 150, 940, 50);

        btnLogin.setBackground(new java.awt.Color(0, 102, 255));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        getContentPane().add(btnLogin);
        btnLogin.setBounds(260, 480, 430, 40);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_assets/login-background.png"))); // NOI18N
        lblBackground.setText("jLabel1");
        lblBackground.setMaximumSize(new java.awt.Dimension(940, 788));
        lblBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        lblBackground.setName(""); // NOI18N
        lblBackground.setPreferredSize(new java.awt.Dimension(940, 788));
        getContentPane().add(lblBackground);
        lblBackground.setBounds(-2, -10, 940, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCreateAccount;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
