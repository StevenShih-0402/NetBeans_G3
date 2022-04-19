/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk8;

/**
 *
 * @author steve
 */
import java.io.*;
public class MI3A_24_HWK8_02 {
    public static void main(String[] args) throws IOException{
        String srcFile = "D:/Data/input.txt";
        String destiFile = "D:/Data/output.txt";
        
        FileReader fr = new FileReader(srcFile);
        FileWriter fw = new FileWriter(destiFile);
        int c;
        
        while((c = fr.read()) != -1){
            fw.write((char) c);
        }
        
        fw.flush();
        fw.close();
        fr.close();
    }
}