package src.Staff;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class Staff{
    private static ArrayList<Staff> staffList = new ArrayList<>();
    private static int totalStaff = 0, staffIDCounter = 0;

    private String ID, firstName, lastName, gender, email, phoneNum, address, position, hiredDate;
    private double basicSalary;

    public Staff() {}
    public Staff(String ID, String firstName, String lastName, String gender, String email, String phoneNum,
                 String address, String position, String hiredDate, double basicSalary)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.position = position;
        this.hiredDate = hiredDate;
        this.basicSalary = basicSalary;
        
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
    public String getHiredDate()    {return this.hiredDate;}
    public String getPosition()     {return this.position;}
    public double getBasicSalary()  {return this.basicSalary;}

    public static Staff retrieveStaffData(String ID){
        for (Staff staff : staffList) {
            if (staff.getID().equals(ID)){
                return staff;
            }
        }
        return null;
    }

    public static String addStaff(String firstName, String lastName, String gender, String email,
                                  String phoneNum, String address, String position, double basicSalary)
    {
        Staff newStaff = new Staff();
        newStaff.firstName = firstName;
        newStaff.lastName = lastName;
        newStaff.gender = gender;
        newStaff.email = email;
        newStaff.phoneNum = phoneNum;
        newStaff.address = address;
        newStaff.hiredDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        newStaff.position = position;
        newStaff.basicSalary = basicSalary;

        totalStaff++;
        staffIDCounter++;
        newStaff.ID = "S" + String.format("%03d", staffIDCounter);

        staffList.add(newStaff);
        return newStaff.ID;
    }

    public static void editStaff(String ID, String firstName, String lastName, String gender, String email,
                                   String phoneNum, String address, String position, double basicSalary){
        for (Staff staff : staffList){
            if (staff.getID().equals(ID)) {
                staff.firstName = firstName;
                staff.lastName = lastName;
                staff.gender = gender;
                staff.email = email;
                staff.phoneNum = phoneNum;
                staff.address = address;
                staff.position = position;
                staff.basicSalary = basicSalary;
                return;
            }
        }
    }

    public static void deleteStaff(String ID){
        Iterator<Staff> curr = staffList.iterator();
        while (curr.hasNext()) {
            Staff staff = curr.next();
            if (staff.getID().equals(ID)) {
                curr.remove();
                totalStaff--;
                return;
            }
        }
    }

    public static boolean loadStaffData(){
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
                          Double.parseDouble(staffData[9].trim()));
    
                    staffList.add(staff);
                }
                else {
                    System.err.println("Invalid data in the file: " + line);
                    return false;
                }
            }
            return true;
        } 
        catch (IOException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
            return false;
        }
    }

    public static boolean saveStaffData(){
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
                        + staff.getPosition() + delimiter
                        + staff.getHiredDate() + delimiter
                        + staff.getBasicSalary() + delimiter + "\n";
                writer.write(staffData);
            }
            return true;
        }
        catch (IOException e) {
            System.err.println("Error saving staff data to " + filename);
            e.printStackTrace();
            return false;
        }
    }
}