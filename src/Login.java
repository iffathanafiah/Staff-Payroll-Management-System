package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.Staff.*;

public class Login extends JFrame implements ActionListener {
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;

    public Login() {
        setTitle("Login to Main System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        JPanel loginPanel = createLoginPanel();
        add(loginPanel);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 1, 0, 2));

        Font f = new Font("TimesRoman", Font.BOLD, 24);
        JLabel title = new JLabel("Staff Payroll Management System");
        title.setFont(f);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel usr = new JPanel();
        usernameTextField = new JTextField(20);
        usr.add(new JLabel("Username :"));
        usr.add(usernameTextField);

        JPanel pwd = new JPanel();
        passwordTextField = new JPasswordField(20);
        pwd.add(new JLabel("Password :"));
        pwd.add(passwordTextField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        loginPanel.add(title, BorderLayout.CENTER);
        loginPanel.add(usr);
        loginPanel.add(pwd);
        loginPanel.add(loginButton);

        return loginPanel;
    }

    private boolean validateLogin(String username, char[] password) {
        return username.equals("admin") && new String(password).equals("admin");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){
            String usr = usernameTextField.getText();
            char[] pwd = passwordTextField.getPassword();

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