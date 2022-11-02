import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class FileManager{
	static public File createFile()
	{
		File file = new File("visitordetails.txt");
		try
		{
			if(file.createNewFile())
				System.out.println("File created successfully");
			
		}
		catch(IOException ie){
			System.out.println("File already exists");
		}
		return file;
		
	}
	static public void writeFile(File f,String record)
	{
		try {
			FileWriter fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(record);
			System.out.println("Successfully written to file");
			bw.close();
			fw.close();
		}
		catch(IOException ie){
			System.out.println(ie);
		}
		
	}
	static public String[] readFile(File f)
	{
		ArrayList<String> arr = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(f);
			sc.useDelimiter(";");
			while(sc.hasNext()) 
					arr.add(sc.next());
			String[] fileContent = new String[arr.size()];
			for(int i=0;i<arr.size();i++)
					fileContent[i] = arr.get(i);
			sc.close();
			return fileContent;
			
				
		}
		catch(IOException ie)
		{
			System.out.println(ie);
		}
		return null;
		
		
	}
}
public class VisitorMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		File file = FileManager.createFile();
		do {			
			System.out.println("Enter Name");
			//sc.nextLine();
			String name = sc.next(); 
			
			System.out.println("Enter Phone Number");
			String phno = sc.next();
			
			System.out.println("Enter email");
			String email = sc.next();
			String ip = name+","+phno+","+email+";";	
			FileManager.writeFile(file,ip);
			System.out.println("Do you want to enter another record?(Y/N)");
			ch = sc.next().charAt(0);			
		}while(ch == 'Y');
		String[] fileContent = FileManager.readFile(file);
		for(String str:fileContent)
			System.out.println(str);
		
		
	}
}
