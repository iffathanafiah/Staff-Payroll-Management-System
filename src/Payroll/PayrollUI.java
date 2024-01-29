package src.Payroll;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PayrollUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JPanel payslip;

    public PayrollUI() {
    }

    public void generatePayslipPage() {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Payroll App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel();
            cardPanel.setLayout(cardLayout);

            PayrollUI payrollApp = new PayrollUI();
            cardLayout.show(cardPanel, "payslip");

            frame.add(cardPanel);
            frame.setVisible(true);
        });
    }
}
