/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other.component;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Background_Panel2 extends JPanel {
    private Random ran = new Random();
    private int xStart;
    private int yStart;
    private Color[] color = {new Color(255, 255, 255), new Color(100, 200, 255), new Color(100, 150, 255)};
    private float[] fractions = {0.0f, 0.2f, 1f};
    private int move = 0;
    private Timer timer;
    private int notes = 0;
    
    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(xStart>=getWidth()){
                move=ran.nextInt(2)+3;
            }else if(xStart<=0){
                move=ran.nextInt(1);
            }else if(yStart>=getHeight()){
                move=ran.nextInt(3);
            }else if(yStart<=0){
                move=ran.nextInt(2)+5;
            }
            if(move==0){
                xStart+=8;
                notes++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }else if(move==1){
                xStart+=8;
                yStart++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }else if(move==2){
                yStart-=8;
                notes++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }else if(move==3){
                xStart-=8;
                yStart-=8;
                notes++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }else if(move==4){
                xStart-=8;
                notes++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }else if(move==5){
                xStart-=8;
                yStart+=8;
                notes++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }else if(move==6){
                yStart+=8;
                notes++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }else if(move==7){
                xStart+=8;
                yStart+=8;
                notes++;
                if(notes==40){move=ran.nextInt(7);notes=0;};
            }
            repaint();    
        }
    };
    
    public Background_Panel2() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        xStart=ran.nextInt((int)dim.width);
        yStart=ran.nextInt((int)dim.height);
        initComponents();
        timer = new Timer(100, listener);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        RadialGradientPaint rgp = new RadialGradientPaint(xStart, yStart, getHeight(), fractions, color);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setPaint(rgp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    
    // Variables declaration - do not modify                     
    // End of variables declaration                   

}

