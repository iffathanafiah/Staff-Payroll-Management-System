package src;
import src.Staff.Staff;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileHandling {
    private static final String FILE_NAME = "staffData.txt";
    private static final String DELIMITER = "|";

    public FileHandling() {
    }

    public ArrayList<Staff> loadStaffData() {
        ArrayList<Staff> staffList = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffData = line.split(Pattern.quote(DELIMITER));
                if (staffData.length == 9) {
                    Staff staff = new Staff(
                            staffData[0].trim(),
                            staffData[1].trim(),
                            staffData[2].trim(),
                            staffData[3].trim(),
                            staffData[4].trim(),
                            staffData[5].trim(),
                            staffData[6].trim(),
                            staffData[7].trim(),
                            staffData[8].trim()
                            // Integer.parseInt(staffData[9].trim()),
                            // new SimpleDateFormat("yyyy-MM-dd").parse(staffData[10].trim())
                    );
    
                    staffList.add(staff);
                }
                else {
                    System.out.println("Invalid data in the file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    
        return staffList;
    }

    public void saveStaffData(ArrayList<Staff> staffList) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Staff staff : staffList) {
                String staffData = staff.getID() + DELIMITER
                        + staff.getFirstName() + DELIMITER
                        + staff.getLastName() + DELIMITER
                        + staff.getGender() + DELIMITER
                        + staff.getEmail() + DELIMITER
                        + staff.getPhoneNum() + DELIMITER
                        + staff.getAddress() + DELIMITER
                        + staff.getDepartment() + DELIMITER
                        + staff.getPosition() + /*DELIMITER*/ "\n";
                        // + staff.getBasicSalary() + DELIMITER
                        // + new SimpleDateFormat("yyyy-MM-dd").format(staff.getHiredDate()) + "\n";
                writer.write(staffData);
            }
            System.out.println("Staff data saved to " + FILE_NAME + " successfully ...");
        }
        catch (IOException e) {
            System.out.println("Error saving staff data to " + FILE_NAME);
            e.printStackTrace();
        }
    }
}
