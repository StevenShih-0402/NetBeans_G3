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
import java.util.*;
public class Testyahoo {
        public static void main(String[] args) throws IOException {
        String srcName =  "D:/Data";
        File srcDir = new File(srcName+"/Yahoo_index_html.txt");
        File destDir = new File(srcName+"/pic_url.txt");
        String key = "img src";
        ReadandWrite(srcDir, destDir, key);
    }

    public static void ReadandWrite(File srcDir, File destDir, String key) throws IOException {
        String[] keys = key.split(" ");
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(destDir));) {
            StreamTokenizer st = new StreamTokenizer(new FileReader(srcDir));
            int state = 0;
            while (true) {
                if (st.nextToken() == StreamTokenizer.TT_EOF) {
                    break;
                }
                switch (state) {
                    case 0:
                        if (st.ttype == '<') {
                            state++;
                        }
                        break;
                    case 1:
                        if (st.ttype == StreamTokenizer.TT_WORD && st.sval.contentEquals(keys[0])) {
                        System.out.println(st.sval);
                            state++;
                        }
                        break;
                    case 2:
                        if (st.ttype == StreamTokenizer.TT_WORD && st.sval.contentEquals(keys[1])) {
                        System.out.println(st.sval);
                            state++;
                        }
                        break;
                    case 3:
                        if (st.ttype == '=') {
                        System.out.println("pass case 3");
                            state++;
                        }
                        break;
                    case 4:
                        bw.write(st.sval);
                        bw.newLine();
                        state = 0;
                        break;
                }
            }
        }
    }
}
