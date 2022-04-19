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

interface Compare{
    // 比較this與obj的大小，若this>obj回傳1, this<obj回傳-1,否則傳回0    
    int compareTo(Object obj); 
}
class Triangle implements Compare{ // 三角形
    int a, b, c ; // 代表三角形三邊長，需保持 a<=b, b<=c的關係
    
    Triangle() { }
    Triangle(int a, int b, int c) { // 8%
        // 初始化三角形三邊長，需保持 a<=b, b<=c的關係
        int[] d = {a,b,c};
        Arrays.sort(d);
        this.a = d[0];
        this.b = d[1];
        this.c = d[2];
    }

    @Override
    public boolean equals(Object obj) { // 5%
        // 比較this與obj所代表的三角形是否全等
        if (obj==this) return true ;
        if (!(obj instanceof Triangle)) return false;
        
        Triangle t = (Triangle) obj;
        
        return this.a == t.a && this.b == t.b && this.c == t.c;

    }
    double area() { // 4%
        double s = (a+b+c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override
    public int compareTo(Object obj) { // 4%
        // 比較this與obj的大小，若this>obj回傳1, this<obj回傳-1,否則為0
        // [方式]:以三角形的面積來決定大小，請先完成上方的area()函數
        Triangle t = (Triangle)obj;
        if(this.area() > t.area())
            return 1;
        else if(this.area() < t.area())
            return -1;
        
        return 0;

    }
    public String toString() {  // 請勿更改此函數
        return "("+a+","+b+","+c+")" ;
    }
}
public class MI3A_24_001  { // XX: 成績座號
    public static void main(String[] args) {
        Triangle t1 = new Triangle(5, 7, 4) ;
        Triangle t2 = new Triangle(5, 3, 7) ;
        Triangle t3 = new Triangle(7, 4, 5) ;
        
        System.out.println("t1="+t1+", t2="+t2+", t3="+t3) ;

        System.out.println("t1.equals(t2)? "+t1.equals(t2));
        System.out.println("t1.equals(t3)? "+t1.equals(t3));
        
        int b1 = t1.compareTo(t2), b2 = t1.compareTo(t3) ;
        System.out.println((b1>0)?"t1>t2":((b1<0)?"t1<t2":"t1==t2")) ;
        System.out.println((b2>0)?"t11>t2":((b2<0)?"t1<53":"t1==t3")) ;        
    }
}
/* [程式輸出]
t1=(4,5,7), t2=(3,5,7), t3=(4,5,7)
t1.equals(t2)? false
t1.equals(t3)? true
t1>t2
t1==t3
*/
