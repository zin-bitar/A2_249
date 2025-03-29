//--------------------------------------------------------
//Assignment 2
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//---------------------------------------------------------
public class QPP extends Deductions{
    //initialize variables for the rates and their maximum
    private static double taxRate = 0.108;
    private static double maxPremium = 7700.40;


    //calculate QPP deductions method
    @Override
    public double calculateTax(Employee employee) {
        double grossSalary = employee.getGrossSalary();
        double QPPTax = grossSalary * taxRate;
        if(QPPTax > maxPremium){
            QPPTax = maxPremium;
        }
        return maxPremium;
    }
}
