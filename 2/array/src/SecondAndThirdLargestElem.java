/**
 * find the second largest element in an array.
 */
public class SecondAndThirdLargestElem {

    public int secondLargestElem(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            }
            if (i < largest && i > secondLargest) {
                secondLargest = i;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    public int thirdLargestElem(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = i;
            }

            if (i < largest && i > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = i;
            }
            if (i < largest && i < secondLargest && i > thirdLargest) {
                thirdLargest = i;
            }
        }
        return thirdLargest;
    }

    public static void main(String[] args) {

        int[] arr = {10, 12, 14, 16};
        SecondAndThirdLargestElem secondAndThirdLargestElem = new SecondAndThirdLargestElem();
        System.out.println(secondAndThirdLargestElem.secondLargestElem(arr));
        System.out.println(secondAndThirdLargestElem.thirdLargestElem(arr));
    }

}
