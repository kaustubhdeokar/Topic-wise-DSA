import java.io.*;
import java.util.*;


class PairOfHeightToPos{

	int height;
	int pos;
	
	PairOfHeightToPos(int height,int pos){
		this.height = height;
		this.pos = pos;
	}
}

public class ContainerWithMostWater{

	public static void main(String[] args){
		
		int[] height = {1,8,6,2,5,4,8,3,7};
		maxArea(height);
	}
	
	public static int maxArea(int[] arr){
		
		int maxArea = 0;
		//1,8,6,2,5,4,8,3,7
		//8-1 8 5 8	8-1 7-1	
		Stack<PairOfHeightToPos> maxRightStack = new Stack<>();
		int[] maxRight = new int[arr.length];

		maxRight[arr.length-1] = -1;	//last elem set as -1.
		maxRightStack.add(new PairOfHeightToPos(arr[arr.length-1],arr.length-1));
		
		for(int i=arr.length-2;i>-1;i--)
		{
			
			while(!maxRightStack.isEmpty() && maxRightStack.peek().height< arr[i])	
			{
				maxRightStack.pop();
			}		
			
			if(!maxRightStack.isEmpty()){
				maxRight[i] =  maxRightStack.peek().pos;
			}
			else{
				maxRight[i] = -1;
			}
			maxRightStack.push(new PairOfHeightToPos(arr[i],i));
		}

		for(int i:maxRight){
			System.out.print(i+1+" ");
		}
					System.out.println();
		Stack<PairOfHeightToPos> maxLeftStack = new Stack<>();
		int[] maxLeft = new int[arr.length];
		maxLeft[0] = -1;	//last elem set as -1.
		maxLeftStack.add(new PairOfHeightToPos(arr[0],-1));
		
		for(int i=1;i<arr.length;i++){
		
			while(!maxLeftStack.isEmpty() && maxLeftStack.peek().height< arr[i]){
				maxLeftStack.pop();
			}
			if(maxLeftStack.isEmpty()){
				maxLeft[i] = -1;
			}
			else{
				maxLeft[i] = maxLeftStack.peek().pos;
			}
			maxLeftStack.push(new PairOfHeightToPos(arr[i],i));
		}	
		
		for(int i:maxLeft){
			System.out.print(i+1+" ");
		}

		return maxArea;
	}
}
		
		
