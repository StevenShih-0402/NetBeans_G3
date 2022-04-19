
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
/*
    Awt: 抽象視窗工具組(Abstract Window Toolkit)，是Java最早提供的GUI工具，Swing是基於其不足的部分再開發的，會用到一些作業系統的元件
    event: 事件處理的類別
    ActionEvent: 處理按鈕被按下的事件
    ActionListener: 進行按鈕事件的處理
    KeyAdapter: 一個抽象類別，用來接收鍵盤事件
    KeyEvent: 用來描述鍵盤事件
    Dimension: 將固定的長度和高度封裝起來的類別
    Graphics: 用來畫圖的類別
*/
import javax.swing.JPanel;
import javax.swing.Timer;
/*
    JPanel: Swing裡的類別，可以建立一個容器存放GUI元件(面板類)
    Timer: 計時用的類別，與util.Timer無法同時載入，功能較少但可以與GUI元件互動
*/
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    //implements: 宣告要使用的介面(一個或多個)
    
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;                                                                                            /*格子長度*/
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    
    int bodyParts = 6;
    int itemEaten;
    int itemX;
    int itemY;
    char direction = 'R';
    boolean running = false;
    
    Timer timer;
    Random random;
    
    
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){
        newItem();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(running){
//                for(int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++){
//                        g.drawLine(i*UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);       /*直線起點(x1,y1)到直線終點(x2,y2)*/
//                        g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//                }
                g.setColor(Color.red);
                g.fillOval(itemX, itemY, UNIT_SIZE, UNIT_SIZE);                                 /*畫出填滿顏色的橢圓形(圖形起始X座標，圖形起始Y座標，長，寬)*/

                for(int i = 0; i < bodyParts; i++){
                        if(i == 0){
                                g.setColor(Color.green);
                                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                        }
                        else{
                                g.setColor(new Color(45,180,0));
                                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                        }
                }
                
                g.setColor(new Color(24, 220, 255));
                g.setFont(new Font("Ink Free", Font.BOLD, 40));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Score: " + itemEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + itemEaten)) / 2, g.getFont().getSize());
        }
        
        else{
            gameOver(g);
        }
        
    }
    public void newItem(){
        itemX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        itemY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }
    public void move(){
        for(int i = bodyParts; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    public void checkItem(){
        if((x[0] == itemX) && (y[0] == itemY)){
            bodyParts++;                                                /*吃到道具時身體變長*/
            itemEaten++;
            newItem();
        }
    }
    public void checkCollisions(){
        //咬到自己的情形(頭碰撞到身體)
        for(int i = bodyParts; i > 0; i--){
            if(x[0] == x[i] && y[0] == y[i]){
                running = false;
            }
        }
        
        //撞牆(左、右、下、上邊界)
        if(x[0] < 0){
            running = false;
        }
        if(x[0] > SCREEN_WIDTH){
            running = false;
        }
        if(y[0] > SCREEN_HEIGHT){
            running = false;
        }
        if(y[0] < 0){
            running = false;
        }
        
        if(!(running)){                         /*將計時器停下，遊戲就無法再運作*/
            timer.stop();
        }
        
    }
    public void gameOver(Graphics g){
        //遊戲結束後顯示的文字
        g.setColor(Color.red);
        g.setFont(new Font("GenKaiMinCho", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics.stringWidth("GAME OVER")) / 2, (SCREEN_HEIGHT / 2));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {                                                /*按下按鈕後要執行的動作*/
        if(running){
            move();
            checkItem();
            checkCollisions();
        }
        repaint();                                                                                                      /*JFrame的方法之一，如果遊戲不再運作，就會執行這行，進行重繪的動作*/
    }
    
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){                       /*蛇的移動方式不能直接回馬槍*/
                        direction = 'L';
                    }
                    break;
                
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                    
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                    
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }
        }
    }
    
}
