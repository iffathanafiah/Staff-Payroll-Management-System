import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PayrollApplet extends JApplet implements ActionListener{
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JPanel payslip;

    public PayrollApplet(CardLayout cardLayout, JPanel cardPanel){
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        generatePayslipPage();

        add(cardPanel);
    }

    public void generatePayslipPage(){
        payslip = new JPanel();
        payslip.setLayout(new BorderLayout());

        // Interface here

        cardPanel.add(payslip, "payslip");
    }
    
    public void actionPerformed(ActionEvent e){
        String choice = e.getActionCommand();
        switch (choice) {
            case "payslip":
                cardLayout.show(cardPanel, "PANEL NAME NAME NAME");
                break;
        }
    }
}