/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk11;

/**
 *
 * @author steve
 */
import java.io.*;
class MyData implements java.io.Serializable{
    String name ;  char sex ;  double salary ;
    public MyData() { }
    public MyData(String _name, char _sex, double _salary) {
        name = _name; sex = _sex; salary = _salary ;
    }
    @Override
    public String toString() {
        return String.format("(%s,%c,%.2f)",name,sex,salary) ; 
    }
}
public class HWK11_18_01 {
    public static void main(String[] args) throws Exception {
//        Demo2() ; 
         EX_V1() ; 
         EX_V2() ; 
    }
    public static void Demo2() throws Exception {
        MyData md = new MyData("Peter", 'M', 45000.8);
        String filename = "D:/Data/op.bin";

        // === 將md物件的內容寫入檔案中 ===
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            oos.writeObject(md);
        }
        // oos.close() ;
        
        // === 將檔案中的物件讀出來 ===== 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
        {
            MyData md1 = (MyData) ois.readObject();
            System.out.println(md1);
        }
        // ois.close() ; 
    }
    public static void EX_V1() throws IOException, ClassNotFoundException {
        MyData[] mds = {new MyData("Peter", 'M', 45000.8), 
                                    new MyData("Mary", 'F', 37500.4),
                                    new MyData("Joe", 'M', 84500.0)} ;
        String filename = "D:/Data/op.bin";        
	// DIY here, 
        // (1) write each object in MyData[] one by one to a binary file 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            for(MyData m : mds){
                oos.writeObject(m);
            }
        }
        // (2) read objects from the binary file and print them out
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
        {
            for(int i = 0; i < mds.length; i++){
                MyData md1 = (MyData) ois.readObject();
                System.out.println(md1);
            }
        }
    }
    public static void EX_V2() throws Exception {
        MyData[] mds = {new MyData("Peter", 'M', 45000.8), 
                                        new MyData("Mary", 'F', 37500.4),
                                        new MyData("Joe", 'M', 84500.0)} ;
	// DIY here,
        String filename = "D:/Data/op2.bin";   
        // (1) write the whole array out at once 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            oos.writeObject(mds);
            
        }
        // (2) read it from the binary file and print the array out
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) 
        {
            MyData[] mm = (MyData[])ois.readObject();
            System.out.println(mm.toString());
            
        }
    }    
}
