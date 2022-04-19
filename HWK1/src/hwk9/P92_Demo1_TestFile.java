/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk9;

/**
 *
 * @author steve
 */
import java.io.*;
import java.util.*;
import javax.swing.*;

public class P92_Demo1_TestFile {

    public static void main(String[] args) throws IOException {
        String srcFile = "d:/Data", destiFile = "d:/Data";
        JFileChooser chooser = new JFileChooser(srcFile);
        int code = chooser.showDialog(null, "choose srcFile");
        if(code == JFileChooser.APPROVE_OPTION){
            File temp = chooser.getSelectedFile();
            srcFile = temp.getPath();
        }
        else if(code == JFileChooser.CANCEL_OPTION){
            System.out.println("Bye!");
            System.exit(0);
        }
        File fin = new File(srcFile);
        if (!fin.exists()) {
            System.out.println(srcFile + ":來源檔不存在");
            System.exit(0);
        }
        
        JFileChooser chooser2 = new JFileChooser(destiFile);
        int code2 = chooser2.showDialog(null, "choose destiFile");
        if(code2 == JFileChooser.APPROVE_OPTION){
            File temp = chooser2.getSelectedFile();
            destiFile = temp.getPath();
        }
        else if(code2 == JFileChooser.CANCEL_OPTION){
            System.out.println("Bye!");
            System.exit(0);
        }
        
        File fout = new File(destiFile);
        if (fout.exists()) {
            System.out.print(destiFile + ":目的檔已存在，要覆寫嗎?(y/n)");
            if (new Scanner(System.in).next().equalsIgnoreCase("n")) {
                System.exit(0);
            }
        }
        FileReader fr = new FileReader(fin);
        FileWriter fw = new FileWriter(fout);

        char[] buf = new char[(int) fin.length()];   //有點危險
        fr.read(buf);    fw.write(buf);

//------讀圖片的方法------
//        FileInputStream fr = new FileInputStream(fin);
//        FileOutputStream fw = new FileOutputStream(fout);
//        int c;
//        while((c = fr.read()) != -1){
//            fw.write(c);
//        }

        fr.close();      fw.close();
//        fin.delete();                         // [optional]: 刪除來源檔
    }
}
