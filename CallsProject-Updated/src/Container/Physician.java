package Container;

import java.util.Comparator;
import java.util.Date;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dariusz
 */
public class Physician
{
    private int employeeId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date startDate;
    private Date endDate;
    private String address;
    private String phoneNumber;
    private int previousHours, curHours, totalHours;
    
    public Physician()
    {
        // constructor
    }
    
    public Physician(int employeeId, String firstName, String lastName, Date birthDate, Date startDate,
               Date endDate, String address, String phoneNumber)
    {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.curHours = 0;
        this.previousHours = 0;
    }

    public Physician(int employeeId, String firstName, String lastName, Date birthDate, Date startDate,
               Date endDate, String address, String phoneNumber, int previousHours)
    {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.previousHours = previousHours;
        this.curHours = 0;
    }

    public Physician(int employeeId, int previousHours, int currentHours)
    {
        this.employeeId = employeeId;
        this.previousHours = previousHours;
        this.curHours = currentHours;
    }
    
    public int getPreviousHours()
    {
        return previousHours;
    }

    public int getCurHours()
    {
        return curHours;
    }

    public void addHours(int hours)
    {
        this.curHours = curHours + hours;
    }
            
    public void setPreviousHours(int previousHours)
    {
        this.previousHours = previousHours;
    }

    public void setCurHours(int curHours)
    {
        this.curHours = curHours;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTotalHours()
    {
        return totalHours;
    }

    public void setTotalHours(int totalHours)
    {
        this.totalHours = totalHours;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }   
}
