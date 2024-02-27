import java.util.Arrays;

public class BuildHeap {

    private int[] arr;
    private int capacity;

    private int size = 0;

    BuildHeap(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void setArray(int... elems) {
        for(int elem: elems){
            insert(elem);
        }
    }

    public void insert(int i) {
        if (capacity == size) {
            System.out.println("increasing the size");
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
        arr[size++] = i;

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

    public void buildHeap(){
        int lastIdx = size-1;
        int parentOfLastIdx = getParentIdx(lastIdx);
        System.out.println(parentOfLastIdx);
        for(int i=parentOfLastIdx;i>=0;i--){
            heapify(arr, i);
        }
    }

    private void heapify(int[] arr, int idx) {

        int leftChildIdx = getLeftChildIdx(idx);
        int smallest = idx;
        if(size > leftChildIdx && arr[leftChildIdx] < arr[idx]){
            smallest = leftChildIdx;
        }
        int rightChildIdx = getRightChildIdx(idx);
        if(size > rightChildIdx && arr[rightChildIdx] < arr[smallest]){
            smallest = rightChildIdx;
        }

        if(smallest!=idx){
            int temp = arr[idx];
            arr[idx] = arr[smallest];
            arr[smallest] = temp;
            printArray();
            heapify(arr, smallest);
        }



    }

    public static void main(String[] args) {
        BuildHeap minHeap = new BuildHeap(1);
        minHeap.setArray(10,5,20,2,4,8);
        minHeap.buildHeap();
    }


}
