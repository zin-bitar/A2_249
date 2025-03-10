public class QPP extends Deductions{
    private static double taxRate = 0.108;
    private static double maxPremium = 7700.40;


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
