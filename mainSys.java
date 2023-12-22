import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.applet.*;

public class mainSys extends Applet {
    // List<Staff> staffList = new ArrayList<>();
    private Label title;
    private Button addButton;

    public void init() {
        Font f = new Font("Times New Roman", Font.BOLD, 36);
        title = new Label("Staff Payroll Management System");
        title.setFont(f);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

    }
}