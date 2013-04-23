/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controller.PhysicianTableModel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Wojg
 */
public class Interface
{

    private JTable table;
    private JScrollPane scrollPane;

    public Interface()
    {
    }

    public JScrollPane createTable()
    {
        PhysicianTableModel ptm = new PhysicianTableModel();
        table = new JTable(ptm);
        table.addMouseListener(new PhysicianTableListener());
        scrollPane = new JScrollPane(table);

        return scrollPane;
    }

    public JDialog addDialog(int empID)
    {
        PhysicianTableModel ptm = new PhysicianTableModel();
        JPanel new_panel = new JPanel(new GridLayout(0, 2));

        JLabel new_fname = new JLabel("First Name");
        JTextField new_text = new JTextField();
        new_text.setText(ptm.getPhysician().get(empID).getFirstName());
        new_panel.add(new_fname);
        new_panel.add(new_text);

        JLabel new_lname = new JLabel("Last Name");
        JTextField new_text2 = new JTextField();
        new_text2.setText(ptm.getPhysician().get(empID).getLastName());
        new_panel.add(new_lname);
        new_panel.add(new_text2);

        JLabel new_bdate = new JLabel("Birth Date");
        JTextField new_text3 = new JTextField();
        new_text3.setText(ptm.getPhysician().get(empID).getBirthDate().toString());
        new_panel.add(new_bdate);
        new_panel.add(new_text3);

        JLabel new_sdate = new JLabel("Start Date");
        JTextField new_text4 = new JTextField();
        new_text4.setText(ptm.getPhysician().get(empID).getStartDate().toString());
        new_panel.add(new_sdate);
        new_panel.add(new_text4);

        JLabel new_edate = new JLabel("End Date");
        JTextField new_text5 = new JTextField();
        try
        {
            new_text5.setText(ptm.getPhysician().get(empID).getEndDate().toString());
        } catch (Exception e)
        {
            System.out.println("End date is NULL: " + e);
        }
        new_panel.add(new_edate);
        new_panel.add(new_text5);

        JLabel new_address = new JLabel("Address");
        JTextField new_text6 = new JTextField();
        new_text6.setText(ptm.getPhysician().get(empID).getAddress());
        new_panel.add(new_address);
        new_panel.add(new_text6);

        JLabel new_phone = new JLabel("Phone");
        JTextField new_text7 = new JTextField();
        new_text7.setText(ptm.getPhysician().get(empID).getPhoneNumber());
        new_panel.add(new_phone);
        new_panel.add(new_text7);





        JOptionPane new_pane = new JOptionPane(new_panel);

        JDialog dialog = new_pane.createDialog(new_panel, "Edit Physician");
        dialog.setModal(false);
        dialog.setVisible(true);
        return dialog;
    }

    private class PhysicianTableListener extends MouseAdapter
    {

        public void mouseClicked(MouseEvent e)
        {
            int selectedRow = table.getSelectedRow();
            // System.out.println(ptm.getPhysician().get(selectedRow).getFirstName());
            System.out.println(selectedRow);
            //     addDialog(selectedRow);

            addDialog(selectedRow);
        }
    }
}
