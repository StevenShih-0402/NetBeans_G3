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
public class P94_EX2_DirCopy {
    public static void main(String[] args) throws Exception {
        String srcName = "d:/Data", destiName = "d:/Data/jpg";
        File srcDir = new File(srcName), destiDir = new File(destiName);
        if (!srcDir.exists()) {
            System.out.println(srcName + " error!");
            System.exit(0);
        }
        if (!destiDir.exists()) {
            destiDir.mkdirs();
        }
        dirCopy(srcDir, destiDir, "jpg");
    }

    public static void dirCopy(File srcDir, File destiDir, String suffix) throws Exception {
        if (srcDir.isFile() || destiDir.isFile()) {
            return;
        }
        File[] flist = srcDir.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File filePath, String dataType){
                return dataType.endsWith(suffix);
            }
        });
        // 過濾檔案可參考listFiles(FileFilter filter), listFiles(FilenameFilter filter)
        // --- DIY here, 使用FileInputStream+FileOutputStream複製檔案 ---
        
        for(File f : flist){
            if(!(f.isDirectory())){
                FileInputStream fis = new FileInputStream(f.getAbsolutePath());
                File newData = new File(destiDir, f.getName());
                newData.createNewFile();
                FileOutputStream fos = new FileOutputStream(newData.getAbsolutePath());
                
                int byt = 0;
                while((byt = fis.read()) != -1){
                    fos.write(byt);
                }
                
                fis.close();
                fos.close();
            }        
        }

        
    }
}
