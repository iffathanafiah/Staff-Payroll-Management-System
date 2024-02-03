package src.Staff;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StaffDelete extends JFrame implements ActionListener {
    private JTextField IDField;
    private String staffID = "";

    public StaffDelete() {
        setTitle("Delete Staff Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel deleteStaffPanel = new JPanel(new GridLayout(2, 2, 10, 10));
    
        JLabel label = new JLabel("Enter Staff ID to delete:");
        IDField = new JTextField();
        JButton deleteButton = new JButton("Remove Staff");
    
        deleteButton.addActionListener(this);
    
        deleteStaffPanel.add(label);
        deleteStaffPanel.add(IDField);
        deleteStaffPanel.add(deleteButton);

        add(deleteStaffPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Remove Staff")) {
            staffID = IDField.getText();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StaffDelete().setVisible(true));
    }
}
