import java.util.Scanner;

class Vehicle implements Loan,Insurance
{
	private String vehicleNumber,modelName,vehicleType;
	private double price;
	
	public Vehicle(String vehicleNumber, String modelName, String vehicleType, double price) {
		this.vehicleNumber = vehicleNumber;
		this.modelName = modelName;
		this.vehicleType = vehicleType;
		this.price = price;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double issueLoan()
	{
		double loanAmount;
		if(vehicleType.equals("4 wheeler"))
			loanAmount = 0.8*price;
		else if(vehicleType.equals("3 wheeler"))
			loanAmount = 0.75*price;
		else if(vehicleType.equals("2 wheeler"))
			loanAmount = 0.5*price;
		else
			loanAmount = 0;
		return loanAmount;
	}
	public double takeInsurance() {
		double insuranceAmt;
		if(price<=150000)
			insuranceAmt = 3500;
		else if(price>150000 && price<=300000)
			insuranceAmt = 4000;
		else if(price>300000)
			insuranceAmt = 5000;
		else 
			insuranceAmt = 0;
		return insuranceAmt;
	}
}
interface Loan{
	 abstract double issueLoan();
}
interface Insurance{
	abstract double takeInsurance();
}

public class VehicleMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vehicle number");
		String vehicleNo = sc.next();
		System.out.println("Enter model name");
		String modelName = sc.next();
		
		System.out.println("Enter vehicle type");
		sc.nextLine();
		String vehicleType = sc.nextLine();
		System.out.println("Enter vehicle price");
		double price = sc.nextDouble();
		Vehicle v = new Vehicle( vehicleNo,modelName,vehicleType,price);
		double loanAmount = v.issueLoan();
		System.out.println("Eligible loan amount : "+loanAmount);
		double insuranceAmount = v.takeInsurance();
		System.out.println("Eligible insurance amount : "+insuranceAmount);

	}

}
