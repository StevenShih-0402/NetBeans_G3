/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midTest;

/**
 *
 * @author steve
 */
import java.util.Arrays;
class Student { // 父類別，不可修改本類別，否則本題不給分
    private int id ;
    private String name ;
    Student() {}
    Student(int a, String b) { id=a; name=b; }
    int getId(){ return id ; }
    String getName(){ return name; }
    void set(int a, String b) {id=a; name=b; }
}

class StudInfo extends Student { //  子類別
    int[] score ;
    
    StudInfo() { }
    // 依照main()中的需求加入三種建構式5%, 3%, 3%
    StudInfo(int id, String name, int[] score){
        super.set(id, name);
        this.score = Arrays.copyOf(score, score.length);
    }
    StudInfo(Student s, int[] score){
        this(s.getId(), s.getName(), score);
    }
    StudInfo(StudInfo st){
        this(st.getId(), st.getName(), st.score);
    }

    void append(StudInfo si2) { // 9%
        // 若si2的id與this的id相同，則將si2的name複製給this的name, 
        // 並將si2的score[]附加到this的score[]之後; 否則不做任何動作。
        if(this.getId() == si2.getId()){
            super.set(si2.getId(), si2.getName());
            int ori = score.length;
            score = Arrays.copyOf(score, score.length + si2.score.length);
            System.arraycopy(si2.score, 0, score, ori, si2.score.length);
        }

    }
    public String toString() { // 3%
        return "ID=" + this.getId() + " Name=" + this.getName() + Arrays.toString(score);
    }
}
public class MI3A_24_002 {
    public static void main(String[] args) {
        StudInfo si1 = new StudInfo(1001, "Peter", new int[] {88, 58, 46, 90}) ;
        System.out.println("si1==> "+si1);
        
        Student s2 = new Student(1002, "Mary") ;
        StudInfo si2 = new StudInfo(s2, new int[] {72, 85, 93}) ;
        System.out.println("si2==> "+si2);
        
        StudInfo si3 = new StudInfo(si1) ;
        System.out.println("si3==> "+si3);
        
        si2.set(1001, "Mary");
        si1.append(si2) ;
        System.out.println("si1.append(si2)==> "+si1);
    }
}
/* [程式輸出]
si1==> ID=1001 Name=Peter [88, 58, 46, 90]
si2==> ID=1002 Name=Mary [72, 85, 93]
si3==> ID=1001 Name=Peter [88, 58, 46, 90]
si1.append(si2)==> ID=1001 Name=Mary [88, 58, 46, 90, 72, 85, 93]
 */
