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
import java.net.*;
import java.io.*;
public class MI3A_26_HWK5_01 {
    public static void main(String[] args) throws Exception {
        try(BufferedReader br = new BufferedReader(new FileReader("D:/Data/HWK5/圖片集.txt"))){
            String line;
            int count = 1;
            while((line=br.readLine()) != null){
                URL url = new URL(line);
                URLConnection uc = url.openConnection();
                InputStream is = uc.getInputStream() ;
                int len = uc.getContentLength();  //  擷取此URL之長度(byte數)
                byte[] bs = new byte[len] ; // 安排一陣列儲存此張圖片
                

                try(DataInputStream dis = new DataInputStream(is);) // 透過dis串流，將bs[]裝滿
                { 
                    dis.readFully(bs);
                }
                //--- 寫入本地端的硬碟中 ---
                try(FileOutputStream fos = new FileOutputStream("d:/Data/HWK5/imgur圖片[" + (count++) + "].png") ;)
                {
                    fos.write(bs);
                }
            }
        }
        
    }
}
