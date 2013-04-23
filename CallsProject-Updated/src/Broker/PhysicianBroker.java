/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import Container.Physician;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Wojg
 */
public class PhysicianBroker {
    
    private static PhysicianBroker pBroker = null;
    private DatabaseBroker connection = new DatabaseBroker();
    
    private PhysicianBroker()
    {
        //singleton
    }
    
    public static PhysicianBroker getPhysicianBroker()
    {
        if (pBroker == null)
        {
            pBroker = new PhysicianBroker();
        }
        return pBroker;
    }
    
    public void addPhysician(Object o)
    {
        try 
        {
            Connection connect = connection.getConnectionFromPool();
            Physician p = (Physician) o;
            String SQL;
            SQL = "call addPhysician(?,?,?,?,?,?,?);";
            CallableStatement cs = connect.prepareCall(SQL);
            //SQL
            cs.setString(1, p.getFirstName());
            cs.setString(2, p.getLastName());
            cs.setDate(3, new Date(p.getBirthDate().getTime()));
            cs.setDate(4, new Date(p.getStartDate().getTime()));
            cs.setDate(5, new Date(p.getEndDate().getTime()));
            cs.setString(6, p.getAddress());
            cs.setString(7, p.getPhoneNumber());
            
            cs.execute();
            cs.close();
            
            connection.returnConnectionToPool(connect);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Add physician function error: " + ex);
        }
    }
    
    public void deletePhysician(int empID) 
    {
        try 
        {
            Connection connect = connection.getConnectionFromPool();         
            String SQL;
            SQL = "call deletePhysician(?);";
            CallableStatement cs = connect.prepareCall(SQL);
            cs.setInt(1,empID); 
            
            cs.execute();
            cs.close();
            
            connection.returnConnectionToPool(connect);            
        } 
        catch (SQLException ex) 
        {
            System.out.println("Delete physician function error: " + ex);
        }
    }
    
    public void updatePhysician(Object o)
    {
        try 
        {
            Connection connect = connection.getConnectionFromPool();   
            Physician p = (Physician) o;
            String SQL;
            SQL = "call updatePhysician(?,?,?,?,?,?,?,?);";
            CallableStatement cs = connect.prepareCall(SQL);
            cs.setInt(1,p.getEmployeeId());
            cs.setString(2,p.getFirstName());
            cs.setString(3,p.getLastName());
            cs.setDate(4,new Date(p.getBirthDate().getTime()));
            cs.setDate(5,new Date(p.getStartDate().getTime()));
            cs.setDate(6,new Date(p.getEndDate().getTime()));
            cs.setString(7,p.getAddress());
            cs.setString(8,p.getPhoneNumber());
            
            cs.execute();
            cs.close();
            
            connection.returnConnectionToPool(connect);            
        } 
        catch (SQLException ex) 
        {
            System.out.println("Update physician function error: " + ex);
        }
    }
    
    public ArrayList<Physician> getAllPhysician()
    {
        ArrayList<Physician> phys = new ArrayList();
        
        try 
        {
            Connection connect = connection.getConnectionFromPool();
            Statement stmt;
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM physician");
            
            while (rs.next())
            {
                Physician p = new Physician(rs.getInt(1),rs.getString(2),rs.getString(3),
                                            rs.getDate(4),rs.getDate(5),rs.getDate(6),rs.getString(7),
                                            rs.getString(8));
                phys.add(p);
            }            
            connection.returnConnectionToPool(connect);
            
            return phys;
        }
        
        catch (SQLException err)
        {
            System.out.println("Get all physicians function: " + err);
            return null;
        }
    }
}
