package src.Payroll;
import src.Staff.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PayrollView extends JInternalFrame implements ActionListener{
    private JLabel titleLabel, payrollIDLabel, monthLabel, yearLabel, totalAllowanceLabel,
				   totalOvertimePayLabel, totalEPFLabel, totalSOCSOLabel;
	private JTextField payrollIDField;
	private JFormattedTextField totalAllowanceField, totalOvertimePayField,
                                totalEPFField, totalSOCSOField;
	private JComboBox<String> monthComboBox;
	private JSpinner yearSpinner;
	private JButton enterButton, viewPayrollButton;
    private String payrollID = "";
    
    public PayrollView() {
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
        enterButton.setBackground(new Color(0x00db00));
        enterButton.setForeground(Color.white);
        enterButton.setFont(enterButton.getFont().deriveFont(enterButton.getFont().getStyle() | Font.BOLD, enterButton.getFont().getSize() + 5f));
        enterButton.addActionListener(this);
        enterButton.setBounds(372, 165, 100, 30);
        getContentPane().add(enterButton);

        setVisible(true);
    }

    public void PayrollViewFrame(){
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
		viewPayrollButton = new JButton();

        titleLabel.setText("View Payroll Information");
		titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
		titleLabel.setBounds(110, 30, 385, titleLabel.getPreferredSize().height);
		getContentPane().add(titleLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            payrollID = payrollIDField.getText();
            if (!payrollID.isEmpty()) {
                if(Payroll.viewPayroll(payrollID)){
                    getContentPane().removeAll();
                    getContentPane().repaint();
                    
                    PayrollViewFrame();

                    revalidate();
                    repaint();
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
