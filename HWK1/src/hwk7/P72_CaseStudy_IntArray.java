/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk7;

/**
 *
 * @author steve
 */
import java.util.Arrays;

class IndexLessThanZero extends Exception {
    int idx ; //記錄引發例之不合法index
    IndexLessThanZero(int x) { idx = x ; } 
    @Override
    public String getMessage(){
        return "Index "+this.idx + " not exist.";
    }
}
class IndexOutOfBound extends Exception { 
    // DIY 
    int idx ; //記錄引發例之不合法index
    IndexOutOfBound(int x) { idx = x ; } 
} 
class IntArray {  
    int[] data = new int[10];
    IntArray() { }
    public int get(int index) throws IndexLessThanZero, IndexOutOfBound{
        // throw exception if index<0 or index >= data.length
        if(index < 0){
            throw new IndexLessThanZero(index);
        }
        else if(index >= data.length){
            throw new IndexOutOfBound(index);
        }

        return data[index] ;
    }
    public void set(int index, int v) throws IndexLessThanZero{
        // throw exception if index < 0
        if(index < 0){
            throw new IndexLessThanZero(index);
        }
        if (index >= data.length) {
            data = Arrays.copyOf(data, data.length+1) ;
        }
        data[index]  = v;
    }
}
public class P72_CaseStudy_IntArray{
    public static void main(String[] args) {
        IntArray arr = new IntArray() ;
        for (int i = 50 ; i>=-10; i--) {
            // catch and report various exceptions, then continue excution
            try{
                arr.set(i, (int)(Math.random()*100)) ;
                System.out.println(arr.get(i)) ;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }
    }
}