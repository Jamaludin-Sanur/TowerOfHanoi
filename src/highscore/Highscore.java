
package highscore;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import other.component.Background_Panel2;

public class Highscore extends JDialog{
    
    private JButton mainMenu = new JButton("Main Menu");
    private JButton quit = new JButton("Quit");
    private JLabel temp;
    private JPanel elB = new Background_Panel2();
    DataControl control = new DataControl();
    String[][] data;
    
    public Highscore() {
        setSize(400,600);
        data = control.getData();
        GUI();
    }

    public Highscore(String amount,String name, String move) {
        setSize(400,600);
        control.addData(amount, name, move);
        data = control.getData();
        GUI();
        
    }
    
    private void GUI(){
        add(elB, BorderLayout.CENTER);
        elB.setLayout(new BoxLayout(elB, BoxLayout.Y_AXIS));
        JPanel els = new JPanel();
        els.setOpaque(false);
        els.setLayout(new GridLayout(1, 3));
        temp = new JLabel("Ring");
        els.add(temp);
        temp.setHorizontalAlignment(JLabel.CENTER);
        temp = new JLabel("Name");
        els.add(temp);
        temp.setHorizontalAlignment(JLabel.CENTER);
        temp = new JLabel("Move");
        els.add(temp);
        temp.setHorizontalAlignment(JLabel.CENTER);
        elB.add(els);
        for(int x=0; x<data.length; x++){
            JPanel el = new JPanel();
            el.setLayout(new GridLayout(1, 3));
            temp = new JLabel(data[x][0]);
            temp.setHorizontalAlignment(JLabel.CENTER);
            el.add(temp);
            temp = new JLabel(data[x][1]);
            temp.setHorizontalAlignment(JLabel.CENTER);
            el.add(temp);
            temp = new JLabel(data[x][2]);
            temp.setHorizontalAlignment(JLabel.CENTER);
            el.add(temp);
            
            el.setOpaque(false);
            elB.add(el);
        }
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
}
