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
}