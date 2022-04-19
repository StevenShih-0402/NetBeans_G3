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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MI3A_24_03 {
	//d:/Data/data.bin
    public static void main(String[] args) throws IOException {
        String srcName =  "D:/Data"; //System.getProperty("user.dir")+"\\src\\javaapplication74\\";
        String inpath1 = "ipt4.bin";
        String outPath = "opt3.txt";

        File in1 = new File(srcName, inpath1);
        File op = new File(srcName, outPath);

        String p1 ="";
        String p2 = "";
        int temp;
        int count= 0;
        //DataInputStream/FileInputStream, FileReader/PrintWriter
        DataInputStream di = new DataInputStream(new FileInputStream(in1));     //讀取bin檔
        PrintWriter pw = new PrintWriter(new FileWriter(op));                                  //用PrintWriter印出
        while((temp=di.read())!=-1){
            //System.out.println(temp+" "+(char)temp+" "+Character.isLetter(temp));
            if(temp>0){
                count=temp;
                break;
            }
        }
        System.out.println(count);
        
        for(int i=0;i<count;i++){
            boolean lock = true;
            String s ="";
            int count2 = 0;
            while((temp=di.read())!=-1){
                //System.out.println(temp+" "+(char)temp+" "+Character.isLetter(temp));
                if(Character.isLetter(temp)){           //判斷是否為字母
                    lock=false;
                    s += (char)temp;
                }
                if(Character.isLetter(temp)==lock){
                    System.out.println(s);
                    pw.format("%-8s",s);
                    break;
                }
            }
            while((temp=di.read())!=-1){
                if(temp>0){
                    count2=temp;
                    System.out.println(count2);
                    break;
                }
            }
            int sum=0;
            String sign= "-->";
            for(int c=0;c<count2;c++){
                while((temp=di.read())!=-1){
                    if(temp>0){
                        sum+=temp;
                        System.out.println(temp);
                        pw.format("%5s",temp);
                        break;
                    }
                }
            }pw.format("%5s%5s\n",sign,sum);
        }
        pw.close();

    }
}

