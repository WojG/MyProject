/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Container;

import java.util.Date;

/**
 *
 * @author Wojg
 */
public class DaysOff 
{    
    private int days_ID;
    private int Employee_ID;
    private Date day_Off;    
    
    public DaysOff()
    {
        // default constructor
    }
    
    public DaysOff(int days_ID, int Employee_ID, Date day_Off)
    {
        this.days_ID = days_ID;
        this.Employee_ID = Employee_ID;
        this.day_Off = day_Off;
    }
    
    public int getDaysID()
    {
        return days_ID;
    }
    
    public void setDays(int days_ID)
    {
        this.days_ID = days_ID;
    }
    
    public int getEmployeeID()
    {
        return Employee_ID;
    }
    
    public void setEmployeeID(int Employee_ID)
    {
        this.Employee_ID = Employee_ID;
    }
    
    public Date getDayOff()
    {
        return day_Off;
    }
    
    public void setDayOff(Date day_Off)
    {
        this.day_Off = day_Off;
    }
    
    @Override
    public String toString()
    {
        return "days_ID: " + days_ID + "Employee_ID: " + Employee_ID + "day_Off: " + day_Off;
    }
}
