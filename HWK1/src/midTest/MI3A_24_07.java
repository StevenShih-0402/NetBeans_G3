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
class Shapes{
    int a,b ; 
    Shapes() { }	
    double area() {
        return 0.0;
    } // 需被子類別覆蓋(override)
} 
class Rectss extends Shapes{
    Rectss(int w, int h) { 
        this.a = w;
        this.b = h;
    }
    @Override
    double area(){ 
        return a * b;
    } 
}
class Circle extends Shapes{
    int r ; 
    Circle(int w, int h, int r) {
        this.a = w;
        this.b = h;
        this.r = r;
    }
    @Override
    double area(){
        return r*r*Math.PI;
    }
}
public class MI3A_24_07 {
    public static void main(String[] args) {
        Shapes[] ss = new Shapes[10] ;
        int cnt = 0 ; 
        ss[cnt++] = new Circle(5,5,3) ;
        ss[cnt++] = new Rectss(4,7) ;
        ss[cnt++] = new Rectss(5,12) ;
        ss[cnt++] = new Circle(2,3,9) ;
        System.out.println("total area="+calTotalArea(ss)) ;
    }
    // DIY: 完成以下函數
     public static double calTotalArea(Shapes[] ss) {
         double total = 0;
         for(Shapes s : ss){
             if(s != null)
                 total += s.area();
         }
         return total;
     }
         
}
