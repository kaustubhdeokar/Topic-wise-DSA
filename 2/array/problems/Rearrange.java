package array;

// arr[i] = arr[arr[i]].
public class Rearrange {

    public static void main(String[] args) {

        int[] arr = {4,0,2,1,3};
        int max = arr.length;

        for(int i=0;i<arr.length;i++){
            arr[i]+=arr[arr[i]]*max;
        }
        for(int i:arr)
            System.out.print(i+" ");
    }

}
