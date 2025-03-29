//--------------------------------------------------------
//Assignment 2
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//---------------------------------------------------------
public class EI extends Deductions{
    //initialize variables for the rates and their maximum
private static double premiumRate = 0.0164;
private static double maxPremium = 1077.48;



    //calculate EI deductions method
    @Override
    public double calculateTax(Employee employee) {
        double grossSalary = employee.getGrossSalary();
        double EITax = grossSalary * premiumRate;
        if(EITax > maxPremium){
            EITax = maxPremium;
        }
        return EITax;
    }
}
