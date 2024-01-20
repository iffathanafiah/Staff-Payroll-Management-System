import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class StaffApplet extends Applet implements ActionListener {
    private CardLayout cardLayout = new CardLayout();
    private Panel cardPanel = new Panel();

    private Panel home, addStaff, viewStaff, editStaff, removeStaff;

    public StaffApplet(CardLayout cardLayout, Panel cardPanel){
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        homePage(cardPanel);
        addStaffPage(cardPanel);
        viewStaffPage(cardPanel);
        editStaffPage(cardPanel);
        removeStaffPage(cardPanel);

        add(cardPanel);
    }

    public Panel header(){
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

        Panel headerPanel = new Panel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(Color.cyan);
        headerPanel.add(h, BorderLayout.NORTH);

        return headerPanel;
    }
    public void homePage(Panel cardPanel){
        home = new Panel();
        home.setLayout(new BorderLayout());

        home.add(header(), BorderLayout.NORTH);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Home Page Content"));
        home.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(home, "home");
    }
    public void addStaffPage(Panel cardPanel){
        addStaff = new Panel();
        addStaff.setLayout(new BorderLayout());

        addStaff.add(header(), BorderLayout.NORTH);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Add New Staff Page Content"));
        addStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(addStaff, "addStaff");
    }
    public void viewStaffPage(Panel cardPanel){
        viewStaff = new Panel();
        viewStaff.setLayout(new BorderLayout());

        viewStaff.add(header(), BorderLayout.NORTH);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("View Staff Info Page Content"));
        viewStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(viewStaff, "viewStaff");
    }
    public void editStaffPage(Panel cardPanel){
        editStaff = new Panel();
        editStaff.setLayout(new BorderLayout());

        editStaff.add(header(), BorderLayout.NORTH);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Edit Staff Info Page Content"));
        editStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(editStaff, "editStaff");
    }
    public void removeStaffPage(Panel cardPanel){
        removeStaff = new Panel();
        removeStaff.setLayout(new BorderLayout());

        removeStaff.add(header(), BorderLayout.NORTH);

        Panel contentPanel = new Panel();
        contentPanel.add(new Label("Remove Staff Data Page Content"));
        removeStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(removeStaff, "removeStaff");
    }
    
    public void actionPerformed(ActionEvent e){
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
