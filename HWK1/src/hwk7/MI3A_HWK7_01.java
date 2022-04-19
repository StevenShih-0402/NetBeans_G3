/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwk7;

import java.util.Arrays;

/**
 *
 * @author steve
 */
class Term {  //表示多項式中的一項
    int coef ; // 此項的係數
    int exponent ; //此項的次方數

    public Term() { }
    public Term(int c, int e) {
        this.coef = c; this.exponent = e;
    }
    public Term(Term t) {
        this.coef = t.coef ; 
        this.exponent = t.exponent ;
    }
    
    public void reset() {
        coef = exponent = 0;
    }

    public Term add(Term t2) { 
        if(t2.exponent!=this.exponent)
            return new Term(0,0);
        int c = t2.coef+this.coef;
        
        return new Term(c,t2.exponent) ; // 撰寫時，請刪除本行
    }
    public Term mul(Term t2) { 
        return new Term(this.coef*t2.coef,this.exponent+t2.exponent) ; 
    }
    public double evalTerm(double x) { 
        int xe = 1;
        for(int i = 0;i<this.exponent;i++)
            xe*=x;
        int an = this.coef*xe;
        return an; 
    }
    public String toString() { 
        if (coef == 0)  
            return "0";
        if (exponent == 0) 
            return String.valueOf(this.coef);
        
        String a, b="X";
        if (this.coef == -1) {
            a = "-";
        }
        else if (this.coef == 1) {
            a = "";
        } 
        else {
            a = String.valueOf(this.coef);
        }
        if (this.exponent !=1)
            b = b+"^"+String.valueOf(this.exponent);
        return a + b;
    }
}

class Polynomial {
    Term[] terms ; // 記錄多項式中包含的各項

    Polynomial(){}
    Polynomial(Term[] ts) { 
        // 利用ts[]初始化terms[], 使用deep copy
        terms = new Term[ts.length];
        for(int i = 0; i < terms.length; i++){
            terms[i] = new Term(ts[i]);
        }
    }
    double eval(double x) { 
        // 將x代入多項式中求值
        double total = 0;
        for(Term t : this.terms){
            total += Math.pow(x, t.exponent) * t.coef;
        }
        return total ;
    }
    Polynomial add(Polynomial p2) { 
        //  將this與p2相加, 並將相加後的多項式傳回, 

        Term[] ans = Arrays.copyOf(this.terms, this.terms.length + p2.terms.length);
        int lon = this.terms.length;
        boolean back = true;
        
        for(int i = 0; i < p2.terms.length; i++){
            for(int j = 0; j < this.terms.length; j++){
                if(p2.terms[i].exponent == this.terms[j].exponent){
                    ans[j].coef += p2.terms[i].coef;
                    back = false;
                }
            }
            if(back)
                ans[lon++] = new Term(p2.terms[i]);
        }
        
        Term[] copyAns = Arrays.copyOf(ans, lon);       
        return new Polynomial(copyAns) ;
    }
    @Override
    public String toString() { 
        // 依照[程式輸出]印出多項式的內容
		// DIY here
        String s = "";
        for(int i = 0; i < this.terms.length-1; i++){
            if(this.terms[i] != null){
                s += this.terms[i].toString();
                if(this.terms[i+1].coef > 0)
                    s += "+";
            } 
        }
        
        s += this.terms[this.terms.length-1].toString();
        return s;
    }
}
public class MI3A_HWK7_01 {
    public static void main(String[] args) {        
        Term[] ts1 = {  new Term(-3, 6), new Term(1,5), new Term(5,3),
                        new Term(-1,1),new Term(3,0) };
        Polynomial p1 = new Polynomial(ts1) ;
        for (int i = 0 ; i<ts1.length; i++)
            ts1[i].reset() ; // 不可刪除本行

        System.out.println("p1="+p1) ;
        double x = 3.5 ;
        System.out.println("p1("+x+")="+p1.eval(x)) ;
        
        Term[] ts2 = {new Term(7,4), new Term(2, 3), new Term(-1,1), new Term(-5,0)} ;
        Polynomial p2 = new Polynomial(ts2) ;
        System.out.println("p2="+p2) ;

        Polynomial p3 = p1.add(p2) ;
        System.out.println("p3=p1+p2="+p3) ;
    }
}
/*
[程式輸出]
p1=-3X^6+X^5+5X^3-X+3
p1(3.5)=-4775.703125
p2=7X^4+2X^3-X-5
p3=p1+p2=-3X^6+X^5+7X^3-2X-2+7X^4
*/

