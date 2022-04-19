/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK2;

/**
 *
 * @author steve
 */
import javax.swing.* ; // for JFrame
import java.awt.* ; // for Graphics
//==CounterFrame: 需能多緒執行(implements Runnable)，又得具有視窗外觀(extends JFrame)
class CounterFrame extends JFrame { 
    double delayInSec = 0.2;
    int mode = -1, no = 0 ; 
    CounterFrame(int x, int y, int w, int h, double delay) {
        setBounds(x,y,w,h) ;
        setVisible(true) ;
        delayInSec = delay ;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void count() { 
        no = 100 ; 
        repaint(); //會呼叫paint();
        Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0 ; i<100 ; i++) { 
                    no = i;
                    repaint(); // 在視窗印製整數i, repaint()會間接呼叫paint(); 
                    delay(delayInSec) ; // 延遲delayInSec秒
                 }
            }
        });
        t.start();
    }
    public void paint(Graphics g) { //在視窗畫面中央繪製數字
        int w = getWidth(), h = getHeight() ;
        g.clearRect(0,0, w,h) ; //清除畫面
        g.drawString(Integer.toString(no), w/2, h/2) ; // 在畫面中央印出數字
    }
    void delay(double sec){
        try{
            Thread.sleep((int)(1000*delayInSec));
        }catch(Exception e) {

        }
    }
}
public class MI3A_26_HWK2_03{
    public static void main(String[] args) {
            CounterFrame cf1 = new CounterFrame(0, 0, 50,100, 0.2) ;  //x, y, w, h, delay
            CounterFrame cf2 = new CounterFrame(121, 0, 50,100, 0.5) ;
            cf1.count(); 
            cf2.count() ;
    }
}
