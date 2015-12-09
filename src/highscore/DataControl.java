/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package highscore;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.LinkedTransferQueue;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class DataControl {
    
    public void addData(String amount,String nama,String langkah){
        try {
                URL url = getClass().getResource("/highscore/Highscore.xml");
                File xml = new File(url.toURI());
                SAXBuilder sax = new SAXBuilder();
                Document doc = (Document)sax.build(xml);
                
                Element root = doc.getRootElement();
                
                Element ring = new Element("ring");
                ring.setAttribute("amount", amount);
                
                Element name = new Element("name").setText(nama);
                ring.addContent(name);
                
                Element move = new Element("move").setText(langkah);
                ring.addContent(move);
                
                root.addContent(ring);
                
                XMLOutputter xmlOutput = new XMLOutputter();
 
		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter(xml));
 
		// xmlOutput.output(doc, System.out);
 
		System.out.println("File updated!");
        } catch (Exception er) {
                JOptionPane.showMessageDialog(null, er);
        }
    }
    
    public String[][] getData(){
       String[][] rawData = null;
        try{
            URL url = getClass().getResource("/highscore/Highscore.xml");
            File xml = new File(url.toURI());
            SAXBuilder sax = new SAXBuilder();
            Document doc = (Document)sax.build(xml);
            
            List list = doc.getRootElement().getChildren("ring");
            rawData = new String[list.size()][3];
            String[][] temp = new String[1][3];
            
           
            
            //read data from xml n add it to array
            for (int i=0; i<list.size(); i++){
                String ring = (((Element)list.get(i)).getAttribute("amount")).getValue();
                String name = ((Element)list.get(i)).getChildText("name").toString();
                String move = ((Element)list.get(i)).getChildText("move").toString();
  
                rawData[i][0] = ring; 
                rawData[i][1] = name;
                rawData[i][2] = move;
            }
            
            //sorting data by amount of ring with bubble sort
            for(int i=0; i<rawData.length-1; i++){
                for(int ii=0; ii<rawData.length-1-i; ii++){
                    if(Integer.valueOf(rawData[ii][0])>Integer.valueOf(rawData[ii+1][0])){
                    temp[0][0] = rawData[ii][0];
                    temp[0][1] = rawData[ii][1];
                    temp[0][2] = rawData[ii][2];
                    rawData[ii][0] = rawData[ii+1][0];
                    rawData[ii][1] = rawData[ii+1][1];
                    rawData[ii][2] = rawData[ii+1][2];
                    rawData[ii+1][0] = temp[0][0];
                    rawData[ii+1][1] = temp[0][1];
                    rawData[ii+1][2] = temp[0][2];
                    }
                }
            }

        }catch(Exception er){
            JOptionPane.showMessageDialog(null, er);
        }
        return rawData;
    }
    
}
