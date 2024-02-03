package src.Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StaffView extends JFrame implements ActionListener {
    private JTextArea viewStaffTextArea;
    private JTextField viewStaffIDField;
    private String staffID = "";

    public StaffView() {
        setTitle("View Staff Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel viewStaffPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());

        viewStaffIDField = new JTextField(4);
        viewStaffTextArea = new JTextArea();
        viewStaffTextArea.setEditable(false);

        inputPanel.add(new JLabel("Enter Staff ID to view:"));
        inputPanel.add(viewStaffIDField);
    
        JButton viewStaffButton = new JButton("View Staff");
        viewStaffButton.addActionListener(this);
        viewStaffPanel.add(viewStaffButton);

        inputPanel.add(viewStaffButton);
        viewStaffPanel.add(inputPanel, BorderLayout.NORTH);
        viewStaffPanel.add(new JScrollPane(viewStaffTextArea), BorderLayout.CENTER);

        add(viewStaffPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("View Staff")) {
            staffID = viewStaffIDField.getText();
            if (!staffID.isEmpty()) {
                String staffInfo = Staff.viewStaff(staffID);
                viewStaffTextArea.setText(staffInfo);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter a Staff ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StaffView().setVisible(true));
    }
}
