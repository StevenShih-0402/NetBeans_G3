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
import java.awt.* ; 
import static java.lang.Math.* ; 
interface Shape {
    double area() ; 
    double border() ; 
}
// 請修改TriangleX，使其實作Shape
class TriangleX implements Shape {
    Point p1, p2, p3 ; 
    
    TriangleX(Point p1, Point p2, Point p3) { // 3%
        // 建構式, 使用p1,p2,p3初始化三角形，請用deep copy
        this.p1 = new Point(p1); 
        this.p2 = new Point(p2); 
        this.p3 = new Point(p3); 
    }
    // 完成Shape所規定之函數, 5%, 4%
    double dist(Point p1, Point p2) {
        return sqrt(pow(p1.x-p2.x, 2)+pow(p1.y-p2.y,2)) ;
    }
    public double area() {
        double a = dist(p1, p2) ; 
        double b = dist(p2, p3) ;
        double c = dist(p1, p3) ; 
        double s = (a+b+c)/2 ;
        return sqrt(s*(s-a)*(s-b)*(s-c)); 
    } 
    public double border() {
        return dist(p1,p2)+dist(p2,p3)+dist(p1,p3) ; 
    }    
}
// 請修改Rect，使其實作Shape
class Rect implements Shape {
    int w, h ;
    Rect(int a, int b) {
        w=a; h=b ;
    }
    // 完成Shape所規定之函數, 3%, 3% 
    public double area() {
        return w*h ; 
    } 
    public double border() {
        return 2*w*h ;
    }    
}
public class MI3A_24_03 {
    public static void main(String[] args) {
        TriangleX t1 = new TriangleX(new Point(0,0), new Point(0,3), new Point(4,0));
        TriangleX t2 = new TriangleX(new Point(-2,0), new Point(0,4), new Point(5,0));
        Rect r1 = new Rect(3,7) ;
        Shape[] ss = {t1, r1, t2} ;
        for (Shape s:ss) {
            System.out.println("area="+s.area()+", border="+s.border());
        }
    }
}
/* [程式輸出]
area=6.0, border=12.0
area=21.0, border=42.0
area=14.0, border=17.875260192432428
*/