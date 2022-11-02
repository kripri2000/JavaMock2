package mocktest;
import java.util.*;
import java.util.stream.Stream;
class Employee2{
	public String employeeId;
	public String employeeName;
	public String salary;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getSalary() {
		return salary;
	}
	
}

class EmployeeUtility{
	public Employee2[] getEmployeeDetails(String[] details)
	{
		Employee2 empObjArr[] = new Employee2[details.length];
		for(int i=0;i<details.length;i++)
		{
			Employee2 e = new Employee2();
			String[] empDetails = details[i].split(";");
			e.setEmployeeId(empDetails[0]);
			e.setEmployeeName(empDetails[1]);
			e.setSalary(empDetails[2]);
			empObjArr[i] = e;
		}
		return empObjArr;
	}
	public Stream<Employee2> getStreamOfEmployee(Employee2[] empDetails)
	{
		
		Stream<Employee2> stream = Arrays.stream(empDetails);
		return stream;
	}
	public String[] shortlistedEmployee(Stream<Employee2> empStream,double minSalary) {
		ArrayList<String> shortlisted = new ArrayList<String>();
		empStream.forEach(a->
		{
			if(Double.parseDouble(a.getSalary()) >= minSalary)
			{
				shortlisted.add(a.getEmployeeId()+" "+a.getEmployeeName()+" "+a.getSalary());
			}
		});
		String[] returnList = new String[shortlisted.size()];
		for(int i=0;i<shortlisted.size();i++)
		{
			returnList[i] = shortlisted.get(i);
		}
		return returnList;
	}
}

public class EmployeeUtilityMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of employees");
		int n = sc.nextInt();
		System.out.println("Enter the details of employees");
		sc.nextLine();
		String empArr[] = new String[n];
		for(int i=0;i<n;i++) {
			String ip = sc.nextLine();
			empArr[i] = ip;
		}
		System.out.println("Enter minimum salary");
		double minSalary = sc.nextDouble();
		
		EmployeeUtility eu = new EmployeeUtility();
		Employee2[] empObjArr = eu.getEmployeeDetails(empArr);
		Stream<Employee2> stream = eu.getStreamOfEmployee(empObjArr);
		String minSalaryempDetails[] = eu.shortlistedEmployee(stream, minSalary);
		if(minSalaryempDetails.length == 0)
			System.out.println("No employee is having the required salary");
		else {
			System.out.println("Shortlisted Employees are:");
			for(int i=0;i<minSalaryempDetails.length;i++)
				System.out.println(minSalaryempDetails[i]);
		}
		
		
	}

}
