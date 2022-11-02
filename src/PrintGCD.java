import java.util.Scanner;

public class PrintGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers a and b : ");
		int count=0;
		int arr[] = new int[10];
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i=1;i<=a || i<=b;i++) {
			if(a%i==0 && b%i==0) {
				count++;
			}
		}
		
		System.out.println("No:of common factors of "+a+" and "+b+" : "+count);
	}

}
