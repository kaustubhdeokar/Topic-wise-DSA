import java.util.*;


public class BinarySearch{

	public static void main(String[] args){
		
		int[] arr = new int[10];
		Random random = new Random();

		for(int i=0;i<10;i++){
			arr[i] = random.nextInt(100);
			System.out.print(arr[i]+" ");
		}

		System.out.println();
				
		int index = binarySearch(arr,arr[1]);
		
		System.out.println(index);
		
	}
	
	public static int binarySearch(int[] arr, int target){
		System.out.println("target is:"+target);		
		int len = arr.length;
		int start = 0;
		int end = len-1;
		
		while(start<=end){
			int midIndex = start+(end-start)/2;
			if(arr[midIndex]>target)
				end = midIndex - 1;
			else if(arr[midIndex]<target)
				start = midIndex + 1;
			else
				return midIndex;
		}
		
		return -1;
	}
		
		
}
