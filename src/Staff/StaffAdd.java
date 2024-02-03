package src.Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StaffAdd extends JFrame implements ActionListener {
    private JTextField firstNameField, lastNameField, emailField, phoneNumField,
            addressField, departmentField, positionField;
    private JRadioButton maleRadioButton, femaleRadioButton;

    public StaffAdd() {
        setTitle("Add Staff Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

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

        add(addStaffPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Staff")) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String email = emailField.getText();
            String phoneNum = phoneNumField.getText();
            String address = addressField.getText();
            String department = departmentField.getText();
            String position = positionField.getText();
        
            Staff.hireStaff(firstName, lastName, gender, email, phoneNum, address, department, position);

            JOptionPane.showMessageDialog(null, "Staff added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Staff added:");
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Gender: " + gender);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phoneNum);
            System.out.println("Address: " + address);
            System.out.println("Department: " + department);
            System.out.println("Position: " + position);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StaffAdd().setVisible(true));
    }
}
