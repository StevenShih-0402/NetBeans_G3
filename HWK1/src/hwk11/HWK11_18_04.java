/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk11;

/**
 *
 * @author steve
 */
import java.awt.* ;
import javax.swing.* ;
class Frame9 extends JFrame {
    int r=3, c=3 ; // 3列, 3欄
    JButton[] btns = new JButton[r*c] ; // r*c=9
    Frame9() {
        Container cp = getContentPane() ;       //視窗管理物件
        cp.setLayout(null) ;                                //用絕對座標放置元件
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //關閉視窗時結束程式
        
        // 畫面布置
        int x=0, y=0, w=50, h=50; // (x,y):第一個按鈕左上角座標
        // Version 1: 選一種版本來實作即可
//        for (int i=0; i<btns.length; i++) {
//            if(i % 3 == 0 && i != 0){
//                x = 0;
//                y += h;
//            }
//            btns[i] = new JButton(String.format("%d", i+1));
//            cp.add(btns[i]);
//            btns[i].setBounds(x, y, w, h);
//            x += w;
//        }
        
        // Version 2:
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if(i != 0 && j == 0){
                    x = 0;
                    y += h;
                }
                btns[i*3+j] = new JButton(String.format("%s", i*3+j+1));
                cp.add(btns[i*3+j]);
                btns[i*3+j].setBounds(x, y, w, h);
                
                x += w;
            }
        }        
    }
}

public class HWK11_18_04 {
    public static void main(String[] args) {
        Frame9 f9 = new Frame9() ;
        f9.setSize(200,200) ;
        f9.setVisible(true) ;
    }
}
