//https://www.geeksforgeeks.org/sum-triangle-from-array/

import java.io.*;
import java.util.*;

public class SumTriangle{
	
	public static void main(String[] args){
		
		int[] arr = {1, 2, 3, 4, 5};
		
		sumArray(arr);
		
	}
	
	public static void sumArray(int[] arr){
	
		if(arr.length==1){
			System.out.println(arr[0]);
			return;
		}
		
		int[] sumArr = new int[arr.length-1];
		for(int i=0;i< arr.length-1; i++)
			sumArr[i] = arr[i]+arr[i+1];
		
		sumArray(sumArr);
		
		for(int i=0;i<arr.length;i++){
		
			if(i==0)
				System.out.print("[");
			if(i!=arr.length-1)
				System.out.print(arr[i]+",");
			if(i==arr.length-1)
				System.out.print(arr[i]+"]");
		
		}
		System.out.println();
		

	}
	
}
