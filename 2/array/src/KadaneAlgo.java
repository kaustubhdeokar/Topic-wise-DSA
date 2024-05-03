public class KadaneAlgo {


    public static void main(String[] args) {

        KadaneAlgo kadaneAlgo = new KadaneAlgo();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = kadaneAlgo.kadanesAlgorithmOn(arr);
        System.out.println(result);

    }

    public int kadanesAlgorithmOn2(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                maxSum = Integer.max(sum,maxSum);
            }
        }
        return maxSum;
    }

    public int kadanesAlgorithmOn(int[] arr) {

        int maxSofar = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxSofar = Integer.max(maxSofar + arr[i], arr[i]);
            max = Integer.max(max, maxSofar);
            System.out.println(maxSofar+":"+max);
        }

        return max;


    }

}
