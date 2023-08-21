/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ludusultimatetictactoe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

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
        
        ultBoard = new UltTTT(btnArray, "X", "Easy");
        
        if (ultBoard.getPlayerPiece().equals("O")) // ai goes first
        {
            ultBoard.moveAI();
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

        jLabel1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ulitmate Tic Tac Toe");

        panButtons.setBackground(new java.awt.Color(0, 0, 153));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            
            panel.add(btnArray[i]);
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
        
        System.out.println(result);
        
        if (result.equals("MoveMade"))
        {
            ultBoard.moveAI();
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
    private javax.swing.JLabel jLabel1;
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
