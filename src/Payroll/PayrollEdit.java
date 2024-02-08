package src.Payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class PayrollEdit extends JInternalFrame implements ActionListener{
    private JLabel titleLabel, payrollIDLabel, monthLabel, yearLabel, totalAllowanceLabel,
				   totalOvertimePayLabel, totalEPFLabel, totalSOCSOLabel, currencyLabel1,
				   currencyLabel2, currencyLabel3, currencyLabel4;
	private JTextField payrollIDField, monthField, yearField;
	private JFormattedTextField totalAllowanceField, totalOvertimePayField,
                                totalEPFField, totalSOCSOField;
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

        enterPayrollIDFrame();
    }

	public void enterPayrollIDFrame(){
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
        enterButton.setBackground(new Color(0x0037a1));
        enterButton.setForeground(Color.white);
        enterButton.setFont(enterButton.getFont().deriveFont(enterButton.getFont().getStyle() | Font.BOLD, enterButton.getFont().getSize() + 5f));
        enterButton.addActionListener(this);
        enterButton.setBounds(372, 165, 100, 30);
        getContentPane().add(enterButton);

        setVisible(true);
	}

    public void PayrollEditFrame(Payroll data){
        titleLabel = new JLabel();
		payrollIDLabel = new JLabel();
		payrollIDField = new JTextField();
		monthLabel = new JLabel();
		monthField = new JTextField();
		yearLabel = new JLabel();
		yearField = new JTextField();
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
		payrollIDField.setText(data.getPayrollID());
		payrollIDField.setEditable(false);
		getContentPane().add(payrollIDField);

		monthLabel.setText("Month : ");
		monthLabel.setFont(monthLabel.getFont().deriveFont(monthLabel.getFont().getSize() + 5f));
		monthLabel.setBounds(355, 120, 100, 30);
		getContentPane().add(monthLabel);

		monthField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		monthField.setText(data.getMonthName());
		monthField.setEditable(false);
		monthField.setBounds(355, 150, 115, 30);
		getContentPane().add(monthField);

		yearLabel.setText("Year : ");
		yearLabel.setFont(yearLabel.getFont().deriveFont(yearLabel.getFont().getSize() + 5f));
		yearLabel.setBounds(480, 120, 65, 30);
		getContentPane().add(yearLabel);

		yearField = new JTextField();
		yearField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearField.setText(String.valueOf(data.getYear()));
		yearField.setEditable(false);
		yearField.setBounds(480, 150, 85, 30);
		getContentPane().add(yearField);

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
		totalAllowanceField.setValue(data.getAllowancePay());
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
		totalOvertimePayField.setValue(data.getOvertimePay());
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
		totalEPFField.setValue(data.getEPF());
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
		totalSOCSOField.setValue(data.getSOCSO());
		totalSOCSOField.setBounds(397, 330, 168, 30);
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
	private JFormattedTextField doubleNumTextField() {
        NumberFormat format = new DecimalFormat("#0.00");
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setMaximum(1000000.0);

        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(10);

        return textField;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Enter")) {
            payrollID = payrollIDField.getText();
            Payroll data = Payroll.retrievePayrollData(payrollID);
            if(data != null){
                getContentPane().removeAll();
                getContentPane().repaint();
                PayrollEditFrame(data);
                revalidate();
                repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "Payroll data not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

		else if (e.getActionCommand().equals("Edit Payroll")){
            double allowance, overtimePay, EPF, SOCSO;

			try{
				if(totalAllowanceField.getText().isEmpty() || totalOvertimePayField.getText().isEmpty() || totalEPFField.getText().isEmpty() || totalSOCSOField.getText().isEmpty()){
					throw new IllegalArgumentException("Please fill in all fields!");
				}
				allowance = Double.parseDouble(totalAllowanceField.getText());
				overtimePay = Double.parseDouble(totalOvertimePayField.getText());
				EPF = Double.parseDouble(totalEPFField.getText());
				SOCSO = Double.parseDouble(totalSOCSOField.getText());

				Payroll.editPayroll(payrollIDField.getText(), allowance, overtimePay, EPF, SOCSO);
				getContentPane().removeAll();
                getContentPane().repaint();
                enterPayrollIDFrame();
                revalidate();
                repaint();
				JOptionPane.showMessageDialog(null, "Payroll data has been edited successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Please enter a valid number for currency!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(IllegalArgumentException ex){
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
    }
}