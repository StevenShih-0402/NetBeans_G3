/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK1;

/**
 *
 * @author steve
 */
import java.util.Random;
import java.util.Arrays;
class oprThread extends Thread{
    int[] a, b, c;
    char opr;
    
    oprThread(int[] a, int[] b, int[] c, char opr){
        this.a = a;
        this.b = b; 
        this.c = c;
        this.opr = opr;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < c.length; i++) {
            if (opr == '+') {
                c[i] = a[i] + b[i];
            } 
            else if (opr == '-') {
                c[i] = a[i] - b[i];
            } 
        }
    }
}
public class MI3A_26_HWK1_01{
    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[100], b = new int[100];
        int[] c = new int[100], d = new int[100];
        // … 亂數填入a[], b[]的值, 範圍[50,200]
        
        Random r = new Random(111);
        for(int i = 0; i < 100; i++){
            a[i] = r.nextInt(151)+50;
            b[i] = r.nextInt(151)+50;
        }
        
        long startTime = System.currentTimeMillis();
        
        oprThread t1 = new oprThread(a, b, c, '+');
        oprThread t2 = new oprThread(a, b, d, '-');
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        
        System.out.println("c = " + Arrays.toString(c));
        System.out.println("d = " + Arrays.toString(d));
    }

//    public static void operation(int[] a, int[] b, int[] c, char opr) {
//        for (int i = 0; i < c.length; i++) {
//            if (opr == '+') {
//                c[i] = a[i] + b[i];
//            } else if (opr == '-') {
//                c[i] = a[i] - b[i];
//            } 
////            else {
////                // DIY here, *, / or others
////            }
//        }
//    }
}
