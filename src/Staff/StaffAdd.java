package src.Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StaffAdd extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, firstNameLabel, lastNameLabel, genderLabel, emailLabel, phoneNumLabel,
                   addressLabel, departmentLabel, positionLabel;
    private JTextField firstNameField, lastNameField, emailField, phoneNumField, addressField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox<String> departmentField, positionField;
    private JButton addStaffButton;

    public StaffAdd() {
        setClosable(false);
        setSize(825, 535);
        setMinimumSize(new Dimension(825, 535));
        setMaximumSize(new Dimension(825, 535));
        setLocation(175, 85);        
        getContentPane().setLayout(null);
        setFrameIcon(null);

        titleLabel = new JLabel("Add New Staff");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(110, 20, 230, titleLabel.getPreferredSize().height);
        getContentPane().add(titleLabel);

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(firstNameLabel.getFont().deriveFont(firstNameLabel.getFont().getSize() + 5f));
        firstNameLabel.setBounds(110, 80, 100, 30);
        getContentPane().add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        firstNameField.setBounds(110, 110, 260, 30);
        getContentPane().add(firstNameField);

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(lastNameLabel.getFont().deriveFont(lastNameLabel.getFont().getSize() + 5f));
        lastNameLabel.setBounds(385, 80, 100, 30);
        getContentPane().add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lastNameField.setBounds(385, 110, 260, 30);
        getContentPane().add(lastNameField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(genderLabel.getFont().deriveFont(genderLabel.getFont().getSize() + 5f));
        genderLabel.setBounds(110, 160, 80, 30);
        getContentPane().add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(maleRadioButton.getFont().deriveFont(maleRadioButton.getFont().getSize() + 5f));
        maleRadioButton.setBounds(205, 160, 75, 30);
        getContentPane().add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(femaleRadioButton.getFont().deriveFont(femaleRadioButton.getFont().getSize() + 5f));
        femaleRadioButton.setBounds(290, 160, 85, 30);
        getContentPane().add(femaleRadioButton);

        emailLabel = new JLabel("E-mail:");
        emailLabel.setFont(emailLabel.getFont().deriveFont(emailLabel.getFont().getSize() + 5f));
        emailLabel.setBounds(110, 205, 80, 30);
        getContentPane().add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setBounds(110, 235, 260, 30);
        getContentPane().add(emailField);

        phoneNumLabel = new JLabel("Phone Number:");
        phoneNumLabel.setFont(phoneNumLabel.getFont().deriveFont(phoneNumLabel.getFont().getSize() + 5f));
        phoneNumLabel.setBounds(385, 205, 140, 30);
        getContentPane().add(phoneNumLabel);

        phoneNumField = new JTextField();
        phoneNumField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phoneNumField.setBounds(385, 235, 260, 30);
        getContentPane().add(phoneNumField);

        addressLabel = new JLabel("Address:");
        addressLabel.setFont(addressLabel.getFont().deriveFont(addressLabel.getFont().getSize() + 5f));
        addressLabel.setBounds(110, 280, 80, 30);
        getContentPane().add(addressLabel);

        addressField = new JTextField();
        addressField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        addressField.setBounds(110, 310, 535, 30);
        getContentPane().add(addressField);

        departmentLabel = new JLabel("Department:");
        departmentLabel.setFont(departmentLabel.getFont().deriveFont(departmentLabel.getFont().getSize() + 5f));
        departmentLabel.setBounds(110, 355, 115, 30);
        getContentPane().add(departmentLabel);

        String[] departments = {"Department 1", "Department 2", "Department 3"};
        departmentField = new JComboBox<>(departments);
        departmentField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        departmentField.setBounds(110, 385, 260, 30);
        getContentPane().add(departmentField);

        positionLabel = new JLabel("Position:");
        positionLabel.setFont(positionLabel.getFont().deriveFont(positionLabel.getFont().getSize() + 5f));
        positionLabel.setBounds(385, 355, 80, 30);
        getContentPane().add(positionLabel);

        String[] positions = {"Position 1", "Position 2", "Position 3"};
        positionField = new JComboBox<>(positions);
        positionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        positionField.setBounds(385, 385, 260, 30);
        getContentPane().add(positionField);
    
        addStaffButton = new JButton("Add Staff");
        addStaffButton.setBackground(new Color(0x00db00));
        addStaffButton.setForeground(Color.white);
        addStaffButton.setFont(addStaffButton.getFont().deriveFont(addStaffButton.getFont().getStyle() | Font.BOLD, addStaffButton.getFont().getSize() + 5f));
        addStaffButton.setBounds(530, 445, 115, addStaffButton.getPreferredSize().height);
        addStaffButton.addActionListener(this);
        getContentPane().add(addStaffButton);

        ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(maleRadioButton);
		buttonGroup1.add(femaleRadioButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Staff")) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String email = emailField.getText();
            String phoneNum = phoneNumField.getText();
            String address = addressField.getText();
            String department = (String) departmentField.getSelectedItem();
            String position = (String) positionField.getSelectedItem();
        
            Staff.hireStaff(firstName, lastName, gender, email, phoneNum, address, department, position);

            JOptionPane.showMessageDialog(null, "Staff added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
