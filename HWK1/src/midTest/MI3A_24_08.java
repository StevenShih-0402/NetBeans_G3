/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midTest;

/**
 *
 * @author steve
 */
import java.util.Arrays;

interface Compares{
	// 如果this>obj, 回傳正數, this<obj, 回傳負數, 否則回傳0
        int compareTo(Object obj) ; 
}
class Sort{ 
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
class MyPoint implements Compares{ 
        int x, y ;
        MyPoint() {}
        MyPoint(int a, int b) { x = a; y=b; }
        
        @Override
        public int compareTo(Object obj){
            MyPoint p = (MyPoint) obj;
            int d1 = x*x+y*y;
            int d2 = p.x*p.x + p.y*p.y;
            
            if(d1 > d2)
                return 1;
            else if(d1 < d2)
                return -1;
            
            return 0;
        }
        public String toString() { return "("+x+","+y+")" ; }
}
public class MI3A_24_08{
    public static void main(String[] args) {
        MyPoint[] mps = {
            new MyPoint(3,6), new MyPoint(0,4), 
            new MyPoint(7,5), new MyPoint(4,12),
            new MyPoint(2,9)
        } ;             

//        Sort.bubbleSort(mps);
        System.out.println("mps[]="+Arrays.toString(mps));
        // … 自行用for印出msp
        
        for(MyPoint p : mps){
            System.out.print(p.toString());
        }

    }
}
