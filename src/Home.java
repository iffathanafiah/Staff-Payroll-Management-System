package src;
import java.awt.*;
import javax.swing.*;

public class Home extends JInternalFrame{
    private JLabel projectDesc, staffLabel, staffDesc1, staffDesc2, payrollLabel, payrollDesc1, payrollDesc2,
				   payrollDesc3, fileHandlingLabel, fileHandlingDesc1, fileHandlingDesc2, contributorTitle;
	private JTextField contributor1, contributor2, contributor3, contributor4;
    
    public Home(){
        setClosable(false);
        setSize(825, 535);
        setMinimumSize(new Dimension(825, 535));
        setMaximumSize(new Dimension(825, 535));
        setLocation(175, 85);        
        getContentPane().setLayout(null);
        setFrameIcon(null);

        homeFrame();
    }
    public void homeFrame(){
        projectDesc = new JLabel();
		staffLabel = new JLabel();
		staffDesc1 = new JLabel();
		staffDesc2 = new JLabel();
		payrollLabel = new JLabel();
		payrollDesc1 = new JLabel();
		payrollDesc2 = new JLabel();
		payrollDesc3 = new JLabel();
		fileHandlingLabel = new JLabel();
		fileHandlingDesc1 = new JLabel();
		fileHandlingDesc2 = new JLabel();
		contributorTitle = new JLabel();
		contributor1 = new JTextField();
		contributor2 = new JTextField();
		contributor3 = new JTextField();
		contributor4 = new JTextField();

		projectDesc.setText("System Description");
		projectDesc.setFont(new Font("Segoe UI", Font.BOLD, 24));
		projectDesc.setBounds(150, 30, 250, 32);
		getContentPane().add(projectDesc);

		staffLabel.setText("Staff Management");
		staffLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		staffLabel.setBounds(150, 90, 150, staffLabel.getPreferredSize().height);
		getContentPane().add(staffLabel);

		staffDesc1.setText("This system can handle the staff data through basic");
		staffDesc1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		staffDesc1.setBounds(350, 90, 375, 22);
		getContentPane().add(staffDesc1);

		payrollLabel.setText("Payroll Management");
		payrollLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		payrollLabel.setBounds(150, 150, 180, 22);
		getContentPane().add(payrollLabel);

		payrollDesc1.setText("This system can handle the payroll data through basic");
		payrollDesc1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		payrollDesc1.setBounds(350, 150, 400, 22);
		getContentPane().add(payrollDesc1);

		fileHandlingLabel.setText("Load and Save Data");
		fileHandlingLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		fileHandlingLabel.setBounds(150, 235, 180, 22);
		getContentPane().add(fileHandlingLabel);

		fileHandlingDesc1.setText("This system able to load and save the data of staff");
		fileHandlingDesc1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		fileHandlingDesc1.setBounds(350, 235, 360, 22);
		getContentPane().add(fileHandlingDesc1);

		contributorTitle.setText("Developed By:");
		contributorTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		contributorTitle.setBounds(new Rectangle(new Point(150, 310), contributorTitle.getPreferredSize()));
		getContentPane().add(contributorTitle);

		contributor1.setEditable(false);
		contributor1.setBackground(Color.white);
		contributor1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contributor1.setText("Muhammad Ariff Ridzlan");
		contributor1.setHorizontalAlignment(SwingConstants.CENTER);
		contributor1.setBounds(150, 355, 240, 40);
		getContentPane().add(contributor1);

		contributor2.setEditable(false);
		contributor2.setBackground(Color.white);
		contributor2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contributor2.setText("Nawfal Syafi'");
		contributor2.setHorizontalAlignment(SwingConstants.CENTER);
		contributor2.setBounds(150, 400, 240, 40);
		getContentPane().add(contributor2);

		contributor3.setEditable(false);
		contributor3.setBackground(Color.white);
		contributor3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contributor3.setText("Muhammad Iffat");
		contributor3.setHorizontalAlignment(SwingConstants.CENTER);
		contributor3.setBounds(395, 355, 240, 40);
		getContentPane().add(contributor3);

		contributor4.setEditable(false);
		contributor4.setBackground(Color.white);
		contributor4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contributor4.setText("Muhammad Haikal Hazim");
		contributor4.setHorizontalAlignment(SwingConstants.CENTER);
		contributor4.setBounds(395, 400, 240, 40);
		getContentPane().add(contributor4);

		fileHandlingDesc2.setText("as well as payroll from and into a file respectively.");
		fileHandlingDesc2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		fileHandlingDesc2.setBounds(350, 260, 360, 22);
		getContentPane().add(fileHandlingDesc2);

		staffDesc2.setText("functionalities like add, view, edit, and delete.");
		staffDesc2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		staffDesc2.setBounds(350, 115, 375, 22);
		getContentPane().add(staffDesc2);

		payrollDesc2.setText("functionalities like add, view, and edit. Payroll can be");
		payrollDesc2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		payrollDesc2.setBounds(350, 175, 400, 22);
		getContentPane().add(payrollDesc2);

		payrollDesc3.setText("generated in image form using print function in view.");
		payrollDesc3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		payrollDesc3.setBounds(350, 200, 400, 25);
		getContentPane().add(payrollDesc3);

		setVisible(true);
    }
}