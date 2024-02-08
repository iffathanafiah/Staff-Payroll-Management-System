package src.Payroll;
import src.Staff.Staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Payroll{
    private static ArrayList<Payroll> payrollList = new ArrayList<>(); 

    private String payrollID, monthName;
    private int year;
    private double totalGrossSalary, totalTaxes, totalNetSalary, EPF, SOCSO, allowancePay, overtimePay, basicSalary;

    public Payroll() {}
    public Payroll(String payrollID, String monthName, int year, double basicSalary, double allowancePay, double overtimePay,
                   double totalGrossSalary, double EPF, double SOCSO, double totalTaxes, double totalNetSalary)
    {
        this.payrollID = payrollID;
        this.monthName = monthName;
        this.year = year;
        this.basicSalary = basicSalary;
        this.allowancePay = allowancePay;
        this.overtimePay = overtimePay;
        this.totalGrossSalary = totalGrossSalary;
        this.EPF = EPF;
        this.SOCSO = SOCSO;
        this.totalTaxes = totalTaxes;
        this.totalNetSalary = totalNetSalary;
    }

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

    public static boolean loadPayrollData(){
        payrollList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Payroll/payrollData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] payrollData = line.split(Pattern.quote("|"));
                if (payrollData.length == 11) {
                    Payroll payroll = new Payroll(
                            payrollData[0].trim(),
                            payrollData[1].trim(),
                            Integer.parseInt(payrollData[2].trim()),
                            Double.parseDouble(payrollData[3].trim()),
                            Double.parseDouble(payrollData[4].trim()),
                            Double.parseDouble(payrollData[5].trim()),
                            Double.parseDouble(payrollData[6].trim()),
                            Double.parseDouble(payrollData[7].trim()),
                            Double.parseDouble(payrollData[8].trim()),
                            Double.parseDouble(payrollData[9].trim()),
                            Double.parseDouble(payrollData[10].trim()));
    
                    payrollList.add(payroll);
                }
                else {
                    System.err.println("Invalid data in the file: " + line);
                    return false;
                }
            }
            return true;
        } 
        catch (IOException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
            return false;
        }
    }

    public static boolean savePayrollData(){
        String delimiter = "|", filename = "src/Payroll/payrollData.txt";

        try (FileWriter writer = new FileWriter(filename)) {
            for (Payroll payroll: payrollList) {
                String payrollData = payroll.getPayrollID() + delimiter
                                   + payroll.getMonthName() + delimiter
                                   + payroll.getYear() + delimiter
                                   + payroll.getBasicSalary() + delimiter
                                   + payroll.getAllowancePay() + delimiter
                                   + payroll.getOvertimePay() + delimiter
                                   + payroll.getTotalGrossSalary() + delimiter
                                   + payroll.getEPF() + delimiter
                                   + payroll.getSOCSO() + delimiter
                                   + payroll.getTotalTaxes() + delimiter
                                   + payroll.getTotalNetSalary() + delimiter + "\n";
                writer.write(payrollData);
            }
            return true;
        }
        catch (IOException e) {
            System.err.println("Error saving payroll data to " + filename);
            e.printStackTrace();
            return false;
        }
    }
}