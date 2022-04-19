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
class PrintThread extends Thread { // 如何將函數->執行緒
    String msg;    int times;

    PrintThread(String s, int n) {
        msg = s;     times = n;
    }
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(msg);
        }
    }
}

public class MI3A_26_HWK1_00{
    public static void main(String args[]) throws InterruptedException {
        PrintThread t1 = new PrintThread("有人在嗎?", 20);
        PrintThread t2 = new PrintThread("***請進!", 20);
        t1.start();  // 此執行緒啟動後，會自動呼叫t1.run()
        t2.start();  // 此執行緒啟動後，會自動呼叫t2.run()
        // … do something
        t1.join();
        t2.join();
    }
}