import java.util.Scanner;
interface MaintenanceCharge{
	public float calculateMaintenanceCharge(float noOfYears);
}
class Account{
	
	private String accountNumber;
	private String customerName;
	private double balance;
	
	public Account(String accountNumber,String customerName,double balance) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}


class CurrentAccount extends Account implements MaintenanceCharge{
	public CurrentAccount(String accountNumber,String customerName,double balance) {
		super(accountNumber, customerName, balance);
	}
	public float calculateMaintenanceCharge(float noOfYears) {
		return 100*noOfYears;
	}

}
class SavingsAccount extends Account implements MaintenanceCharge {
	public SavingsAccount(String accountNumber,String customerName,double balance) {
		super(accountNumber, customerName, balance);
	}
	
	public float calculateMaintenanceCharge(float noOfYears) {
		return 50*noOfYears;
	}
}
public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.Savings Account\n2.Current Account\nEnter your choice:");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		System.out.println("Enter the Account number");
		String accountNumber = sc.next();
		System.out.println("Enter the Customer Name");
		String customerName = sc.next();
		System.out.println("Enter the Balance amount");
		double balance = sc.nextDouble();
		System.out.println("Enter the number of years");
		float noOfYears = sc.nextFloat();
		if(ch == 1) {
			SavingsAccount sa = new SavingsAccount(accountNumber,customerName,balance);
			System.out.println("Customer Name : "+sa.getCustomerName());
			System.out.println("Account Number : "+sa.getAccountNumber());
			System.out.println("Account Balance : "+sa.getBalance());
			System.out.println("Maintenance Charge for Savings Account : "+sa.calculateMaintenanceCharge(noOfYears));
		}
		else if(ch == 2)
		{
			CurrentAccount ca = new CurrentAccount(accountNumber,customerName,balance);
			System.out.println("Customer Name : "+ca.getCustomerName());
			System.out.println("Account Number : "+ca.getAccountNumber());
			System.out.println("Account Balance : "+ca.getBalance());
			System.out.println("Maintenance Charge for Savings Account : "+ca.calculateMaintenanceCharge(noOfYears));
			
		}
		else
			System.out.println("Invalid Choice");
		

	}

}
