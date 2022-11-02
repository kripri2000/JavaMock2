package mocktest;
import java.util.Scanner;
class Login{
	public boolean checkLoginId(String id)
	{
		if(id.matches("GBL/[0-9]{3}/[0-9]{4}"))
			return true;
		else
			return false;
	}
}
public class CheckLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your ID");
		String id = sc.next();
		Login login = new Login();
		if(login.checkLoginId(id))
			System.out.println("Login success");
		else
			System.out.println("Incorrect ID");
		

	}

}
