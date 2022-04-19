/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK5;

/**
 *
 * @author steve
 */
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
public class MI3A_26_HWK5_02 {
    static int imgCount = 1;
    public static void main(String[] args){
        try{
            URL url = new URL("https://www.yahoo.com.tw"); //建立連結
            HttpsURLConnection uc = (HttpsURLConnection) url.openConnection(); 
            uc.addRequestProperty("User-Agent", " Firefox/3.0.10"); 
            HttpsURLConnection.setFollowRedirects(false);
            
            InputStreamReader isr = new InputStreamReader(uc.getInputStream(),"utf-8") ;    //抓取資料
            try(BufferedReader br = new BufferedReader(isr)){
                String line;
                while((line=br.readLine()) != null){
                    try(StringReader sr = new StringReader(line);)
                    {
                        StreamTokenizer st = new StreamTokenizer(sr);

                        int state = 0;
                        while(true){                                                                                                            
                            if(st.nextToken() == StreamTokenizer.TT_EOF)
                               break;   

                            switch(state){
                                case 0:
                                    if(st.ttype == '<'){
                                        state++;
                                    }
                                    break;
                                case 1:
                                    if(st.ttype == StreamTokenizer.TT_WORD){
                                        if(st.sval.contentEquals("img")){
                                            state++;
                                        }
                                    }
                                    break;
                                case 2:
                                    if(st.ttype == StreamTokenizer.TT_WORD){
                                        if(st.sval.contentEquals("src")){
                                            state++;
                                        }
                                    }
                                    break;
                                case 3:
                                    if(st.ttype == '='){
                                        state++;
                                    }
                                    break;
                                case 4:
                                    System.out.println(st.sval);
                                    URL urlImg = new URL(st.sval);
                                    URLConnection uc2 = urlImg.openConnection();
                                    uc2.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36 Edg/99.0.1150.52");
                                    InputStream is = uc2.getInputStream() ;
                                    int len = uc2.getContentLength();  //  擷取此URL之長度(byte數)
                                    byte[] bs = new byte[len] ; // 安排一陣列儲存此張圖片

                                    try(DataInputStream dis = new DataInputStream(is);) // 透過dis串流，將bs[]裝滿
                                    { 
                                        dis.readFully(bs);
                                    }
                                                            //--- 寫入本地端的硬碟中 ---
                                    try(FileOutputStream fos = new FileOutputStream("d:/Data/HWK5/Yahoo[" + imgCount++ + "].jpg") ;)
                                    {
                                        fos.write(bs);
                                    }
                                    
                                    state = 0;
                                    break;
                                    
                            }  // switch
                        }  //inifityLoop
                    }  //StringReader
                }  //readLine
            }   //BufferedReader
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
