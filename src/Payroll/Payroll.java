package src.Payroll;
import src.Staff.*;

import java.util.ArrayList;

public class Payroll{
    private static ArrayList<Payroll> payrollList = new ArrayList<>(); 

    private String payrollID, monthName;
    private int year;
    private double totalGrossSalary, totalTaxes, totalNetSalary, EPF, SOCSO, allowancePay, overtimePay, basicSalary;

    public Payroll() {}

    public String getPayrollID()            {return this.payrollID;}
    public String getMonthName()            {return this.monthName;}
    public int getYear()                    {return this.year;}
    public double getTotalGrossSalary()     {return this.totalGrossSalary;}
    public double getTotalTaxes()           {return this.totalTaxes;}
    public double getTotalNetSalary()       {return this.totalNetSalary;}
    public double getBasicSalary()          {return this.basicSalary;}
    public double getAllowancePay()         {return this.allowancePay;}
    public double getOvertimePay()          {return this.overtimePay;}
    public double getEPF()                  {return this.EPF;}
    public double getSOCSO()                {return this.SOCSO;}

    public static String getMonthNumber(String monthName) {
		switch (monthName) {
			case "January":		return "01";
			case "February":	return "02";
			case "March":		return "03";
			case "April":		return "04";
			case "May":			return "05";
			case "June":		return "06";
			case "July":		return "07";
			case "August":		return "08";
			case "September":	return "09";
			case "October":		return "10";
			case "November":	return "11";
			case "December":	return "12";
			default:			return "";
		}
	}

    public static boolean validatePayroll(String staffID, int year, String month){
        String payrollID = staffID + "_" + year + "-" + getMonthNumber(month);
        for(Payroll payroll : payrollList){
            if(payroll.getPayrollID().equals(payrollID)){
                return true;
            }
        }
        return false;
    }
    public static Payroll retrievePayrollData(String payrollID){
        for(Payroll payroll : payrollList){
            if(payroll.getPayrollID().equals(payrollID)){
                return payroll;
            }
        }
        return null;
    }

    public static String addPayroll(Staff staff, String month, int year, double allowance, double overtimePay, double EPF, double SOCSO){
        Payroll newSlip = new Payroll();
        newSlip.payrollID = staff.getID() + "_" + year + "-" + getMonthNumber(month);
        newSlip.monthName = month;
        newSlip.year = year;
        newSlip.basicSalary = staff.getBasicSalary();
        newSlip.allowancePay = allowance;
        newSlip.overtimePay = overtimePay;
        newSlip.totalGrossSalary = newSlip.basicSalary + allowance + overtimePay;
        newSlip.EPF = EPF;
        newSlip.SOCSO = SOCSO;
        newSlip.totalTaxes = EPF + SOCSO;
        newSlip.totalNetSalary = newSlip.totalGrossSalary - newSlip.totalTaxes;
        
        payrollList.add(newSlip);
        return newSlip.payrollID;
    }

    public static void editPayroll(String payrollID, double allowance, double overtimePay, double EPF, double SOCSO){
        for (Payroll payroll : payrollList){
            if(payroll.getPayrollID().equals(payrollID)){
                payroll.allowancePay = allowance;
                payroll.overtimePay = overtimePay;
                payroll.totalGrossSalary = payroll.basicSalary + allowance + overtimePay;
                payroll.EPF = EPF;
                payroll.SOCSO = SOCSO;
                payroll.totalTaxes = EPF + SOCSO;
                payroll.totalNetSalary = payroll.totalGrossSalary - payroll.totalTaxes;
                return;
            }
        }
    }

    public static void loadPayrollData(){

    }
    public static void savePayrollData(){

    }
}