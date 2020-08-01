import java.util.Arrays;

public class BinarySearchMainClass {



    static int binarySearch(Integer[] intArray, int start, int end, int element) {
        boolean notFound = false;
        int mid = (start + end) / 2;
        if(start<=end){
            if (intArray[mid] < element) {
                return binarySearch(intArray, mid, end, element);
            }
            else if (intArray[mid] > element) {
                return binarySearch(intArray, start, mid, element);
            }
            else if (intArray[mid] == element) {
                return mid;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Integer[] intArray = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        System.out.println(BinarySearchMainClass.binarySearch(intArray,0,intArray.length,1));



    }

    }
