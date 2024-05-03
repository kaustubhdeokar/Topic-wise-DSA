/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


//Problem statement: find the no. of distinct numbers that can be formed by using the sum of any two numbers between a range of integers (L,R)
//
//		let's take an example of (2,4)
//
//		we can form :
//		2+2(4) 2+3(5) 2+4(6)
//		3+2(5) 3+3(6) 3+4(7)
//		4+4(8)
//
//
//		hence we can see there are many repeating numbers. (like 5,6)
//
//		BUT THERE IS A RANGE IN WHICH THESE NUMBERS ARE FORMED.
//		the smallest sum we can form = lowest_no +lowest_no.
//		similarly, the largest = largest_no + largest_no.
//
//		hence we can form each number between (smallest&largest)
//		(4&8) (4,5,6,7,8)
//
//		HENCE THAT IS THE ANSWER = LARGEST-SMALLEST+1.	= 8-4+1.

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

