package src;
import src.Staff.*;
import src.Payroll.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainSystem extends JFrame implements ActionListener {
    private JLabel menu, title, title2, titleBg, colorBg;
	private JButton addStaff, viewStaff, editStaff, deleteStaff,
					addPayroll, viewPayroll, editPayroll, loadData, saveData;
	private JInternalFrame internalFrame;

	public MainSystem() {
		setResizable(false);
		setTitle("Staff Payroll Management System - Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
		setLayout(null);
		
		menu = new JLabel("MENU");
		menu.setOpaque(true);
		menu.setFont(menu.getFont().deriveFont(menu.getFont().getStyle() | Font.BOLD, menu.getFont().getSize() + 15f));
		menu.setBackground(new Color(0x0075af));
		menu.setForeground(Color.white);
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setBounds(0, 0, 175, 90);
		add(menu);
		
		title = new JLabel("STAFF PAYROLL MANAGEMENT SYSTEM");
		title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 24f));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.white);
		title.setBounds(175, 0, 825, 85);
		add(title);
		
		title2 = new JLabel("STAFF PAYROLL MANAGEMENT SYSTEM");
		title2.setFont(title2.getFont().deriveFont(title2.getFont().getStyle() | Font.BOLD, title2.getFont().getSize() + 24f));
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setBounds(186, 5, 810, 81);
		add(title2);
		
		titleBg = new JLabel();
		titleBg.setIcon(new ImageIcon("src/images/titleBackground.jpeg"));
		titleBg.setBounds(175, -5, 825, 95);
		add(titleBg);
		
		addStaff = new JButton("  Add Staff");
		addStaff.setBackground(new Color(0x00d1d1));
		addStaff.setFont(addStaff.getFont().deriveFont(addStaff.getFont().getStyle() | Font.BOLD, addStaff.getFont().getSize() + 5f));
		addStaff.setForeground(Color.white);
		addStaff.setBorderPainted(false);
		addStaff.setBorder(null);
		addStaff.setIcon(new ImageIcon("src/images/addStaff.png"));
		addStaff.setHorizontalAlignment(SwingConstants.LEFT);
		addStaff.setActionCommand("addStaff");
		addStaff.addActionListener(this);
		addStaff.setBounds(0, 90, 175, 58);
		add(addStaff);
		
		viewStaff = new JButton("  View Staff");
		viewStaff.setBackground(new Color(0x00d1d1));
		viewStaff.setFont(viewStaff.getFont().deriveFont(viewStaff.getFont().getStyle() | Font.BOLD, viewStaff.getFont().getSize() + 5f));
		viewStaff.setForeground(Color.white);
		viewStaff.setBorderPainted(false);
		viewStaff.setBorder(null);
		viewStaff.setIcon(new ImageIcon("src/images/viewStaff.png"));
		viewStaff.setHorizontalAlignment(SwingConstants.LEFT);
		viewStaff.setActionCommand("viewStaff");
		viewStaff.addActionListener(this);
		viewStaff.setBounds(0, 145, 175, 58);
		add(viewStaff);
		
		editStaff = new JButton("  Edit Staff");
		editStaff.setBackground(new Color(0x00d1d1));
		editStaff.setForeground(Color.white);
		editStaff.setFont(editStaff.getFont().deriveFont(editStaff.getFont().getStyle() | Font.BOLD, editStaff.getFont().getSize() + 5f));
		editStaff.setBorderPainted(false);
		editStaff.setBorder(null);
		editStaff.setIcon(new ImageIcon("src/images/editStaff.png"));
		editStaff.setHorizontalAlignment(SwingConstants.LEFT);
		editStaff.setActionCommand("editStaff");
		editStaff.addActionListener(this);
		editStaff.setBounds(0, 200, 175, 58);
		add(editStaff);
		
		deleteStaff = new JButton("  Delete Staff");
		deleteStaff.setBackground(new Color(0x00d1d1));
		deleteStaff.setForeground(Color.white);
		deleteStaff.setFont(deleteStaff.getFont().deriveFont(deleteStaff.getFont().getStyle() | Font.BOLD, deleteStaff.getFont().getSize() + 5f));
		deleteStaff.setBorderPainted(false);
		deleteStaff.setBorder(null);
		deleteStaff.setIcon(new ImageIcon("src/images/deleteStaff.png"));
		deleteStaff.setHorizontalAlignment(SwingConstants.LEFT);
		deleteStaff.setActionCommand("deleteStaff");
		deleteStaff.addActionListener(this);
		deleteStaff.setBounds(0, 255, 175, 58);
		add(deleteStaff);
		
		addPayroll = new JButton(" Add Payroll");
		addPayroll.setFont(addPayroll.getFont().deriveFont(addPayroll.getFont().getStyle() | Font.BOLD, addPayroll.getFont().getSize() + 5f));
		addPayroll.setForeground(Color.white);
		addPayroll.setBackground(new Color(0x00d1d1));
		addPayroll.setBorderPainted(false);
		addPayroll.setBorder(null);
		addPayroll.setHorizontalAlignment(SwingConstants.LEFT);
		addPayroll.setIcon(new ImageIcon("src/images/addPayroll.png"));
		addPayroll.setActionCommand("addPayroll");
		addPayroll.addActionListener(this);
		addPayroll.setBounds(0, 325, 175, 58);
		add(addPayroll);
		
		viewPayroll = new JButton(" View Payroll");
		viewPayroll.setFont(viewPayroll.getFont().deriveFont(viewPayroll.getFont().getStyle() | Font.BOLD, viewPayroll.getFont().getSize() + 5f));
		viewPayroll.setForeground(Color.white);
		viewPayroll.setBackground(new Color(0x00d1d1));
		viewPayroll.setBorderPainted(false);
		viewPayroll.setBorder(null);
		viewPayroll.setIcon(new ImageIcon("src/images/viewPayroll.png"));
		viewPayroll.setHorizontalAlignment(SwingConstants.LEFT);
		viewPayroll.setActionCommand("viewPayroll");
		viewPayroll.addActionListener(this);
		viewPayroll.setBounds(0, 380, 175, 58);
		add(viewPayroll);
		
		editPayroll = new JButton(" Edit Payroll");
		editPayroll.setFont(editPayroll.getFont().deriveFont(editPayroll.getFont().getStyle() | Font.BOLD, editPayroll.getFont().getSize() + 5f));
		editPayroll.setForeground(Color.white);
		editPayroll.setBackground(new Color(0x00d1d1));
		editPayroll.setBorderPainted(false);
		editPayroll.setBorder(null);
		editPayroll.setHorizontalAlignment(SwingConstants.LEFT);
		editPayroll.setIcon(new ImageIcon("src/images/editPayroll.png"));
		editPayroll.setActionCommand("editPayroll");
		editPayroll.addActionListener(this);
		editPayroll.setBounds(0, 435, 175, 58);
		add(editPayroll);
		
		loadData = new JButton("  Load Data");
		loadData.setBackground(new Color(0x00d1d1));
		loadData.setFont(loadData.getFont().deriveFont(loadData.getFont().getStyle() | Font.BOLD, loadData.getFont().getSize() + 5f));
		loadData.setForeground(Color.white);
		loadData.setBorderPainted(false);
		loadData.setBorder(null);
		loadData.setHorizontalAlignment(SwingConstants.LEFT);
		loadData.setIcon(new ImageIcon("src/images/loadData.png"));
		loadData.setActionCommand("loadData");
		loadData.addActionListener(this);
		loadData.setBounds(0, 505, 175, 58);
		add(loadData);
		
		saveData = new JButton("  Save Data");
		saveData.setBackground(new Color(0x00d1d1));
		saveData.setForeground(Color.white);
		saveData.setFont(saveData.getFont().deriveFont(saveData.getFont().getStyle() | Font.BOLD, saveData.getFont().getSize() + 5f));
		saveData.setBorderPainted(false);
		saveData.setBorder(null);
		saveData.setHorizontalAlignment(SwingConstants.LEFT);
		saveData.setIcon(new ImageIcon("src/images/saveData.png"));
		saveData.setActionCommand("saveData");
		saveData.addActionListener(this);
		saveData.setBounds(0, 560, 175, 58);
		add(saveData);
		
		colorBg = new JLabel();
		colorBg.setOpaque(true);
		colorBg.setFont(colorBg.getFont().deriveFont(colorBg.getFont().getStyle() | Font.BOLD, colorBg.getFont().getSize() + 15f));
		colorBg.setBackground(new Color(0x99ffff));
		colorBg.setForeground(Color.magenta);
		colorBg.setHorizontalAlignment(SwingConstants.CENTER);
		colorBg.setBounds(0, 90, 175, 530);
		add(colorBg);
		
		setVisible(true);
		
		if(Staff.loadStaffData() && Payroll.loadPayrollData()){}
		else{
			JOptionPane.showMessageDialog(null, "ERROR! Bad file reading", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
    }

    public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();

		if (command != "loadData" && command != "saveData" && internalFrame != null) {
			internalFrame.getContentPane().removeAll();
			internalFrame.dispose();
        }

        switch (command) {
            case "addStaff":
				internalFrame = new StaffAdd();
                break;
            case "viewStaff":
				internalFrame = new StaffView();
                break;
			case "editStaff":
				internalFrame = new StaffEdit();
                break;
            case "deleteStaff":
				internalFrame = new StaffDelete();
                break;
                
			case "addPayroll":
				internalFrame = new PayrollAdd();
                break;
			case "viewPayroll":
                internalFrame = new PayrollView();
                break;
			case "editPayroll":	
				internalFrame = new PayrollEdit();
                break;

            case "loadData":
				if(Staff.loadStaffData() && Payroll.loadPayrollData()){
					JOptionPane.showMessageDialog(null, "Data loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "ERROR! Bad file reading", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
                break;
			case "saveData":
				if(Staff.saveStaffData() && Payroll.savePayrollData()){
					JOptionPane.showMessageDialog(null, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "ERROR! Bad file writing", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
                break;
        }

		if(command != "loadData" && command != "saveData"){
			internalFrame.setSize(825, 535);
			internalFrame.setLocation(175, 85);
			getContentPane().setLayout(null);
			getContentPane().add(internalFrame);
			
			internalFrame.setBounds(175, 85, 825, 535);
			internalFrame.setVisible(true);
		}
    }
}