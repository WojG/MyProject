/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Broker.PhysicianBroker;
import Container.Physician;
import Utility.Utilities;
import java.util.ArrayList;
import java.util.Date;
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
        column_Names.add("Birth Date");
        column_Names.add("Start Date");
        column_Names.add("End Date");
        column_Names.add("Adress");
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
        System.out.println(p.getBirthDate());
        switch (columnIndex)
        {
            case 0:                
                return p.getFirstName();
            case 1:
                return p.getLastName();
            case 2:                
                return p.getBirthDate();
            case 3:
                return p.getStartDate();
            case 4:
                return p.getEndDate();
            case 5:
                return p.getAddress();
            case 6:
                return p.getPhoneNumber();
            default:
                return "Incorrect Input";
        }        
    }

    @Override
    public Class getColumnClass(int c)
    {
        Object value = this.getValueAt(0, c);
        return (value == null) ? Object.class : value.getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col)
    {
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int col)
    {
        Physician p = phys.get(row);
        int empID = p.getEmployeeId();
        System.out.println("row: " + row + " col: " + col);
        switch (col)
        {
            case 0:
                p.setFirstName((String)value);
                pb.updatePhysician(value, empID, col);
                break;
            case 1:
                p.setLastName((String)value);                
                pb.updatePhysician(value, empID, col);
                break;
            case 2:
                p.setBirthDate((Date)value); 
                pb.updatePhysician(value, empID, col);
                break;
            case 3:
                p.setStartDate((Date)value);
                pb.updatePhysician(value, empID, col);
                break;
            case 4:
                p.setEndDate((Date)value);                
                pb.updatePhysician(value, empID, col);
                break;
            case 5:
                p.setAddress((String)value);                
                pb.updatePhysician(value, empID, col);
                break;
            case 6:
                p.setPhoneNumber((String)value);                
                pb.updatePhysician(value, empID, col);
                break;
        } 
        fireTableCellUpdated(row, col);
    }
}
