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
import java.util.*;
public class MI3A_24_HWK8_04 {
    public static void main(String[] args) throws IOException{
        String srcFile = "D:/Data/input-2.txt";
        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        
        String destiFile = "D:/Data/output-2.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(destiFile));
        
        String line;
        
        while((line = br.readLine()) != null){
            String[] elements = line.split("\\s{2,}");
            for(int i = 0; i < elements.length; i++){
                if(!(elements[i].equals("") || elements[i].equals(" "))){
                    bw.write(elements[i]);
                    if(i != 3)
                        bw.write(",");
                }
            }
            bw.newLine();
        }
        
        br.close();
        bw.close();
    }
}
