/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utility.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Wojg
 */
public class CalendarController
{
    private ArrayList<JPanel> calendarPanels;
    private ArrayList<JLabel> dayNames;
    private ArrayList<JPanel> monthPanels;
    
    private JButton next, previous;
    
    private JLabel date;
    
    private int init_month;
    private int init_year;
    private int init_DOM;
    private int init_GapMonth;
    
    private JPanel calendar, calendarPanel, calendarNavigation; 
    
    private GridBagConstraints gbc;
    
    private String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    
    public CalendarController()
    {
        calendarPanels = new ArrayList();
        dayNames = new ArrayList();
        monthPanels = new ArrayList();
        
        calendarPanel = new JPanel(new BorderLayout());
        calendar = new JPanel(new GridBagLayout()); 
        calendarNavigation = new JPanel(new FlowLayout());
        
        next = new JButton("Next");
        next.addActionListener(new CalendarButtons());
        previous = new JButton("Previous");                
        
        gbc = new GridBagConstraints();        
        
        Calendar cal = Calendar.getInstance();
        
        init_month = cal.get(Calendar.MONTH);
        init_year = cal.get(Calendar.YEAR);
        init_DOM = cal.getActualMaximum(Calendar.DAY_OF_MONTH);        
        init_GapMonth = cal.get(Calendar.DAY_OF_WEEK);
        
        date = new JLabel(Utilities.integerToMonth(init_month, init_year));
    }
    
    public JPanel constructCalendarWindow()
    {        
        calendarPanel.add(createNavigation(),BorderLayout.NORTH);
        calendarPanel.add(createCalendarSkeleton(), BorderLayout.CENTER);
        
        createDayNames();
        addDayNamesToCalendar();
        addMonthPanelsAndNumbers();
        
        return calendarPanel;
    }
    
    public JPanel createNavigation()
    {        
        calendarNavigation.add(previous);
        calendarNavigation.add(date);
        calendarNavigation.add(next);
        
        return calendarNavigation;
    }
    
    public JPanel createCalendarSkeleton()
    {
        for (int i = 0; i < 49; i++)
        {
            calendarPanels.add(new JPanel(new BorderLayout()));
            calendarPanels.get(i).setBorder(BorderFactory.createLoweredBevelBorder());
            set_gbc(i/7,i%7, 1.0, (i/7 == 0) ? 0.1 : 1.0, 1,1,GridBagConstraints.BOTH,GridBagConstraints.CENTER);
            calendar.add(calendarPanels.get(i),gbc);
        }        
        return calendar;
    }
    
    public ArrayList createDayNames()
    {
        for (int i = 0; i < days.length; i++)
        {            
            dayNames.add(new JLabel(days[i],JLabel.CENTER));          
        }        
        return dayNames;
    }
    
    public void addDayNamesToCalendar()
    {
        for (int i = 0; i < days.length; i++)
        {
            calendarPanels.get(i).setBorder(BorderFactory.createRaisedBevelBorder());
            calendarPanels.get(i).add(dayNames.get(i));
        }
    }
    
    public void addMonthPanelsAndNumbers()
    {
        for (int i = 0; i < init_DOM; i++)
        {
            monthPanels.add(new JPanel(new BorderLayout()));
            monthPanels.get(i).add(new JLabel(Integer.toString(i+1)));
            monthPanels.get(i).setBorder(BorderFactory.createRaisedBevelBorder());
            monthPanels.get(i).setBackground(Color.WHITE);
            calendarPanels.get(i+(days.length - 1)+init_GapMonth).add(monthPanels.get(i));
        }        
    }
        
    private void set_gbc(int row, int column, double wx, double wy, int width, int height, int fill, int anchor)
    {
        gbc.gridy = row;
        gbc.gridx = column;
        gbc.weightx = wx;
        gbc.weighty = wy;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.anchor = anchor;
    }

    private class CalendarButtons implements ActionListener
    {

        public CalendarButtons()
        {
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == next)
            {
                
            }
            
            else if (e.getSource() == previous)
            {
                
            }
        }
    }
}
