
package snake;

import javax.swing.JFrame;      
/*
   GUI:圖形使用者介面(Graphical User Interface)
   javax: Java內建的API包之一
   Swing: javax裡的套件，是一個輕量級的GUI類別庫
   JFrame: Swing裡的類別，可以建立一個視窗擺放GUI元件(窗口類)
*/

public class GameFrame extends JFrame{
    GameFrame(){
        this.add(new GamePanel());                                                      //加入一個新的GamePanel(等同於 GamePanel panel = new GamePanel(); this.add(panel);)
        this.setTitle("Snake");                                                                //JFrame建立的視窗標題
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //設定使用者在視窗上發起"close"時要執行的動作，EXIT_ON_CLOSE表示使用System.exit()的方法退出應用程式
        this.setResizable(false);                                                              //設定視窗是否能被縮放
        this.pack();                                                                                  //使視窗擴展到足以容納所有元件
        this.setVisible(true);                                                                   //設定元件的可見性(要有這行視窗才能被看見)
        this.setLocationRelativeTo(null);                                               //設定視窗相對於指定元件的位置，如果是null，則視窗會放在螢幕中央
        
    }
}
