/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk3;

/**
 *
 * @author steve
 */
class Point{ 
    int x, y ; 
    
    Point(){
        this.x = -1;
        this.y = -1;
    }
    
    void set(int a, int b) { 
        this.x = a; 
        this.y = b;
    }
    
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
}
class Point3D extends Point {
    int z ;
    
    Point3D(){
        super.set(-1, -1);
        this.z = -1;
    }
    
    Point3D(int x, int y, int z){
        super.set(x, y);
        this.z = z;
    }
    
    void set(int a, int b, int c) { 
        super.set(a,b); 
        this.z = c ;
    }
    
    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }
}
class Sphere extends Point3D{ // 球體
    double r;
    
    Sphere(){
        super();
        this.r = -1;
    }
    
    Sphere(int a, int b, int c, double r){
        super(a,b,c);
        this.r = r;
    }
    
    void set(int a, int b, int c, double r) { 
        super.set(a,b,c);  
        this.r = r;
    } 
    
    public String toString(){
        return "(x,y,z)=(" + this.x + "," + this.y + "," + this.z + "), r=" + this.r;
    }
}
public class P24_Demo_TestSphere {
    public static void main(String[] args) {
        Sphere cp = new Sphere();
        cp.set(5, 3, 9); cp.r = 12.5;
        cp.set(3, 4, 5, 7.3) ;
        
        // 承上，請為上述各類別加入建構式與toString()，印出規定輸出
        Sphere sp = new Sphere(5, 3, 9, 12.5) ;
        System.out.println("sp="+sp) ;// 印出(x,y,z)=(5,3,9), r=12.5
        
    }
}
