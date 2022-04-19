/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author steve
 */
public class MI3A_26_04 {
    public static void main(String[] args) throws MalformedURLException, IOException{
        String urlStr = "D:/Data/小考第4題.txt";
        String newStr = "";
        
        URL url = new URL(urlStr);
        URLConnection uc = url.openConnection();
        
        InputStreamReader isr = new InputStreamReader(uc.getInputStream());
        
        String line;
        try(BufferedReader br = new BufferedReader(isr)){
            while((line=br.readLine()) != null){
                newStr += line.replace("[", "").replace("]", "").replace(",", "-") + "\n";
            }
        }
        
        System.out.println("newStr = \n" + newStr);
        
    }
}
