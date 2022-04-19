/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk3;

/**
 *
 * @author steve
 */
import java.awt.Point ;
class Shapes { 
    private Point p1 ; //形狀的左上角座標，或多邊形的第一個點
    protected void setP1(Point p) { this.p1 = p ;}
    protected Point getP1() { return p1 ; }
}
class Ellipses extends Shapes{ // 繼承Shape, 由左上角座標p1, 長寬為d1,d2的矩形所表示
    // DIY: 變數宣告
    int d1, d2;
    void set(Point p, int width, int height){
         super.setP1(p);
         this.d1 = width;
         this.d2 = height;
    }
    // DIY: 函數定義
    double calArea(){
        return this.d1 * this.d2 * Math.PI;
    }
}
class Triangles extends Shapes{  // 繼承Shape, p1代表三角形的第一點
    // DIY: 變數宣告
    Point p2, p3;
    void set(Point[] p){
         super.setP1(p[0]);
         this.p2 = p[1];
         this.p3 = p[2];
    }
    // DIY: 函數定義
    double calArea(){
        double a = Math.sqrt(Math.pow(this.getP1().x - this.p2.x, 2) + Math.pow(this.getP1().y - this.p2.y, 2));
        double b = Math.sqrt(Math.pow(this.p3.x - this.p2.x, 2) + Math.pow(this.p3.y - this.p2.y, 2));
        double c = Math.sqrt(Math.pow(this.getP1().x - this.p3.x, 2) + Math.pow(this.getP1().y - this.p3.y, 2));
        
        double s = (a + b + c) / 2;
        
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

}
public class P21_EX1_TestShape {
    public static void main(String[] args) {
        Ellipses e = new Ellipses() ; // 橢圓形
        e.set(new Point(10,10), 12, 7) ;
        System.out.println("Ellipse Area="+ e.calArea());
        Triangles t = new Triangles() ; // 橢圓形
        Point[] ps = 
                {new Point(-3,0), new Point(2,0), new Point(1,7)}; 
        t.set(ps) ;
        System.out.println("Triangle Area="+t.calArea());
    }
}
