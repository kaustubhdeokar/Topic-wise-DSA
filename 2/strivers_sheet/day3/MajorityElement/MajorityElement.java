import java.util.*;
import java.io.*;

public class MajorityElement{
        public static void main(String[] args){
                Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                System.out.println("enter the length on input array:");
                int n = scanner.nextInt();
                System.out.println("Enter n elements");
                int[] arr = new int[n];
                for(int i=0;i<n;i++){
                        arr[i] = scanner.nextInt();
                }
                System.out.print(findMajorityElement_SortingApproach(arr));
		System.out.print(findMajorityElem_CandidateApproach(arr));
	
	}

	public static int findMajorityElement_SortingApproach(int[] arr){
		Arrays.sort(arr);
		return arr[arr.length/2];
	}

	public static int findMajorityElem_CandidateApproach(int[] arr){
		int candidate=arr[0];
		int count =0;
		for(int i=0;i<arr.length;i++){
			if(count==0){
				candidate = arr[i];
			}
			if(candidate==arr[i]){
				count+=1;
			}
			else{
				count-=1;
			}
		}
		return candidate;
	}

}





