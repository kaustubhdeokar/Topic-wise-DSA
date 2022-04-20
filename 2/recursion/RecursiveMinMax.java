//https://www.geeksforgeeks.org/sum-triangle-from-array/

import java.io.*;
import java.util.*;

public class RecursiveMinMax{
	
	public static void main(String[] args){
		
		int[] arr = {1, 4, 3, -5, -4, 8, 6};
		
		System.out.println(recursiveMin(arr,0));
		
	}
	
	public static int recursiveMin(int[] arr, int nextIndex){
	
		if(nextIndex>=(arr.length))
			return Integer.MAX_VALUE;
		
		return Integer.min(arr[nextIndex],recursiveMin(arr,nextIndex+1));

	}
	
	public static int recursiveMax(int[] arr, int nextIndex){
	
		if(nextIndex>=(arr.length))
			return Integer.MIN_VALUE;
		
		return Integer.max(arr[nextIndex],recursiveMin(arr,nextIndex+1));

	}
	
}
