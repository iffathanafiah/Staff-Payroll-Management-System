package src;
import src.Staff.*;
import src.Payroll.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainSystem extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private StaffAdd addStaffPage;
    private StaffView viewStaffPage;
    private StaffEdit editStaffPage;
    private StaffDelete deleteStaffPage;
    private PayrollAdd addPayrollPage;
    
    public MainSystem(){
        setTitle("Staff Payroll Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        
        Staff.loadStaffData();
        homePage();
        addStaffPage = new StaffAdd();
        viewStaffPage = new StaffView();
        editStaffPage = new StaffEdit();
        deleteStaffPage = new StaffDelete();
        addPayrollPage = new PayrollAdd();

        add(cardPanel);
        add(navPanel(), BorderLayout.NORTH);
        setVisible(true);
    }

    private void homePage() {
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Home Interface Content"));

        cardPanel.add(homePanel, "home");
    }

    private JButton navButton(String buttonText, String command) {
        JButton button = new JButton(buttonText);
        button.setActionCommand(command);
        button.addActionListener(this);
        return button;
    }

    private JPanel navPanel() {
        JPanel navBar = new JPanel(new GridLayout(3, 1, 10, 10));
        JPanel navBar1 = new JPanel(new FlowLayout());
        JPanel navBar2 = new JPanel(new FlowLayout());
        JPanel navBar3 = new JPanel(new FlowLayout());

        navBar1.add(navButton("Add Staff", "addStaff"));
        navBar1.add(navButton("View Staff", "viewStaff"));
        navBar1.add(navButton("Edit Staff", "editStaff"));
        navBar1.add(navButton("Delete Staff", "deleteStaff"));
        navBar2.add(navButton("Add Payroll", "addPayroll"));
        navBar2.add(navButton("Test2", "test2"));
        navBar3.add(navButton("Load Data", "loadData"));
        navBar3.add(navButton("Save Data", "saveData"));

        navBar.add(navBar1);
        navBar.add(navBar2);
        navBar.add(navBar3);

        return navBar;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "addStaff":
                SwingUtilities.invokeLater(() -> new StaffAdd().setVisible(true));
                break;
            case "viewStaff":
                SwingUtilities.invokeLater(() -> new StaffView().setVisible(true));
                break;
            case "editStaff":
                SwingUtilities.invokeLater(() -> new StaffEdit().setVisible(true));
                break;
            case "deleteStaff":
                SwingUtilities.invokeLater(() -> new StaffDelete().setVisible(true));
                break;
                
            case "addPayroll":
                SwingUtilities.invokeLater(() -> new PayrollAdd().setVisible(true));
                break;
            case "test2":
                cardLayout.show(cardPanel, command);
                break;

            case "loadData":
                Staff.loadStaffData();
                JOptionPane.showMessageDialog(null, "Data loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "saveData":
                Staff.saveStaffData();
                JOptionPane.showMessageDialog(null, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainSystem());
    }
}
