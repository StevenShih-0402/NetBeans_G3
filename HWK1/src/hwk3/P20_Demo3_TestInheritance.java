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
class Employee { //公司員工
    int ID ;	String name ;  
    void set(int id, String n) {
        this.ID = id; this.name = n ;
    }
} 
class Fulltime extends  Employee{ // 全職人員
    // int ID ;  String name ; 
    double baseSalary; int lenOfService ;
    
    void set(int ID, String name, double baseSalary){
        super.set(ID, name);
        this.baseSalary = baseSalary;
    }
    
    double calSalary(){
        double salary = this.baseSalary * Math.pow((1 + 0.05), this.lenOfService - 1);
        if(salary > this.baseSalary * 2)
            salary = this.baseSalary*2;
        
        return salary;
    }
    
    public String toString(){
        DecimalFormat d = new DecimalFormat("#,###,###");
        String baseSalary = d.format(this.baseSalary);
        return "(" + this.ID + ", " + "\"" + this.name + "\", " + baseSalary + ", " +  this.lenOfService + ")";
    }
}

public class P20_Demo3_TestInheritance {
    public static void main(String[] args) {
        Fulltime f = new Fulltime() ;
        f.set(1002,"Peter"); // OK ?
        f.baseSalary = 37300 ; // 比照碩士生基本薪資
        f.lenOfService = 5 ; // 年資5年
        System.out.println(f) ;
        System.out.println(f.calSalary());
    }
}