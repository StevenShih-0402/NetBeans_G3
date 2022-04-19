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
class Shapes{
    int a,b ; 
    Shapes() { }	
    double area() {
        return 0.0;
    } // 需被子類別覆蓋(override)
} 
class Rect extends Shapes{
    Rect(int w, int h) { a = w; b=h;}
    
    @Override
    double area(){ 
        return a*b;
    } 
}
class Circle extends Shapes{
    int r ; 
    Circle(int w, int h, int r) { a = w; b=h; this.r = r ;}
    
    @Override
    double area(){
        return Math.PI*r*r ;
    }
}
public class P34_EX3_TestGenericShape {
    public static void main(String[] args) {
	Shapes[] ss = new Shapes[10] ;
	int cnt = 0 ; 
	ss[cnt++] = new Circle(5,5,3) ;
	ss[cnt++] = new Rect(4,7) ;
	ss[cnt++] = new Rect(5,12) ;
                    ss[cnt++] = new Circle(2,3,9) ;
	System.out.println("total area="+calTotalArea(ss)) ;
    }
    // DIY: 完成以下函數
     public static double calTotalArea(Shapes[] ss) {
         double total = 0;
         for(int i = 0; i < ss.length; i++){
             if(ss[i] != null)
                total += ss[i].area();
         }
         
         return total;
     } 
}
