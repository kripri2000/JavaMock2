package mocktest;

import java.util.Scanner;

abstract class Employee{
	protected int employeeId;
	protected String employeeName;
	protected double salary;
	
	public Employee(int employeeId,String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	
	protected int getEmployeeId() {
		return employeeId;
	}
	protected void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	protected String getEmployeeName() {
		return employeeName;
	}
	protected void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	protected double getSalary() {
		return salary;
	}
	protected void setSalary(double salary) {
		this.salary = salary;
	}
	public abstract void calculateSalary();
}
class PermanentEmployee extends Employee{
	private double basicPay;
	public PermanentEmployee(int employeeId,String employeeName,double basicPay)
	{
		super(employeeId,employeeName);
		this.basicPay = basicPay;
	}
	public void calculateSalary() {
		double pf = basicPay*0.12;
		double salary = basicPay-pf;
		setSalary(salary);
	}
	
}
class TemporaryEmployee extends Employee{
	private int hoursWorked;
	private int hourlyWages;
	
	public TemporaryEmployee(int employeeId,String employeeName,int hoursWorked,int hourlyWages)
	{
		super(employeeId,employeeName);
		this.hoursWorked = hoursWorked;
		this.hourlyWages = hourlyWages;
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public int getHourlyWages() {
		return hourlyWages;
	}
	public void setHourlyWages(int hourlyWages) {
		this.hourlyWages = hourlyWages;
	}
	public void calculateSalary() {
		double salary = hoursWorked*hourlyWages;
		setSalary(salary);
	}
}
class Loan{
	private double loanAmount;
	public double calculateLoanAmount(Employee employeeObj) {
		if(employeeObj instanceof PermanentEmployee)
			loanAmount = 0.15*employeeObj.getSalary();
		else if(employeeObj instanceof TemporaryEmployee)
			loanAmount = 0.1*employeeObj.getSalary();
		return loanAmount;
	}
}
public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee ID");
		int employeeId = sc.nextInt();
		System.out.println("Enter employee name");
		String employeeName = sc.next();
		System.out.println("Enter basic pay");
		double basicPay = sc.nextDouble();
		PermanentEmployee pe = new PermanentEmployee(employeeId,employeeName,basicPay);
		pe.calculateSalary();
		System.out.println("Salary is "+pe.salary);
		Loan loan = new Loan();
		double loanAmount = loan.calculateLoanAmount(pe);
		System.out.println("Loan Amount : "+loanAmount);
		

	}

}
