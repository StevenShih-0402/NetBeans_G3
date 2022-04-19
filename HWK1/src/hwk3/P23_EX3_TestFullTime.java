/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk3;

import java.text.DecimalFormat;

/**
 *
 * @author steve
 */
class Staff { // 員工
    int ID; String name ;
    Staff() { this.ID=-1; this.name="XXX"; }
    Staff(int id, String n) { ID=id; name=n;}
}
class Fulltimes extends Staff { // 全職員工
    double baseSalary; int lenOfService ; // 底薪與年資
    // DIY: 自行加入合適的建構式與toString()
    Fulltimes(){
        super();
        this.baseSalary = -1;
        this.lenOfService = -1;
    }
    Fulltimes(int ID, String name, double baseSalary, int lenOfService){
        super(ID, name);
        this.baseSalary = baseSalary;
        this.lenOfService = lenOfService;
    }
    
    public String toString(){
        DecimalFormat d = new DecimalFormat("#,###,###");
        String baseSalary = d.format(this.baseSalary);
        return "(" + this.ID + ", " + "\"" + this.name + "\", " + baseSalary + ", " +  this.lenOfService + ")";
    }

}
public class P23_EX3_TestFullTime {
    public static void main(String[] args){
         Fulltimes f1 = new Fulltimes() ; // -1, XXX, -1, -1
         Fulltimes f2 = new Fulltimes(1001,"Peter",32000,5) ;
         System.out.println(f1+"\n"+f2) ;
    }
}