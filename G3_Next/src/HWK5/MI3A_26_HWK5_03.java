/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HWK5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JTextArea;

/**
 *
 * @author jscha
 */
public class MI3A_26_HWK5_03 extends javax.swing.JFrame {

    /**
     * Creates new form P164_Demo_GoogleSearch
     */
    public MI3A_26_HWK5_03() {
        initComponents();
        setSize(600,600) ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        article = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        search.setPreferredSize(new java.awt.Dimension(400, 35));
        search.setLayout(new java.awt.BorderLayout());
        search.add(searchBar, java.awt.BorderLayout.CENTER);

        searchButton.setText("Google");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        search.add(searchButton, java.awt.BorderLayout.LINE_END);

        getContentPane().add(search, java.awt.BorderLayout.PAGE_START);

        article.setColumns(20);
        article.setLineWrap(true);
        article.setRows(5);
        scroll.setViewportView(article);

        getContentPane().add(scroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        doSearch() ;
    }//GEN-LAST:event_searchButtonActionPerformed
    public void doSearch(){  
      try {
        // === 準備查詢字串(query string), 產生URL物件
        String part1 = "https://www.google.com.tw/search?hl=zh-TW&q=" ;
        String qString = URLEncoder.encode(searchBar.getText(),"Big5"); 
        String part2 = "&meta=&aq=f&gws_rd=ssl";         
        URL url = new URL(part1+qString+part2) ;
        System.out.println(url.toExternalForm()) ;                  // 顯示Google搜尋結果的網址
        
        // === 假裝本連線是瀏覽器，以免HTTP Server阻攔, 另可看HttpsURLConnection
        HttpsURLConnection uc = (HttpsURLConnection) url.openConnection(); 
        uc.addRequestProperty("User-Agent", " Firefox/3.0.10"); 

        InputStreamReader isr = new InputStreamReader(uc.getInputStream(),"Big5") ; // or utf-8
        String inputLine="", allStr="", writePlace="D:/Data/HWK5/MI3A_HWK5_03.txt";
        try(BufferedReader br = new BufferedReader(isr) ;){
            while ((inputLine = br.readLine()) != null) {
                System.out.println("\n---Start Running---\n");
                allStr+=(inputLine+"\n");
                getSearch(inputLine, writePlace, article);
                
            }
        }
        article.setText(allStr) ;
      } catch (Exception e) { 
          e.printStackTrace(); 
      }
    }
   
    public static void getSearch(String inputline, String writePlace, JTextArea article) throws IOException{
        inputline = inputline.replaceAll("fuLhoc ", "");
        String[] getTitle = inputline.split("<span class=\"CVA68e qXLe6d\">");
        String[] getLink = inputline.split("<a class=\"ZWRArf\" href=\"");
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(writePlace))){
            for(int i = 1; i < getTitle.length; i++){
                String reg1 = getTitle[i].substring(0, getTitle[i].indexOf("<"));
                String reg2 = getLink[i].substring(getLink[i].indexOf("=")+1, getLink[i].indexOf("&"));
                if(!(reg1.equals("  ") && reg2.equals("zh-TW"))){
                    bw.write("# " + reg1);
                    bw.newLine();
                    System.out.println("# "+reg1);
                    
                    bw.write(reg2);
                    bw.newLine();
                    System.out.println(reg2+"\n");
                    
                    bw.newLine();
                }
            }
            System.out.println("\n---Finish get Title.---");
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
            java.util.logging.Logger.getLogger(MI3A_26_HWK5_03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK5_03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK5_03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MI3A_26_HWK5_03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MI3A_26_HWK5_03().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea article;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel search;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
