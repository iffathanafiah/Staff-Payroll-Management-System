package src.Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StaffView extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, staffIDLabel, firstNameLabel, lastNameLabel, genderLabel,
                   emailLabel, phoneNumLabel, addressLabel, departmentLabel, positionLabel;
	private JTextField staffIDField, firstNameField, lastNameField, emailField, phoneNumField, addressField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox<String> departmentField, positionField;
	private JButton enterButton, editStaffButton;
    private String staffID = "";

    public StaffView() {
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

    public void StaffViewFrame(){
        titleLabel = new JLabel("View Staff Information");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(110, 20,375, titleLabel.getPreferredSize().height);
        getContentPane().add(titleLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            staffID = staffIDField.getText();
            if (!staffID.isEmpty()){
                if(Staff.viewStaff(staffID)){
                    getContentPane().removeAll();
                    getContentPane().repaint();
                    
                    StaffViewFrame();

                    revalidate();
                    repaint();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Staff ID does not exist in system.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter a Staff ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
