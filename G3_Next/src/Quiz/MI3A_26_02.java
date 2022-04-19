/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author steve
 */
public class MI3A_26_02 {
    public static void main(String[] args) throws InterruptedException{
        int size = 20;
        int[] a = new int[size];
        int[] b = new int[size];
        int[] c = new int[size];
        int[] d = new int[size];
        
        int[][] dataSeq = {a,b,c,d};
        int[] seeds = {303, 222, 528, 109};
        int[] sum = new int[dataSeq.length];
        
        Thread[] ts = new Thread[dataSeq.length];
        for(int i = 0; i < dataSeq.length; i++){
            int where = i;
            int seed = seeds[where];
            int[] data = dataSeq[where];
            int len = data.length;
            
            ts[i] = new Thread(()->{
                Random r = new Random(seed);
                for(int j = 0; j < len; j++){
                    data[j] = r.nextInt(101);
                    sum[where] += data[j];
                }
            });
            
            ts[i].start();
        }
        
        for(Thread t : ts){
            t.join();
        }
        
        for(int i = 0; i < dataSeq.length; i++){
            System.out.println(Arrays.toString(dataSeq[i]));
        }
        
        double total = 0;
        for(int i = 0; i < sum.length; i++){
            total += sum[i];
        }
        
        System.out.printf("Overall Avg = %.3f%n", total / (dataSeq.length*size)/*IntStream.of(sum).sum()*1.0/(dataSeq.length*size)*/);
    }
}
