package src.Payroll;
import src.Staff.*;

import java.util.Date;
import java.util.ArrayList;

public class Payroll{
    private static ArrayList<Payroll> payrollList = new ArrayList<>(); 

    private String payrollID;
    private Date payrollDate;
    private double totalGrossSalary, totalTaxes, totalNetSalary, EPF, SOCSO, allowancePay, overtimePay, basicSalary;

    public Payroll() {}

    public String getPayrollID()            {return this.payrollID;}
    public double getTotalGrossSalary()     {return this.totalGrossSalary;}
    public double getTotalTaxes()           {return this.totalTaxes;}
    public double getTotalNetSalary()       {return this.totalNetSalary;}
    public double getBasicSalary()          {return this.basicSalary;}
    public double getAllowancePay()         {return this.allowancePay;}
    public double getOvertimePay()          {return this.overtimePay;}
    public double getEPF()                  {return this.EPF;}
    public double getSOCSO()                {return this.SOCSO;}

    public static boolean addPayroll(String staffID, double allowance, double overtimePay, double EPF, double SOCSO){
        Staff staff = new Staff();
        if (Staff.validateStaff(staffID)) {
            Payroll newSlip = new Payroll();
            /*newSlip.payrollDate = GETDATEINFORMAT--MONTH-YEAR*/;
            newSlip.payrollID = staffID /* + GETDATEINFORMAT--MONTH-YEAR*/;
            newSlip.basicSalary = staff.getBasicSalary(staffID);
            newSlip.allowancePay = allowance;
            newSlip.overtimePay = overtimePay;
            newSlip.totalGrossSalary = newSlip.basicSalary + allowance + overtimePay;
            newSlip.EPF = EPF;
            newSlip.SOCSO = SOCSO;
            newSlip.totalTaxes = EPF + SOCSO;
            newSlip.totalNetSalary = newSlip.totalGrossSalary - newSlip.totalTaxes;
            
            payrollList.add(newSlip);
            
            return true;
        }
        else{
            // lmao takde data bruh
        }
        return false;
    }

    public static boolean viewPayroll(String payrollID){
        for(Payroll payroll : payrollList){
            if (payroll.getPayrollID().equals(payrollID)) {
                StringBuilder payrollInfo = new StringBuilder();
                payrollInfo.append("Payroll ID      : ").append(payroll.getPayrollID()).append("\n\n");
                payrollInfo.append("Basic Salary    : ").append(payroll.getBasicSalary()).append("\n");
                payrollInfo.append("Allowances      : ").append(payroll.getAllowancePay()).append("\n");
                payrollInfo.append("Overtime Pay    : ").append(payroll.getOvertimePay()).append("\n");
                payrollInfo.append("Gross Salary    : ").append(payroll.getTotalGrossSalary()).append("\n\n");
                payrollInfo.append("EPF             : ").append(payroll.getEPF()).append("\n");
                payrollInfo.append("SOCSO           : ").append(payroll.getSOCSO()).append("\n");
                payrollInfo.append("Total Deduction : ").append(payroll.getTotalTaxes()).append("\n\n");
                payrollInfo.append("Net Salary      : ").append(payroll.getTotalNetSalary()).append("\n");

                return true;
            }
        }
        return false;
    }
    
    public void generatePayslip(String payrollID, Date payrollDate, double totalGrossSalary, double totalTaxes, 
                                double totalNetSalary, double epf, double socso, double allowancePay, double overtimePay, double basicSalary)
    {
        this.basicSalary = basicSalary;
        this.totalGrossSalary = totalGrossSalary;
        this.totalTaxes = totalTaxes;
        this.totalNetSalary = totalNetSalary;
        this.EPF = epf;
        this.SOCSO = socso;
        this.allowancePay = allowancePay;
        this.overtimePay = overtimePay;

        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Allowance Pay : " + allowancePay);
        System.out.println("Overtime Pay : " + overtimePay);
        System.out.println("Gross Salary : " + totalGrossSalary);
        System.out.println("EPF : " + epf);
        System.out.println("SOCSO : " + socso);
        System.out.println("Total Taxes : " + totalTaxes);
        System.out.println("Net Salary : " + totalNetSalary);
    }
}