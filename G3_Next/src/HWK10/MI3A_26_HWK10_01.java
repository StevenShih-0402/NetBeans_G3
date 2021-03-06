/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author steve
 */
public class MI3A_26_HWK10_01 extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form MI3A_26_HWK10_01
     */
    DefaultListModel lm1 = new DefaultListModel();
    DefaultListModel lm2 = new DefaultListModel();
    String path = "D:/Data/HWK10/menu.txt";
    boolean hasData = false;
    String[] item, price;
    int listPriceTotal = 0;
    
    public MI3A_26_HWK10_01(){
        initComponents();
        menu.setModel(lm1);
        list.setModel(lm2);
        try{
            loadMenu(lm1);
        }catch(IOException e){
            e.printStackTrace();
        }
        this.add.addActionListener(this);
        this.del.addActionListener(this);
        
        count.setText("1");
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            loadToList();
        }
        else if(e.getSource() == del){
            delList();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        menu = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        count = new javax.swing.JTextField();
        money = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        del = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setToolTipText("");
        jScrollPane1.setViewportView(menu);

        jScrollPane2.setViewportView(list);

        add.setText("ADD");

        del.setText("DEL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(count, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(del)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(del))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadMenu(DefaultListModel lm) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line, total = "";
            while((line=br.readLine()) != null){
                total += line+"\n";
            }
            String[] itemPrice = total.split("\n");
            item = new String[itemPrice.length];
            price = new String[itemPrice.length];
            int cnt = 0;
            
            if(!hasData){
                for(String s : itemPrice){
                    item[cnt] = s.split(",")[0];
                    price[cnt] = s.split(",")[1];
                    
                    lm.addElement(item[cnt++]);
                }
                hasData = true;
            }   
        }
    }
    
    public void loadToList(){
        int[] indices = menu.getSelectedIndices();
        for(int i : indices){
            int priMulCount = Integer.parseInt(price[i]) * Integer.parseInt(count.getText());
            lm2.addElement(lm1.getElementAt(i) + "->" + priMulCount);
            listPriceTotal += priMulCount;
        }
        money.setText(String.valueOf(listPriceTotal));
    }
    
    public void delList(){
        int[] indices = list.getSelectedIndices();
        for(int i : indices){
            String priCount = lm2.getElementAt(i).toString().split("->")[1];
            lm2.removeElementAt(i);
            listPriceTotal -= Integer.parseInt(priCount);
        }
        money.setText(String.valueOf(listPriceTotal));
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
            java.util.logging.Logger.getLogger(MI3A_26_HWK10_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK10_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK10_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK10_01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MI3A_26_HWK10_01().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField count;
    private javax.swing.JButton del;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list;
    private javax.swing.JList<String> menu;
    private javax.swing.JTextField money;
    // End of variables declaration//GEN-END:variables
}
