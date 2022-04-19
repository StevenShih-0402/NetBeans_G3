package Re_HWK6;

import java.net.* ;
import java.io.* ;
public class FileClient {
    static String localDir = "D:/Data/HWK6" ; // 或者c:/local
    
    public static void main(String[] args) throws Exception {
        System.out.println("--- FTP Client ----");
        System.out.println("本地端目錄: "+localDir);
        
//        getFileFromServer("test1.txt", "127.0.0.1", 5555) ; // 下載檔案
         putFileToServer("upload1.txt", "127.0.0.1", 5555) ;  // 上傳檔案
    }
    
    
    private static void getFileFromServer(String fileName, String IP, int port) throws Exception {
        System.out.println(">>> download "+fileName+" to Server:"+IP);
          Socket querySocket = new Socket(IP, port);    // Client端的Socket
          
          // === (1) 傳送下載命令給Server
          DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream()) ;
          dos.writeUTF("GetFile") ;       // 傳送第一段指令：下載/上傳
          dos.writeUTF(fileName) ;       // 傳送第二段指令：檔案名稱
          dos.flush();
          
          // === (2) 等待接收Server的回應
          DataInputStream dis = new DataInputStream(querySocket.getInputStream()) ;
          String res = dis.readUTF();       // 讀取第三段指令
          System.out.println("response="+res) ;
          if (res.equalsIgnoreCase("Success")) {        // 如果第三段指令=Success
            int len = dis.readInt() ;                              // 讀取第四段指令
            byte[] b= new byte[len] ;
            dis.readFully(b);                                         // 讀取第五段：檔案
            
            // ==== (3) 寫入本地端的檔案系統 ====
            try(FileOutputStream fos = new FileOutputStream(localDir+"/"+fileName)){
                fos.write(b) ;
            }
            System.out.println("download complete! ("+fileName+")") ;
          }
          // === (3) 關閉Socket
          dos.close();
          dis.close();
          querySocket.close();
    }
    
    
    private static void putFileToServer(String fileName, String IP, int port) throws Exception {
        System.out.println(">>> upload "+fileName+" to Server:"+IP);
        
          // === (1) 準備上傳檔案所需之各項資訊 ===
          File uploadFile = new File(localDir+"/"+fileName) ;
          int len = (int)uploadFile.length() ; 
          System.out.println("Len="+len);
          byte[] bs = new byte[len] ; 
          try(DataInputStream fdis = new DataInputStream(new FileInputStream(uploadFile))){
              fdis.readFully(bs);
          }

          // === (2) 將各項資訊傳給伺服器 ===          
          Socket querySocket = new Socket(IP, port);
          DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream()) ;
          dos.writeUTF("PutFile") ;       // 傳送第一段指令：下載/上傳
          dos.writeUTF(fileName) ;       // 傳送第二段指令：檔案名稱                    
          dos.writeInt(len) ;                   // 傳送第三段指令：檔案長度
          dos.write(bs);                          // 傳送第四段：檔案
          dos.flush() ;
          
          // === (3) 等待接收Server的回應
          DataInputStream dis = new DataInputStream(querySocket.getInputStream()) ;
          String res = dis.readUTF(); // 讀取回應字串
          System.out.println("response="+res) ;
          
          dos.close();
          dis.close();
          querySocket.close();
    }    
}

