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
public class yahooReader {
    public static void main(String[] args) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("D:/Data/Yahoo_index_html.txt"));
              BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Data/pic_url.txt"));)
        {
            int urlNum = 1;
            String line;
            while((line=br.readLine()) != null){
                try(StringReader sr = new StringReader(line);)
                {
                    StreamTokenizer st = new StreamTokenizer(sr);
                
                    int state = 0;
                    while(true){                                                                                                            
                        if(st.nextToken() == StreamTokenizer.TT_EOF)
                           break;   

                        switch(state){
                            case 0:
                                if(st.ttype == '<'){
                                    state++;
                                }
                                break;
                            case 1:
                                if(st.ttype == StreamTokenizer.TT_WORD){
                                    if(st.sval.contentEquals("img")){
                                        state++;
                                    }
                                }
                                break;
                            case 2:
                                if(st.ttype == StreamTokenizer.TT_WORD){
                                    if(st.sval.contentEquals("src")){
                                        state++;
                                    }
                                }
                                break;
                            case 3:
                                if(st.ttype == '\"'){
                                    state++;
                                }
                                break;
                            case 4:
                                if(st.ttype == '\"'){
                                    state = 0;
                                }
                                else{
                                    bw.write("[" + (urlNum++) + "]"  +st.sval);
                                }
                                break;
                        }
                    }
                }

                bw.newLine();
            }
        }
//        br.close();
//        bw.close();
    }
}
