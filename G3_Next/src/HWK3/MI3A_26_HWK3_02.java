/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK3;

/**
 *
 * @author steve
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author aa
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
EX2: 撰寫一程式，啟動n條執行緒，能找出[1, m]中所有質數，最後將其存於一個檔案中(prime_m_n.txt)，並記錄執行時間(與單一執行緒比較)。
     例如，
	m=10_0000, n=4          Thread 1 [1,25000]
                                                            Thread 2 [25001,50000]
                                                            Thread 3 [50001,75000]
                                                            Thread 4 [75001,100000]
*/
public class MI3A_26_HWK3_02{
    static ArrayList<Integer>[] primeListArr;
    public static void main(String[] args) throws InterruptedException, IOException {
        int m = 100000 ;
        int threadNo = 4 ; 
        int gap = m/threadNo ; // 75000
        
        // DIY here
       long start = System.currentTimeMillis();
       Thread[] ts = new Thread[threadNo];
       primeListArr = new ArrayList[threadNo];
       
        System.out.println("--CREATE AND START "+threadNo + "-Threads ----");
       for(int i = 0; i < threadNo; i++){
           int tNo = i, lb = i*gap+1, ub = (i+1)*gap;
           ts[i] = new Thread(()->collectPrimes(tNo, lb, ub));
           ts[i].start();
           System.out.println("Thread-"+i+" [lb="+lb + ", ub="+ub+"]");
       }
       
       for(Thread t : ts){
           t.join();
       }
       long end = System.currentTimeMillis();
       double time = (end-start)/1000.0;
       System.out.printf("cpu time = %.4f (secs)\n",(end-start)/1000.0);    
       
       collectResults(m, threadNo, time);
    }
    
    public static void collectPrimes(int tNo, int lb, int ub){
        primeListArr[tNo] = findPrimes(lb, ub);
    }
    
    public static ArrayList<Integer> findPrimes(int lb, int ub) {
        ArrayList<Integer> primeList = new ArrayList<>() ; 
        // DIY
        for(int i = lb; i < ub; i++){
            if(isPrime(i))
                primeList.add(i);
        }
        return primeList ; 
    }
    
    public static boolean isPrime(int num){
        num = Math.abs(num);
        if(num < 2)
            return false;
        if(num == 2)
            return true;
        int bound = (int)(Math.sqrt(num)+1);
        for(int i = 2; i < bound; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    
    public static void collectResults(int m, int threadNo, double time) throws IOException{
        System.out.println("\n--- collect results from each of primeList ---");
        File f = new File("D:/Data/HWK3/Primes.txt");
        int totalPrimeNo = 0;
        try(FileWriter fw = new FileWriter(f)){
            for(int i = 0; i < primeListArr.length; i++){
                ArrayList<Integer> primeList = primeListArr[i];
                totalPrimeNo += primeList.size();
                System.out.println("#Collected Primes by thread-" + i + ": " + primeList.size());
                String primeStr = primeList.toString().replace("[", "").replace("]", "");
                fw.write(primeStr);
                if(i != primeListArr.length-1){
                    fw.write(", ");
                }
            }
            System.out.println("#total primes=" + totalPrimeNo);
            fw.write(String.format("\ncpu time = %.4f (secs)\n",time));
        }
    } 
}