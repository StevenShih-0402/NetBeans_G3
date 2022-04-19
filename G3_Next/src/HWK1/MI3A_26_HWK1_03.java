/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK1;

/**
 *
 * @author steve
 */
class Fermat extends Thread {
    // DIY
    int startX, endX, startY, endY, exp;
    Fermat(int sx, int ex, int sy, int ey, int p){
        this.startX = sx;
        this.endX = ex;
        this.startY = sy;
        this.endY = ey;
        this.exp = p;
    }
    
    @Override
    public void run(){
        int num = 1;
        int z;
        
        if(startX < startY){
            for(int i = startX; i < startY; i++){
                for(int j = startY; j <= endY; j++){
                    z = (int)Math.sqrt(Math.pow(i, exp) + Math.pow(j, exp));
                    if(Math.pow(i, exp) + Math.pow(j, exp) == Math.pow(z, exp)){
                        System.out.printf("[%d]%d^%d+%d^%d=%d^%d%n%.0f+%.0f=%.0f%n", num, i, exp, j, exp, z, exp, Math.pow(i, exp), Math.pow(j, exp), Math.pow(z, exp));
                        num++;
                    }
                }
            }
        }

        for(int i = startY; i <= endY; i++){
            for(int j = i; j <= endY; j++){
                z = (int)Math.sqrt(Math.pow(i, exp) + Math.pow(j, exp));
                if(Math.pow(i, exp) + Math.pow(j, exp) == Math.pow(z, exp)){
                    System.out.printf("[%d]%d^%d+%d^%d=%d^%d%n%.0f+%.0f=%.0f%n", num, i, exp, j, exp, z, exp, Math.pow(i, exp), Math.pow(j, exp), Math.pow(z, exp));
                    num++;
                }
            }
        }
    }
}

public class MI3A_26_HWK1_03{
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis() ;

        // (1) 先完成class Fermat，讓單執行緒版本可正常執行
        Thread t = new Fermat(1,30000,1,30000,2) ;
        t.start() ;
        t.join();
        // 檢驗x^2+y^2=z^2 , x,y in [1,30000], exp=2,
        

        // (2) 修改上述程式，改為啟動4條執行緒，分別計算y在以下四個範圍內
//        //  [1,7500][7501,15000][15001,22500][22501,30000]中符合x^2+y^2=z^2的數對(x,y,z)
//        Thread t1 = new Fermat(1, 30000, 1, 7500, 2);
//        Thread t2 = new Fermat(1, 30000, 7501, 15000, 2);
//        Thread t3 = new Fermat(1, 30000, 15001, 22500, 2);
//        Thread t4 = new Fermat(1, 30000, 22501, 30000, 2);
//        
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        
//        t1.join() ;
//        t2.join() ;
//        t3.join() ;
//        t4.join() ;

        //等候執行緒t結束
        long end = System.currentTimeMillis() ;
        System.out.printf("cpu time = %.2f (secs)\n",(end-start)/1000.0);    
    }
}
/* 
[執行結果]
[1]3^2+4^2=5^2
9+16=25
-------------------------------
[2]5^2+12^2=13^2
25+144=169
-------------------------------
[3]6^2+8^2=10^2
36+64=100
...
-------------------------------
[49307]29716^2+29835^2=42109^2
883040656+890127225=1773167881
-------------------------------
[49308]29750^2+30000^2=42250^2
885062500+900000000=1785062500
-------------------------------
[49309]29928^2+29971^2=42355^2
895685184+898260841=1793946025
-------------------------------
*/
