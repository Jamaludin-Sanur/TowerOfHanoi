

package game;

import highscore.Highscore;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import other.win.Win;


/**
 * @author Jason Amavisca
 */

class Modifier implements MouseListener, MouseMotionListener{
        
        private JPanel parent;
        private JLabel label;
        private boolean dragable=false;
        private JLayeredPane layer;
        private int ring;
        private JLabel move;
        private JFrame parentFrame;

    public Modifier(JLayeredPane layer,JLabel move, int ring, JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.layer = layer;
        this.ring =ring;
        this.move=move;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        label = (JLabel)e.getSource();
        parent = (JPanel) label.getParent();
        int biggestRing = parent.getComponentCount();
        if(parent.getComponentZOrder(label)==1){
            dragable=true;
            parent.remove(label);
            layer.setLayer(label, JLayeredPane.MODAL_LAYER);
            layer.add(label);
            label.setLocation(e.getXOnScreen(), e.getYOnScreen());
        }else{
            dragable=false;
            return;
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    if(dragable==true){
        label.setVisible(false);
        Component target = layer.findComponentAt(e.getXOnScreen(), e.getYOnScreen());
        
        if(target instanceof JPanel){
            JPanel targets = (JPanel)target;
            
            if(targets.getComponentCount()>1){
                JLabel BiggestRing = (JLabel)targets.getComponent(1);
                if(Integer.valueOf(BiggestRing.getText())<Integer.valueOf(label.getText())){
                    layer.remove(label);
                    parent.add(label, 1);
                    
                }else{
                   
                    layer.remove(label);
                    targets.add(label, 1);
                    int i = Integer.valueOf(move.getText());
                    i++;
                    move.setText(""+i);
                    win(targets);
                }
            }else{
                layer.remove(label);
                targets.add(label, 1);
                int i = Integer.valueOf(move.getText());
                i++;
                move.setText(""+i);
                win(targets);
            }
            
        }else{
            layer.remove(label);
            parent.add(label, 1);
        }
        label.setVisible(true);
    }else{
        return;
    }
    }

    @Override
    public void mouseEntered(MouseEvent e) {} 

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        if(dragable==true){
        label.setLocation(e.getXOnScreen(), e.getYOnScreen());
        }else{
            return;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    public void win(JPanel target){
        if(target.equals(layer.getComponent(4))){
           if (target.getComponentCount()==(ring+1)){
               new Win(""+ring,move.getText(), parentFrame);
           }
        }
            
        
    }
}
