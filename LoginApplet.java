import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class LoginApplet extends Applet implements ActionListener{
    private CardLayout cardLayout;
    private Panel cardPanel;

    private TextField usernameTextField, passwordTextField;
    private Button loginButton;
    private Label title;

    private StaffApplet staff;
    // private PayrollApplet payroll;

    public void init(){
        cardLayout = new CardLayout();
        cardPanel = new Panel();
        cardPanel.setLayout(cardLayout);

        staff = new StaffApplet(cardLayout, cardPanel);
        // payroll = new PayrollApplet(cardLayout, cardPanel);

        loginPage();

        cardLayout.show(cardPanel, "login");
        add(cardPanel);

        loginButton.addActionListener(this);
    }

    public void loginPage(){
        Panel login = new Panel(new GridLayout(4, 1, 0, 2));
        
        Font f = new Font("TimesRoman", Font.BOLD, 30);
        Label title = new Label("Staff Payroll Management System");
        title.setFont(f);
        title.setAlignment(Label.CENTER);
        
        Panel usr = new Panel();
        usernameTextField = new TextField(20);
        usr.add(new Label("Username:"));
        usr.add(usernameTextField);
        
        Panel pwd = new Panel();
        passwordTextField = new TextField(20);
        passwordTextField.setEchoChar('*');
        pwd.add(new Label("Password:"));
        pwd.add(passwordTextField);
        
        loginButton = new Button("Login");

        login.add(title, BorderLayout.CENTER);
        login.add(usr);
        login.add(pwd);
        login.add(loginButton);

        cardPanel.add(login, "login");
    }
    private boolean validateLogin(String username, String password){
        return username.equals("admin") && password.equals("admin");
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton) {
            String usr = usernameTextField.getText();
            String pwd = passwordTextField.getText();

            if (validateLogin(usr, pwd)) {
                cardLayout.show(cardPanel, "home");
            } else {
                System.out.println("Invalid login credentials. Please try again.");
                // printed in terminal, not Applet ...
            }
        }
    }
}
