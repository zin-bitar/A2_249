public class Employee {
    private long employeeNumber;
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double hourlyWage;
    private double grossSalary;

    public Employee(){
        this.employeeNumber = 0;
        this.firstName = "";
        this.lastName = "";
        this.hoursWorked = 0;
        this.hourlyWage = 0;
        this.grossSalary =0;
    }

    public Employee(long employeeNumber, String firstName, String lastName, double hoursWorked, double hourlyWage, double grossSalary){
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        this.grossSalary = grossSalary;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public String toString(){
        return "Employee number" + this.employeeNumber +"\n" +
                "First name: " + this.firstName +"\n" +
                "Last name: " + this.lastName +"\n" +
                "Hours worked: " + this.hoursWorked+"\n" +
                "Hourly wage: " + this.hourlyWage +"\n" +
                "Gross salary: " + this.grossSalary;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        Employee employee = (Employee)o;
        return this.employeeNumber == employee.getEmployeeNumber();
    }
}
