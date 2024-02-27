import java.util.Arrays;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    MinHeap() {
        arr = new int[]{10, 20, 15, 40, 50, 100, 25, 45};
        size = arr.length;
        this.capacity = arr.length;
        initializeMinHeap();
    }

    int getLeftChild(int i) {
        return 2 * i + 1;
    }

    int getRightChild(int i) {
        return 2 * i + 2;
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }

    public void initializeMinHeap() {
        capacity = arr.length;
    }

    public void printArray() {
        for (int a = 0; a < size; a++) {
            System.out.print(arr[a] + " ");
        }
        System.out.println();
    }

    public void insertInMinHeap(int i) {
        if (capacity == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
            capacity *= 2;
        }
        arr[size++] = i;

        for (int position = size - 1; position > 0 && arr[getParent(position)] > arr[position]; position = getParent(position)) {

            int temp = arr[getParent(position)];
            arr[getParent(position)] = arr[position];
            arr[position] = temp;

        }
    }

    public void heapify(int i) {


        int smallest = i;
        int left = getLeftChild(i);
        if (size > left && arr[left] < arr[i]) {
            smallest = left;
        }
        int right = getRightChild(i);
        if (size > right && arr[right] < arr[smallest]) {
            smallest = right;
        }
        //System.out.println("smallest:"+smallest+" elem:"+arr[smallest]);

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            //System.out.println("after swap");
            //printArray();
            heapify(smallest);
        }

    }

    private void corruptMinHeap() {
        //below heap does not follow rules of min-heap, every element
        //is not less than its child elements.
        arr = new int[]{40, 20, 30, 35, 25, 80, 32, 100, 70, 60};

    }

    private int extractMin() {
        if (size == 0) return Integer.MAX_VALUE;
        if (size == 1) return arr[0];

        int min = arr[0];
        arr[0] = arr[size - 1];
        size -= 1;
        heapify(0);
        return min;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.initializeMinHeap();
        minHeap.insertInMinHeap(12);
        minHeap.insertInMinHeap(2);
        minHeap.printArray();

        //for heapify.
        System.out.println("corrupting min heap");
        minHeap.corruptMinHeap();
        System.out.println("heapified. restored min heap");
        minHeap.heapify(0);

        System.out.println("extracting min element");
        System.out.println("min value:" + minHeap.extractMin());
    }
}
