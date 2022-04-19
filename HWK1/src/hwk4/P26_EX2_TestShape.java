/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk4;

/**
 *
 * @author steve
 */
import java.awt.Point ;
class Shape {
    protected Point p ; // 記錄形狀的左上角座標
    protected double w, h ;
    
    void set(Point upLeft, double w, double h) {
        // DIY here
        this.p = upLeft;
        this.w = w;
        this.h = h;
    }
    double calArea() { return -1 ; } // 不知道是何形狀，所以回傳-1
    public String toString() { return p+","+w+","+h ; }
} 


class Ellipse extends Shape { // 橢圓形
    // DIY here, toString(), calArea()
    Ellipse(Point p, double w, double h){
        super.set(p, w, h);
    }
    @Override
    double calArea(){
        return this.h * this.w * Math.PI;
    }
    @Override
    public String toString(){
        return "center:(" + this.p.x + ", " + this.p.y + "), r1=" + this.w + ", r2=" + this.h;
    }

}
public class P26_EX2_TestShape {
    public static void main(String[] args) {
         Ellipse e = new Ellipse(new Point(5, 10), 8, 10) ; // 左上角，長、短邊
         System.out.println("e="+e); // 印出e= center:(5,10), r1=4, r2=7.5
         System.out.println("area of e ="+e.calArea()) ; // 印出面積
    }
}
