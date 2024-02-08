package src.Payroll;
import src.Staff.Staff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class PayrollAdd extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, staffIDLabel, monthLabel, yearLabel, totalAllowanceLabel,
				   totalOvertimePayLabel, totalEPFLabel, totalSOCSOLabel, currencyLabel1,
				   currencyLabel2, currencyLabel3, currencyLabel4;
	private JTextField staffIDField;
	private JFormattedTextField totalAllowanceField, totalOvertimePayField,
                                totalEPFField, totalSOCSOField;
	private JComboBox<String> monthComboBox;
	private JSpinner yearSpinner;
	private JButton createPayrollButton;

    public PayrollAdd() {
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
		monthLabel = new JLabel();
		monthComboBox = new JComboBox<>();
		yearLabel = new JLabel();
		yearSpinner = new JSpinner();
		totalAllowanceLabel = new JLabel();
		currencyLabel1 = new JLabel();
		totalAllowanceField = doubleNumTextField();
		totalOvertimePayLabel = new JLabel();
		currencyLabel2 = new JLabel();
		totalOvertimePayField = doubleNumTextField();
		totalEPFLabel = new JLabel();
		currencyLabel3 = new JLabel();
		totalEPFField = doubleNumTextField();
		totalSOCSOLabel = new JLabel();
		currencyLabel4 = new JLabel();
		totalSOCSOField = doubleNumTextField();
		createPayrollButton = new JButton();
        
        titleLabel.setText("Add Staff Payroll");
		titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
		titleLabel.setBounds(110, 30, 265, titleLabel.getPreferredSize().height);
		getContentPane().add(titleLabel);

		staffIDLabel.setText("Staff ID : ");
		staffIDLabel.setFont(staffIDLabel.getFont().deriveFont(staffIDLabel.getFont().getSize() + 5f));
		staffIDLabel.setBounds(110, 120, 100, 30);
		getContentPane().add(staffIDLabel);

		staffIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		staffIDField.setBounds(110, 150, 105, 30);
		getContentPane().add(staffIDField);

		monthLabel.setText("Month : ");
		monthLabel.setFont(monthLabel.getFont().deriveFont(monthLabel.getFont().getSize() + 5f));
		monthLabel.setBounds(355, 120, 100, 30);
		getContentPane().add(monthLabel);

		monthComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		monthComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"-----",
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

		currencyLabel1.setText("RM");
		currencyLabel1.setFont(currencyLabel1.getFont().deriveFont(currencyLabel1.getFont().getStyle() | Font.BOLD, currencyLabel1.getFont().getSize() + 2f));
		currencyLabel1.setBorder(UIManager.getBorder("TextField.border"));
		currencyLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		currencyLabel1.setBounds(110, 255, 45, 30);
		getContentPane().add(currencyLabel1);

		totalAllowanceField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalAllowanceField.setBounds(152, 255, 168, 30);
		getContentPane().add(totalAllowanceField);

		totalOvertimePayLabel.setText("Overtime : ");
		totalOvertimePayLabel.setFont(totalOvertimePayLabel.getFont().deriveFont(totalOvertimePayLabel.getFont().getSize() + 5f));
		totalOvertimePayLabel.setBounds(110, 300, 100, 30);
		getContentPane().add(totalOvertimePayLabel);

		currencyLabel2.setText("RM");
		currencyLabel2.setFont(currencyLabel2.getFont().deriveFont(currencyLabel2.getFont().getStyle() | Font.BOLD, currencyLabel2.getFont().getSize() + 2f));
		currencyLabel2.setBorder(UIManager.getBorder("TextField.border"));
		currencyLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		currencyLabel2.setBounds(110, 330, 45, 30);
		getContentPane().add(currencyLabel2);

		totalOvertimePayField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalOvertimePayField.setBounds(152, 330, 168, 30);
		getContentPane().add(totalOvertimePayField);

		totalEPFLabel.setText("EPF : ");
		totalEPFLabel.setFont(totalEPFLabel.getFont().deriveFont(totalEPFLabel.getFont().getSize() + 5f));
		totalEPFLabel.setBounds(355, 225, 90, 30);
		getContentPane().add(totalEPFLabel);

		currencyLabel3.setText("RM");
		currencyLabel3.setFont(currencyLabel3.getFont().deriveFont(currencyLabel3.getFont().getStyle() | Font.BOLD, currencyLabel3.getFont().getSize() + 2f));
		currencyLabel3.setBorder(UIManager.getBorder("TextField.border"));
		currencyLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		currencyLabel3.setBounds(355, 255, 45, 30);
		getContentPane().add(currencyLabel3);

		totalEPFField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalEPFField.setBounds(397, 255, 168, 30);
		getContentPane().add(totalEPFField);

		totalSOCSOLabel.setText("SOCSO : ");
		totalSOCSOLabel.setFont(totalSOCSOLabel.getFont().deriveFont(totalSOCSOLabel.getFont().getSize() + 5f));
		totalSOCSOLabel.setBounds(355, 300, 110, 30);
		getContentPane().add(totalSOCSOLabel);

		currencyLabel4.setText("RM");
		currencyLabel4.setFont(currencyLabel4.getFont().deriveFont(currencyLabel4.getFont().getStyle() | Font.BOLD, currencyLabel4.getFont().getSize() + 2f));
		currencyLabel4.setBorder(UIManager.getBorder("TextField.border"));
		currencyLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		currencyLabel4.setBounds(355, 330, 45, 30);
		getContentPane().add(currencyLabel4);

		totalSOCSOField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalSOCSOField.setBounds(397, 330, 168, 30);
		getContentPane().add(totalSOCSOField);

		createPayrollButton.setText("Add Payroll");
		createPayrollButton.setBackground(new Color(0x00db00));
		createPayrollButton.setForeground(Color.white);
		createPayrollButton.setFont(createPayrollButton.getFont().deriveFont(createPayrollButton.getFont().getStyle() | Font.BOLD, createPayrollButton.getFont().getSize() + 5f));
		createPayrollButton.addActionListener(this);
		createPayrollButton.setBounds(435, 435, 130, createPayrollButton.getPreferredSize().height);
		getContentPane().add(createPayrollButton);

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
	public void resetFields() {
		staffIDField.setText("");
		totalAllowanceField.setValue(null);
		totalOvertimePayField.setValue(null);
		totalEPFField.setValue(null);
		totalSOCSOField.setValue(null);
		monthComboBox.setSelectedIndex(0);
		yearSpinner.setValue(2024);
	}

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Payroll")){			
			String staffID = staffIDField.getText();
            Staff staff = Staff.retrieveStaffData(staffID);
			String month = (String) monthComboBox.getSelectedItem();
			int year = (int) yearSpinner.getValue();
            double allowance, overtimePay, EPF, SOCSO;

			try{
				if(staffID.isEmpty() || month == "-----" || year == 0 || totalAllowanceField.getText().isEmpty() || totalOvertimePayField.getText().isEmpty() || totalEPFField.getText().isEmpty() || totalSOCSOField.getText().isEmpty()){
					throw new IllegalArgumentException("Please fill in all fields!");
				}
				if(staff == null){
					throw new NullPointerException("Staff not found!");
				}
				if(Payroll.validatePayroll(staffID, year, month)){
					throw new IllegalArgumentException("Payroll already created!");
				}
				allowance = Double.parseDouble(totalAllowanceField.getText());
				overtimePay = Double.parseDouble(totalOvertimePayField.getText());
				EPF = Double.parseDouble(totalEPFField.getText());
				SOCSO = Double.parseDouble(totalSOCSOField.getText());

				String payrollID = Payroll.addPayroll(staff, month, year, allowance, overtimePay, EPF, SOCSO);
				JOptionPane.showMessageDialog(null, "Payroll added successfully!\nPayroll ID : " + payrollID, "Success", JOptionPane.INFORMATION_MESSAGE);
				resetFields();
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Please enter a valid number for currency!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(IllegalArgumentException ex){
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
