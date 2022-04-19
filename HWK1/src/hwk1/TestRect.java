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
class Rect { //矩形
    int x,y, w, h ; // (x,y):左上角座標, w:寬, h:高
    // DIY: set(), draw(), toString()
    void set(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    void draw(String icon){
        for(int h = 0; h < this.h; h++){
            for(int w = 0; w < this.w; w++){
                if(h == 0 || h == this.h-1)
                    System.out.print(icon);
                else
                    if(w == 0 || w == this.w-1)
                        System.out.print(icon);
                    else
                        System.out.print("　");
            }
            System.out.println("");
        }    
    }
    
    public String toString(){
        return "(" + this.x + "," + this.y + "), w=" + this.w + ", h=" + this.h;
    }
    // DIY: double overlapArea(r2): 判別 this 與 r2 交集之面積
    
    double overlapArea(Rect r2){
        return ((this.x + this.w) - (r2.x)) * ((this.y) - (r2.y - r2.h));
    }
}

public class TestRect{
    public static void main(String[] args) {
        Rect r1 = new Rect() ;
        r1.set(1,4 ,4 ,3) ; // (x,y)=(1,4), w=4, h=3 
        System.out.println("r1="+r1) ; // LU=(1,4), w=4, h=3
        r1.draw("@") ; // 用@畫出空心 r1
        Rect r2 = new Rect() ; r2.set(2, 7, 5, 5) ; // w=5, h=5
        double overlapArea = r1.overlapArea(r2) ; 
        System.out.println("overlapArea="+overlapArea) ;
    }
}
