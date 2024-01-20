import java.util.ArrayList;

public class Staff{
    private String firstName, lastName, position;
    private int ID;
    ArrayList<Payroll> payroll = new ArrayList<>();

    public Staff() {
    }
    public int getID(){
        return this.ID;
    }
    public void hireStaff(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Staff data added successfully ...");
    }
    public void viewStaff(){

    }
    public void updateStaff(){

    }
    public void fireStaff(){

    }
}