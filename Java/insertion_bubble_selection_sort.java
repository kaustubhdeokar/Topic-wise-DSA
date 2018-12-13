import java.util.Scanner;


class sort{
	
	int i,size,j,temp;
	Scanner scan=new Scanner(System.in);
	
	public void bubblesort(int a[],int size)
	{
		for(i=0;i<size;i++)
		{
			for(j=i+1;j<size;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}	
		}
		
		for(int x=0;x<5;x++)
		{
			System.out.print(a[x]);
				
		}
		System.out.println();
		
	}
	
	public void insertionsort(int a[],int size){
		
		//4 5 5
		//a[i]=2
		//i=2 j=i-1->0
		// 3 4 5
		
		for(i=1;i<a.length;i++){
			j=i-1;
			temp=a[i];
			while(j>=0 && a[j]>a[i])
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
			
		}
		
		for(int x=0;x<5;x++)
		{
			System.out.print(a[x]);
		}

		System.out.println();
	}
	
	public void selectionsort(int a[]){
		
		int minindex=i;
		
		for(i=0;i<a.length;i++)
		{
			minindex=i;
			for(j=i+1;j<a.length;j++)
			{
				if(a[j]<a[minindex])
				{
					minindex=j;
				}
			}
			
			temp=a[i];
			a[i]=a[minindex];
			a[minindex]=temp;
		}
		
		for(int x=0;x<5;x++)
		{
		System.out.print(a[x]);
		}
		System.out.println();
	}
}


public class Question1 {

	public static void main(String[] args){
		
	sort obj=new sort();
	int a[]={5,4,3,2,1};
	System.out.print("Bubble sort:");
	obj.bubblesort(a,5);
	System.out.print("Insertion sort:");
	obj.insertionsort(a,5);
	System.out.print("Selection sort:");
	obj.selectionsort(a);
	}
	
}
