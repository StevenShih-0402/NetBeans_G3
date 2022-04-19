/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk5;

/**
 *
 * @author steve
 */
public class Main {
    public static void main(String[] args){
        AlarmTimer bw = new BeepWatch() ;
        TimerTool.startTimer(bw, 20, 2) ; // 啟動BeepWatch的鬧鈴，間隔2秒, 持續20秒
        AlarmTimer ew = new EchoWatch() ;
        TimerTool.startTimer(ew, 10, 1) ; //啟動EchoWatch的鬧鈴，間隔1秒, 持續10秒
    }
}
