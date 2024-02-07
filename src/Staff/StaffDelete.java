package src.Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StaffDelete extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, staffIDLabel;
	private JTextField staffIDField;
	private JButton deleteStaffButton;
    private String staffID = "";

    public StaffDelete() {
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
		deleteStaffButton = new JButton();

        titleLabel.setText("Delete Staff");
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

        deleteStaffButton.setText("Delete");
        deleteStaffButton.setBackground(new Color(0xcb0000));
        deleteStaffButton.setForeground(Color.white);
        deleteStaffButton.setFont(deleteStaffButton.getFont().deriveFont(deleteStaffButton.getFont().getStyle() | Font.BOLD, deleteStaffButton.getFont().getSize() + 5f));
        deleteStaffButton.addActionListener(this);
        deleteStaffButton.setBounds(340, 145, 100, 30);
        getContentPane().add(deleteStaffButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Delete")) {
            staffID = staffIDField.getText();
            if (!staffID.isEmpty()){
                if(Staff.fireStaff(staffID)){
                    JOptionPane.showMessageDialog(null, "Staff deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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
