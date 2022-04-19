package HWK6;

import java.io.* ;
import java.net.* ;
public class ChatSender extends Thread {
    String peerIP = "127.0.0.1" ;
    int peerPort = 4444 ;
    String msg = "Hello" ; 
    
    ChatSender(String hIp, int hPort, String msg) {
        this.peerIP = hIp ;
        this.peerPort = hPort ;
        this.msg = msg ;
    }
    public void run() {
        try ( Socket querySocket = new Socket(peerIP, peerPort); 
            DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream()) )
        {
          dos.writeUTF(msg) ;  //將msg傳送到對方(peer)
          // dos.close() ;   querySocket.close();
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }
    public static void main(String[] args) {
        new ChatSender("127.0.0.1", 4444, "Peter: Hello").start() ;
    }    
}
