package src.Staff;
import java.util.*;

public class Staff{
    private String ID, firstName, lastName, gender, email, phoneNum, address, department, position;
    private int basicSalary;
    private Date hiredDate;

    private static int totalStaff = 0, staffIDCounter = 0;

    public Staff() {}
    public Staff(String ID, String firstName, String lastName, String gender, String email, String phoneNum,
                 String address, String department, String position/*, int basicSalary, Date hiredDate*/) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.department = department;
        this.position = position;
        // this.basicSalary = basicSalary;
        // this.hiredDate = hiredDate;
        
        totalStaff++;
        staffIDCounter++;
    }
    
    public boolean isEmpty()        {return totalStaff == 0;}
    public String getID()           {return this.ID;}
    public String getFirstName()    {return this.firstName;}
    public String getLastName()     {return this.lastName;}
    public String getGender()       {return this.gender;}
    public String getEmail()        {return this.email;}
    public String getPhoneNum()     {return this.phoneNum;}
    public String getAddress()      {return this.address;}
    public String getDepartment()   {return this.department;}
    public String getPosition()     {return this.position;}
    public int getBasicSalary()     {return this.basicSalary;}
    public Date getHiredDate()      {return this.hiredDate;}

    public static void hireStaff(ArrayList<Staff> staffList, String firstName, String lastName, String gender,
                                 String email, String phoneNum, String address, String department, String position)
    {
        Staff newStaff = new Staff();
        newStaff.firstName = firstName;
        newStaff.lastName = lastName;
        newStaff.gender = gender;
        newStaff.email = email;
        newStaff.phoneNum = phoneNum;
        newStaff.address = address;
        newStaff.department = department;
        newStaff.position = position;

        totalStaff++;
        staffIDCounter++;
        newStaff.ID = "S" + String.format("%03d", staffIDCounter);

        staffList.add(newStaff);

        System.out.println("Staff data added successfully ...");
    }

    public static String viewStaff(ArrayList<Staff> staffList, String targetID) {
        for (Staff staff : staffList) {
            if (staff.getID().equals(targetID)) {
                StringBuilder staffInfo = new StringBuilder();
                staffInfo.append("Staff ID      : ").append(staff.getID()).append("\n");
                staffInfo.append("First Name    : ").append(staff.getFirstName()).append("\n");
                staffInfo.append("Last Name     : ").append(staff.getLastName()).append("\n");
                staffInfo.append("Gender        : ").append(staff.getGender()).append("\n");
                staffInfo.append("Email Address : ").append(staff.getEmail()).append("\n");
                staffInfo.append("Phone Number  : ").append(staff.getPhoneNum()).append("\n");
                staffInfo.append("Home Address  : ").append(staff.getAddress()).append("\n");
                staffInfo.append("Department    : ").append(staff.getDepartment()).append("\n");
                staffInfo.append("Position      : ").append(staff.getPosition()).append("\n");

                return staffInfo.toString();
            }
        }
        return "Staff not found";
    }

    public static void updateStaff(ArrayList<Staff> staffList, String ID, String firstName, String lastName, String gender,
                            String email, String phoneNum, String address, String department, String position){
        Iterator<Staff> curr = staffList.iterator();
        while (curr.hasNext()) {
            Staff staff = curr.next();
            if (staff.getID().equals(ID)) {
                staff.firstName = firstName;
                staff.lastName = lastName;
                staff.gender = gender;
                staff.email = email;
                staff.phoneNum = phoneNum;
                staff.address = address;
                staff.department = department;
                staff.position = position;
                System.out.println("Staff data edited successfully ...");
                return;
            }
        }
        System.out.println(ID);
        System.out.println("Not found ...");
    }

    public static boolean fireStaff(ArrayList<Staff> staffList, String ID){
        Iterator<Staff> curr = staffList.iterator();
        while (curr.hasNext()) {
            Staff staff = curr.next();
            if (staff.getID().equals(ID)) {
                curr.remove();
                totalStaff--;
                System.out.println("Staff data removed successfully ...");
                return true;
            }
        }
        return false;
    }

    public static void deleteAllStaff(ArrayList<Staff> staffList) {
        staffList.clear();
        totalStaff = 0;
        staffIDCounter = 0;
    }
}