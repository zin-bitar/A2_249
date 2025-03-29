//--------------------------------------------------------
//Assignment 2
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//---------------------------------------------------------
public class ProvincialIncomeTax extends Deductions{
    //initialize variables for tax brackets and their rates
    private static double taxRateBracketOne = 0.14;
    private static double taxRateBracketTwo = 0.19;
    private static double taxRateBracketThree = 0.24;
    private static double taxRateBracketFour = 0.2575;
    private double bracket1 = 18571;
    private double bracket2 = 53255;
    private double bracket3 = 106495;
    private double bracket4 = 129590;



    //calculate provincial taxes using the given tax brackets in each salary range
    @Override
    public double calculateTax(Employee employee) {
        double grossSalary = employee.getGrossSalary();
        double tempSalary = grossSalary;
        double provincialTax = 0;
        if(tempSalary > bracket4){
            provincialTax += (tempSalary - bracket4) * taxRateBracketFour;
            tempSalary =bracket4;
        }
        if(tempSalary > bracket3){
            provincialTax += (tempSalary - bracket3) * taxRateBracketThree;
            tempSalary =bracket3;
        }
        if(tempSalary > bracket2){
            provincialTax += (tempSalary - bracket2) * taxRateBracketTwo;
            tempSalary =bracket2;
        }
        if(tempSalary > bracket1){
            provincialTax += (tempSalary - bracket1) * taxRateBracketOne;
        }
        return provincialTax;
    }
}
