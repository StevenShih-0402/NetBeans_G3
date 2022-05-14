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
class glo{
    public static int number = 0;
}

public class MI3A_26_HWK7_01 {
    public static void main(String[] args){
        ControlFrame cf = new ControlFrame();
        DisplayFrame df = new DisplayFrame();
        cf.setVisible(true);
        df.setVisible(true);
        
        while(true){
            df.setNum();
        }
    }
}
