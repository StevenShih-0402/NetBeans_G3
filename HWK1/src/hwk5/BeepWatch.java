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
import java.awt.Toolkit;

public class BeepWatch implements AlarmTimer{
    @Override
    public void alerm(){
        Toolkit.getDefaultToolkit().beep();
    }
}
