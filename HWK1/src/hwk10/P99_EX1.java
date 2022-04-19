/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk10;

/**
 *
 * @author steve
 */
import java.io.*;
import java.util.Scanner;
public class P99_EX1 {
    /*
    static String s = "#Peter Male 34500\n"+
                "#Mary Female 53667.8\n"+
                "#Killer Male 44333"; 
    */
    static String s = """
                      #Peter Male 34500
                      #Mary Female 53667.8
                      #Killer Male 44333""";   
    
    public static void main(String[] args) throws IOException {
        parseByScanner(); 
        parseByStreamTokenizer();
    }
    public static void parseByStreamTokenizer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:/Data/ip.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Data/op.txt"));
        
        String line;
        while((line = br.readLine()) != null){
            StringReader sr = new StringReader(line);
            StreamTokenizer st = new StreamTokenizer(sr);
            
            int state = 0;
            while(true){
                if(st.nextToken() == st.TT_EOF)
                    break;
                switch(state){
                    case 0:
                        if(st.ttype == '#'){
                            bw.write("@");
                            state++;
                        }
                        break;
                    case 1:
                        if(st.ttype == StreamTokenizer.TT_WORD){
                            bw.write("<"+st.sval + ">");
                            state++;
                        }
                        break;
                    case 2:
                        if(st.ttype == StreamTokenizer.TT_WORD){
                            bw.write("<"+st.sval + ">");
                            state++;
                        }
                        break;
                    case 3:
                        if(st.ttype == StreamTokenizer.TT_NUMBER){
                            bw.write("<"+st.nval + ">");
                            state=0;
                        }
                        break;
      
                }
            }
            bw.newLine();
            sr.close();
        }
        
        br.close();
        bw.close();
    }
    public static void parseByScanner() throws IOException {
        StringReader sr = new StringReader(s) ;
        Scanner cin = new Scanner(sr) ; 
        while (cin.hasNext()) {
            // #Peter Male 34500
            String name = cin.next().substring(1); // 去除"#"
            boolean gender = cin.next().equals("Male") ;
            double salary = cin.nextDouble() ;
            // @<Peter><Male><34500>
            System.out.printf("@<%s><%s><%d>\n",name,gender,((int)salary));
        }
        sr.close(); 
    }
}