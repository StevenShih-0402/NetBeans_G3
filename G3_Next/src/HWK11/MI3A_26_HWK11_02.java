/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author steve
 */
public class MI3A_26_HWK11_02 extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form MI3A_26_HWK11_02
     */
    TreeModel tm;
    String path = "D:/Data/HWK11/data.txt";
    int childNo = -1;
    
    JPanel fieldArea = new JPanel();
    JPanel btnArea = new JPanel();
    JTextField deep = new JTextField();
    JTextField text = new JTextField();
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    JTextField newName = new JTextField();
    
    public MI3A_26_HWK11_02() {
        initComponents();
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        fieldArea.setLayout(new GridLayout(1,2));     // Row, Column
        fieldArea.add(deep);
        fieldArea.add(text);
        
        btnArea.setPreferredSize(new Dimension(170, HEIGHT));
        newName.setPreferredSize(new Dimension(150, 30));
        btnArea.add(add);
        btnArea.add(remove);
        btnArea.add(newName);
        
        cp.add(treeScroll, BorderLayout.CENTER);
        cp.add(fieldArea, BorderLayout.SOUTH);
        cp.add(btnArea, BorderLayout.EAST);
        try{
            buildTreeModel();
        }catch(Exception e){
            e.printStackTrace();
        }
        tree.setModel(tm);
        
        add.addActionListener(this);
        remove.addActionListener(this);
    }
    
    public void buildTreeModel() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            DefaultMutableTreeNode temp, root = null;
            while((line = br.readLine()) != null){
                
                // Level2(**)
                if(line.substring(0, 2).equals("**")){
                    temp = (DefaultMutableTreeNode)root.getChildAt(childNo);
                    temp.add(new DefaultMutableTreeNode(line.substring(2, line.length())) );
                }
                
                // Level1(*)
                else if(line.substring(0, 1).equals("*")){
                    temp = new DefaultMutableTreeNode(line.substring(1, line.length()));
                    root.add(temp);
                    childNo++;
                }
                
                // Level0(root)
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

        treeScroll = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
        treeScroll.setViewportView(tree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(treeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(treeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged
        // TODO add your handling code here:
        TreePath tp = evt.getPath();        // 取得節點路徑
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tp.getLastPathComponent();        // 取得路徑的最後一項，即選取的節點
        
        deep.setText("深度：" + tp.getPathCount());
        text.setText((String)node.getUserObject());
    }//GEN-LAST:event_treeValueChanged

    public void actionPerformed(ActionEvent ex){
        TreePath tp = tree.getSelectionModel().getLeadSelectionPath();
        DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode)tp.getLastPathComponent();
        
        if(ex.getSource() == add){
            if(newName.getText() != null){
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newName.getText());
                DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
                treeModel.insertNodeInto(newNode, lastNode, lastNode.getChildCount());
                newName.setText("");
            }
        }
        else if(ex.getSource() == remove){
            if(lastNode == tree.getModel().getRoot()){
                JOptionPane.showMessageDialog(this, "有話好說，沒必要斬草除根。");
            }
            else{
                DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
                treeModel.removeNodeFromParent(lastNode);
            }
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
    private javax.swing.JTree tree;
    private javax.swing.JScrollPane treeScroll;
    // End of variables declaration//GEN-END:variables
}