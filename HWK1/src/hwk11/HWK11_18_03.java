/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk11;

/**
 *
 * @author steve
 */

/*
3. 撰寫一Java程式，具有分割與合併檔案的功能，操作概要如下:
(1) split (2) merge (3) exit: 1 (按Enter)
File to be split: d:/Data/test.mp3
How many kb(s)/per splitted file: 1024
--- spliting file ---
test_mp3_0  test_mp3_1   test_mp3_2
test_mp3_3  test_mp3_4	test_mp3_5
--- Splitting complete ---

(1) split (2) merge (3) exit: 2 
File to be merge: d:/Data/test_mp3_0
--- merging file ---
test_mp3_0  test_mp3_1  test_mp3_2
test_mp3_3  test_mp3_4  test_mp3_5
-> generating merged file: test_new.mp3
--- Merging complete ---
*/
import java.io.* ;
import java.util.*;
public class HWK11_18_03 {
    public static void main(String[] args) throws IOException {
        Scanner cin = new Scanner(System.in) ; 
        int choice = 0 ;
        while (true) {
            System.out.print("(1) split (2) merge (3) exit: ") ; 
            choice = cin.nextInt() ; 
            if (choice==1) {
                split("D:/Data", "BIGDADBERTOSH-DRIVES.mp3") ;                 
            } else if (choice ==2) {
                merge("D:/Data", "BIGDADBERTOSH-DRIVES_mp3_0") ; 
            } else {
                break ; 
            }            
        }
        
    }
    public static void split(String baseDir, String filename) throws IOException {
        // DIY 
        File docDir = new File(baseDir, filename);
        System.out.println("File to be split: " + docDir.getAbsolutePath());
        System.out.println("How many kb(s)/per splitted file: 1024000"); 
        System.out.println("--- spliting file ---");
        
        try(RandomAccessFile ras = new RandomAccessFile(docDir.getAbsolutePath(), "rw"))
        {
            byte[] data = new byte[(int)ras.length()];
            ras.readFully(data);
            String s = filename.replace(".", "_");
            for(int i = 0; i <= (data.length / 1024000); i++){
                File docSplit = new File(baseDir, s + "_" + i);
                try(RandomAccessFile rasplit = new RandomAccessFile(docSplit.getAbsolutePath(), "rw"))
                {
                    if(!(data.length - i * 1024000 < 1024000)){
                        rasplit.write(data, i*1024000, 1024000);
                        System.out.println(docSplit.getName());
                    }
                    else if(data.length - i * 1024000 < 1024000){
                        rasplit.write(data, i *1024000, data.length-i*1024000);
                        System.out.println(docSplit.getName());
                    }
                }
            }
            
            System.out.println("--- Splitting complete ---\n\n");
        }
        
    }
    public static void merge(String baseDir, String firstFile) throws IOException {
        // DIY
        File docDir = new File(baseDir, firstFile);
        System.out.println("File to be merge: " + docDir.getAbsolutePath());
        System.out.println("--- merging file ---");

        File newFile = new File(baseDir, "test_new.mp3");
        try(RandomAccessFile ras = new RandomAccessFile(newFile.getAbsolutePath(), "rw"))
        {
            File base = new File(baseDir);
            File[] Flist = base.listFiles();
            String rex = ".+_[\\d]+";
            
            for(File f : Flist){
//                System.out.println(f.getName());
                if(f.getName().matches(rex)){
                    try(RandomAccessFile rascopy = new RandomAccessFile(f.getAbsolutePath(), "rw"))
                    {
                        byte[] data = new byte[(int)rascopy.length()];
                        rascopy.readFully(data);
                        System.out.println(f.getName());
                        
                        ras.write(data);
                    }
                }
            }
        }
        System.out.println("\n->generating merged file: test_new.mp3"); 
        System.out.println("--- Merging complete ---\n\n");
    }    
}

