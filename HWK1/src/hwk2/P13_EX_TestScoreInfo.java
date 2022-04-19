/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk2;

/**
 *
 * @author steve
 */
class ClassInfo{ // 紀錄一個班的平均分數
    static final int defaultStudNo = 20; // 預設為20位同學
    static final float defaultScore = -1; // 預設的平均分數
    String className ;
    double[] avgScore; //儲存每位同學的Avg Score
    
    ClassInfo() { 
        //  DIY: 
        this("XXX", defaultStudNo, defaultScore);
    }	
    ClassInfo(String className, int studNo, double initScore) { 
        // DIY        
        // 設定班級名稱，學生人數與初始分數(initScore)
        avgScore = new double[studNo];
        this.className = className;
        for(int i = 0; i < studNo; i++){ 
            this.avgScore[i] = initScore;
        }
        
    }
    void display() { 
        /* DIY */
        System.out.printf("className:%s%n", this.className);
        for(int i = 0; i < this.avgScore.length; i++){
            System.out.printf("[%d]:%.1f%n", i+1, this.avgScore[i]);
        }
        System.out.println("");
    }
}

public class P13_EX_TestScoreInfo {
    public static void main(String[] args) {
        ClassInfo ci1=new ClassInfo() ; // 一個空的班級
        ci1.display() ; // 印出className: XXX(換行)[1]:-1, [2]:-1, [3]:-1, …, [20]:-1

        ClassInfo ci2=new ClassInfo("三乙", 15, 60); //有20人，初始分數為60
        ci2.display(); //印出className:三乙(換行)[1]:60, [2]:60, [3]:60, …, [20]:60
    }
}
