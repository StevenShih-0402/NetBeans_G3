/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK4;

/**
 *
 * @author steve
 */
import java.net.* ;
import java.io.* ;
import java.awt.Toolkit;
import javax.net.ssl.HttpsURLConnection ;

public class MI3A_26_HWK4_01{
    public static void main(String[] args) throws Exception {
        // === 假裝本連線是瀏覽器，以免HTTP Server阻攔
        URL url = new URL("https://tw.yahoo.com") ;                                                     //建立連結
        HttpsURLConnection uc = (HttpsURLConnection) url.openConnection(); 
        uc.addRequestProperty("User-Agent", " Firefox/3.0.10"); 
        HttpsURLConnection.setFollowRedirects(false);

        InputStreamReader isr = new InputStreamReader(uc.getInputStream(),"utf-8") ;    //抓取資料
        
        try(BufferedReader br = new BufferedReader(isr) ;){
            String inputLine="";
            int count = 1;
            while ((inputLine = br.readLine()) != null) {
                if(inputLine.indexOf("人") != -1){
                    System.out.println("["+ (count++) + "]\n" + inputLine+"\n\n\n");        //找到後印出整行，並換行三次
                    Toolkit.getDefaultToolkit().beep();                                                             //發出提示音
                    try{                                                                                                                //找到後停止2秒
                        Thread.sleep(2000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }      
    }
}
