//https://www.codechef.com/LP1TO201/problems/TANDJ1

//concept can be found in ../concepts/parity_matrix.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class ParityMatrix
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = scanner.nextInt();
		
		while(testcases-->0)
		{
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int k = scanner.nextInt();
		
		int dist = Math.abs(c-a)+Math.abs(d-b);
		
		if(k>=dist && k%2==dist%2)
		    System.out.println("YES");
		    
		else
            System.out.println("NO");
		

	    }

	}
	    
}


