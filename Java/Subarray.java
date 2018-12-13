import java.io.*;
import java.util.*;


public class Subarray {

    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int i,j,count=0;
        int arr[]=new int[n];
        for(i=0;i<n;i++)
        	arr[i]=scan.nextInt();
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if((sumofArray(i,j,arr))==1)
                {
                    count+=1;
                }
            }

        }
    System.out.println(count);
    }
    public static int sumofArray(int i,int j,int[] arr)
    {
        int k,sum=0;
        for(k=i;k<=j;k++)
        {
            sum+=arr[k];
        }
        if(sum<0)
        {
        return 1;
        }
        else
        {
        return 0;
        }
    }


}

