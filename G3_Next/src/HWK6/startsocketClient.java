/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK6;

/**
 *
 * @author steve
 */
import java.net.*;
import java.io.*;
public class startsocketClient {
    public static void main(String[] args) throws IOException{
        Socket querySocket = new Socket("127.0.0.1", 4444);
        
        DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream());       // 傳給Server
        dos.writeUTF("Hello");
        
        
        DataInputStream dis = new DataInputStream(querySocket.getInputStream());                  // 接收Server回傳的訊息
        System.out.println(dis.readUTF());
        
        
        querySocket.close();
    }
}
