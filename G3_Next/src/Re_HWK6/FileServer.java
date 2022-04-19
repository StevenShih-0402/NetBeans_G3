package Re_HWK6;

import java.net.*;
import java.io.*;

public class FileServer {
    // pubDir: 檔案上傳、下載區
    static String pubDir = "d:/Data/pub/"; // 或者 c:/pub
    static boolean running = true;
    
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5555);               // ServerSocket：5555
        System.out.println("File Server Init ....");
        System.out.println("公用目錄: "+pubDir);
        System.out.println("[注意]: 請先在公用目錄中產生任意文字檔text1.txt");
        
        while (running) {
            Socket client = ss.accept();                // 取得Client端的Socket
            System.out.println("accept a client:" + client);
            new Thread(()->processRequest(client)).start() ;
        }
        ss.close();
    }
    private static void processRequest(Socket client) {
        // ==== 1. 接收client傳來的命令
        try ( DataInputStream dis = new DataInputStream(client.getInputStream());  
              DataOutputStream dos = new DataOutputStream(client.getOutputStream())) {
            String cmd = dis.readUTF(); // 讀取第一段指令
            
            // ==== 2. 處理client的命令
            System.out.println("----- Request: " + cmd);
            if (cmd.equalsIgnoreCase("GetFile")) {                          // 如果第一段指令是GetFile，從伺服器下載檔案
                try {
                    var success = processGetFile(dis, dos, pubDir);    // 從伺服器取得檔案(怎麼下載?)
                    if (!success) {
                        dos.writeUTF("Fail");
                    }
                } catch (Exception e) {
                    dos.writeUTF("Fail");
                    e.printStackTrace();
                }
            } else if (cmd.equalsIgnoreCase("PutFile")) {               // 如果第一段指令是PutFile，上傳檔案至FTP Server
                try {
                    processPutFile(dis, dos, pubDir);                          // 上傳檔案到伺服器(怎麼上傳?)
                    dos.writeUTF("Success");
                } catch (Exception e) {
                    dos.writeUTF("Fail");
                    e.printStackTrace(); 
                }
            } else {
                System.out.println("@@@@ Unknown command @@@@\n");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        // dos.close();  dis.close() ;
    }
    private static boolean processGetFile(DataInputStream dis, DataOutputStream dos, String pubDir) throws Exception {
        
        String fileName = dis.readUTF();                        // 讀取第二段指令
        File[] fileList = new File(pubDir).listFiles();         // 建立一個包含Server所有File的陣列
        int i = 0;
        for (; i < fileList.length; i++) {
            if (fileName.equals(fileList[i].getName())) {   // 如果第二段指令符合某個檔名
                dos.writeUTF("Success");                            // 回傳第三段指令：成功/失敗
                int len = (int) fileList[i].length();
                dos.writeInt(len);                                         // 回傳第四段指令：檔案長度
                byte[] bs = new byte[len];
                try (DataInputStream fdis = new DataInputStream(new FileInputStream(fileList[i]))) {
                    fdis.readFully(bs);
                }
                dos.write(bs);                                                // 回傳第五段：檔案
                break;
            }
        }
        return i != fileList.length ; // 找不到要下載的檔案
    }
    private static void processPutFile(DataInputStream dis, DataOutputStream dos, String pubDir) throws Exception {
        
        String fileName = dis.readUTF();                                                        // 讀取第二段指令
        int len = dis.readInt() ;                                                                        // 讀取第三段指令
        System.out.println(">>> "+fileName+", len="+len);
        byte[] bs = new byte[len] ; 
        dis.readFully(bs) ;                                                                                 // 讀取第四段：檔案
        
        File uploadedFile = new File(pubDir, fileName) ;                                // 寫入公用資料夾pub
        System.out.println(">>> Write file to "+uploadedFile+", len"+len);
        try (DataOutputStream fdos = new DataOutputStream(new FileOutputStream(uploadedFile))) {
            fdos.write(bs);
        }
    }
}
