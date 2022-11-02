import java.util.Scanner;

class Stud{
	protected int studentId,departmentId;
	protected String name,gender,phone;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
class Hosteller extends Stud{
	private String hostelName;
	private int roomNumber;
	
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
}
public class HostellerMain {
	public static Hosteller getHostellerDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Details:\nStudent Id");
		int studId = sc.nextInt();
		System.out.println("Student Name");
		String studName = sc.next();
		System.out.println("Department Id");
		int deptId = sc.nextInt();
		System.out.println("Gender");
		String gender = sc.next();
		System.out.println("Phone Number");
		String phno = sc.next();
		System.out.println("Hostel Name");
		String hostelName = sc.next();
		System.out.println("Room No");
		int roomNumber = sc.nextInt();
		Hosteller h = new Hosteller();
		h.setDepartmentId(deptId);
		h.setGender(gender);
		h.setHostelName(hostelName);
		h.setName(studName);
		h.setPhone(phno);
		h.setRoomNumber(roomNumber);
		return h;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hosteller h = getHostellerDetails();
		System.out.println("Modify Room Number(Y/N)");
		char rChoice = sc.next().charAt(0);
		if(rChoice == 'Y')
		{
			System.out.println("New Room Number");
			int newRoomNumber = sc.nextInt();
			h.setRoomNumber(newRoomNumber);
		}
		System.out.println("Modify Room Number(Y/N)");
		char phChoice = sc.next().charAt(0);
		if(phChoice == 'Y')
		{			
			System.out.println("New Phone Number");
			String newPhoneNumber = sc.next();
			h.setPhone(newPhoneNumber);
		}
		System.out.println("The Student Details:");
		System.out.println(h.getStudentId()+" "+h.getName()+" "+h.getDepartmentId()+" "+h.getGender()+" "+h.getPhone()+" "+h.getHostelName()+" "+h.getRoomNumber());
		
	}

}
