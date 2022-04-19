/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk6;

/**
 *
 * @author steve
 */
import java.util.Arrays;

interface Compare {
	// 如果this>obj, 回傳正數, this<obj, 回傳負數, 否則回傳0
        int compareTo(Object obj) ; 
}
class Sort { 
    public static void bubbleSort(Compare[] objs) {
        for (int i = objs.length-1; i>0 ; i--)
           for (int j = 0 ; j<i; j++) 
                 if (objs[j].compareTo(objs[j+1])>0) 
                     swap(objs, j, j+1) ;	
    }
    public static void swap(Object[] objs, int x, int y) {
        Object temp = objs[x] ;
        objs[x] = objs[y] ;
        objs[y] = temp ;
    }
}
// ========== clint side ================
class MyPoint implements Compare{ 
        int x, y ;
        MyPoint() {}
        MyPoint(int a, int b) { x = a; y=b; }
        public int compareTo(Object obj){
            MyPoint mp = (MyPoint) obj;
            double d1 = Math.sqrt(x*x+y*y);
            double d2 = Math.sqrt(mp.x*mp.x+mp.y*mp.y);
            
            if(d1 > d2)
                return 1;
            else if(d1 < d2)
                return -1;
            
            return 0;
        }
        public String toString() { return "("+x+","+y+")" ; }
}
public class P35_Demo_V2 {
    public static void main(String[] args) {
        MyPoint[] mps = {
            new MyPoint(3,6), new MyPoint(0,4), 
            new MyPoint(7,5), new MyPoint(4,12),
            new MyPoint(2,9)
        } ;             

        Sort.bubbleSort(mps) ;
        System.out.println("mps[]="+Arrays.toString(mps));
        // … 自行用for印出msp
        for(MyPoint p : mps){
            System.out.println(p.toString());
        }
    }
}
