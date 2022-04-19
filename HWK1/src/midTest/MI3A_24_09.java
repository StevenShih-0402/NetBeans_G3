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
import java.util.* ;
class Arrays{
    public static void sort(Object[] mps, MPComparator m){
        for(int i = mps.length-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(m.CompareTo(mps[j], mps[j+1]) > 0){
                    Object temp = mps[j];
                    mps[j] = mps[j+1];
                    mps[j+1] = temp;
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
        MyPoints p1 = (MyPoints)o1;
        MyPoints p2 = (MyPoints)o2;
        
        int d1 = p1.x*p1.x + p1.y*p1.y;
        int d2 = p2.x*p2.x+p2.y*p2.y;
        
        if(d1 > d2)
            return 1;
        else if(d1 < d2)
            return -1;
        
        return 0;
        
    }

    public boolean equals(Object o){
//        if(o == this)
//            return true;
//        if(!(o instanceof MyPoint))
//            return false;
//        MyPoint p = (MyPoint)o;
//        
//        return p.x == this.x && p.y == this.y;
        return this == o;
    }
}
public class MI3A_24_09{
    public static void main(String[] args) {
        MyPoints[] mps = {new MyPoints(3,6), new MyPoints(1, 2), new MyPoints(-1, -1), new MyPoints(-8, 9)} ; 
        Arrays.sort(mps, new MPComparator()) ;
        // … 自行用for印出msp //(-1,-1) (1, 2) ( 3,6) (-8,9)
        for(MyPoints p : mps){
            System.out.print(p.toString());
        }
    }
}