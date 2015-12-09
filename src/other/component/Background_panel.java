

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
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class Background_panel extends JLayeredPane {
    
    
        public Background_panel() {
    
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
        BufferedImage pic = ImageIO.read(getClass().getResource("/other/pic/background.png"));
        Graphics2D g2 = (Graphics2D)g.create();
        g2.drawImage(pic, 0, 0, getWidth(), getHeight(), null);
        g2.dispose();
        }catch(Exception er){er.printStackTrace();}
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

