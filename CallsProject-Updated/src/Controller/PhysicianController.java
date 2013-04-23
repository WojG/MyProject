/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Broker.PhysicianBroker;
import Container.Physician;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Wojg
 */
public class PhysicianController {
    
    public PhysicianController()
    {
        
    }
    
    public void addPhysician(int employee_ID, String fname, String lname, Date bdate, Date sdate, Date edate, String Address, String phoneNumber)
    { 
        Physician p = new Physician(employee_ID, fname, lname, bdate, sdate, edate, Address, phoneNumber);
        PhysicianBroker.getPhysicianBroker().addPhysician(p);
    }
    
    public void deletePhysician(int employee_ID)
    {
        PhysicianBroker.getPhysicianBroker().deletePhysician(employee_ID);
    }
    
    public void updatePhysician(int employee_ID, String fname, String lname, Date bdate, Date sdate, Date edate, String Address, String phoneNumber)
    {
        Physician p = new Physician(employee_ID, fname, lname, bdate, sdate, edate, Address, phoneNumber);
        PhysicianBroker.getPhysicianBroker().updatePhysician(p); 
    }
    
    public Date convertFromString(String date, String format)
    {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date d = sdf.parse(date);
            return d;
        } 
        catch (ParseException ex) 
        {
            System.out.println("Error in convert from string: " + ex);
            return null;
        }      
    }
}
