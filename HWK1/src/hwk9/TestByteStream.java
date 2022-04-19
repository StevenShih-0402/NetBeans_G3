/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk9;

/**
 *
 * @author steve
 */
import java.io.*;
public class TestByteStream {
    public static void main(String[] args) throws IOException{
        String[] names = {"Peter", "Paul", "Mary", "Joe", "Cathy", "Samuel"};
        double[] scores = {88.5, 47.9, 90.3, 77.5, 65.8, 92.3};
        
        writeToBinaryFile("D:/Data/test.bin", names, scores);
        readFromBinaryFile("D:/Data/test.bin");
    }
    
    public static void writeToBinaryFile(String fName, String[] ns, double[] ss) throws IOException{
        FileOutputStream fos = new FileOutputStream(fName);
        DataOutputStream dos = new DataOutputStream(fos);
        
        for(int i = 0; i < ns.length; i++){
            dos.writeInt(i);
            dos.writeUTF(ns[i]);
            dos.writeDouble(ss[i]);
        }
        dos.writeInt(ns.length);
        dos.close();
        
    }
    
    public static void readFromBinaryFile(String fName) throws IOException{
        FileInputStream fis = new FileInputStream(fName);
        DataInputStream dis = new DataInputStream(fis);

        while(dis.readInt() < 6){
            System.out.println("(" + dis.readUTF() + "," + dis.readDouble() + ")");
        }
        
        dis.close();
    }
}
