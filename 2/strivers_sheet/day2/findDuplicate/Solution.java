package findDuplicate;

public class Solution {
    

    public int searchDuplicate(int[] arr){

        int minDuplicate = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(i>=arr[i])
                minDuplicate = Integer.min(minDuplicate,arr[i]);
        }
        return minDuplicate;

    }

    public static void main(String[] args){


        Solution solution = new Solution();
        int sol = solution.searchDuplicate(new int[]{1,3,4,2,2});
        System.out.println(sol);

    }


}
