package mocktest;
import java.util.*;
public class IntegerCheck {
	public static String isInteger(String str)
	{
		String result = "YES";
		char[] strArr = str.toCharArray();
		if(strArr[0] == '0')
			result ="NO";
		else {
			for(int i=0;i<strArr.length;i++)
			{
				if(strArr[i] =='.')
				{
					for(int j=i+1;j<strArr.length;j++)
					{
							if(strArr[j] != '0')
							{
								result = "NO";
								break;
							}
					}
				}
			}
		}
		return result;
			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i=0;i<testcase;i++)
		{
			String ip = sc.next();
			System.out.println(isInteger(ip));		
		}
		
	}

}
