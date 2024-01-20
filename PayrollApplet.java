import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class PayrollApplet extends Applet implements ActionListener{
    private CardLayout cardLayout;
    private Panel cardPanel;

    private Panel payslip;

    public PayrollApplet(CardLayout cardLayout, Panel cardPanel){
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        generatePayslipPage();

        add(cardPanel);
    }

    public void generatePayslipPage(){
        payslip = new Panel();
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