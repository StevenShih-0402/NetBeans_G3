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
class Rects { //矩形
    int x,y, w, h ; // (x,y):左上角座標, w:寬, h:高
    // DIY: set(), draw(), toString()
    void set(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    void draw(String icon){
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(i == 0 || i == h-1){
                    System.out.print(icon);
                }
                else{
                    if(j == 0 || j == w-1)
                        System.out.print(icon);
                    else
                        System.out.print("　");
                }
            }
            System.out.println("");
        }
    }
    
    public String toString(){
        return "LU=("+this.x + "," + this.y + "), w=" + this.w + ", h=" + this.h;
    }

    // DIY: double overlapArea(r2): 判別 this 與 r2 交集之面積
    
    double overlapArea(Rects r2){
        return ((this.x+this.w)-r2.x) * (r2.y - this.y);
    }
}

public class MI3A_24_04{
    public static void main(String[] args) {
        Rects r1 = new Rects() ;
        r1.set(1,4 ,4 ,3) ; // (x,y)=(1,4), w=4, h=3 
        System.out.println("r1="+r1) ; // LU=(1,4), w=4, h=3
        r1.draw("@") ; // 用@畫出空心 r1
        Rects r2 = new Rects() ; r2.set(2, 7, 5, 5) ; // w=5, h=5
        double overlapArea = r1.overlapArea(r2) ; 
        System.out.println("overlapArea="+overlapArea) ;
    }
}

