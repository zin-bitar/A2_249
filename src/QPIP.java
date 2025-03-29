//--------------------------------------------------------
//Assignment 2
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//---------------------------------------------------------
public class QPIP extends Deductions{

    //initialize variables for the rates and their maximum
    private static double taxRate = 0.00494;
    private static double maxPremium = 484.12;


    //calculate QPIP deductions method
    @Override
    public double calculateTax(Employee employee) {
        double grossSalary = employee.getGrossSalary();
        double QPIPTax = grossSalary * taxRate;
        if(QPIPTax > maxPremium){
            QPIPTax = maxPremium;
        }
        return QPIPTax;
    }
}
