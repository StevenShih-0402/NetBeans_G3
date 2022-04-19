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

class fThr extends Thread{
    int[] a;
    int limit;
    boolean type;
    
    fThr(){
        limit = 1000;
        type = false;
    }
    fThr(int[] a){
        this.a = a;
        this.limit = a.length;
        type = true;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < limit; i++){
            if(type){
                int temp = (int)(Math.sqrt(a[i])*10) ;
                System.out.println(a[i]+" -> "+temp);
            }
            else if(!(type))
                System.out.println("Hello") ;
        }
    }
}

public class MI3A_26_HWK1_02{
    public static void main(String[] args) throws InterruptedException {
        int[] score= new int[100] ;
        for (int i=0; i<score.length; i++) {
            score[i] = (int)(Math.random()*101) ; 
        }
        // 欲使用執行緒來執行二段不相關的任務
        
        fThr f1 = new fThr();
        fThr f2 = new fThr(score);
        
        f1.start();
        f2.start();

        f1.join();
        f2.join();
        
    }
//    public static void f1() { // 印出Hello
//        for (int i = 0 ; i<100; i++) 
//            System.out.println("Hello") ;
//    }
//    public static void f2(int[] x) { // 印出調整後成績
//        for (int i =0 ; i<x.length; i++) {
//            int temp = (int)(Math.sqrt(x[i])*10) ;
//            System.out.println(x[i]+" -> "+temp);
//        }
//    }
}
