/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk1;

/**
 *
 * @author steve
 */
class Point {
    double x, y ; 
    void set(double a, double b) { this.x = a; this.y = b; }
    double distOnLine(Point p2, Point p3) { 
    // 如果 this, p2, p3 同在一直線，則回傳最遠二點距離
    // 如果不是，回傳-1
        if(((this.y - p2.y) / (this.x  -p2.x)) == ((this.y - p3.y) / (this.x - p3.x))){
            
            double dis1 = (this.x - p2.x) * (this.y - p2.y);
            double dis2 = (this.x - p3.x) * (this.y - p3.y);
            double dis3 = (p2.x - p3.x) * (p2.y - p3.y);
            
            double max = dis1;
            if(dis2 > max)
                max = dis2;
            if(dis3 > max)
                max = dis3;
            
            return max;
        }
        return -1;
    }
}

public class TestPoint {
    public static void main(String[] args) {
        Point p1 =new Point(), p2=new Point(), p3=new Point() ;
        p1.set(5,3); p2.set(3,0); p3.set(4,1);
        System.out.println("length of line="+p1.distOnLine(p2,p3)) ;
        
        Point p4 = new Point() ; 
        p4.set(1,1) ; 
        System.out.println("length of line="+p1.distOnLine (p3,p4)) ;
    }
}

