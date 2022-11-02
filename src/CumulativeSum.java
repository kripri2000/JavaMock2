import java.util.Scanner;

public class CumulativeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		int sum=0;
		if(n<=0)
			System.out.println("Invalid Range");
		else {
			int arr[] = new int[n];
			System.out.println("Enter the elements");
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
				
			for(int i=0;i<n;i++)
			{
				sum += arr[i];
				System.out.print(sum + " ");
			}
		}
	}

}
