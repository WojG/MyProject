/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Wojg
 */
public class Utilities
{
    public static Date convertFromString(String date, String format)
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
