package src.Payroll;
import src.Staff.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PayrollEdit extends JInternalFrame implements ActionListener{
    private JLabel titleLabel, payrollIDLabel, monthLabel, yearLabel, totalAllowanceLabel,
				   totalOvertimePayLabel, totalEPFLabel, totalSOCSOLabel;
	private JTextField payrollIDField;
	private JFormattedTextField totalAllowanceField, totalOvertimePayField,
                                totalEPFField, totalSOCSOField;
	private JComboBox<String> monthComboBox;
	private JSpinner yearSpinner;
	private JButton enterButton, editPayrollButton;
    private String payrollID = "";

    public PayrollEdit(){
        setClosable(false);
        setSize(825, 535);
        setMinimumSize(new Dimension(825, 535));
        setMaximumSize(new Dimension(825, 535));
        setLocation(175, 85);        
        getContentPane().setLayout(null);
        setFrameIcon(null);

        titleLabel = new JLabel();
		payrollIDLabel = new JLabel();
		payrollIDField = new JTextField();
		enterButton = new JButton();

        titleLabel.setText("Edit Payroll Information");
        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(110, 30, 385, titleLabel.getPreferredSize().height);
        getContentPane().add(titleLabel);

        payrollIDLabel.setText("Enter Payroll ID:");
        payrollIDLabel.setFont(payrollIDLabel.getFont().deriveFont(payrollIDLabel.getFont().getSize() + 5f));
        payrollIDLabel.setBounds(110, 120, 145, 30);
        getContentPane().add(payrollIDLabel);

        payrollIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        payrollIDField.setBounds(110, 165, 180, 30);
        getContentPane().add(payrollIDField);

        enterButton.setText("Enter");
        enterButton.setBackground(new Color(0x00db00));
        enterButton.setForeground(Color.white);
        enterButton.setFont(enterButton.getFont().deriveFont(enterButton.getFont().getStyle() | Font.BOLD, enterButton.getFont().getSize() + 5f));
        enterButton.addActionListener(this);
        enterButton.setBounds(372, 165, 100, 30);
        getContentPane().add(enterButton);

        setVisible(true);
    }

    public void PayrollEditFrame(){
        titleLabel = new JLabel();
		payrollIDLabel = new JLabel();
		payrollIDField = new JTextField();
		monthLabel = new JLabel();
		monthComboBox = new JComboBox<>();
		yearLabel = new JLabel();
		yearSpinner = new JSpinner();
		totalAllowanceLabel = new JLabel();
		totalAllowanceField = new JFormattedTextField();
		totalOvertimePayLabel = new JLabel();
		totalOvertimePayField = new JFormattedTextField();
		totalEPFLabel = new JLabel();
		totalEPFField = new JFormattedTextField();
		totalSOCSOLabel = new JLabel();
		totalSOCSOField = new JFormattedTextField();
		editPayrollButton = new JButton();

        titleLabel.setText("Edit Payroll Information");
		titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
		titleLabel.setBounds(110, 30, 385, titleLabel.getPreferredSize().height);
		getContentPane().add(titleLabel);

		payrollIDLabel.setText("Payroll ID : ");
		payrollIDLabel.setFont(payrollIDLabel.getFont().deriveFont(payrollIDLabel.getFont().getSize() + 5f));
		payrollIDLabel.setBounds(110, 120, 100, 30);
		getContentPane().add(payrollIDLabel);

		payrollIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		payrollIDField.setBounds(110, 150, 105, 30);
		getContentPane().add(payrollIDField);

		monthLabel.setText("Month : ");
		monthLabel.setFont(monthLabel.getFont().deriveFont(monthLabel.getFont().getSize() + 5f));
		monthLabel.setBounds(355, 120, 100, 30);
		getContentPane().add(monthLabel);

		monthComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		monthComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		}));
		monthComboBox.setBounds(355, 150, 115, 30);
		getContentPane().add(monthComboBox);

		yearLabel.setText("Year : ");
		yearLabel.setFont(yearLabel.getFont().deriveFont(yearLabel.getFont().getSize() + 5f));
		yearLabel.setBounds(480, 120, 65, 30);
		getContentPane().add(yearLabel);

		yearSpinner.setModel(new SpinnerNumberModel(2024, 1924, 2124, 1));
		yearSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearSpinner.setBounds(480, 150, 85, 30);
		getContentPane().add(yearSpinner);

		totalAllowanceLabel.setText("Allowance : ");
		totalAllowanceLabel.setFont(totalAllowanceLabel.getFont().deriveFont(totalAllowanceLabel.getFont().getSize() + 5f));
		totalAllowanceLabel.setBounds(110, 225, 100, 30);
		getContentPane().add(totalAllowanceLabel);

		totalAllowanceField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalAllowanceField.setBounds(110, 255, 210, 30);
		getContentPane().add(totalAllowanceField);

		totalOvertimePayLabel.setText("Overtime : ");
		totalOvertimePayLabel.setFont(totalOvertimePayLabel.getFont().deriveFont(totalOvertimePayLabel.getFont().getSize() + 5f));
		totalOvertimePayLabel.setBounds(110, 300, 100, 30);
		getContentPane().add(totalOvertimePayLabel);

		totalOvertimePayField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalOvertimePayField.setBounds(110, 330, 210, 30);
		getContentPane().add(totalOvertimePayField);

		totalEPFLabel.setText("EPF : ");
		totalEPFLabel.setFont(totalEPFLabel.getFont().deriveFont(totalEPFLabel.getFont().getSize() + 5f));
		totalEPFLabel.setBounds(355, 225, 90, 30);
		getContentPane().add(totalEPFLabel);

		totalEPFField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalEPFField.setBounds(355, 255, 210, 30);
		getContentPane().add(totalEPFField);

		totalSOCSOLabel.setText("SOCSO : ");
		totalSOCSOLabel.setFont(totalSOCSOLabel.getFont().deriveFont(totalSOCSOLabel.getFont().getSize() + 5f));
		totalSOCSOLabel.setBounds(355, 300, 110, 30);
		getContentPane().add(totalSOCSOLabel);

		totalSOCSOField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalSOCSOField.setBounds(355, 330, 210, 30);
		getContentPane().add(totalSOCSOField);

		editPayrollButton.setText("Edit Payroll");
		editPayrollButton.setBackground(new Color(0x00db00));
		editPayrollButton.setForeground(Color.white);
		editPayrollButton.setFont(editPayrollButton.getFont().deriveFont(editPayrollButton.getFont().getStyle() | Font.BOLD, editPayrollButton.getFont().getSize() + 5f));
		editPayrollButton.addActionListener(this);
		editPayrollButton.setBounds(435, 435, 130, editPayrollButton.getPreferredSize().height);
		getContentPane().add(editPayrollButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Enter")) {
            getContentPane().removeAll();
            getContentPane().repaint();
            
            PayrollEditFrame();

            revalidate();
            repaint();
        }
    }
}