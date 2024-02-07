package src.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffEdit extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, staffIDLabel, firstNameLabel, lastNameLabel, genderLabel,
                   emailLabel, phoneNumLabel, addressLabel, departmentLabel, positionLabel;
	private JTextField staffIDField, firstNameField, lastNameField, emailField, phoneNumField, addressField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox<String> departmentField, positionField;
	private JButton enterButton, editStaffButton;
    private String staffID = "";
    
    public StaffEdit() {
        setClosable(false);
        setSize(825, 535);
        setMinimumSize(new Dimension(825, 535));
        setMaximumSize(new Dimension(825, 535));
        setLocation(175, 85);        
        getContentPane().setLayout(null);
        setFrameIcon(null);

		titleLabel = new JLabel();
		staffIDLabel = new JLabel();
		staffIDField = new JTextField();
		enterButton = new JButton();

        titleLabel.setText("Edit Staff Information");
        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(110, 20, 335, titleLabel.getPreferredSize().height);
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

    public void StaffEditFrame(){
        titleLabel = new JLabel("Edit Staff Information");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(110, 20,335, titleLabel.getPreferredSize().height);
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
    
        editStaffButton = new JButton("Edit Staff");
        editStaffButton.setBackground(new Color(0x00db00));
        editStaffButton.setForeground(Color.white);
        editStaffButton.setFont(editStaffButton.getFont().deriveFont(editStaffButton.getFont().getStyle() | Font.BOLD, editStaffButton.getFont().getSize() + 5f));
        editStaffButton.setBounds(530, 445, 115, editStaffButton.getPreferredSize().height);
        editStaffButton.addActionListener(this);
        getContentPane().add(editStaffButton);

        ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(maleRadioButton);
		buttonGroup1.add(femaleRadioButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            getContentPane().removeAll();
            getContentPane().repaint();
            
            StaffEditFrame();

            revalidate();
            repaint();
        }
    }
}
