

public class MinCostStairs {

    public static void main(String[] args) {
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        int cost = 0;
        for(int i=2;i<arr.length;i++){
            arr[i] = arr[i]+Math.min(arr[i-1],arr[i-2]);
        }
        cost = Math.min(arr[arr.length-1],arr[arr.length-2]);
        System.out.println(cost);
    }


}

