/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

/**
 *
 * @author steve
 */
public class MI3A_26_01 {
    public static void main(String[] args){
        
       new Thread(()->{
            for(int j = 0; j < 20; j++){
                System.out.println("[" + j + "]AAA");
            }
        }).start();
       
       new Thread(()->{
            for(int j = 0; j < 20; j++){
                System.out.println("[" + j + "]BBB");
            }
        }).start();
       
       new Thread(()->{
            for(int j = 0; j < 20; j++){
                System.out.println("[" + j + "]CCC");
            }
        }).start();
        
    }
}
