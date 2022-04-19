/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk5;

/**
 *
 * @author steve
 */
import java.awt.*;

interface Shape{
    double area();
}
class Circle implements Shape{
    double r;
    Circle(double r){
        this.r = r;
    }
    @Override
    public double area(){
        return Math.PI * r * r;
    }

}

class Rect implements Shape{
    double w, h;
    Rect(double w, double h){
        this.w = w;
        this.h = h;
    }
    @Override
    public double area(){
        return w * h;
    }
}

class PaintBoard{
    Shape[] shapes = new Shape[100];
    int cnt = 0;
    void add(Shape s){
        shapes[cnt++] = s;
    }
    double calTotalArea(){
        double total = 0;
        for(Shape ss : shapes){
            if(ss != null)
                total += ss.area();
        }
        return total;
    }
}

public class P50_TestPaintBoard {
    public static void main(String[] args){
        PaintBoard pb = new PaintBoard();
        pb.add(new Circle(3));
        pb.add(new Rect(9, 4));
        pb.add(new Circle(5.5));
        System.out.println("Total Area = " + pb.calTotalArea());
    }
}
