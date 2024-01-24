import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class StaffApplet extends JApplet implements ActionListener {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel();

    private ArrayList<Staff> staff = new ArrayList<>();
    private JPanel home, addStaff, viewStaff, editStaff, removeStaff;

    private JTextField ID, fname, lname, email, phoneNum, address, department, position;
    private JRadioButton gender1, gender2;
    private ButtonGroup gender;

    public StaffApplet(CardLayout cardLayout, JPanel cardPanel){
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        homePage(cardPanel);
        addStaffPage(cardPanel);
        viewStaffPage(cardPanel);
        editStaffPage(cardPanel);
        removeStaffPage(cardPanel);

        add(cardPanel);
    }

    public void resetInput(){
        fname.setText("");
        lname.setText("");
        gender.clearSelection();
        email.setText("");
        phoneNum.setText("");
        address.setText("");
        department.setText("");
        position.setText("");
    }

    public JPanel header(){
        Font f = new Font("TimesRoman", Font.BOLD, 30);
        JLabel title = new JLabel("Staff Payroll Management System");
        title.setFont(f);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout());
        
        JButton homeButton = new JButton("Home");
        JButton addStaffButton = new JButton("Add New Staff");
        JButton viewStaffButton = new JButton("View Staff Info");
        JButton editStaffButton = new JButton("Edit Staff Info");
        JButton removeStaffButton = new JButton("Remove Staff Data");

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

        JPanel h = new JPanel();
        h.setLayout(new BorderLayout());
        h.add(title, BorderLayout.NORTH);
        h.add(navBar, BorderLayout.SOUTH);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(Color.cyan);
        headerPanel.add(h, BorderLayout.NORTH);

        return headerPanel;
    }
    public void homePage(JPanel cardPanel){
        home = new JPanel();
        home.setLayout(new BorderLayout());

        home.add(header(), BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Home Page Content"));
        home.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(home, "home");
    }
    public void addStaffPage(JPanel cardPanel){
        addStaff = new JPanel();
        addStaff.setLayout(new BorderLayout());
        addStaff.add(header(), BorderLayout.NORTH);
        
        JPanel fnameElem = new JPanel();
        fname = new JTextField(10);
        fnameElem.add(new JLabel("First Name    "));
        fnameElem.add(fname);
        JPanel lnameElem = new JPanel();
        lname = new JTextField(10);
        lnameElem.add(new JLabel("Last Name     "));
        lnameElem.add(lname);
        JPanel genderElem = new JPanel();
        gender1 = new JRadioButton("Male");
        gender2 = new JRadioButton("Female");
        gender = new ButtonGroup();
        gender.add(gender1);
        gender.add(gender2);
        genderElem.add(new JLabel("Gender        "));
        genderElem.add(gender1);
        genderElem.add(gender2);
        JPanel emailElem = new JPanel();
        email = new JTextField(10);
        emailElem.add(new JLabel("Email Address "));
        emailElem.add(email);
        JPanel phoneNumElem = new JPanel();
        phoneNum = new JTextField(10);
        phoneNumElem.add(new JLabel("Phone Number  "));
        phoneNumElem.add(phoneNum);
        JPanel addressElem = new JPanel();
        address = new JTextField(10);
        addressElem.add(new JLabel("Home Address  "));
        addressElem.add(address);
        JPanel departmentElem = new JPanel();
        department = new JTextField(10);
        departmentElem.add(new JLabel("Department    "));
        departmentElem.add(department);
        JPanel positionElem = new JPanel();
        position = new JTextField(10);
        positionElem.add(new JLabel("Position      "));
        positionElem.add(position);
        
        JButton addData = new JButton("KICK IN");
        addData.addActionListener(this);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(10, 0, 10, 10));
        contentPanel.add(new JLabel("Add New Staff Page Content"));
        contentPanel.add(fnameElem);
        contentPanel.add(lnameElem);
        contentPanel.add(genderElem);
        contentPanel.add(emailElem);
        contentPanel.add(phoneNumElem);
        contentPanel.add(addressElem);
        contentPanel.add(departmentElem);
        contentPanel.add(positionElem);
        contentPanel.add(addData);

        addStaff.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(addStaff, "addStaff");
    }
    public void viewStaffPage(JPanel cardPanel){
        viewStaff = new JPanel();
        viewStaff.setLayout(new BorderLayout());
        viewStaff.add(header(), BorderLayout.NORTH);

        JButton viewData = new JButton("VIEW ALL");
        viewData.addActionListener(this);

        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("View Staff Info Page Content"));
        contentPanel.add(viewData);
        
        viewStaff.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(viewStaff, "viewStaff");
    }
    public void editStaffPage(JPanel cardPanel){
        editStaff = new JPanel();
        editStaff.setLayout(new BorderLayout());

        editStaff.add(header(), BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Edit Staff Info Page Content"));
        editStaff.add(contentPanel, BorderLayout.CENTER);

        cardPanel.add(editStaff, "editStaff");
    }
    public void removeStaffPage(JPanel cardPanel){
        removeStaff = new JPanel();
        removeStaff.setLayout(new BorderLayout());
        removeStaff.add(header(), BorderLayout.NORTH);

        JPanel IDElem = new JPanel();
        ID = new JTextField(4);
        IDElem.add(new JLabel("Staff ID :"));
        IDElem.add(ID);

        JButton removeData = new JButton("FIRE STAFF");
        removeData.addActionListener(this);

        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Remove Staff Data Page Content"));
        contentPanel.add(IDElem);
        contentPanel.add(removeData);
        
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

            case "KICK IN":
                String staffFname = fname.getText();
                String staffLname = lname.getText();
                String staffGender = "";
                if(gender1.isSelected()){ staffGender = "Male";}
                else if(gender2.isSelected()){staffGender = "Female";}
                String staffEmail = email.getText();
                String staffPhoneNum = phoneNum.getText();
                String staffAddress = address.getText();
                String staffDepartment = department.getText();
                String staffPosition = position.getText();
                Staff newStaff = new Staff();
                newStaff.hireStaff(staffFname, staffLname, staffGender, staffEmail, staffPhoneNum,
                                   staffAddress, staffDepartment, staffPosition);
                staff.add(newStaff);
                break;
            case "VIEW ALL":
                Staff.viewStaff(staff);
                break;
            case "FIRE STAFF":
                String id = ID.getText();
                Staff.fireStaff(staff, id);
                break;
        }
        resetInput();
    }
}