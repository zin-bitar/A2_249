//--------------------------------------------------------
//Assignment 2
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//---------------------------------------------------------

import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 Program description:
 The program takes a text file containing employee information, including their name, ID, hours worked and salary.
 It then calculates the employee's gross salary and creates an employee object. Then, it calculates the various deductions
 on the employee's gross salary to determine their net salary. The employee's full information, including deductions and net
 salary are then output to a payroll report text file. Every line of the input is an employee and every line of the output is an employee.
 If, when gathering the input, the employee's information is invalid or their hourly salary is below minimum wage, their full information is put into a
 payroll error text file (without deductions and gross salary, as that cannot be calculated from their invalid input).
 **/

public class Main {
    public static void main(String[] args) {
        //welcome users
        System.out.println("\nWelcome to the TAX evasion machine!\n");
        //this will count the number of employees that aren't minimum wage
        int count = 0;
        //initialize objects and variables
        Scanner scanner = FileHandler.createInputScanner("src/payroll.txt");
        System.out.println("> Opening file payroll...");
        PrintWriter writer = FileHandler.createPrintWriter("src/payrollError.txt");
        String IDString = "";
        String first = "";
        String last = "";
        String hoursString = "";
        String wageString = "";
        double hours = 0;
        double wage = 0;
        long ID = 0;
        Employee[] employees = new Employee[100];
        int counter = 0;
        int countCatched = 0;
        System.out.println("> Reading file payroll...");
        System.out.println("> Error lines found in file payroll ");
        //checking if each employee is either minimum wage or if there are mistakes in the inputs given for their attributes and we create another array with valid employees while printing to payrollError the invalid ones
        while(scanner.hasNextLine()){
                IDString = scanner.next();
                first = scanner.next();
                last = scanner.next();
                hoursString = scanner.next();
                wageString = scanner.next();
                counter++;
                try{
                    //we check if the inputs are in the correct format
                    ID = Long.parseLong(IDString);
                    hours = Double.parseDouble(hoursString);
                    wage = Double.parseDouble(wageString);
                    if(wage < 15.75) throw new MinimumWageException("");
                    employees[count] = new Employee(ID, first, last, hours, wage);
                    count++;
                }
                //output the wrong employees on the console and the payrollError.txt
                catch(NumberFormatException | MinimumWageException e){
                    writer.println(IDString + " " + first + " " + last + " " + hoursString + " " + wageString);
                    System.out.println(IDString + " " + first + " " + last + " " + hoursString + " " + wageString);
                    scanner.nextLine();
                    countCatched++;
                }
        }
        System.out.println("> " + counter + " lines read from file payroll\n" + "> " + countCatched + " lines written to error file\n> Calculating deductions\n> Writing report file \n");
        System.out.println("Valid employees: \n");
        //output the wrong employees to the console
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].toString());
        }
        writer.close();


        //create new printwriter to write the valid employees on payrollReport
        PrintWriter writer2 = FileHandler.createPrintWriter("src/payrollReport.txt");
        writer2.println("Employee Number First name Last Name Gross salary Deductions Net salary \n-------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < count; i++) {
            double deductions = Math.round(totalDeductions(employees[i]) * 100.0) / 100.0;
            double netSalary = Math.round((employees[i].getGrossSalary() - deductions) * 100.0) / 100.0;

            writer2.println(String.format("%-10d %-14s %-14s $%-10.2f      $%-10.2f      $%-10.2f",
                    employees[i].getEmployeeNumber(),
                    employees[i].getFirstName(),
                    employees[i].getLastName(),
                    employees[i].getGrossSalary(),
                    deductions,
                    netSalary));
        }
        writer2.print("````````````````````````````````````````````````````````````````````````````````````````````````````````````````");
        writer2.close();
    }
    //method to calculate the total deductions from each employee
    public static double totalDeductions(Employee employee){
        QPIP qpip = new QPIP();
        EI ei = new EI();
        QPP qpp = new QPP();
        ProvincialIncomeTax provincial = new ProvincialIncomeTax();
        FederalIncomeTax federal = new FederalIncomeTax();
        double totalDeductions = 0;
        totalDeductions = qpip.calculateTax(employee) + ei.calculateTax(employee) + qpp.calculateTax(employee) + provincial.calculateTax(employee) + federal.calculateTax(employee);
        return totalDeductions;
    }
}
