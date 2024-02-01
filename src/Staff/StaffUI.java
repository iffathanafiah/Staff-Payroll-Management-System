package src.Staff;
import src.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StaffUI extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JTextArea viewStaffTextArea;
    private JTextField idField, firstNameField, lastNameField, emailField, phoneNumField,
                       addressField, departmentField, positionField, viewStaffIdField;
    private JRadioButton maleRadioButton, femaleRadioButton;

    private String staffID = "";
    private ArrayList<Staff> staff;
    private FileHandling file;

    public StaffUI(){
        setTitle("Staff Payroll Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        file = new FileHandling();
        staff = file.loadStaffData();

        homePage();
        addStaffPage();
        viewStaffPage();
        editStaffPage();
        deleteStaffPage();

        add(cardPanel);
        add(navPanel(), BorderLayout.NORTH);
        setVisible(true);
    }

    private void homePage() {
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Home Interface Content"));

        cardPanel.add(homePanel, "home");
    }

    private void addStaffPage() {
        JPanel addStaffPanel = new JPanel(new GridLayout(10, 2, 10, 10));
    
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        phoneNumField = new JTextField();
        addressField = new JTextField();
        departmentField = new JTextField();
        positionField = new JTextField();
    
        addStaffPanel.add(new JLabel("First Name:"));
        addStaffPanel.add(firstNameField);
        addStaffPanel.add(new JLabel("Last Name:"));
        addStaffPanel.add(lastNameField);
    
        addStaffPanel.add(new JLabel("Gender:"));
        
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        
        JPanel genderPanel = new JPanel(new FlowLayout());
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
    
        addStaffPanel.add(genderPanel);
    
        addStaffPanel.add(new JLabel("Email:"));
        addStaffPanel.add(emailField);
        addStaffPanel.add(new JLabel("Phone Number:"));
        addStaffPanel.add(phoneNumField);
        addStaffPanel.add(new JLabel("Address:"));
        addStaffPanel.add(addressField);
        addStaffPanel.add(new JLabel("Department:"));
        addStaffPanel.add(departmentField);
        addStaffPanel.add(new JLabel("Position:"));
        addStaffPanel.add(positionField);
    
        JButton addStaffButton = new JButton("Add Staff");
        addStaffButton.addActionListener(this);
    
        addStaffPanel.add(addStaffButton);
    
        cardPanel.add(addStaffPanel, "addStaff");
    }

    private void viewStaffPage() {
        JPanel viewStaffPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());

        viewStaffIdField = new JTextField(4);
        viewStaffTextArea = new JTextArea();
        viewStaffTextArea.setEditable(false);

        inputPanel.add(new JLabel("Enter Staff ID to view:"));
        inputPanel.add(viewStaffIdField);

        JButton viewStaffButton = new JButton("View Staff");
        viewStaffButton.setActionCommand("View Staff");
        viewStaffButton.addActionListener(this);

        inputPanel.add(viewStaffButton);
        viewStaffPanel.add(inputPanel, BorderLayout.NORTH);
        viewStaffPanel.add(new JScrollPane(viewStaffTextArea), BorderLayout.CENTER);

        cardPanel.add(viewStaffPanel, "viewStaff");
    }

    private void editStaffPage() {
        JPanel editStaffPanel = new JPanel();
        editStaffPanel.add(new JLabel("Edit Staff Interface Content"));

        cardPanel.add(editStaffPanel, "editStaff");
    }

    private void deleteStaffPage() {
        JPanel deleteStaffPanel = new JPanel(new GridLayout(2, 2, 10, 10));
    
        JLabel label = new JLabel("Enter Staff ID to delete:");
        idField = new JTextField();
        JButton deleteButton = new JButton("Remove Staff");
    
        deleteButton.addActionListener(this);
    
        deleteStaffPanel.add(label);
        deleteStaffPanel.add(idField);
        deleteStaffPanel.add(deleteButton);
    
        cardPanel.add(deleteStaffPanel, "deleteStaff");
    }

    private JButton navButton(String buttonText, String command) {
        JButton button = new JButton(buttonText);
        button.setActionCommand(command);
        button.addActionListener(this);
        return button;
    }

    private JPanel navPanel() {
        JPanel navBar = new JPanel(new FlowLayout());

        navBar.add(navButton("Home", "home"));
        navBar.add(navButton("Add Staff", "addStaff"));
        navBar.add(navButton("View Staff", "viewStaff"));
        navBar.add(navButton("Edit Staff", "editStaff"));
        navBar.add(navButton("Delete Staff", "deleteStaff"));
        navBar.add(navButton("Load Data", "loadData"));
        navBar.add(navButton("Save Data", "saveData"));

        return navBar;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "home":
            case "addStaff":
            case "viewStaff":
            case "editStaff":
            case "deleteStaff":
                cardLayout.show(cardPanel, command);
                break;

            case "Add Staff":
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String email = emailField.getText();
                String phoneNum = phoneNumField.getText();
                String address = addressField.getText();
                String department = departmentField.getText();
                String position = positionField.getText();
        
                Staff.hireStaff(staff, firstName, lastName, gender, email, phoneNum, address, department, position);
        
                JOptionPane.showMessageDialog(null, "Staff added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "View Staff":
                staffID = viewStaffIdField.getText();
                if (!staffID.isEmpty()) {
                    String staffInfo = Staff.viewStaff(staff, staffID);
                    viewStaffTextArea.setText(staffInfo);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a Staff ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }    
                break;
            case "Remove Staff":
                staffID = idField.getText();
                if (!staffID.isEmpty()){
                    if(Staff.fireStaff(staff, staffID)){
                        JOptionPane.showMessageDialog(null, "Staff deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Staff ID does not exist in system.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a Staff ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "loadData":
                Staff.deleteAllStaff(staff);
                staff = file.loadStaffData();
                JOptionPane.showMessageDialog(null, "Data loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;

            case "saveData":
                file.saveStaffData(staff);
                JOptionPane.showMessageDialog(null, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;

            default:
                System.out.println("Unknown command");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StaffUI());
    }
}
