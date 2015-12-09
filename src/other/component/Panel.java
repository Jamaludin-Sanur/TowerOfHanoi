

package other.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jason Amavisca
 */

public class Panel extends JPanel{

    public Panel() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
        BufferedImage pic = ImageIO.read(getClass().getResource("/other/pic/tower.png"));
        Graphics2D g2 = (Graphics2D)g.create();
        g2.drawImage(pic, 150, 0, getWidth()/3, getHeight(), null);
        g2.dispose();
        }catch(Exception er){er.printStackTrace();}
        
    }
    
    
}
