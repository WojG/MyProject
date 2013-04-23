/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calls;

import Controller.PhysicianController;
import Interface.Interface;
import java.awt.Color;
import javax.swing.JFrame;


/**
 *
 * @author Wojg
 */
public class Calls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interface i = new Interface();
        PhysicianController pc = new PhysicianController();
        
        JFrame frame = new JFrame("Calls Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        
        frame.setContentPane(i.createTable());
        frame.getContentPane().setBackground(new Color(102, 102, 102));
        frame.setBounds(200, 200, 1000, 800);
        frame.setVisible(true);
        
        /*Date bdate = pc.convertFromString("1983-09-08", "yyyy-MM-dd");
        Date sdate = pc.convertFromString("2011-09-08", "yyyy-MM-dd");
        Date edate = pc.convertFromString("2012-09-08", "yyyy-MM-dd");
        */
     //   pc.addPhysician(0, "Witek", "Antek" , bdate,sdate,edate,"123 Test Street", "403-765-9988");
     //   pc.deletePhysician(14); 
      //  pc.updatePhysician(9, "Sean", "Nettelle" , bdate, sdate, edate, "HelloWorld 123", "403-123-2344"); 
    }
     
    
}
