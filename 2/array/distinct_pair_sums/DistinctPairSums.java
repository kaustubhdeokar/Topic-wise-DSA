/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class DistinctPairSums
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = scanner.nextInt();
		
		while(testcases-->0)
		{
		    int l = scanner.nextInt();
		    int r = scanner.nextInt();
		    System.out.println(2*r-2*l+1);
		}
	}
}

