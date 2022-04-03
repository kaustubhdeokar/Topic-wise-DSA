import java.util.*;
import java.io.*;

public class MajorityElement_3{
	public static void main(String[] args){
	
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n=scan.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = scan.nextInt();
		}
		Set<Integer> majorElems = new HashSet<>();
		Arrays.sort(arr);
		for(int i=0;i<n;i++){
			if((i+(n/3))<n && arr[i]==arr[i+n/3])
				majorElems.add(arr[i]);
		}
		List<Integer> list = new ArrayList<>();
		list.addAll(majorElems);
		
		System.out.println("major elems");
		for(Integer i1:list)
			System.out.print(i1+" ");
		//1 1 1 1 2 2 2 3 3 3 (10/3=3>)
		//int[] majorElems = [2];
		//for i in 0,n:
		//	arr[i]=num &&  arr[i+n/3]=num (majority elem) addto majorElems
		//      	while(arr[i]!=num)
		//      		i++;
		//
		//
		//
		
	}
}

