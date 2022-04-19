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
import java.io.* ; 
public class P87_EX1_BinCopy {
    public static void main(String[] args) throws IOException{
        String srcFile = "D:/meme/醒來只會更悲慘.png", destFile = "D:/Data/test.txt" ; 
        FileInputStream fis = new FileInputStream(srcFile) ;
        FileOutputStream fos = new FileOutputStream(destFile) ;
        // DIY here
        int c;
        
        while((c=fis.read()) != -1){
            fos.write(c);
        }
        
        fis.close();
        fos.close();
        
    }
}
