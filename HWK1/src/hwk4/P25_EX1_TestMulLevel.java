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
class IntNum {
    private int n ; 
    void set(int x) { n = x; }
    int getN() { return n; }
}
class Score extends IntNum {
    // 把父類別中的整數n做為學生的id之用 
    private float gpa ;  
    /*DIY, 加入set(id,gpa), getGPA()*/
    void set(int id, float gpa){
        super.set(id);
        this.gpa = gpa;
    }
    float getGPA(){
        return gpa;
    }
 }

class Record extends Score { 
    private String comment ;  
    /*DIY, 加入set(id,gpa,comment), getComment(), toString()*/
    void set(int id, float gpa, String comment){
        super.set(id, gpa);
        this.comment = comment;
    }
    String getComment(){
        return comment;
    }
    @Override
    public String toString(){
        return "(" + super.getN() + ", " + super.getGPA() + ", " + this.comment + ")";
    }
}

public class P25_EX1_TestMulLevel {
    public static void main(String[] args) {
        Record r = new Record() ;
         r.set(1001, 3.14f, "Good") ; // 設定r物件之n,gpa,comment變數
         System.out.println(r) ;  // 覆寫toString()函數
    }
}
