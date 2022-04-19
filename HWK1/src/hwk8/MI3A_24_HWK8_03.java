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
import java.util.*;
import java.io.*;
public class MI3A_24_HWK8_03 {
    public static void main(String[] args) throws IOException{
        String srcFile = "D:/Data/input.csv";
        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        
        String destiFile = "D:/Data/output.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(destiFile));
        
        String line;
        
        while((line = br.readLine()) != null){
            String[] elements = line.split(",");
            for(int i = 0; i <elements.length; i++){
                if(i == 2)
                    bw.write(String.format("%-13s", elements[i]));
                else
                    bw.write(String.format("%-10s", elements[i]));
                
                //下面這行比較像講義上的格式:
                //bw.write(String.format("%s\t", elements[i]));
            }
            bw.newLine();
        }
        
        br.close();
        bw.close();
        
    }
}
