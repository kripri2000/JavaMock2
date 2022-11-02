package mocktest;

import java.util.Scanner;

public class Nplayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //no of players
		int L[] = new int[n];
		int R[]  =new int[n];
		int m = 0; //traverse output array rows
		//start hours for players
		for(int i=0;i<n;i++)
			L[i] = sc.nextInt();
		//corresponding end hours
		for(int i=0;i<n;i++)
			R[i] = sc.nextInt();
		int freeArr[][] = new int[n][2];
		int minHr = L[0];
		int maxHr = R[n-1];
		if(minHr != 0)
		{
			freeArr[m][0] = 0;
			freeArr[m][1] = minHr ;
			m++;
		}
		for(int i=0;i<n-1;i++)
		{
			if(R[i]<L[i+1]) //checks diagonal elts in L and R
			{
				freeArr[m][0] = R[i];
				freeArr[m][1] = L[i+1];
				m++;
			}
		}
		if(maxHr != 1000000000)
		{
			freeArr[m][0] = R[n-1];
			freeArr[m][1] = 1000000000;
			
		}
		//print output array
		for(int i=0;i<freeArr.length;i++) {
			for(int j=0;j<freeArr[0].length;j++)
				System.out.print(freeArr[i][j]+" ");
			System.out.println();
		}
	}

}
