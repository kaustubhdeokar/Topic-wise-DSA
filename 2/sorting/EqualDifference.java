/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class EqualDifference
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = scanner.nextInt();
		while(testcases-->0){
		    int n = scanner.nextInt();
		    int[] arr = new int[n];
		    
		    HashMap<Integer,Integer> map = new HashMap<>();
		    int maxKey = Integer.MIN_VALUE;
		    
		    for(int i=0;i<n;i++){
		        arr[i] =scanner.nextInt();
		        if(map.get(arr[i])!=null){
		            int val = map.get(arr[i])+1;
		            map.put(arr[i],val);
		            maxKey = Integer.max(val,maxKey);
		        }
		        else{
		            map.put(arr[i],1);
		        }
		    }
		    
		    if(map.size()==n){
		        System.out.println(Integer.max(0,n-2));
		    }
		    else{
		        System.out.println(n-maxKey);
		    }
		    
		           
		}
	}
}

