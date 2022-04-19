/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalTest;

/**
 *
 * @author steve
 */
import java.io.*;
public class MI3A_24_04 {

    public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub
            String srcName =  "D:/Data"; //System.getProperty("user.dir")+"\\src\\javaapplication74\\";
            FileReader sr=new FileReader(srcName+"/ipt4.txt");
            StreamTokenizer st=new StreamTokenizer(new BufferedReader(sr));
            boolean eof = false;
            String s="";
            double d=0;
            int avgc = 0;
            while (!eof){
               int token = st.nextToken();
               switch (token) {
                  case StreamTokenizer.TT_EOF:                         
                     System.out.printf("%s: %.2f\n",s,d/avgc);
                     eof = true;
                     break;
                  case StreamTokenizer.TT_EOL:
                     break;
                  case StreamTokenizer.TT_WORD:
                     s= st.sval;
                     break;
                  case StreamTokenizer.TT_NUMBER:
                     d+= st.nval;
                     avgc+=1;
                     break;
                  default:
                     if (token == '#'&&d!=0) {
                        System.out.printf("%s: %.2f\n",s,d/avgc);d=0;avgc=0;
                     }
               }
            } 
    }

}

