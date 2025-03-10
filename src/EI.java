public class EI extends Deductions{
private static double premiumRate = 0.0164;
private static double maxPremium = 1077.48;



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
