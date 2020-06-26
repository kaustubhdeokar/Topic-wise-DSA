import java.util.*;

public class BST_Node {
		
	public static void main(String[] args){
		
		int i,n=0,j;
		int[] arr={1,3,5,7,9,10};
		int [] arr2={2,5,8,9,10};
		int arrlen=arr.length;
		int arr2len=arr2.length;
		i=0;
		j=0;
		while(i!=arrlen || j!=arr2len){
			if(arr[i]==arr2[j])
			{
				n++;
				i++;
				j++;
			}
			else if(arr[i]>arr2[j])
			{
				j++;
			}
			else
			{
				i++;
			}
			
		}
		System.out.println(n);
		
		
	}
	
	
	
}
