import java.util.*;
import java.io.*;


public class Solution{

    public static boolean binarySearch(int[] arr,int low,int high, int toFind){
        
        int med = (low+high)/2;
        
        if(low>high)
            return false;
        
        if(arr[med] == toFind)
            return true;

            else if(arr[med]>toFind)
            high = med;

        else
            low = med;

        return binarySearch(arr, low, high, toFind);

    }

    public static void main(String[] args){

        int[] arr = {1,3,5,7,9,11,13,15,17};
        
        boolean result = binarySearch(arr,0,arr.length-1,0);

        System.out.println("result"+result);


    }
}