/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk4;

/**
 *
 * @author steve
 */
import java.util.LinkedList ;
public class MyList<T> extends LinkedList<T> {
    public static int addLastCnt = 0 ; // 記錄祖先類別提供的addLast()被呼叫幾次
    public void addList(T item, int n) { // 呼叫祖先類別提供的add(item) n次
        for(int i = 0; i < n; i++){
            super.add(item);
        }
    }
    public void addLast(T item) { // 先呼叫祖先類別提供的addLast(item), 
        super.addLast(item);
        addLastCnt++;
    }
}
