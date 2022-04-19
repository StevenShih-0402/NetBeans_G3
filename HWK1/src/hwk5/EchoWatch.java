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
public class EchoWatch implements AlarmTimer{
    @Override
    public void alerm(){
        System.out.println("醒過來");
    }
}
