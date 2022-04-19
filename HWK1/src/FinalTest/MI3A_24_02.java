package FinalTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author steve
 */
package javaapplication74;

import java.io.*;
import java.util.LinkedList;

public class MI3A_24_02 {

    public static void main(String[] args) throws IOException {
        String srcName =  "D:/Data"; //System.getProperty("user.dir")+"\\src\\javaapplication74\\";
        FileReader fr = new FileReader(srcName+"/ipt3.txt");
        FileWriter fw = new FileWriter(srcName+"/opt2.txt");

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        String ss = "";
        int c;
        while ((c=br.read()) != -1) {
            ss += (char) c;
        }

        String[] students = ss.split("\r\n");

        double tsum=0;
        double[] avgGrade = new double[students.length];
        
        for (int i=0; i<students.length; i++) {
            double sum = 0;
            double cnt = 0;
            String[] std = students[i].split(",");

            for (int j=1; j<std.length; j++) {
                if (!(std[j].contains("-"))) {
                    sum += Integer.parseInt(std[j].trim());
                }
                cnt++;
            }
            
            avgGrade[i] = sum / cnt;
            tsum+=avgGrade[i] ;
        }
        
        for (int i=0; i<students.length; i++) {
            String[] std = students[i].split(",");
            String sp;
            if (avgGrade[i] > (tsum /avgGrade.length)) {
                sp = "Above";
            }
            else {
                sp = "Below";
            }
            String t = String.format("%.1f", avgGrade[i]);
            bw.write(String.format("%-10s%5s%s%-10s\n", std[0], t, " ", sp));
			
//                bw.write();
        }
        bw.close();
		
    }
}

