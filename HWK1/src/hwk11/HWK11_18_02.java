/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk11;

/**
 *
 * @author steve
 */
import java.io.* ;
import java.util.Random;
public class HWK11_18_02 {
    public static void main(String []args) throws IOException{
        String filename = "D:/Data/sitdown.jpg" ;
        String filename2 = "D:/Data/sitdown_encrypt.jpg" ;
        
        String passwd = "24680" ; // 假設密碼只能為整數
        encode(filename, passwd, filename2) ; 
        
        String filename3 = "D:/Data/sitdown_decode.jpg";
        decode(filename2, passwd, filename3) ; 
    }
    public static void encode(String filename,  String passwd, String filename2) throws IOException {
        System.out.println("---- Encoding -----");
        // 原始檔family.jpg -> 編碼後，寫入family_encrypt.jpg
        // (1) 讀取檔案 -> byte[]
        try(RandomAccessFile ras = new RandomAccessFile(filename ,"rw");
               RandomAccessFile ras2 = new RandomAccessFile(filename2 ,"rw"); )
        {
            byte[] data = new byte[(int)ras.length()] ;
            ras.readFully(data) ;
        
        // (2) DIY: 處理data[]內容, 方式如下: 
        // 利用passwd做為亂數種子，隨機選取data[]中的任意byte，與data[0]互換，
        // 共進行1000次
        // 最後將結果寫入family_encrypt.jpg(加密檔)
        
            Random r = new Random(Integer.parseInt(passwd));
            for(int i = 0; i < 1000; i++){
                int rdm = r.nextInt(data.length);
                byte temp = data[rdm];
                data[rdm] = data[0];
                data[0] = temp;
            }

            ras2.write(data);
        }
        
        System.out.println("---- Encoding Completed -----");
    }
    public static void decode(String filename2, String passwd, String filename3) throws IOException {
        System.out.println("---- Decoding -----");
        // DIY: 解碼family_encrypt.jpg 產生family_decoded.jpg
        try(RandomAccessFile ras2 = new RandomAccessFile(filename2 ,"rw");
              RandomAccessFile ras3 = new RandomAccessFile(filename3 ,"rw");)
        {
            byte[] data = new byte[(int)ras2.length()] ;
            ras2.readFully(data) ;
            Random r = new Random(Integer.parseInt(passwd));
            int[] q = new int[1000];
            
            for(int i = 0; i < 1000; i++){
                q[i] = r.nextInt(data.length);
            }
            
            for(int j = 999; j >=0; j--){
                byte temp = data[q[j]];
                data[q[j]] = data[0];
                data[0] = temp;
            }
            
            ras3.write(data);

        }
        System.out.println("---- Decoding Completed -----");
    }    
}


