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
public class MI3A_24_HWK8_01 {
    public static void main(String[] args) throws IOException{
        final String PATH = "D:/Data/input.txt";
        FileReader fr = new FileReader(PATH);
        int c, space=0, br=0;
        
        while((c = fr.read()) != -1){
            System.out.print((char) c);
            if((char) c == ' ')
                space++;
            else if((char) c == '\n')
                br++;
        }
        
        fr.close();
        System.out.println("\n\nSpace:" + space + "  Return:" + br);
    }
}
