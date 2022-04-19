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
import java.util.* ;
class Arrays{
    public static void sort(Object[] a, Comparator c){
        for(int j = a.length-1; j >0; j--){                                 //bubbleSort的實作方法
            for(int i = 0; i< j; i++){
                if(c.CompareTo(a[i], a[i+1]) > 0){
                     Object temp = a[i];
                     a[i] = a[i+1];
                     a[i+1] = temp;
                }
            }    
        }      
    }
}
interface Comparator{
        int CompareTo(Object o1, Object o2);
        boolean equals(Object o);
}
class MyPoints{ 
        int x, y ;
        MyPoints(int a, int b) { x = a; y=b; }
        public String toString() { return "("+x+","+y+")" ; }
}
class MPComparator implements Comparator{
    public int CompareTo(Object o1, Object o2){
       MyPoints p1 = (MyPoints) o1;
       MyPoints p2 = (MyPoints) o2;
       
       double d1 = Math.sqrt(p1.x*p1.x + p1.y*p1.y);
       double d2 = Math.sqrt(p2.x*p2.x + p2.y*p2.y);
       
       if(d1 > d2)
           return 1;
       else if(d1 < d2)
           return -1;
       return 0;
    }

    public boolean equals(Object o){
        return this == o;
    }
}
public class P55_EX_TestComparable {
    public static void main(String[] args) {
        MyPoints[] mps = {new MyPoints(3,6), new MyPoints(1, 2), new MyPoints(-1, -1), new MyPoints(-8, 9)} ; 
        Arrays.sort(mps, new MPComparator()) ;
        // … 自行用for印出msp //(-1,-1) (1, 2) ( 3,6) (-8,9)
        for(MyPoints p : mps){
            System.out.println(p.toString());
        }
    }
}
