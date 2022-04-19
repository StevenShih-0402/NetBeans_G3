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
class Time { // 以24小時進制儲存時間
    int h, m, s;
    
    // DIY: 自行完成所需建構式
   Time(int h, int m, int s){
       this.h = h;
       this.m = m;
       this.s = s;
   }
   Time(String time){
       String[] ap = time.split(" ");
       if(ap[0].equals("AM")||ap[0].equals("PM")){
           String[] times = ap[1].split(":");
           this.h = (ap[0].equals("AM")) ? Integer.parseInt(times[0]) : Integer.parseInt(times[0])+12;
           this.m = Integer.parseInt(times[1]);
           this.s = Integer.parseInt(times[2]);
       }
       else{
           String[] times = ap[0].split(":");
           this.h = Integer.parseInt(times[0]);
           this.m = Integer.parseInt(times[1]);
           this.s = Integer.parseInt(times[2]);
       }
   }
    void show(String msg) {
         //可能需修改
         System.out.printf("%02d:%02d:%02d%n", this.h, this.m, this.s);
    } 
}

public class MI3A_24_05{
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
