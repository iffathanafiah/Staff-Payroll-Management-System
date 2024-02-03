package src.Staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Staff{
    private static ArrayList<Staff> staffList = new ArrayList<>();
    private static int totalStaff = 0, staffIDCounter = 0;

    private String ID, firstName, lastName, gender, email, phoneNum, address, department, position;
    private double basicSalary;
    private Date hiredDate;

    public Staff() {}
    public Staff(String ID, String firstName, String lastName, String gender, String email, String phoneNum,
                 String address, String department, String position, double basicSalary/*, Date hiredDate*/) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.department = department;
        this.position = position;
        this.basicSalary = basicSalary;
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
    public double getBasicSalary()  {return this.basicSalary;}
    public Date getHiredDate()      {return this.hiredDate;}
    
    public double getBasicSalary(String ID){
        for (Staff staff : staffList) {
            if (staff.getID().equals(ID)){
                return staff.basicSalary;
            }
        }
        return 0.00;
    }

    public static void hireStaff(String firstName, String lastName, String gender, String email,
                                 String phoneNum, String address, String department, String position)
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
        newStaff.basicSalary = 1000;

        totalStaff++;
        staffIDCounter++;
        newStaff.ID = "S" + String.format("%03d", staffIDCounter);

        staffList.add(newStaff);

        System.out.println("Staff data added successfully ...");
    }

    public static String viewStaff(String targetID) {
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

    public static void updateStaff(String ID, String firstName, String lastName, String gender,
                            String email, String phoneNum, String address, String department, String position){
        for (Staff staff : staffList) {
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

    public static boolean fireStaff(String ID){
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
    
    public static boolean validateStaff(String ID){
        for (Staff staff : staffList) {
            if (staff.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }

    public static void loadStaffData(){
        staffList.clear();
        totalStaff = 0;
        staffIDCounter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Staff/staffData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffData = line.split(Pattern.quote("|"));
                if (staffData.length == 10) {
                    Staff staff = new Staff(
                            staffData[0].trim(),
                            staffData[1].trim(),
                            staffData[2].trim(),
                            staffData[3].trim(),
                            staffData[4].trim(),
                            staffData[5].trim(),
                            staffData[6].trim(),
                            staffData[7].trim(),
                            staffData[8].trim(),
                            Double.parseDouble(staffData[9].trim())
                            // new SimpleDateFormat("yyyy-MM-dd").parse(staffData[10].trim())
                    );
    
                    staffList.add(staff);
                }
                else {
                    System.out.println("Invalid data in the file: " + line);
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }

    }

    public static void saveStaffData(){
        String delimiter = "|", filename = "src/Staff/staffData.txt";

        try (FileWriter writer = new FileWriter(filename)) {
            for (Staff staff : staffList) {
                String staffData = staff.getID() + delimiter
                        + staff.getFirstName() + delimiter
                        + staff.getLastName() + delimiter
                        + staff.getGender() + delimiter
                        + staff.getEmail() + delimiter
                        + staff.getPhoneNum() + delimiter
                        + staff.getAddress() + delimiter
                        + staff.getDepartment() + delimiter
                        + staff.getPosition() + delimiter
                        + staff.getBasicSalary() + /*DELIMITER +*/ "\n";
                        // + new SimpleDateFormat("yyyy-MM-dd").format(staff.getHiredDate()) + "\n";
                writer.write(staffData);
            }
            System.out.println("Staff data saved to " + filename + " successfully ...");
        }
        catch (IOException e) {
            System.out.println("Error saving staff data to " + filename);
            e.printStackTrace();
        }
    }
    
}