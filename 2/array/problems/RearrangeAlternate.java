package array;

public class RearrangeAlternate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int n = arr.length;
        int maxEle = arr[n-1]+1;
        int min_ind = 0;
        int max_ind = n-1;
        for(int i=0;i<n;i++){
            if((i&1)==1){
                arr[i] = arr[i] + (arr[min_ind]%maxEle)*maxEle;
                min_ind++;
            }
            else{
                arr[i] = arr[i] + (arr[max_ind]%maxEle)*maxEle;
                max_ind--;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] /= maxEle;
        }

    }
}
