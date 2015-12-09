

package simulator;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * @author Jason Amavisca
 */

public class MoveComponent implements Runnable{
    Thread t;
    JPanel source;
    JPanel destiny;
    JLayeredPane layer = new JLayeredPane();
    JLabel target;

    public MoveComponent(JPanel source, JPanel destiny) {
        this.source=source;
        this.destiny=destiny;
        this.target=(JLabel)source.getComponent(1);
        this.layer=(JLayeredPane)source.getParent();
        t = new Thread(this);
    }
    
    @Override
    public void run(){
        try{
            for(int i=1; i>0; i--){
                t.sleep(1000);
                
            }
            
            source.remove(1);
            destiny.add(target,1);
            layer.revalidate();
            layer.repaint();
            int i =Integer.valueOf(Simulator.move.getText());
            i+=1;
            Simulator.move.setText(i+"");
        }catch(Exception er){
            
        }
    }
}
