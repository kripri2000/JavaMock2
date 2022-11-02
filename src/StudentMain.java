import java.util.Scanner;

class Student{
	private int id;
	private String name;
	private int marks[];
	private char grade;
	public float avg;
	public Student(int id, String name, int[] marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
			this.marks = marks;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public void calculateAvg() {
		int sum = 0;
		for(int i=0;i<this.marks.length;i++)
			sum += this.marks[i];
		
		this.avg = sum/marks.length;
	}
	public void findGrade()
	{
		if(this.avg>=80 && this.avg <=100)
			this.setGrade('O');
		else if(this.avg<50)
			this.setGrade('F');
		else
			this.setGrade('A');		
	}
	
}
public class StudentMain {
	public static Student getStudentDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id:");
		int id = sc.nextInt();
		System.out.println("Enter the name:");
		String name = sc.next();
		int num;
		do {
			System.out.println("Enter the no of subjects:");
			num = sc.nextInt();
			if(num <=0) 
				System.out.println("Invalid number of subjects");
		}while(num<=0);
		int marks[] = new int[num];
		int mark;
			for(int i=0;i<num;i++)
			{
				System.out.println("Enter mark for subject "+(i+1));
				mark = sc.nextInt();
				do{
					
					if(mark>=0 && mark<=100) {
						marks[i] = mark;
					}
					else {
						System.out.println("Invalid Mark");
						i--;	
					}
					
				}while(mark<0 && mark>100);
			}
		
		Student studObj = new Student(id,name,marks);
		return studObj;
	}

	public static void main(String[] args) {
		Student studObj = getStudentDetails();
		System.out.println("\nId:"+studObj.getId());
		System.out.println("Name:"+studObj.getName());
		studObj.calculateAvg();
		System.out.println("Average:"+studObj.avg);
		studObj.findGrade();
		System.out.println("Grade:"+studObj.getGrade());		

	}

}
