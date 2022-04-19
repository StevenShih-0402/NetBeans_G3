/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk10;

/**
 *
 * @author steve
 */

import java.io.*;
import java.util.ArrayList;
class StaffX {
    String name ; boolean gender; double salary ;
    StaffX(String a, boolean b, double c) { 
        name=a; gender=b; salary=c;
    }
    // DIY, 自行加上toString(), 格式如(name,gender,salary)
   @Override
    public String toString(){
       return "(" + name + ","+ gender + ","+ salary + ")";
   }
} 
class StaffTable {
    ArrayList<StaffX> staffList = new ArrayList<>(); 
    // Staff[] staffList ; 
    StaffTable(String filename) throws IOException{
        // DIY, 由檔案filename中讀取
        // d:/Data/staff.txt內容如下
        // Peter,true,38000.5
        // Mary,false,43875.2
        // Joe,true,50000.0
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        String line;
        while((line = br.readLine()) != null){
            String[] fileData = line.split(",");
            StaffX data = new StaffX(fileData[0], Boolean.parseBoolean(fileData[1]), Double.parseDouble(fileData[2]));
            this.staffList.add(data);
        }
        
    }
    double avgSalary() {
        double total = 0;
        for(StaffX x : staffList){
            total += x.salary;
        }
        return total / staffList.size(); // DIY
    }
    void print(String formatString) {
        // 依照formatString逐列印出staff的內容
        // formatString = "%-9s%7s%9.1f"
        for (StaffX staff : staffList) {
            // DIY 
            System.out.printf(formatString, staff.name, staff.gender, staff.salary);
        }
    }
    public String toString() {
        String s = "";
        for(StaffX x : staffList){
            s += x.toString() + "\n";
        }
        
        return s;
    }
}
public class P96_EX3_StaffTable {
    public static void main(String[] args) throws IOException{
        StaffTable sTable = new StaffTable("d:/Data/staff.txt") ;
        System.out.println("avg salary="+sTable.avgSalary());
        sTable.print("%-9s%7s%9.1f%n");
        System.out.println("Staff Table=\n"+sTable);
    }
}

