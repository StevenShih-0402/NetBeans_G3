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
public class TimerTool {
    public static void startTimer(AlarmTimer timer, int duration, int step){
        try{
            for(int i = 0; i < duration / step; i++){
                timer.alerm();
                Thread.sleep(step*1000);
            }           
        }catch(InterruptedException e){
            e.printStackTrace();                        //印出錯誤訊息
        }
    }
}
