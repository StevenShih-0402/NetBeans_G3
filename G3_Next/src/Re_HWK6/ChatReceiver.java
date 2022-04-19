package Re_HWK6;

import java.io.* ;
import java.net.* ;

public class ChatReceiver extends Thread {    
    private int portNo = 4444; // default
    private String ipAddr ;
    private boolean running = true ;
    private BlackBoard board = null ;
    
    public ChatReceiver(int pNo, BlackBoard bb){
        try {
            ipAddr = InetAddress.getLocalHost().getHostAddress();
            portNo = pNo ;
            board = bb ;
            System.out.println("Chat Server, My IP addr="+this.ipAddr);
        } catch(Exception e) {
            e.printStackTrace();
        }        
    }
    public void setRunning(boolean b) {
        running = b ;
    }
    public void run() {
       try {
           ServerSocket ss = new ServerSocket(portNo) ;
           System.out.println("---- Server Init ....");
           while (running){
              Socket client = ss.accept() ;
              System.out.println("accept a client:"+client);
              // === 讀取並處理client傳來的訊息
              new Thread(()->processRequest(client)).start();
           }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    private void processRequest(Socket client) {
        try {
            String msg = new DataInputStream(client.getInputStream()).readUTF() ;
            System.out.println(">msg="+msg);
            if (board!=null) 
                board.show(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ChatReceiver(4444, null).start() ; 
    }
}
