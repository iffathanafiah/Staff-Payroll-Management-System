package src.Payroll;
import src.Staff.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PayrollView extends JInternalFrame implements ActionListener{
    private JLabel titleLabel, payrollIDLabel, paymentDateLabel, staffIDLabel, fullNameLabel, positionLabel, basicSalaryLabel,
                   allowanceLabel, overtimeLabel, totalEPFLabel, totalSOCSOLabel, netPayLabel, currencyLabel1,
                   currencyLabel2, currencyLabel3, currencyLabel4, currencyLabel5, currencyLabel6;
	private JTextField payrollIDField, dateField, staffIDField, fullNameField, positionField, totalBasicSalaryField;
	private JFormattedTextField totalAllowanceField, totalOvertimePayField,
                                totalEPFField, totalSOCSOField, netSalaryField;
	private JButton enterButton, returnButton, printPayrollButton;
    private String payrollID = "";
    
    public PayrollView() {
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

        titleLabel.setText("View Payroll Information");
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

    public void PayrollViewFrame(Staff staffData, Payroll payrollData){
		titleLabel = new JLabel();
		paymentDateLabel = new JLabel();
		staffIDLabel = new JLabel();
		fullNameLabel = new JLabel();
		positionLabel = new JLabel();
		basicSalaryLabel = new JLabel();
		allowanceLabel = new JLabel();
		overtimeLabel = new JLabel();
		totalEPFLabel = new JLabel();
		totalSOCSOLabel = new JLabel();
		netPayLabel = new JLabel();
		dateField = new JTextField();
		staffIDField = new JTextField();
		fullNameField = new JTextField();
		positionField = new JTextField();
		currencyLabel1 = new JLabel();
		currencyLabel2 = new JLabel();
		currencyLabel3 = new JLabel();
		currencyLabel4 = new JLabel();
		currencyLabel5 = new JLabel();
		currencyLabel6 = new JLabel();
		totalBasicSalaryField = new JTextField();
		totalAllowanceField = doubleNumTextField();
		totalOvertimePayField = doubleNumTextField();
		totalEPFField = doubleNumTextField();
		totalSOCSOField = doubleNumTextField();
		netSalaryField = doubleNumTextField();
		returnButton = new JButton();
		printPayrollButton = new JButton();

        titleLabel.setText("Staff Payroll");
        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
        titleLabel.setBounds(100, 20, 265, titleLabel.getPreferredSize().height);
        getContentPane().add(titleLabel);

        paymentDateLabel.setText("Payment Date  -");
        paymentDateLabel.setFont(paymentDateLabel.getFont().deriveFont(paymentDateLabel.getFont().getSize() + 5f));
        paymentDateLabel.setBounds(425, 25, 130, 35);
        getContentPane().add(paymentDateLabel);

        staffIDLabel.setText("Staff ID");
        staffIDLabel.setFont(staffIDLabel.getFont().deriveFont(staffIDLabel.getFont().getSize() + 5f));
        staffIDLabel.setBounds(100, 95, 110, 35);
        getContentPane().add(staffIDLabel);

        fullNameLabel.setText("Full Name");
        fullNameLabel.setFont(fullNameLabel.getFont().deriveFont(fullNameLabel.getFont().getSize() + 5f));
        fullNameLabel.setBounds(100, 130, 110, 35);
        getContentPane().add(fullNameLabel);

        positionLabel.setText("Position");
        positionLabel.setFont(positionLabel.getFont().deriveFont(positionLabel.getFont().getSize() + 5f));
        positionLabel.setBounds(100, 165, 110, 35);
        getContentPane().add(positionLabel);

        basicSalaryLabel.setText("Basic Salary");
        basicSalaryLabel.setFont(basicSalaryLabel.getFont().deriveFont(basicSalaryLabel.getFont().getSize() + 5f));
        basicSalaryLabel.setBounds(100, 240, 100, 35);
        getContentPane().add(basicSalaryLabel);

        allowanceLabel.setText("Allowance");
        allowanceLabel.setFont(allowanceLabel.getFont().deriveFont(allowanceLabel.getFont().getSize() + 5f));
        allowanceLabel.setBounds(100, 275, 100, 35);
        getContentPane().add(allowanceLabel);

        overtimeLabel.setText("Overtime");
        overtimeLabel.setFont(overtimeLabel.getFont().deriveFont(overtimeLabel.getFont().getSize() + 5f));
        overtimeLabel.setBounds(100, 310, 110, 35);
        getContentPane().add(overtimeLabel);

        totalEPFLabel.setText("Total EPF");
        totalEPFLabel.setFont(totalEPFLabel.getFont().deriveFont(totalEPFLabel.getFont().getSize() + 5f));
        totalEPFLabel.setBounds(440, 240, 90, 35);
        getContentPane().add(totalEPFLabel);

        totalSOCSOLabel.setText("Total SOCSO");
        totalSOCSOLabel.setFont(totalSOCSOLabel.getFont().deriveFont(totalSOCSOLabel.getFont().getSize() + 5f));
        totalSOCSOLabel.setBounds(440, 275, 120, 35);
        getContentPane().add(totalSOCSOLabel);

        netPayLabel.setText("Net Pay");
        netPayLabel.setFont(netPayLabel.getFont().deriveFont(netPayLabel.getFont().getSize() + 5f));
        netPayLabel.setBounds(440, 360, 120, 35);
        getContentPane().add(netPayLabel);

        dateField.setEditable(false);
        dateField.setBackground(Color.white);
        dateField.setText(payrollData.getMonthName() + " " + payrollData.getYear());
        dateField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dateField.setBounds(560, 25, 170, 35);
        getContentPane().add(dateField);

        staffIDField.setEditable(false);
        staffIDField.setBackground(Color.white);
        staffIDField.setText(staffData.getID());
        staffIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        staffIDField.setBounds(230, 95, 120, 35);
        getContentPane().add(staffIDField);

        fullNameField.setEditable(false);
        fullNameField.setBackground(Color.white);
        fullNameField.setText(staffData.getFirstName() + " " + staffData.getLastName());
        fullNameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameField.setBounds(230, 130, 330, 35);
        getContentPane().add(fullNameField);

        positionField.setEditable(false);
        positionField.setBackground(Color.white);
        positionField.setText(staffData.getPosition());
        positionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        positionField.setBounds(230, 165, 330, 35);
        getContentPane().add(positionField);

        currencyLabel1.setText("RM");
        currencyLabel1.setFont(currencyLabel1.getFont().deriveFont(currencyLabel1.getFont().getStyle() | Font.BOLD, currencyLabel1.getFont().getSize() + 2f));
        currencyLabel1.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        currencyLabel1.setBounds(230, 240, 45, 35);
        getContentPane().add(currencyLabel1);

        currencyLabel2.setText("RM");
        currencyLabel2.setFont(currencyLabel2.getFont().deriveFont(currencyLabel2.getFont().getStyle() | Font.BOLD, currencyLabel2.getFont().getSize() + 2f));
        currencyLabel2.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        currencyLabel2.setBounds(230, 275, 45, 35);
        getContentPane().add(currencyLabel2);

        currencyLabel3.setText("RM");
        currencyLabel3.setFont(currencyLabel3.getFont().deriveFont(currencyLabel3.getFont().getStyle() | Font.BOLD, currencyLabel3.getFont().getSize() + 2f));
        currencyLabel3.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        currencyLabel3.setBounds(230, 310, 45, 35);
        getContentPane().add(currencyLabel3);

        currencyLabel4.setText("RM");
        currencyLabel4.setFont(currencyLabel4.getFont().deriveFont(currencyLabel4.getFont().getStyle() | Font.BOLD, currencyLabel4.getFont().getSize() + 2f));
        currencyLabel4.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        currencyLabel4.setBounds(560, 240, 45, 35);
        getContentPane().add(currencyLabel4);

        currencyLabel5.setText("RM");
        currencyLabel5.setFont(currencyLabel5.getFont().deriveFont(currencyLabel5.getFont().getStyle() | Font.BOLD, currencyLabel5.getFont().getSize() + 2f));
        currencyLabel5.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        currencyLabel5.setBounds(560, 275, 45, 35);
        getContentPane().add(currencyLabel5);

        currencyLabel6.setText("RM");
        currencyLabel6.setFont(currencyLabel6.getFont().deriveFont(currencyLabel6.getFont().getStyle() | Font.BOLD, currencyLabel6.getFont().getSize() + 2f));
        currencyLabel6.setBorder(UIManager.getBorder("TextField.border"));
        currencyLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        currencyLabel6.setBounds(560, 360, 45, 35);
        getContentPane().add(currencyLabel6);

        totalBasicSalaryField.setEditable(false);
        totalBasicSalaryField.setBackground(Color.white);
        totalBasicSalaryField.setText(String.valueOf(payrollData.getBasicSalary()));
        totalBasicSalaryField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        totalBasicSalaryField.setBounds(274, 240, 125, 34);
        getContentPane().add(totalBasicSalaryField);
        
        totalAllowanceField.setEditable(false);
        totalAllowanceField.setBackground(Color.white);
        totalAllowanceField.setText(String.valueOf(payrollData.getAllowancePay()));
        totalAllowanceField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        totalAllowanceField.setBounds(274, 275, 125, 34);
        getContentPane().add(totalAllowanceField);

        totalOvertimePayField.setEditable(false);
        totalOvertimePayField.setBackground(Color.white);
        totalOvertimePayField.setText(String.valueOf(payrollData.getOvertimePay()));
        totalOvertimePayField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        totalOvertimePayField.setBounds(274, 310, 125, 34);
        getContentPane().add(totalOvertimePayField);
        
        totalEPFField.setEditable(false);
        totalEPFField.setBackground(Color.white);
        totalEPFField.setText(String.valueOf(payrollData.getEPF()));
        totalEPFField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        totalEPFField.setBounds(604, 240, 125, 34);
        getContentPane().add(totalEPFField);
        
        totalSOCSOField.setEditable(false);
        totalSOCSOField.setBackground(Color.white);
        totalSOCSOField.setText(String.valueOf(payrollData.getSOCSO()));
        totalSOCSOField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        totalSOCSOField.setBounds(604, 275, 125, 34);
        getContentPane().add(totalSOCSOField);

        netSalaryField.setEditable(false);
        netSalaryField.setBackground(Color.white);
        netSalaryField.setText(String.valueOf(payrollData.getTotalNetSalary()));
        netSalaryField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        netSalaryField.setBounds(604, 360, 125, 34);
        getContentPane().add(netSalaryField);

        returnButton.setText("Return");
        returnButton.setBackground(new Color(0x484848));
        returnButton.setForeground(Color.white);
        returnButton.setFont(returnButton.getFont().deriveFont(returnButton.getFont().getStyle() | Font.BOLD, returnButton.getFont().getSize() + 5f));
        returnButton.addActionListener(this);
        returnButton.setBounds(620, 440, 110, returnButton.getPreferredSize().height);
        getContentPane().add(returnButton);

        printPayrollButton.setText("Print");
        printPayrollButton.setBackground(new Color(0x0037a1));
        printPayrollButton.setForeground(Color.white);
        printPayrollButton.setFont(printPayrollButton.getFont().deriveFont(printPayrollButton.getFont().getStyle() | Font.BOLD, printPayrollButton.getFont().getSize() + 5f));
        printPayrollButton.addActionListener(this);
        printPayrollButton.setBounds(505, 440, 110, 34);
        getContentPane().add(printPayrollButton);

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

    private void generatePayrollImage(Container contentPane, String fileName) {
        Dimension size = contentPane.getSize();
        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        contentPane.paint(graphics);
        graphics.dispose();

        String directoryPath = "src/Payroll/" + fileName;
        File outputFile = new File(directoryPath);
        try {
            ImageIO.write(image, "png", outputFile);
            JOptionPane.showMessageDialog(null, "Payroll slip has been generated!\nSaved in " + directoryPath, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            payrollID = payrollIDField.getText();
            Payroll payrollData = Payroll.retrievePayrollData(payrollID);
            if(payrollData != null){
                getContentPane().removeAll();
                getContentPane().repaint();
                Staff staffData = Staff.retrieveStaffData(payrollID.substring(0, 4));
                PayrollViewFrame(staffData, payrollData);
                revalidate();
                repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "Payroll data not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (e.getActionCommand().equals("Print")) {
            generatePayrollImage(getContentPane(), payrollID + ".png");
        }
        
        else if (e.getActionCommand().equals("Return")) {
            getContentPane().removeAll();
            getContentPane().repaint();
            enterPayrollIDFrame();
            revalidate();
            repaint();
        }
    }
}
