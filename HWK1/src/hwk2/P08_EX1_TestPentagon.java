/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk2;

/**
 *
 * @author steve
 */

class PointX {
    double x, y;
    void set(double a, double b) {
        this.x = a;
        this.y = b;
    }
    double dist(PointX p2) {
        // DIY
        return Math.sqrt(Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2));
    }
}

class Pentagon { //五邊形
    PointX[] points; //記錄五個頂點

    void set(PointX[] ps) {
        points = ps;
    }
    double boundary() {
        /* DIY 計算周長 */
        if (points == null || points.length != 5) {
            return 0.0;
        }
        double total = 0;
        // DIY here
        for(int i = 1; i < points.length; i++){
            total += points[i-1].dist(points[i]);
        }
        total += points[0].dist(points[points.length-1]);
        return total;
    }
}

public class P08_EX1_TestPentagon {
    public static void main(String[] args) {
        // 頂點(0,0) (4,0) (6, 2), (4, 4), (0, 4)
        PointX p1 = new PointX();
        PointX p2 = new PointX();
        PointX p3 = new PointX();
        PointX p4 = new PointX();
        PointX p5 = new PointX();
        
        p1.set(0, 0);
        p2.set(4, 0);
        p3.set(6, 2);
        p4.set(4, 4);
        p5.set(0, 4);
        
        PointX[] ps = {p1, p2, p3, p4, p5};
        Pentagon pen = new Pentagon();
        pen.set(ps);
        System.out.println("周長=" + pen.boundary());
    }
}
