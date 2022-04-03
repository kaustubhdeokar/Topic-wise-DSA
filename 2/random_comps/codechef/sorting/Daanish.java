//i-ai
//-k problems.

import java.util.*;
import java.io.*;

public class Daanish{
	public static void main(String[] args){

		int testcases;
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		testcases = scan.nextInt();

		while(testcases-->0){
			
			int[] arr = new int[10];
			for(int i=0;i<10;i++)
				arr[i] = scan.nextInt();
			int k = scan.nextInt();


			
			while(k>=0){
			
				for(int i=9;i>-1;i--){
					if(arr[i]>0){
						if(arr[i]>k){
							System.out.println(i+1);
							k=-1;
							break;
						}
						else{
							k-=arr[i];
						}
					}	

				}		

			}

		}
	}
}

