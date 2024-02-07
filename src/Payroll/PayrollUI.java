package src.Payroll;
import src.Staff.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PayrollUI extends JFrame implements ActionListener {
    
    public PayrollUI() {
    }

    public void test2(JPanel cardPanel){
        JPanel testPanel2 = new JPanel();
        testPanel2.add(new JLabel("Test2"));

        JButton testButton2 = new JButton("Test Button2");
        testButton2.addActionListener(this);
        testPanel2.add(testButton2);

        cardPanel.add(testPanel2, "test2");
    }

    public void printPayslip(ArrayList<Staff> staffList, String ID) {
        for (Staff staff : staffList) {
            if (staff.getID().equals(ID)) {
                System.out.println("-------------- Payslip --------------");
                System.out.println("Bufferflow inc");
                // System.out.println("Date: " + dateFormat.format(new Date()));
                System.out.println("Staff ID: " + staff.getID());
                System.out.println("Name: " + staff.getFirstName() + staff.getLastName());
                System.out.println("-------------------------------------");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Payroll")){

        }
    }
}
