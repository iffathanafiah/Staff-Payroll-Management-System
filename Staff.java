import java.util.ArrayList;
import java.util.List;

public class Staff{
    private String firstName, lastName, position;
    private int ID;
    List<Payroll> payroll = new ArrayList<>();

    public Staff(int ID, String firstName, String lastName, String position){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }
    public int getID(){
        return this.ID;
    }
    public void hireStaff(){

    }
    public void viewStaff(){

    }
    public void updateStaff(){

    }
    public void fireStaff(){

    }
}