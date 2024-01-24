import java.util.*;

public class Staff{
    private String ID, firstName, lastName, gender, email, phoneNum, address, department, position;
    private int basicSalary;
    private Date hiredDate;

    private ArrayList<Payroll> payroll = new ArrayList<>();
    private static int totalStaff, staffIDCounter;

    public Staff(){}
    public boolean isEmpty()        {return totalStaff == 0;}

    public String getID()           {return this.ID;}
    public String getFname()        {return this.firstName;}
    public String getLname()        {return this.lastName;}
    public String getGender()       {return this.gender;}
    public String getEmail()        {return this.email;}
    public String getPhoneNum()     {return this.phoneNum;}
    public String getAddress()      {return this.address;}
    public String getDepartment()   {return this.department;}
    public String getPosition()     {return this.position;}

    public void hireStaff(String firstName, String lastName, String gender, String email, String phoneNum,
                          String address, String department, String position){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.department = department;
        this.position = position;

        totalStaff++; staffIDCounter++;
        this.ID = "S" + String.format("%03d", staffIDCounter);
        System.out.println("Staff data added successfully ...");
        return;
    }

    public static void viewStaff(ArrayList<Staff> staffList){
        if(staffList.isEmpty()){
            System.out.println("No staff");
            return;
        }
        for(Staff staff : staffList){
            System.out.println();
            System.out.println("Staff ID      : " + staff.getID());
            System.out.println("First Name    : " + staff.getFname());
            System.out.println("Last Name     : " + staff.getLname());
            System.out.println("Gender        : " + staff.getGender());
            System.out.println("Email Address : " + staff.getEmail());
            System.out.println("Phone Number  : " + staff.getPhoneNum());
            System.out.println("Home Address  : " + staff.getAddress());
            System.out.println("Department    : " + staff.getDepartment());
            System.out.println("Position      : " + staff.getPosition());
        }
        return;
    }

    public static void updateStaff(){
        
    }

    public static void fireStaff(ArrayList<Staff> staffList, String ID){
        Iterator<Staff> i = staffList.iterator();
        while (i.hasNext()) {
            Staff staff = i.next();
            if (staff.getID().equals(ID)) {
                i.remove();
                totalStaff--;
                System.out.println("Staff data removed successfully ...");
                return;
            }
        }
    }
}