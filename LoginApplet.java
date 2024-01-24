import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginApplet extends JApplet implements ActionListener{
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;

    private StaffApplet staff;
    // private PayrollApplet payroll;

    public void init(){
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        staff = new StaffApplet(cardLayout, cardPanel);
        // payroll = new PayrollApplet(cardLayout, cardPanel);

        loginPage();

        cardLayout.show(cardPanel, "login");
        add(cardPanel);

        loginButton.addActionListener(this);
    }

    public void loginPage(){
        JPanel login = new JPanel(new GridLayout(4, 1, 0, 2));
        
        Font f = new Font("TimesRoman", Font.BOLD, 30);
        Label title = new Label("Staff Payroll Management System");
        title.setFont(f);
        title.setAlignment(Label.CENTER);
        
        JPanel usr = new JPanel();
        usernameTextField = new JTextField(20);
        usr.add(new Label("Username :"));
        usr.add(usernameTextField);
        
        JPanel pwd = new JPanel();
        passwordTextField = new JPasswordField(20);
        pwd.add(new JLabel("Password :"));
        pwd.add(passwordTextField);
        
        loginButton = new JButton("Login");

        login.add(title, BorderLayout.CENTER);
        login.add(usr);
        login.add(pwd);
        login.add(loginButton);

        cardPanel.add(login, "login");
    }
    private boolean validateLogin(String username, char[] password){
        return username.equals("admin") && new String(password).equals("admin");
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton) {
            String usr = usernameTextField.getText();
            char[] pwd = passwordTextField.getPassword();

            if (validateLogin(usr, pwd)) {
                cardLayout.show(cardPanel, "home");
            } else {
                System.out.println("Invalid login credentials. Please try again.");
                // printed in terminal, not Applet ...
            }
        }
    }
}
