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
class Time { // 以24小時進制儲存時間
    int h, m, s;
    
    // DIY: 自行完成所需建構式
    Time(int h, int m, int s){
        this.h = h;
        this.m = m;
        this.s = s;      
    }
    
    Time(String num){
        String[] AP = num.split(" ");
        String[] time = (AP[0].equals("PM") || AP[0].equals("AM")) ? AP[1].split(":") : AP[0].split(":");
        
        this.h = Integer.parseInt(time[0]);
        if(AP[0].equals("PM"))
            this.h += 12;
        this.m = Integer.parseInt(time[1]);
        this.s = Integer.parseInt(time[2]);

    }
    
    void show(String msg) {
        System.out.printf("%s%02d:%02d:%02d%n", msg, this.h, this.m, this.s); //可能需修改
    } 
}

public class P10_EX2_TestTime {
    public static void main(String[] args) {
        Time t1 = new Time(15, 30, 20);
        Time t2 = new Time("18:5:50");
        Time t3 = new Time("AM 8:20:50");
        Time t4 = new Time("PM 7:10:40");
        t1.show("t1=");
        t2.show("t2=");
        t3.show("t3=");
        t4.show("t4=");
    }
}
/* [程式輸出]
15:30:20
18:05:50
08:20:50
19:10:40

*/