import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DesiredSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the array size : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements :");
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println("Enter the desired sum : ");
		int dsum = sc.nextInt();
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]+arr[j] == dsum &&!(hm.containsValue(arr[i])))
						hm.put(arr[i],arr[j]);
			}
		}
		for(Map.Entry m : hm.entrySet()) {
			System.out.println("("+m.getKey()+","+m.getValue()+")");
		}
	}

}
