

package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import other.component.Background_Cincin;
import other.component.Background_panel;
import other.component.Panel;



public class Game extends JFrame{
    private int ring;
        private JLayeredPane layer = new Background_panel();
        private JLabel caraMain = new JLabel();
        private JLabel move = new JLabel("0");
        private JPanel elWest;
        private JPanel elMid;
        private JPanel elEast;
        private Random random = new Random();
        private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
    public Game(int ring) {
        this.ring = ring;
        setSize(dim);
        System.out.println(dim);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add(layer,BorderLayout.CENTER);
        
        elWest = new Panel();
        elMid = new Panel();
        elEast = new Panel();
        
        elWest.setOpaque(false);
        elMid.setOpaque(false);
        elEast.setOpaque(false);
        
        layer.setLayer(elWest, JLayeredPane.PALETTE_LAYER);
        layer.setLayer(elMid, JLayeredPane.PALETTE_LAYER);
        layer.setLayer(elEast, JLayeredPane.PALETTE_LAYER);
        layer.setLayer(caraMain, JLayeredPane.PALETTE_LAYER);
        layer.setLayer(move, JLayeredPane.PALETTE_LAYER);
        
        layer.add(caraMain);
        caraMain.setBounds(10, 0, getWidth(), 150);
        
        layer.add(move);
        move.setHorizontalAlignment(JLabel.CENTER);
        move.setVerticalAlignment(JLabel.CENTER);
        move.setBounds(0, getHeight()-100, getWidth(), 100);
        
        layer.add(elWest);
        elWest.setBounds(0, 160, dim.width/3, getHeight()-260);
        
        layer.add(elMid);
        elMid.setBounds((dim.width/3), 160, (dim.width/3), getHeight()-260);
        
        layer.add(elEast);
        elEast.setBounds((dim.width/3)*2, 160, dim.width/3, getHeight()-260);
        
        elWest.setLayout(new BoxLayout(elWest, BoxLayout.Y_AXIS));
        elMid.setLayout(new BoxLayout(elMid, BoxLayout.Y_AXIS));
        elEast.setLayout(new BoxLayout(elEast, BoxLayout.Y_AXIS));
        
        elWest.add(Box.createVerticalGlue());
        elMid.add(Box.createVerticalGlue());
        elEast.add(Box.createVerticalGlue());

        int widthCut = elWest.getSize().width/ring;
        int widthCut2 = elWest.getSize().width/ring;
        int heightCut = ((elWest.getSize().height/ring)-((elWest.getSize().height/ring)/2));
        
        Modifier modif = new Modifier(layer,move, ring, this);   
        for(int i=0; i<ring; i++){
            JLabel label = new Background_Cincin(""+(i+1));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            elWest.add(label);
            
            //tinggi
            label.setPreferredSize(new Dimension(widthCut, heightCut));
            
            //panjang
            label.setMaximumSize(new Dimension(widthCut, heightCut));
            label.setMinimumSize(new Dimension(100, heightCut));
            //label.setSize(100, heightCut);
            
            widthCut = widthCut+widthCut2;
            
            label.addMouseListener(modif);
            label.addMouseMotionListener(modif);

            label.setBorder(BorderFactory.createEmptyBorder());
            label.setOpaque(false);
            
            label.setHorizontalAlignment(JLabel.CENTER);
        }
        setVisible(true);
    }
} 
    

