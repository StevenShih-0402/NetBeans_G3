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
public class startsocketServer {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(4444);
        System.out.println("---Server Init---\n");
        
        while(true){
            Socket querySocket = ss.accept(); // 取得Client端的Socket
            System.out.println("accept a client : " + querySocket);
            
            String req = new DataInputStream(querySocket.getInputStream()).readUTF();
            String res = "Unknown";
            
            if(req.equalsIgnoreCase("Hello")){
                res = "Server : Welcome!";
            }
            
            new DataOutputStream(querySocket.getOutputStream()).writeUTF(res);
            querySocket.close();
        }
    }
}
