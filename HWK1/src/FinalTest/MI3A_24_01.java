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

public class MI3A_24_01 {
    public static void main(String[] args) throws Exception {
        String srcName =  "D:/Data"; //System.getProperty("user.dir")+"\\src\\javaapplication74\\";
        String inpath1 = "ipt1.txt";
        String inpath2 = "ipt2.txt";

        String outPath = "opt1.txt";

        File in1 = new File(srcName, inpath1);
        File in2 = new File(srcName, inpath2);
        int a=0,b=0;
        File op = new File(srcName, outPath);
        
        String p1 ="";
        String p2 = "";
        String temp;
        
        try(BufferedReader br1 = new BufferedReader(new FileReader(in1));
                BufferedReader br2 = new BufferedReader(new FileReader(in2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(op)))
        {

            while(true) {
                if((temp=br1.readLine())!=null){
                    p1+=temp+"\n";
                    a++;
                }
                else
                    break;
            }
            while(true) {
                if((temp=br2.readLine())!=null){
                    p2+=temp+"\n";
                    b++;
                }
                else
                    break;
            }


            if(a<b) {
                bw.write(p1);
                bw.write(p2);

            }
            else {
                bw.write(p2);
                bw.write(p1);
            }

        }catch(Exception e){

        }


        System.out.println(p1);
        System.out.println(p2);



    }
	
	
}
