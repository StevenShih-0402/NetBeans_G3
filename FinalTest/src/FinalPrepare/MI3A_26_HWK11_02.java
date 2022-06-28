/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalPrepare;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author steve
 */
public class MI3A_26_HWK11_02 extends javax.swing.JFrame {

    /**
     * Creates new form MI3A_26_HWK11_02
     */
    TreeModel tm;
    String path = "D:/Data/HWK11/data.txt";
    int childNo = -1;
    
    public MI3A_26_HWK11_02() {
        initComponents();
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(treeArea, BorderLayout.CENTER);
        cp.add(nodeDataArea, BorderLayout.SOUTH);
        cp.add(controlArea, BorderLayout.EAST);
        try {
            initTreeModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tree.setModel(tm);
        
    }
    
    public void initTreeModel() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            DefaultMutableTreeNode root = null, subNode = null;
            while ((line = br.readLine()) != null) {
                if(line.substring(0, 2).equals("**")){
                    subNode = (DefaultMutableTreeNode) root.getChildAt(childNo);
                    subNode.add(new DefaultMutableTreeNode(line.replace("**", "")));
                    
                }
                else if(line.substring(0, 1).equals("*")){
                    subNode = new DefaultMutableTreeNode(line.replace("*", ""));
                    root.add(subNode);
                    childNo++;
                }
                else{
                    root = new DefaultMutableTreeNode(line);
                    tm = new DefaultTreeModel(root);
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

        treeArea = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        controlArea = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        newName = new javax.swing.JTextField();
        nodeDataArea = new javax.swing.JPanel();
        deep = new javax.swing.JTextField();
        name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
        treeArea.setViewportView(tree);

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlAreaLayout = new javax.swing.GroupLayout(controlArea);
        controlArea.setLayout(controlAreaLayout);
        controlAreaLayout.setHorizontalGroup(
            controlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newName)
                    .addGroup(controlAreaLayout.createSequentialGroup()
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(remove)))
                .addContainerGap())
        );
        controlAreaLayout.setVerticalGroup(
            controlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(remove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        nodeDataArea.setLayout(new java.awt.GridLayout(1, 2));
        nodeDataArea.add(deep);
        nodeDataArea.add(name);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nodeDataArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(treeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(controlArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(controlArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(treeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nodeDataArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged
        // TODO add your handling code here:
        TreePath tp = evt.getPath();
        DefaultMutableTreeNode nodeData = (DefaultMutableTreeNode) tp.getLastPathComponent();
        
        deep.setText("深度：" + String.valueOf(tp.getPathCount()));
        name.setText((String)nodeData.getUserObject());
    }//GEN-LAST:event_treeValueChanged

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        TreePath tp = tree.getSelectionModel().getLeadSelectionPath();
        DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) tp.getLastPathComponent();
        
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newName.getText());
        DefaultTreeModel dtm = (DefaultTreeModel) tree.getModel();
        dtm.insertNodeInto(newNode, lastNode, lastNode.getChildCount());
        
        newName.setText("");
    }//GEN-LAST:event_addActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        TreePath tp = tree.getSelectionModel().getLeadSelectionPath();
        DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) tp.getLastPathComponent();
        
        DefaultTreeModel dtm = (DefaultTreeModel)tree.getModel();
        if(lastNode == dtm.getRoot()){
            System.out.println("殺人豬心！");
        }
        else{
            dtm.removeNodeFromParent(lastNode);
        }    
    }//GEN-LAST:event_removeActionPerformed

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
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK11_02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MI3A_26_HWK11_02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JPanel controlArea;
    private javax.swing.JTextField deep;
    private javax.swing.JTextField name;
    private javax.swing.JTextField newName;
    private javax.swing.JPanel nodeDataArea;
    private javax.swing.JButton remove;
    private javax.swing.JTree tree;
    private javax.swing.JScrollPane treeArea;
    // End of variables declaration//GEN-END:variables
}
