package src.Staff;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class StaffView extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, staffIDLabel, firstNameLabel, lastNameLabel, genderLabel, emailLabel,
                   phoneNumLabel, addressLabel, positionLabel, basicSalaryLabel, currencyLabel,   
                   colon1, colon2, colon3, colon4, colon5, colon6, colon7, colon8;
	private JTextField staffIDField, firstNameField, lastNameField, genderField, emailField,
                       phoneNumField, addressField, positionField;
    private JFormattedTextField basicSalaryField;
	private JButton enterButton, returnButton;
    private String staffID = "";

    public StaffView() {
        setClosable(false);
        setSize(825, 535);
        setMinimumSize(new Dimension(825, 535));
        setMaximumSize(new Dimension(825, 535));
        setLocation(175, 85);        
        getContentPane().setLayout(null);
        setFrameIcon(null);

        enterStaffIDFrame();
    }

    public void enterStaffIDFrame(){
		titleLabel = new JLabel();
		staffIDLabel = new JLabel();
		staffIDField = new JTextField();
		enterButton = new JButton();

        titleLabel.setText("View Staff Information");
        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(110, 20, 375, titleLabel.getPreferredSize().height);
        getContentPane().add(titleLabel);

        staffIDLabel.setText("Enter Staff ID:");
        staffIDLabel.setFont(staffIDLabel.getFont().deriveFont(staffIDLabel.getFont().getSize() + 5f));
        staffIDLabel.setBounds(110, 100, 120, 30);
        getContentPane().add(staffIDLabel);

        staffIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        staffIDField.setBounds(110, 145, 180, 30);
        getContentPane().add(staffIDField);

        enterButton.setText("Enter");
        enterButton.setBackground(new Color(0x00db00));
        enterButton.setForeground(Color.white);
        enterButton.setFont(enterButton.getFont().deriveFont(enterButton.getFont().getStyle() | Font.BOLD, enterButton.getFont().getSize() + 5f));
        enterButton.addActionListener(this);
        enterButton.setBounds(340, 145, 100, 30);
        getContentPane().add(enterButton);

        setVisible(true);
    }

    public void StaffViewFrame(Staff data){
		titleLabel = new JLabel();
		firstNameLabel = new JLabel();
		colon1 = new JLabel();
		lastNameLabel = new JLabel();
		colon2 = new JLabel();
		genderLabel = new JLabel();
		colon3 = new JLabel();
		emailLabel = new JLabel();
		colon4 = new JLabel();
		phoneNumLabel = new JLabel();
		colon5 = new JLabel();
		addressLabel = new JLabel();
		colon6 = new JLabel();
		positionLabel = new JLabel();
		colon7 = new JLabel();
		basicSalaryLabel = new JLabel();
		colon8 = new JLabel();
		currencyLabel = new JLabel();
		firstNameField = new JTextField();
		lastNameField = new JTextField();
		genderField = new JTextField();
		emailField = new JTextField();
		phoneNumField = new JTextField();
		addressField = new JTextField();
		positionField = new JTextField();
		basicSalaryField = doubleNumTextField();
		returnButton = new JButton();

        titleLabel.setText("Staff Information");
        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(110, 20, 265, titleLabel.getPreferredSize().height);
        getContentPane().add(titleLabel);

        firstNameLabel.setText("First Name");
        firstNameLabel.setFont(firstNameLabel.getFont().deriveFont(firstNameLabel.getFont().getSize() + 5f));
        firstNameLabel.setBounds(110, 110, 130, 35);
        getContentPane().add(firstNameLabel);

        colon1.setText(":");
        colon1.setFont(colon1.getFont().deriveFont(colon1.getFont().getSize() + 5f));
        colon1.setBounds(245, 110, 20, 35);
        getContentPane().add(colon1);

        lastNameLabel.setText("Last Name");
        lastNameLabel.setFont(lastNameLabel.getFont().deriveFont(lastNameLabel.getFont().getSize() + 5f));
        lastNameLabel.setBounds(110, 145, 130, 35);
        getContentPane().add(lastNameLabel);

        colon2.setText(":");
        colon2.setFont(colon2.getFont().deriveFont(colon2.getFont().getSize() + 5f));
        colon2.setBounds(245, 145, 20, 35);
        getContentPane().add(colon2);

        genderLabel.setText("Gender");
        genderLabel.setFont(genderLabel.getFont().deriveFont(genderLabel.getFont().getSize() + 5f));
        genderLabel.setBounds(110, 180, 130, 35);
        getContentPane().add(genderLabel);

        colon3.setText(":");
        colon3.setFont(colon3.getFont().deriveFont(colon3.getFont().getSize() + 5f));
        colon3.setBounds(245, 215, 20, 35);
        getContentPane().add(colon3);

        emailLabel.setFont(emailLabel.getFont().deriveFont(emailLabel.getFont().getSize() + 5f));
        emailLabel.setText("Email");
        emailLabel.setBounds(110, 215, 130, 35);
        getContentPane().add(emailLabel);

        colon4.setText(":");
        colon4.setFont(colon4.getFont().deriveFont(colon4.getFont().getSize() + 5f));
        colon4.setBounds(245, 180, 20, 35);
        getContentPane().add(colon4);

        phoneNumLabel.setText("Phone Number");
        phoneNumLabel.setFont(phoneNumLabel.getFont().deriveFont(phoneNumLabel.getFont().getSize() + 5f));
        phoneNumLabel.setBounds(110, 250, 130, 35);
        getContentPane().add(phoneNumLabel);

        colon5.setText(":");
        colon5.setFont(colon5.getFont().deriveFont(colon5.getFont().getSize() + 5f));
        colon5.setBounds(245, 250, 20, 35);
        getContentPane().add(colon5);

        addressLabel.setText("Address");
        addressLabel.setFont(addressLabel.getFont().deriveFont(addressLabel.getFont().getSize() + 5f));
        addressLabel.setBounds(110, 285, 130, 35);
        getContentPane().add(addressLabel);

        colon6.setText(":");
        colon6.setFont(colon6.getFont().deriveFont(colon6.getFont().getSize() + 5f));
        colon6.setBounds(245, 285, 20, 35);
        getContentPane().add(colon6);

        positionLabel.setText("Position");
        positionLabel.setFont(positionLabel.getFont().deriveFont(positionLabel.getFont().getSize() + 5f));
        positionLabel.setBounds(110, 320, 130, 35);
        getContentPane().add(positionLabel);

        colon7.setText(":");
        colon7.setFont(colon7.getFont().deriveFont(colon7.getFont().getSize() + 5f));
        colon7.setBounds(245, 320, 20, 35);
        getContentPane().add(colon7);

        basicSalaryLabel.setText("Basic Salary");
        basicSalaryLabel.setFont(basicSalaryLabel.getFont().deriveFont(basicSalaryLabel.getFont().getSize() + 5f));
        basicSalaryLabel.setBounds(110, 355, 130, 35);
        getContentPane().add(basicSalaryLabel);

        colon8.setText(":");
        colon8.setFont(colon8.getFont().deriveFont(colon8.getFont().getSize() + 5f));
        colon8.setBounds(245, 355, 20, 35);
        getContentPane().add(colon8);

        currencyLabel.setText("RM");
        currencyLabel.setFont(currencyLabel.getFont().deriveFont(currencyLabel.getFont().getStyle() | Font.BOLD, currencyLabel.getFont().getSize() + 2f));
        currencyLabel.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currencyLabel.setBounds(275, 355, 45, 35);
        getContentPane().add(currencyLabel);

        firstNameField.setEditable(false);
        firstNameField.setBackground(Color.white);
        firstNameField.setText(data.getFirstName());
        firstNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        firstNameField.setBounds(275, 110, 445, 35);
        getContentPane().add(firstNameField);
        
        lastNameField.setEditable(false);
        lastNameField.setBackground(Color.white);
        lastNameField.setText(data.getLastName());
        lastNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lastNameField.setBounds(275, 145, 445, 35);
        getContentPane().add(lastNameField);
        
        genderField.setEditable(false);
        genderField.setBackground(Color.white);
        genderField.setText(data.getGender());
        genderField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderField.setBounds(275, 180, 445, 35);
        getContentPane().add(genderField);
        
        emailField.setEditable(false);
        emailField.setBackground(Color.white);
        emailField.setText(data.getEmail());
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setBounds(275, 215, 445, 35);
        getContentPane().add(emailField);
        
        phoneNumField.setEditable(false);
        phoneNumField.setBackground(Color.white);
        phoneNumField.setText(data.getPhoneNum());
        phoneNumField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        phoneNumField.setBounds(275, 250, 445, 35);
        getContentPane().add(phoneNumField);
        
        addressField.setEditable(false);
        addressField.setBackground(Color.white);
        addressField.setText(data.getAddress());
        addressField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        addressField.setBounds(275, 285, 445, 35);
        getContentPane().add(addressField);
        
        positionField.setEditable(false);
        positionField.setBackground(Color.white);
        positionField.setText(data.getPosition());
        positionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        positionField.setBounds(275, 320, 445, 35);
        getContentPane().add(positionField);
        
        basicSalaryField.setEditable(false);
        basicSalaryField.setBackground(Color.white);
        basicSalaryField.setText(String.valueOf(data.getBasicSalary()));
        basicSalaryField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        basicSalaryField.setBounds(315, 355, 405, 35);
        getContentPane().add(basicSalaryField);

        returnButton.setText("Return");
        returnButton.setBackground(new Color(0x333333));
        returnButton.setForeground(Color.white);
        returnButton.setFont(returnButton.getFont().deriveFont(returnButton.getFont().getStyle() | Font.BOLD, returnButton.getFont().getSize() + 5f));
        returnButton.addActionListener(this);
        returnButton.setBounds(590, 435, 130, returnButton.getPreferredSize().height);
        getContentPane().add(returnButton);

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

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            staffID = staffIDField.getText();
            Staff data = Staff.retrieveStaffData(staffID);
            if(data != null){
                getContentPane().removeAll();
                getContentPane().repaint();
                StaffViewFrame(data);
                revalidate();
                repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "Staff not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getActionCommand().equals("Return")) {
            getContentPane().removeAll();
            getContentPane().repaint();
            enterStaffIDFrame();
            revalidate();
            repaint();
        }
    }
}
