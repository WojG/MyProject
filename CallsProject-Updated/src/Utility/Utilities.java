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
    
    public static String integerToMonth(int month, int year)
    {
        DateFormat formatter = new SimpleDateFormat("MMMM, yyyy");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        
        return formatter.format(calendar.getTime());
    }
    
    
}
