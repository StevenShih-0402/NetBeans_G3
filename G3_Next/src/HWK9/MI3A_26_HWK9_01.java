/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWK9;

/**
 *
 * @author steve
 */
import java.awt.event.*;
import javax.swing.* ;
import java.util.* ;
import java.awt.* ;

interface StackListener {  
    void updateUI() ; 
}

interface StackModel {
    void push(Object x) ;    
    Object pop() ;
    void addListener(StackListener sl) ;
}

// VisualStack = StackModel + StackUI
// === (1) StackModel ===
class DefaultStackModel implements StackModel{
    // listener 儲存對於堆疊內容改變有興趣的物件(此處為StackUI)
    ArrayList<StackListener> listener = new ArrayList() ;
    private Vector data = new Vector() ; // 可自動增加長度的陣列

    public void addListener(StackListener sl) { 
        listener.add(sl) ;
    }
    public void notifyStackListener() {
        for (int i = 0 ; i<listener.size(); i++) 
            listener.get(i).updateUI() ;
    }
    public void push(Object x) {
        data.add(x);
        notifyStackListener();
    }
    public Object pop() {
        Object obj = data.remove(data.size() - 1);
        notifyStackListener();
        return obj;
    }
    public String toString() {
        return data.toString().replace("[","").replace("]","") ;
    }        
}

// === (1) UI-Delegate: 堆疊的視覺化操作介面 ===
class StackUI extends JFrame implements StackListener, ActionListener {
    StackModel model; //此畫面所代表之堆疊資料結構
    JTextField tf = new JTextField(10) ; //顯示stack全部內容
    JButton push = new JButton("Push") ;
    JButton pop = new JButton("Pop") ;
    JTextField newItem = new JTextField(3) ;
    JLabel lbl = new JLabel("堆疊內容:") ;
    
    public StackUI() {	
        Container cp = this.getContentPane() ;
        cp.setLayout(new GridLayout(2,1));
        JPanel panel1 = new JPanel() ;
        JPanel panel2 = new JPanel() ;
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        
        panel1.add(newItem); 
        panel1.add(push); 
        panel1.add(pop) ;
        
        panel2.add(lbl) ; 
        panel2.add(tf) ; 
        
        cp.add(panel1) ;    
        cp.add(panel2) ; 
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(0,0,300,150);  
        setVisible(true) ;
        push.addActionListener(this);
        pop.addActionListener(this);
        
    }
    public void updateUI() { 
        tf.setText(model.toString());
    } 
    public StackModel getModel() {
        return model; 
    }
    public void setModel(StackModel sm) { 
        model =sm ; 
        model.addListener(this) ; 
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == push) 
            model.push(newItem.getText()) ;
        else if (e.getSource() == pop)
            model.pop() ;
        newItem.setText("");
    } 
}

class StackUI2 extends JFrame implements StackListener, ActionListener {
    StackModel model;
    JTextField tf = new JTextField() ;
    
    public StackUI2() {
        tf.setFont(new Font("Klee One", Font.BOLD, 36));
        tf.setForeground(new Color(46,97,113));
        
        Container cp = this.getContentPane() ;
        cp.setLayout(new BorderLayout());
        cp.add(tf, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(300,0,300,150);
        setVisible(true) ;
    }
    public void updateUI() { 
        tf.setText(model.toString());
    } 
    public void setModel(StackModel sm) { 
        model =sm ; 
        model.addListener(this) ; 
    }
    public void actionPerformed(ActionEvent e){}
}

public class MI3A_26_HWK9_01{
    public static void main(String[] args) {
        DefaultStackModel stkModel = new DefaultStackModel() ;
        StackUI sui = new StackUI() ;
        StackUI2 sui2 = new StackUI2();
        sui.setModel(stkModel) ;
        sui2.setModel(stkModel);
    }
}
