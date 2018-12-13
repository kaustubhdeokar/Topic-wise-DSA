
class Question2b { 

	static void maxSubArraySum(int a[], int size) 
	{ 
		
	int max_so_far = Integer.MIN_VALUE,start = 0,max_ending_here = 0, end = 0, s = 0; 
		for (int i = 0; i < size; i++) 
		{ 
			max_ending_here+=a[i];
			if(max_ending_here>max_so_far){
				max_so_far=max_ending_here;
				start=s;
				end=i;
			}
			if(max_ending_here<0){
				s=i+1;
				max_ending_here=0;
			}
			
			
		} 
		System.out.println("Maximum contiguous sum is:"+ max_so_far); 
		System.out.println("Starting index " + start); 
		System.out.println("Ending index " + end); 
	} 
	public static void main(String[] args) 
	{ 
		int a[] = { 4,-5,-3,-4,9,7,9,18,-10,-21,42,-33}; 
		int n = a.length; 
		maxSubArraySum(a, n); 
	} 
} 
