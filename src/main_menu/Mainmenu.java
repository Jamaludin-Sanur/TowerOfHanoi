

package main_menu;

import game.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import simulator.Simulator;

public class Mainmenu extends JDialog implements ActionListener{
    
    private JTextField ring = new JTextField();
    private JLabel lRing = new JLabel("Number of ring   ");
    private JButton nPlay = new JButton("Play");
    private JButton nExit = new JButton("Exit");
    private JButton nSimulator = new JButton("Simulator");
    private JButton nHighScore = new JButton("High Score");
    private JLabel lbg = new JLabel();
    
    private JLabel ltitle = new JLabel("<html> HANOI<br/> TOWER </html>");
    private JLabel lNamaKelompok = new JLabel(" By Jamaludin Sanur ");
    
    public Mainmenu() {
        
        getContentPane().setPreferredSize(new Dimension(500, 400));
        getContentPane().setSize(new Dimension(500, 400));
        
        
        
        getContentPane().setLayout( new BorderLayout() );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {
            lbg.setIcon( new ImageIcon(ImageIO.read( getClass().getResource("/other/pic/mainmenu_1.png") )) );
        } catch (IOException ex) {
            Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        getContentPane().add(lbg, BorderLayout.CENTER);
        ltitle.setFont( new Font("Courier New", Font.BOLD, 80) );
        lNamaKelompok.setFont( new Font(lNamaKelompok.getFont().getFontName(), Font.PLAIN, 14) );
        
        //meletakkan komponen pada panel
        lbg.add(lRing);
        lbg.add(ring);
        lbg.add(nPlay);
        lbg.add(nExit);
        lbg.add(nSimulator);
        lbg.add(nHighScore);
        lbg.add(ltitle);
        lbg.add(lNamaKelompok);
        
        //memberi listener pada button
        nPlay.addActionListener(this);
        nExit.addActionListener(this);
        nSimulator.addActionListener(this);
        nHighScore.addActionListener(this);
        
        //mengatur posisi & ukuran komponen
        ltitle.setBounds(143, 30, 500, 200);
        
        lNamaKelompok.setBounds(334, 330, 500, 100);
        lRing.setBounds(130, 250, 100, 50);
        ring.setBounds(230, 260, 150, 25);
        nPlay.setBounds(50, 300, 100, 30);
        nSimulator.setBounds(150, 300, 100, 30);
        nHighScore.setBounds(250, 300, 100, 30);
        nExit.setBounds(350, 300, 100, 30);
        
        pack();
        setVisible(true);
    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//        
//                try{
//        BufferedImage pic = ImageIO.read(getClass().getResource("/other/pic/menu.png"));
//        Graphics2D g2 = (Graphics2D)g.create();
//        g2.drawImage(pic, 0, 0, 400, 400, null);
//        g2.dispose();
//        }catch(Exception er){er.printStackTrace();}
//    }

//    @Override
//    public void paintAll(Graphics g) {
//        super.paintAll(g); //To change body of generated methods, choose Tools | Templates.
//        
//                                try{
//        BufferedImage pic = ImageIO.read(getClass().getResource("/other/pic/menu.png"));
//        Graphics2D g2 = (Graphics2D)g.create();
//        g2.drawImage(pic, 0, 0, 400, 400, null);
//        g2.dispose();
//        }catch(Exception er){er.printStackTrace();}
//    }
    
    

//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
//        
//                        try{
//        BufferedImage pic = ImageIO.read(getClass().getResource("/other/pic/menu.png"));
//        Graphics2D g2 = (Graphics2D)g.create();
//        g2.drawImage(pic, 0, 0, 400, 400, null);
//        g2.dispose();
//        }catch(Exception er){er.printStackTrace();}
//    }

    

    
    
    
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Mainmenu().setLocationRelativeTo(null);
            }
        });
        
         
}
    
    //listener pada button
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(nPlay)){
            int ringz = Integer.valueOf(ring.getText());
            SwingUtilities.getWindowAncestor(this).dispose();
            new Game(ringz);
        }else if(e.getSource().equals(nSimulator)){
            int ringz = Integer.valueOf(ring.getText());
            SwingUtilities.getWindowAncestor(this).dispose();
            new Simulator(ringz);
        }else if(e.getSource().equals(nHighScore)){
            System.out.println("a");
            SwingUtilities.getWindowAncestor(this).dispose();
            new highscore.Highscore();
        }else if(e.getSource().equals(nExit)){
            SwingUtilities.getWindowAncestor(this).dispose();
        }
    }
    
    
}
