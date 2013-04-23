/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Broker.PhysicianBroker;
import Container.Physician;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class PhysicianTableModel extends AbstractTableModel
{
    private ArrayList<String> column_Names;
    private ArrayList<Physician> phys;
    private PhysicianBroker pb;    
    
    public PhysicianTableModel()
    {
        pb = PhysicianBroker.getPhysicianBroker();
        phys = pb.getAllPhysician();
        
        column_Names = new ArrayList();
        
        column_Names.add("First Name");
        column_Names.add("Last Name");
        column_Names.add("Phone Number");
    }
    
    public ArrayList<Physician> getPhysician()
    {
        return phys;
    }
    
    @Override
    public int getRowCount() 
    {
        return phys.size();
    }

    @Override
    public int getColumnCount() 
    {
        return column_Names.size();
    }
    
    @Override
    public String getColumnName(int col)
    {
        return column_Names.get(col);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Physician p = phys.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return p.getFirstName();
            case 1:
                return p.getLastName();
            case 2:
                return p.getPhoneNumber();
            default:
                return "Incorrect Input";
        }
    }
    
    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0,c).getClass();
    }
}
