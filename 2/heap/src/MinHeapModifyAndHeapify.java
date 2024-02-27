import java.util.Arrays;

public class MinHeapModifyAndHeapify {

    private int[] arr;
    private int capacity;

    private int size = 0;

    MinHeapModifyAndHeapify(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public int getLeftChildIdx(int i) {
        return 2 * i + 1;
    }

    public int getRightChildIdx(int i) {
        return 2 * i + 2;
    }

    public int getParentIdx(int i) {
        return (i - 1) / 2;
    }

    public void printArray() {
        for (int a = 0; a < size; a++) {
            System.out.print(arr[a] + " ");
        }
        System.out.println();
    }

    public void insert(int i) {
        if (capacity == size) {
            System.out.println("increasing the size");
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
        arr[size++] = i;

        for (int position = size - 1; position != 0 && arr[getParentIdx(position)] > arr[position]; position = getParentIdx(position)) {
            int temp = arr[position];
            arr[position] = arr[getParentIdx(position)];
            arr[getParentIdx(position)] = temp;
        }
    }

    public void decreaseKeyAtIdx(int index, int newValue){
        arr[index] = newValue;

        for(int position = index; position!=0 && arr[getParentIdx(position)] > arr[position]; position = getParentIdx(position)){
            int temp = arr[position];
            arr[position] = arr[getParentIdx(position)];
            arr[getParentIdx(position)] = temp;
        }
    }

    public static void main(String[] args) {

        MinHeapModifyAndHeapify minHeap = new MinHeapModifyAndHeapify(1);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(40);
        minHeap.insert(80);
        minHeap.insert(100);
        minHeap.insert(70);

        minHeap.printArray();
        minHeap.decreaseKeyAtIdx(3,5);
        minHeap.printArray();
    }

}
