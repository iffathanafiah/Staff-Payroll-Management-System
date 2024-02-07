package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener{
	private JLabel title1, title2, title3, title4, title5, title6;
	private JButton loginButton;
	private JPanel loginPanel;
	private JLabel usernameLabel, passwordLabel, backgroundImg;
	private JPasswordField passwordField;
	private JTextField usernameField;

	public Login() {
		title1 = new JLabel();
		title2 = new JLabel();
		title3 = new JLabel();
		title4 = new JLabel();
		title5 = new JLabel();
		title6 = new JLabel();
		loginButton = new JButton();
		usernameField = new JTextField();
		usernameLabel = new JLabel();
		passwordLabel = new JLabel();
		passwordField = new JPasswordField();
		loginPanel = new JPanel();
		backgroundImg = new JLabel();

		//======== this ========
		setResizable(false);
		setTitle("Login to System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
		setIconImage(null);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- title1 ----
		title1.setText("  STAFF PAYROLL");
		title1.setFont(new Font("Segoe UI", Font.BOLD, 38));
		title1.setForeground(Color.white);
		contentPane.add(title1);
		title1.setBounds(0, 20, 385, 50);

		//---- title2 ----
		title2.setText("  MANAGEMENT");
		title2.setFont(new Font("Segoe UI", Font.BOLD, 38));
		title2.setForeground(Color.white);
		contentPane.add(title2);
		title2.setBounds(0, 70, 320, 40);

		//---- title3 ----
		title3.setText("  SYSTEM");
		title3.setFont(new Font("Segoe UI", Font.BOLD, 38));
		title3.setForeground(Color.white);
		contentPane.add(title3);
		title3.setBounds(0, 115, 320, 40);

		//---- title4 ----
		title4.setText("STAFF PAYROLL");
		title4.setFont(new Font("Segoe UI", Font.BOLD, 38));
		title4.setForeground(new Color(0x333333));
		contentPane.add(title4);
		title4.setBounds(23, 0, 330, 95);

		//---- title5 ----
		title5.setText("MANAGEMENT");
		title5.setFont(new Font("Segoe UI", Font.BOLD, 38));
		title5.setForeground(new Color(0x333333));
		contentPane.add(title5);
		title5.setBounds(23, 67, 290, 50);

		//---- title6 ----
		title6.setText("SYSTEM");
		title6.setFont(new Font("Segoe UI", Font.BOLD, 38));
		title6.setForeground(new Color(0x333333));
		contentPane.add(title6);
		title6.setBounds(23, 115, 175, 45);

		//---- loginButton ----
		loginButton.setText("LOGIN");
		loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		loginButton.addActionListener(this);
		contentPane.add(loginButton);
		loginButton.setBounds(850, 550, 100, 25);

		//---- passwordLabel ----
		passwordLabel.setText("Password");
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		passwordLabel.setForeground(Color.white);
		contentPane.add(passwordLabel);
		passwordLabel.setBounds(695, 495, 100, 25);
		contentPane.add(passwordField);
		passwordField.setBounds(810, 500, 140, passwordField.getPreferredSize().height);

		//======== loginPanel ========
		{
			loginPanel.setBackground(new Color(0x999999));
			loginPanel.setBorder(new CompoundBorder(
					new SoftBevelBorder(SoftBevelBorder.LOWERED),
					new TitledBorder(
							new EmptyBorder(0, 0, 0, 0),
							"",
							TitledBorder.CENTER,
							TitledBorder.BOTTOM,
							new Font("", Font.BOLD, 12),
							Color.RED
					)
			));

			//---- usernameLabel ----
			usernameLabel.setText("Username");
			usernameLabel.setForeground(Color.white);
			usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

			GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
			loginPanel.setLayout(loginPanelLayout);
			loginPanelLayout.setHorizontalGroup(
				loginPanelLayout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
						.addContainerGap(16, Short.MAX_VALUE)
						.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25))
			);
			loginPanelLayout.setVerticalGroup(
				loginPanelLayout.createParallelGroup()
					.addGroup(loginPanelLayout.createSequentialGroup()
						.addGap(25, 25, 25)
						.addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addComponent(usernameField)
							.addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap(119, Short.MAX_VALUE))
			);
		}
		contentPane.add(loginPanel);
		loginPanel.setBounds(675, 435, 300, 170);

		//---- backgroundImg ----
		backgroundImg.setBackground(new Color(0xccccff));
		backgroundImg.setIcon(new ImageIcon("src/images/loginBackground.png"));
		contentPane.add(backgroundImg);
		backgroundImg.setBounds(0, 0, 995, 620);

		{
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	private boolean validateLogin(String username, char[] password) {
        return username.equals("admin") && new String(password).equals("admin");
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton){
            String usr = usernameField.getText();
            char[] pwd = passwordField.getPassword();

            if(validateLogin(usr, pwd)){
                dispose();
                SwingUtilities.invokeLater(() -> new MainSystem());
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid login credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
	}

	public static void main(String[] args){
        SwingUtilities.invokeLater(Login::new);
    }
}
