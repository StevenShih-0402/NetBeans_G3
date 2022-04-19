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
class ID {
    private int id ; 
    ID(int a) {
        this.id = a;
    }
    void reset(){
        id=-1;
    }
    int getId(){
        return id;
    }
    public String toString(){
        return id+"";
    }
}
class Scores extends ID{ 
    private float gpa ;  
    Scores(int a, float b) {
        super(a);
        this.gpa=b;
    }
    void reset() { 
        // DIY here
        super.reset();
        this.gpa = -1;
    }
    float getGpa(){
        return gpa;
    }
    public String toString() { // id,gpa
        return  "Score: toString()"  ; // DIY
    } 
}


class Records extends Scores { 
    private String comment ;  
    Records(int a,float b, String s) { 
        super(a,b); 
        this.comment= s; 
    }
    @Override
    void reset() {       
        // DIY here
        super.reset();
        this.comment = "XXX";
    }
    @Override
    public String toString() {
        return "(" + super.getId() + ", " + super.getGpa() + ", " + this.comment + ")"; 
    }
}
public class P27_EX2_TestRecord {
    public static void main(String[] args) {
        Records r = new Records(1001, 4.3f, "GOOD") ; 
        System.out.println("Record="+r) ; // 印出(1001, 4.3, GOOD)
        r.reset() ; // id=-1,  gpa=-1,  comment="XXX"
        System.out.println("Record="+r) ; // 印出(-1, -1, XXX)
    }
}
