/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalPrepare;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author steve
 */
public class MI3A_26_01 extends javax.swing.JFrame {

    /**
     * Creates new form MI3A_26_01
     */
    ImageIcon[] imgs = new ImageIcon[6];
    int[] images = new int[6];
    
    public MI3A_26_01() {
        initComponents();
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(load, BorderLayout.NORTH);
        cp.add(picScroll, BorderLayout.CENTER);
        cp.add(right, BorderLayout.SOUTH);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        load = new javax.swing.JButton();
        right = new javax.swing.JButton();
        picScroll = new javax.swing.JScrollPane();
        picArea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        load.setText("Load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        right.setText("Rotate Right");
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        picArea.setLayout(new java.awt.GridLayout(1, 6));
        picArea.add(jLabel1);
        picArea.add(jLabel2);
        picArea.add(jLabel3);
        picArea.add(jLabel4);
        picArea.add(jLabel5);
        picArea.add(jLabel6);

        picScroll.setViewportView(picArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 139, Short.MAX_VALUE)
                        .addComponent(right)
                        .addGap(164, 164, 164))
                    .addComponent(picScroll)))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(load)
                .addGap(18, 18, 18)
                .addComponent(picScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(right)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < imgs.length; i++){
            imgs[i] = new ImageIcon("D:/Data/duke/duke0" + i + ".gif");
            images[i] = i;
        }
        insertImg();
    }//GEN-LAST:event_loadActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        // TODO add your handling code here:
        int temp = images[images.length-1];
        for(int i = images.length-1; i > 0; i--){
            images[i] = images[i-1];
        }
        images[0] = temp;
        insertImg();
    }//GEN-LAST:event_rightActionPerformed

    public void insertImg(){
        this.jLabel1.setIcon(imgs[images[0]]);
        this.jLabel2.setIcon(imgs[images[1]]);
        this.jLabel3.setIcon(imgs[images[2]]);
        this.jLabel4.setIcon(imgs[images[3]]);
        this.jLabel5.setIcon(imgs[images[4]]);
        this.jLabel6.setIcon(imgs[images[5]]);
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
            java.util.logging.Logger.getLogger(MI3A_26_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MI3A_26_01().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton load;
    private javax.swing.JPanel picArea;
    private javax.swing.JScrollPane picScroll;
    private javax.swing.JButton right;
    // End of variables declaration//GEN-END:variables
}