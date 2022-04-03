import java.util.*;
import java.io.*;

public class Chopsticks{
	public static void main(String[] args){

		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = scan.nextInt();
		int diff = scan.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = scan.nextInt();
		Arrays.sort(arr);
		
		//1 3 3 4 9
		int count = 0;
		for(int i=0;i<n-1;i++){

			if((arr[i+1]-arr[i])<=diff)
			{
				count+=1;
				i+=1;
			}
		}
		System.out.println(count);
	}
}

