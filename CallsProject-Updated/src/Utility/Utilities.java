/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wojg
 */
public class Utilities
{

    /**
     *
     * @param date
     * @param format
     * @return
     */
    public static Date convertFromString(String date, String format)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date d = sdf.parse(date);
            return d;
        } catch (ParseException ex)
        {
            System.out.println("Error in convert from string: " + ex);
            return null;
        }
    }
    
    public static String integerToStringMonth(int month, int year)
    {
        DateFormat formatter = new SimpleDateFormat("MMMM, yyyy");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        return formatter.format(calendar.getTime());
    }
    
    public static long stringToIntegerMonth(String d)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM, yyyy");
            Date date = sdf.parse(d);
            return date.getTime();            
        } 
        
        catch (ParseException ex)
        {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }   
        
        
    }
    
    public static boolean isLeapYear(int y)
    {
        if (y % 4 == 0 && y % 100 != 0 || y % 100 == 0)
            return true;
        else 
            return false;
    }
}
