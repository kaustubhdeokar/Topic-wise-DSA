package MergeTwoSortedArraysWOExtraSpace;
/*
n = 4, arr1[] = [1 4 8 10] 
m = 3, arr2[] = [2 3 9]


[1 4 8 10] 
[2 3 9]

https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/

*/
import java.util.Arrays;

public class Solution{
    public static void main(String[] main){

        int[] arr1 = {1,3,5,7};
        int arr1Len = 4;
        int[] arr2 = {5,6,7,8,9};
        int arr2Len = 5;

        int p1 = 0;
        int p2 = 0;
        int count = 0;
        //calculating what should stay in arr1 from arr1. 
        while(count!=arr1Len){
            if(arr1[p1]<arr2[p2]) p1++;
            else  p2++;
            count+=1;
        }
        //p1 points to place where we have to replace from. 
        //p1->8.
        p2=0;
        while(p1!=arr1Len){
            int temp = arr1[p1];
            arr1[p1] = arr2[p2];
            arr2[p2] = temp;
            p1+=1;
            p2+=1;
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i1:arr1){
            System.out.print(i1+" ");
        }
        for(int i2:arr2){
            System.out.print(i2+" ");
        }


    }
}