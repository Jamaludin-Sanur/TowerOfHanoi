
package other.win;

import highscore.DataControl;
import highscore.Highscore;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main_menu.Mainmenu;

/**
 *
 * @author TOSHIBA
 */
public class Win extends JDialog implements ActionListener{
    private JLabel congraturations = new JLabel();
    private JLabel please = new JLabel("Your name");
    private JTextField name = new JTextField();
    private JButton submit = new JButton("Submit highscore");
    private JButton mainMenu = new JButton("Main Menu");
    private JFrame parentFrame;
    
    private String amount;
    private String move;
    
    public Win(String amount,String move, JFrame parentFrame) {
        this.amount=amount;
        this.move=move;
        this.parentFrame = parentFrame;
        
        getContentPane().setPreferredSize(new Dimension(500, 400));
        getContentPane().setLayout(null);
        
        getContentPane().add(congraturations);
        congraturations.setBounds(25, 0, 450, 300);
        congraturations.setIcon(new ImageIcon(getClass().getResource("/other/pic/congrats.png")));
        
        getContentPane().add(please);
        please.setBounds(100, 300, 150, 30);
        
        getContentPane().add(name);
        name.setBounds(250, 300, 150, 25);
        
        getContentPane().add(submit);
        submit.setBounds(100, 350, 150, 30);
        submit.addActionListener(this);
        
        getContentPane().add(mainMenu);
        mainMenu.setBounds(250, 350, 150, 30);
        mainMenu.addActionListener(this);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(submit)){
            
            this.dispose();
            highscore.Highscore highscore= new Highscore(amount, name.getText(), move);
        }else if(e.getSource().equals(mainMenu)){
            this.dispose();
            parentFrame.dispose();
            new Mainmenu().setLocationRelativeTo(null);
        }
        
        
        
    }
    
    public static void quit(){
        
    }
}
