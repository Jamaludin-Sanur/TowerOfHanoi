/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author TOSHIBA
 */
public class Background_Cincin extends JLabel{

    public Background_Cincin(String text) {
        super(text);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
        BufferedImage pic = ImageIO.read(getClass().getResource("/other/pic/brick.png"));
        Graphics2D g2 = (Graphics2D)g.create();
        g2.drawImage(pic, 0, 0, getWidth(), getHeight(), null);
        g2.dispose();
        }catch(Exception er){er.printStackTrace();}
    }

    
    
}
