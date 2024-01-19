import java.awt.*;
import java.awt.event.*;

import javafx.scene.layout.Border;

import java.applet.*;

public class mainSys extends Applet implements ActionListener {
    private CardLayout cardLayout;
    private Panel cardPanel;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private Button loginButton;

    private Panel home;
    private Panel addStaff;
    private Panel viewStaff;
    private Panel editStaff;
    private Panel removeStaff;

    public void init() {
        cardLayout = new CardLayout();
        cardPanel = new Panel();
        cardPanel.setLayout(cardLayout);

        loginPage();
        homePage();
        addStaffPage();
        viewStaffPage();
        editStaffPage();
        removeStaffPage();

        cardLayout.show(cardPanel, "login");
        add(cardPanel);

        loginButton.addActionListener(this);
    }

    private void loginPage() {
        Panel login = new Panel();
        usernameTextField = new TextField(20);
        passwordTextField = new TextField(20);
        passwordTextField.setEchoChar('*');
        loginButton = new Button("Login");

        login.add(new Label("Username:"));
        login.add(usernameTextField);
        login.add(new Label("Password:"));
        login.add(passwordTextField);
        login.add(loginButton);

        cardPanel.add(login, "login");
    }
    private boolean validateLogin(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

    private void header(Panel panel) {
        Font f = new Font("TimesRoman", Font.BOLD, 30);
        Label title = new Label("Staff Payroll Management System");
        title.setFont(f);
        title.setAlignment(Label.CENTER);
        
        Panel navBar = new Panel();
        navBar.setLayout(new FlowLayout());
        
        Button homeButton = new Button("Home");
        Button addStaffButton = new Button("Add New Staff");
        Button viewStaffButton = new Button("View Staff Info");
        Button editStaffButton = new Button("Edit Staff Info");
        Button removeStaffButton = new Button("Remove Staff Data");

        homeButton.addActionListener(this);
        addStaffButton.addActionListener(this);
        viewStaffButton.addActionListener(this);
        editStaffButton.addActionListener(this);
        removeStaffButton.addActionListener(this);

        navBar.add(homeButton);
        navBar.add(addStaffButton);
        navBar.add(viewStaffButton);
        navBar.add(editStaffButton);
        navBar.add(removeStaffButton);

        Panel h = new Panel();
        h.setLayout(new BorderLayout());
        h.add(title, BorderLayout.NORTH);
        h.add(navBar, BorderLayout.SOUTH);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.cyan);
        panel.add(h, BorderLayout.NORTH);
    }

    private void homePage() {
        home = new Panel();
        home.setLayout(new BorderLayout());

        header(home);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Home Page Content"));
        home.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(home, "home");
    }

    private void addStaffPage() {
        addStaff = new Panel();
        addStaff.setLayout(new BorderLayout());

        header(addStaff);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Add New Staff Page Content"));
        addStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(addStaff, "addStaff");
    }

    private void viewStaffPage() {
        viewStaff = new Panel();
        viewStaff.setLayout(new BorderLayout());

        header(viewStaff);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("View Staff Info Page Content"));
        viewStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(viewStaff, "viewStaff");
    }

    private void editStaffPage() {
        editStaff = new Panel();
        editStaff.setLayout(new BorderLayout());

        header(editStaff);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Edit Staff Info Page Content"));
        editStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(editStaff, "editStaff");
    }

    private void removeStaffPage() {
        removeStaff = new Panel();
        removeStaff.setLayout(new BorderLayout());

        header(removeStaff);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Remove Staff Data Page Content"));
        removeStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(removeStaff, "removeStaff");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String usr = usernameTextField.getText();
            String pwd = passwordTextField.getText();

            if (validateLogin(usr, pwd)) {
                cardLayout.show(cardPanel, "home");
            } else {
                System.out.println("Invalid login credentials. Please try again.");
            }
        }
        else{
            String choice = e.getActionCommand();
            switch (choice) {
                case "Home":
                    cardLayout.show(cardPanel, "home");
                    break;
                case "Add New Staff":
                    cardLayout.show(cardPanel, "addStaff");
                    break;
                case "View Staff Info":
                    cardLayout.show(cardPanel, "viewStaff");
                    break;
                case "Edit Staff Info":
                    cardLayout.show(cardPanel, "editStaff");
                    break;
                case "Remove Staff Data":
                    cardLayout.show(cardPanel, "removeStaff");
                    break;
            }
        }
    }
}
