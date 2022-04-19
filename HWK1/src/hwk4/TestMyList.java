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

public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> list1 = new MyList<>() ;
        list1.addList(10, 5); // 將元素10加入串列5次
        System.out.println("list1="+list1) ;  // 印出list1=[10, 10, 10, 10, 10] 
        
        MyList<String> list2 = new MyList<>() ;
        for (int i = 0 ; i<12; i++) {
            list2.addLast("ID"+(1000+i)) ;
        }
        System.out.println("#calls of addList()="+MyList.addLastCnt) ;
	// 印出 #calls of addList()=12     
    }
}
