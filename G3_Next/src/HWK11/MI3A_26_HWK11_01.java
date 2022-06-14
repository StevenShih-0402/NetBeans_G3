/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steve
 */
public class MI3A_26_HWK11_01 extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form MI3A_26_HWK11_01
     */
    JTextField boxText = new JTextField();
    JButton clear = new JButton("Clear");
    DefaultTableModel dtm = new DefaultTableModel(0,4);     // Row, column
    int[] rs, cs;
    
    public MI3A_26_HWK11_01() {
        initComponents();
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        
        box.setModel(dtm);
        
        Object[][] data = {{1,2,3,4},{5,6,7,8}};
        String[] title = {"Title1", "Title2", "Title3", "Title4"};
        dtm.setDataVector(data, title);
        
        cp.add(boxText, BorderLayout.NORTH);
        cp.add(boxScroll, BorderLayout.CENTER);
        cp.add(clear, BorderLayout.SOUTH);
        
        boxText.addActionListener(this);
        clear.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boxText){
            int c = box.getSelectedColumn();
            int r = box.getSelectedRow();
            
            dtm.setValueAt(boxText.getText(), r, c);
        }
        else if(e.getSource() == clear){
            for(int i : rs){
                for(int j : cs){
                    dtm.setValueAt("", i, j);
                }
            }
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

        boxScroll = new javax.swing.JScrollPane();
        box = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        box.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        box.setCellSelectionEnabled(true);
        box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxMouseReleased(evt);
            }
        });
        boxScroll.setViewportView(box);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boxScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boxScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMouseClicked
        // TODO add your handling code here:
        int c = box.getSelectedColumn();
        int r = box.getSelectedRow();
        
        boxText.setText(String.valueOf(dtm.getValueAt(r, c)));
    }//GEN-LAST:event_boxMouseClicked

    private void boxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMouseReleased
        // TODO add your handling code here:
        cs = box.getSelectedColumns();
        rs = box.getSelectedRows();
    }//GEN-LAST:event_boxMouseReleased

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
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MI3A_26_HWK11_01().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable box;
    private javax.swing.JScrollPane boxScroll;
    // End of variables declaration//GEN-END:variables
}
