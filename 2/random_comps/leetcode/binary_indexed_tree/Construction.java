package binary_indexed_tree;

public class Construction {

    public static void updateBinaryIndexedTree(int[] bTree, int index, int val, int n){

        index+=1;

        while(index<=n){
                bTree[index]+=val;
                index+=(index&(-index));
        }
    }

    public static void constructBinaryIndexedTree(int[] arr, int[] bTree){

        for(int i=0;i<arr.length; i++){
            updateBinaryIndexedTree(bTree, i, arr[i], arr.length);
        }

    }

    public static int getSum(int[] bTree, int i){
        
        int index = i+1;
        int sum = 0;
        while(index>0){
            sum+=bTree[index];
            index-= (index & (-index));
        }
        return sum;
    }

    public static void main(String[] args){

        int[] arr = {10,20,30,40,50};

        int[] bTree = new int[arr.length+1];

        constructBinaryIndexedTree(arr, bTree);

        for(int i=0;i<=arr.length;i++){
            System.out.print(bTree[i]+" ");
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(getSum(bTree, i));
        }

    }

}
