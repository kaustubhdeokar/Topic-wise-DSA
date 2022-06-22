import java.util.*;
import java.io.*;

public class QuickSort{


    public static void main(String[] args) {

        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();


        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    private static void quickSort(int[] arr, int low, int high) {

        if (low >= high)
            return;

        int pivot = arr[high];

        int leftPointer = low;
        int rightPointer = high;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer)
                leftPointer += 1;
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer)
                rightPointer -= 1;
            swap(arr, leftPointer, rightPointer);
        }

            swap(arr, leftPointer, high);

        quickSort(arr, low, leftPointer - 1);
        quickSort(arr, leftPointer + 1, high);
    }

    public static void swap(int[] arr, int i, int j) {
        if(arr[i]<arr[j])
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

		
		
		
