/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controller.CalendarController;
import Controller.PhysicianTableModel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Wojg
 */
public class Interface
{

    private JTable table;
    private JScrollPane scrollPane;
    private JPanel calendar;

    public Interface()
    {
        calendar = new JPanel(new BorderLayout());
    }

    public JScrollPane createTable()
    {
        PhysicianTableModel ptm = new PhysicianTableModel();
        table = new JTable(ptm);
        table.addMouseListener(new PhysicianTableListener());
        scrollPane = new JScrollPane(table);

        return scrollPane;
    }
    
    public JPanel calendar()
    {
        CalendarController cc = new CalendarController();
        calendar.add(cc.constructCalendarWindow());
        return calendar;
    }

    private class PhysicianTableListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            int selectedRow = table.getSelectedRow();
            System.out.println(selectedRow);            
        }
    }
}
