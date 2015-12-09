

package simulator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jason Amavisca
 */

public class SetComponent implements Runnable{
    
    Thread t;
    JPanel west;
    JPanel mid;
    JPanel east;
    int pointer;

    public SetComponent( int pointer, JPanel west, JPanel mid, JPanel east) {
        this.west = west;
        this.mid = mid;
        this.east = east;
        this.pointer = pointer;
        
        t = new Thread(this);
    }
    
    @Override
    public void run(){
        if(pointer==1){
            try {
                MoveComponent m = new MoveComponent(west, east);
                 m.t.start();
                 m.t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(SetComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try{
                SetComponent s = new SetComponent(pointer-1, west, east, mid);
            s.t.start();
            s.t.join();
            
            MoveComponent m = new MoveComponent(west, east);
            m.t.start();
            m.t.join();
            
            SetComponent ss = new SetComponent(pointer-1, mid, west, east);
            ss.t.start();
            ss.t.join();
            }catch(Exception er){
                er.printStackTrace();
            }
        }
    }
    
    
}
