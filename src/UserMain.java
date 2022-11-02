import java.util.Scanner;

class User{
	private int id;
	private String username,password;
	//default
	public User() {						
		this.id = 1;
		this.username = "Louis";
		this.password = "rxfsuzA2345";
	}
	//parameterized
	public User(int id,String username,String password)
	{
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getid()
	{
		return id;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
}
class UserBO{
	User[] users = new User[5];
	
	public User[] getUser()
	{
		users[0] = new User(1,"Louis",encryptPassword("rxfsuzA2345"));
		users[1] = new User(2,"Messie",encryptPassword("hpphmf1:"));
		users[2] = new User(3,"Steve",encryptPassword("openfKt"));
		users[3] = new User(4,"kallis",encryptPassword("23456778"));
		users[4] = new User(5,"Wipro",encryptPassword("A$%"));
		return users;
	}
	private String encryptPassword(String password)
	{
		String encrypted = "";
		for(int i=0;i<password.length();i++)
		{
			int ascii = (int)password.charAt(i);
			encrypted += (char)(ascii+1);
		}
		return encrypted;
	}
	boolean validate(String username,String password)
	{
		for(int i=0;i<users.length;i++)
			if(users[i].getUsername().equals(username) && users[i].getPassword().equals(encryptPassword(password)))
				return true;
		return false;		
			
	}
}
public class UserMain {

	public static void main(String[] args) {
		UserBO u = new UserBO();
		User users[] = u.getUser();
		Scanner sc = new Scanner(System.in);
		System.out.println("Username:");
		String username = sc.next();
		System.out.println("Password:");
		String password = sc.next();
		if(u.validate(username,password))
			System.out.println("Login successful");
		else
			System.out.println("Incorrect username/password");
	}

}
