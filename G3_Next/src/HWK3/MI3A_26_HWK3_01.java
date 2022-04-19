/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK3;

/**
 *
 * @author steve
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;

/**
 *
 * @author aa
 */
interface BiTransform{
    public int apply(int x, int y);
}

public class MI3A_26_HWK3_01{
    public static void main(String[] args){
        int[] a = {1,3,5,2};
        int[] b = {22,33,44,55};
        int[] c = new int[a.length];
        
        combine(a,b,c, (x,y)->x+y);
        System.out.println(Arrays.toString(c));
        combine(a,b,c, (x,y)->(int)(x*x+Math.sqrt(y)));
        System.out.println(Arrays.toString(c));
             
    }
    
    public static void combine(int[] a, int[] b, int[] c, BiTransform bt){
        for(int i = 0; i < a.length; i++){
            c[i] = bt.apply(a[i], b[i]);
        }
    }
}