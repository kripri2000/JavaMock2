import java.util.Scanner;

class UserManagement{
	private String _name,_username,_password;
	private long _mobileNumber;
	
	public UserManagement(String _name,long _mobileNumber,String _username,String _password)
	{
		this._name = _name;
		this._mobileNumber = _mobileNumber;
		this._username = _username;
		this._password = _password;
		
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_username() {
		return _username;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
	public long get_mobileNumber() {
		return _mobileNumber;
	}
	public void set_mobileNumber(long _mobileNumber) {
		this._mobileNumber = _mobileNumber;
	}
	
}
class UserManageBO{
	int i=0;
	public UserManagement[] add(String name,long mobileNumber,String username,String password,UserManagement[] users)
	{
		users[i] = new UserManagement(name,mobileNumber,username,password);
		i++;
		return users;
	}
	public UserManagement[] remove(int id,UserManagement[] users)
	{
		UserManagement[] usersDeleted = new UserManagement[users.length-1];
		int j=0;
		for(int i=0;i<users.length;i++)
		{
			if(i+1 != id )
			{
				usersDeleted[j] = users[i];
				j++;
			}
		}
		System.out.println("User removed successfully");
		return usersDeleted;
	}
	public void display(UserManagement[] users)
	{
		if(users.length == 0)
			System.out.println("No itemType found");
		else {
			System.out.printf("%s %8s %20s %15s %15s ","Id","Name","Mobile Number","Username","Password");
			System.out.println();
			for(int i=0;i<users.length;i++)
			{
				System.out.printf("%d %10s %20s %15s %15s ",i+1,users[i].get_name(),users[i].get_mobileNumber(),users[i].get_username(),users[i].get_password());
				System.out.println();
			}
		}
	}
}
public class UserManagementMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserManageBO u = new UserManageBO();
		System.out.println("Enter the number of users to be added");
		int n = sc.nextInt();
		UserManagement[] users = new UserManagement[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the user details "+(i+1)+":");
			System.out.println("Enter the name:");
			String name = sc.next();
			System.out.println("Enter mobile number:");
			long mob = sc.nextLong();
			System.out.println("Enter the username:");
			String username = sc.next();
			System.out.println("Enter the password:");
			String password = sc.next();
			u.add(name,mob,username,password,users);
		}
		System.out.println("Users created successfully");
		int ch;
		do {
			System.out.println("Menu:");
			System.out.println("1.Display all users\n2.Remove a user\n3.Exit");
			ch = sc.nextInt();
			if(ch == 1)
				u.display(users);
			else if(ch == 2)
			{
				System.out.println("Enter the user id:");
				int id = sc.nextInt();
				boolean found = false;
				for(int i=0;i<users.length;i++)
				{
					if(i+1 == id) 
					{
						found = true;
						users = u.remove(id,users);
						break;
					}
				}
				if(found == false)
					System.out.println("Invalid Input");
					
			}
			else if(ch == 3)
				System.exit(0);
			else
				System.out.println("Invalid Choice");
			
		}while(ch<4);
	}
}


