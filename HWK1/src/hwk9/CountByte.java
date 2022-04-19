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
public class CountByte {
    public static void main(String[] args)throws IOException{
        String srcFile = "D:/Data/wind_of_hope.mp3";
        FileInputStream fis = new FileInputStream(srcFile);
        int bt, bts=0;
        while((bt = fis.read()) != -1){
            bts++; 
        }
        
        System.out.printf("%,d bytes", bts);
    }
}
