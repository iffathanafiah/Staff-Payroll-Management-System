package src.Staff;

import java.awt.event.*;
import javax.swing.*;

public class StaffEdit extends JFrame implements ActionListener {

    public StaffEdit() {
        setTitle("Edit Staff Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel editStaffPanel = new JPanel();
        editStaffPanel.add(new JLabel("Edit Staff Interface Content"));

        add(editStaffPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Edit Staff")) {
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StaffEdit().setVisible(true));
    }
}
