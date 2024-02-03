package src.Payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PayrollAdd extends JFrame implements ActionListener {
    private JTextField staffIDField, totalAllowanceField, totalOvertimePayField,
                       totalEPFField, totalSOCSOField;
    
    public PayrollAdd() {
        setTitle("Add Payroll Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel createPayrollPanel = new JPanel(new GridLayout(10, 2, 10, 10));
        
        staffIDField = new JTextField();
        totalAllowanceField = createDoubleNumTextField();
        totalOvertimePayField = createDoubleNumTextField();
        totalEPFField = createDoubleNumTextField();
        totalSOCSOField = createDoubleNumTextField();
        //add month field ???

        createPayrollPanel.add(new JLabel("Staff ID:"));
        createPayrollPanel.add(staffIDField);
        createPayrollPanel.add(new JLabel("Allowance:"));
        createPayrollPanel.add(totalAllowanceField);
        createPayrollPanel.add(new JLabel("Overtime:"));
        createPayrollPanel.add(totalOvertimePayField);
        createPayrollPanel.add(new JLabel("Total EPF:"));
        createPayrollPanel.add(totalEPFField);
        createPayrollPanel.add(new JLabel("Total SOCSO:"));
        createPayrollPanel.add(totalSOCSOField);

        JButton createPayrollButton = new JButton("Add Payroll");
        createPayrollButton.addActionListener(this);
        createPayrollPanel.add(createPayrollButton);

        add(createPayrollPanel);
    }
    private JFormattedTextField createDoubleNumTextField() {
        NumberFormat format = new DecimalFormat("#0.00");
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setMaximum(1000000.0);

        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(10);

        return textField;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Payroll")) {
            double allowance = Double.parseDouble(totalAllowanceField.getText());
            double overtimePay = Double.parseDouble(totalOvertimePayField.getText());
            double EPF = Double.parseDouble(totalEPFField.getText());
            double SOCSO = Double.parseDouble(totalSOCSOField.getText());

            if(Payroll.addPayroll(staffIDField.getText(), allowance, overtimePay, EPF, SOCSO)){
                JOptionPane.showMessageDialog(null, "Payslip Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Staff ID does not exist in system.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
