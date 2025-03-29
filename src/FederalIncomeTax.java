//--------------------------------------------------------
//Assignment 2
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//---------------------------------------------------------
public class FederalIncomeTax extends Deductions{
    //initialize variables for tax brackets and their rates
    private static double taxRateBracketOne = 0.15;
    private static double taxRateBracketTwo = 0.205;
    private static double taxRateBracketThree = 0.26;
    private static double taxRateBracketFour = 0.29;
    private static double taxRateBracketFive = 0.33;
    private double bracket1 = 16129;
    private double bracket2 = 57376;
    private double bracket3 = 114751;
    private double bracket4 = 177883;
    private double bracket5 = 253414;


    //calculate federal taxes using the given tax brackets in each salary range
    @Override
    public double calculateTax(Employee employee) {
        double grossSalary = employee.getGrossSalary();
        double tempSalary = grossSalary;
        double federalTax = 0;
        if(tempSalary > bracket5){
            federalTax += (tempSalary - bracket5) * taxRateBracketFive;
            tempSalary =bracket5;
        }
        if(tempSalary > bracket4){
            federalTax += (tempSalary - bracket4) * taxRateBracketFour;
            tempSalary =bracket4;
        }
        if(tempSalary > bracket3){
            federalTax += (tempSalary - bracket3) * taxRateBracketThree;
            tempSalary =bracket3;
        }
        if(tempSalary > bracket2){
            federalTax += (tempSalary - bracket2) * taxRateBracketTwo;
            tempSalary =bracket2;
        }
        if(tempSalary > bracket1){
            federalTax += (tempSalary - bracket1) * taxRateBracketOne;
        }
        return federalTax;
    }
}

