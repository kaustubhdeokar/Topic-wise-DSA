
public class Question2a {

	public static void main(String[] args){
		
		int a[]={1,4,3,2,5,7};
		int i=0;
		for(i=0;i<a.length;i++)
		{
			if(i==0)
			{
				int l=(printlargest(a,1,a.length));
				System.out.print("largest index is:"+l+" ");
				System.out.println("largest value is:"+a[l]);
			}
			else if(i==(a.length-1))
			{
				int l=(printlargest(a,0,a.length-1));
				System.out.print("largest index is:"+l+" ");
				System.out.println("largest value is:"+a[l]);
			
			}
			else
			{
				int l=(printlargest(a,0,i));
				int h=(printlargest(a,i+1,a.length));
				if(l>h)
				{
					System.out.print("largest index is:"+l+" ");
					System.out.println("largest value is:"+a[l]);
				}
				else
				{
					System.out.print("largest index is:"+h+" ");
					System.out.println("largest value is:"+a[h]);
				}
			}
			
			
		}
	}
	
	static int printlargest(int a[],int l,int h){
		
		System.out.println(l+" "+h);
		int i;
		int largest=a[l];
		int largestindex=l;
		for(i=l+1;i<h;i++)
		{
			if(a[i]>largest)
			{
				largestindex=i;
				largest=a[i];
			}
		}
		return largestindex;
	}
	
	
}
