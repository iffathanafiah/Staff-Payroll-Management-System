package src.Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class StaffAdd extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, firstNameLabel, lastNameLabel, genderLabel, emailLabel,
                   phoneNumLabel, addressLabel, positionLabel, basicSalaryLabel, currencyLabel;
    private JTextField firstNameField, lastNameField, emailField, phoneNumField, addressField;
    private JFormattedTextField basicSalaryField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup buttonGroup;
    private JComboBox<String> positionField;
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

        positionLabel = new JLabel("Position:");
        positionLabel.setFont(positionLabel.getFont().deriveFont(positionLabel.getFont().getSize() + 5f));
        positionLabel.setBounds(110, 355, 115, 30);
        getContentPane().add(positionLabel);

        String[] positions = {"-----", "IT - Software Developer", "Finance - Financial Analyst", "Marketing - Promoter"};
        positionField = new JComboBox<>(positions);
        positionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        positionField.setBounds(110, 385, 260, 30);
        getContentPane().add(positionField);

        basicSalaryLabel = new JLabel("Basic Salary:");
        basicSalaryLabel.setFont(positionLabel.getFont().deriveFont(basicSalaryLabel.getFont().getSize() + 5f));
        basicSalaryLabel.setBounds(385, 355, 120, 30);
        getContentPane().add(basicSalaryLabel);

        currencyLabel = new JLabel(" RM");
        currencyLabel.setFont(currencyLabel.getFont().deriveFont(currencyLabel.getFont().getStyle() | Font.BOLD, currencyLabel.getFont().getSize() + 2f));
        currencyLabel.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel.setHorizontalAlignment(SwingConstants.LEADING);
        currencyLabel.setBounds(385, 385, 40, 30);
        getContentPane().add(currencyLabel);

        basicSalaryField = doubleNumTextField();
        basicSalaryField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        basicSalaryField.setBounds(425, 385, 225, 30);
        getContentPane().add(basicSalaryField);
    
        addStaffButton = new JButton("Add Staff");
        addStaffButton.setBackground(new Color(0x00db00));
        addStaffButton.setForeground(Color.white);
        addStaffButton.setFont(addStaffButton.getFont().deriveFont(addStaffButton.getFont().getStyle() | Font.BOLD, addStaffButton.getFont().getSize() + 5f));
        addStaffButton.setBounds(530, 445, 115, addStaffButton.getPreferredSize().height);
        addStaffButton.addActionListener(this);
        getContentPane().add(addStaffButton);

        buttonGroup = new ButtonGroup();
		buttonGroup.add(maleRadioButton);
		buttonGroup.add(femaleRadioButton);

        setVisible(true);
    }
    private JFormattedTextField doubleNumTextField() {
        NumberFormat format = new DecimalFormat("#0.00");
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setMaximum(1000000.0);

        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(10);
        
        return textField;
    }
    public void resetFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        buttonGroup.clearSelection();
        emailField.setText("");
        phoneNumField.setText("");
        addressField.setText("");
        positionField.setSelectedIndex(0);
        basicSalaryField.setValue(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Staff")) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String gender = "";
            if(maleRadioButton.isSelected())        {gender = "Male";}
            else if(femaleRadioButton.isSelected()) {gender = "Female";}
            String email = emailField.getText();
            String phoneNum = phoneNumField.getText();
            String address = addressField.getText();
            String position = (String) positionField.getSelectedItem();
            String temp = basicSalaryField.getText();
            double basicSalary = 0.0;

            try {
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || gender.isEmpty() || phoneNum.isEmpty() || address.isEmpty() || position == "-----" || temp.isEmpty()) {
                    throw new IllegalArgumentException("Please fill in all fields!");
                }
                basicSalary = Double.parseDouble(temp);
                
                String staffID = Staff.addStaff(firstName, lastName, gender, email, phoneNum, address, position, basicSalary);
                JOptionPane.showMessageDialog(null, "Staff data added successfully!\nStaff ID : " + staffID, "Success", JOptionPane.INFORMATION_MESSAGE);
                resetFields();
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Please enter a valid number for basic salary!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
