import java.util.Scanner;

class Associate{
	private int associateId;
	private String associateName,workStatus;
	
	public Associate(int associateId, String associateName) {
		this.associateId = associateId;
		this.associateName = associateName;
		
	}

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public void trackAssociateStatus(int noOfDays)
	{
		
		if(noOfDays <= 20)
			setWorkStatus("Learning Core Skills");
		else if(noOfDays > 20 && noOfDays <= 40)
			setWorkStatus("Learning Advanced modules");
		else if(noOfDays > 40 && noOfDays <= 60)
			setWorkStatus("Project Phase");
		else if(noOfDays>60)
			setWorkStatus("Deployed in project");
		else
			setWorkStatus("Invalid Input");
	}
}
public class AssociateMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the associate id:");
		int associateId = sc.nextInt();
		System.out.println("Enter associate name:");
		String associateName = sc.next();
		Associate a = new Associate(associateId,associateName);
		System.out.println("Enter the number of days:");
		int noOfDays = sc.nextInt();
		a.trackAssociateStatus(noOfDays);
		System.out.println("The associate "+a.getAssociateName()+" work status: "+a.getWorkStatus());
		

	}

}
