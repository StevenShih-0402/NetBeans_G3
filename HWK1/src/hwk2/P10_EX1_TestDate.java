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
class MonthDay {
    int m, d; 
    // diy here
    MonthDay(int m ,int d){
        this.m = m;
        this.d = d;
    }
    MonthDay(MonthDay day){
        this.m = day.m;
        this.d = day.d;
    }
    MonthDay(String date){
        String[] num = date.split("/");
        this.m = Integer.parseInt(num[0]);
        this.d = Integer.parseInt(num[1]);
    }
    void show(String header) { 
        System.out.println(header+m+"/"+d); 
    }
}
public class P10_EX1_TestDate {
    public static void main(String[] args) {
        // ---- 完成class MonthDay後，自行解開註解 ---
        
	 MonthDay d1 = new MonthDay(12, 5), d2=new MonthDay(d1);
 	 MonthDay d3 = new MonthDay("8/15") ;
	 d1.show("d1="); d2.show("d2="); d3.show("d3=") ;
    }
}
