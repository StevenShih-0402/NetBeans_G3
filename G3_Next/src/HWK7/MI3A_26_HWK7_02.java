/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK7;

/**
 *
 * @author steve
 */


public class MI3A_26_HWK7_02 extends javax.swing.JFrame {

    /**
     * Creates new form MI3A_26_HWK7_02
     */
    public static int totalMoney = 99;
    public MI3A_26_HWK7_02() {
        initComponents();
        showMoney();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RBG = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboA = new javax.swing.JRadioButton();
        comboB = new javax.swing.JRadioButton();
        comboC = new javax.swing.JRadioButton();
        add1 = new javax.swing.JCheckBox();
        add2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Klee One SemiBold", 0, 18)); // NOI18N
        jLabel1.setText("總金額：");

        total.setFont(new java.awt.Font("Klee One", 0, 18)); // NOI18N
        total.setText("0");

        jLabel2.setFont(new java.awt.Font("Klee One SemiBold", 0, 14)); // NOI18N
        jLabel2.setText("(主餐一律99元)");

        RBG.add(comboA);
        comboA.setFont(new java.awt.Font("Klee One SemiBold", 0, 16)); // NOI18N
        comboA.setText("A套餐(50元)");
        comboA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAActionPerformed(evt);
            }
        });

        RBG.add(comboB);
        comboB.setFont(new java.awt.Font("Klee One SemiBold", 0, 16)); // NOI18N
        comboB.setText("B套餐(70元)");
        comboB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBActionPerformed(evt);
            }
        });

        RBG.add(comboC);
        comboC.setFont(new java.awt.Font("Klee One SemiBold", 0, 16)); // NOI18N
        comboC.setText("C套餐(80元)");
        comboC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCActionPerformed(evt);
            }
        });

        add1.setFont(new java.awt.Font("Klee One SemiBold", 0, 16)); // NOI18N
        add1.setText("飲料加大(+5元)");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        add2.setFont(new java.awt.Font("Klee One SemiBold", 0, 16)); // NOI18N
        add2.setText("薯條加大(+5元)");
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboC)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboA)
                                    .addComponent(comboB))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add2)
                                    .addComponent(add1))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboA)
                    .addComponent(add1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboB)
                    .addComponent(add2))
                .addGap(10, 10, 10)
                .addComponent(comboC)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAActionPerformed
        // TODO add your handling code here:
        cul();
    }//GEN-LAST:event_comboAActionPerformed
    private void comboBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBActionPerformed
        // TODO add your handling code here:
        cul();
    }//GEN-LAST:event_comboBActionPerformed
    private void comboCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCActionPerformed
        // TODO add your handling code here:
        cul();
    }//GEN-LAST:event_comboCActionPerformed
    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        cul();
    }//GEN-LAST:event_add1ActionPerformed
    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        // TODO add your handling code here:
        cul();
    }//GEN-LAST:event_add2ActionPerformed

    void showMoney(){
        total.setText(String.valueOf(totalMoney));
    }
    void add(int money){
        totalMoney += money;
    }
    void sub(int money){
        totalMoney -= money;
    }
        
    void cul(){
        totalMoney = 99;
        if(comboA.isSelected()){
            add(50);
        }
        else if(comboB.isSelected()){
            add(70);
        }
        else if(comboC.isSelected()){
            add(80);
        }

        if(add1.isSelected()){
            add(5);
        }
        if(add2.isSelected()){
            add(5);
        }
        showMoney();
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
            java.util.logging.Logger.getLogger(MI3A_26_HWK7_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK7_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK7_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK7_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MI3A_26_HWK7_02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RBG;
    private javax.swing.JCheckBox add1;
    private javax.swing.JCheckBox add2;
    private javax.swing.JRadioButton comboA;
    private javax.swing.JRadioButton comboB;
    private javax.swing.JRadioButton comboC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}