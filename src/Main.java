import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the TAX evasion machine!\n");
        System.out.println("Valid employees: \n");
        //this will count the number of employees that aren't minimum wage
        int count = 0;
        //demandez a lasmar de taidez avec employee 5, 7, 10 for the error handling of numbers integer parse type shit
        Scanner scanner = FileHandler.createInputScanner("src/payroll.txt");
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
        while(scanner.hasNextLine()){
                IDString = scanner.next();
                first = scanner.next();
                last = scanner.next();
                hoursString = scanner.next();
                wageString = scanner.next();
                try{
                    ID = Long.parseLong(IDString);
                    hours = Double.parseDouble(hoursString);
                    wage = Double.parseDouble(wageString);
                    if(wage < 15.75) throw new MinimumWageException("");
                    employees[count] = new Employee(ID, first, last, hours, wage);
                    System.out.println(employees[count].toString());
                    count++;
                }
                catch(NumberFormatException | MinimumWageException e){
                    writer.println(IDString + " " + first + " " + last + " " + hoursString + " " + wageString);
                    scanner.nextLine();
                }
        }
        writer.close();


        PrintWriter writer2 = FileHandler.createPrintWriter("src/payrollReport.txt");
        writer2.println("Employee Number First name Last Name Gross salary Deductions Net salary \n-------------------------------------------------------------------------------------------------------\n");
        for(int i = 0; i < count; i++) {
            writer2.println(employees[i].getEmployeeNumber() + " " + employees[i].getFirstName() + " " + employees[i].getLastName() + " $" + employees[i].getGrossSalary() + " $" + Math.round(totalDeductions(employees[i])*100.0)/100.0 + " $" + Math.round((employees[i].getGrossSalary() - totalDeductions(employees[i]))*100.0)/100.0+ "\n");
        }
        writer2.print("……. …………….. …………….. ………….. …………. ………….");
        writer2.close();
    }
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
