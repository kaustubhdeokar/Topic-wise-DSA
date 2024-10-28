package sorting;

public class Insertion {

    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        insertion.insertionSort(new int[]{5, 4, 3, 2, 1});
    }

    public void insertionSort(int[] arr) {

        int index = 0;
        while (index < arr.length - 1) {
            int smallest = index;
            for (int i = index; i < arr.length; i++) {
                if (arr[i] < arr[smallest]) {
                    smallest = i;
                }
            }
            System.out.println(smallest);
            int temp = arr[index];
            arr[index] = arr[smallest];
            arr[smallest] = temp;
            index += 1;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
