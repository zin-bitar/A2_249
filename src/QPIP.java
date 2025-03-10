public class QPIP extends Deductions{
    private static double taxRate = 0.00494;
    private static double maxPremium = 484.12;


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
