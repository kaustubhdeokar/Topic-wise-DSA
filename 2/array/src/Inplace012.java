public class Inplace012 {


    public static void main(String[] args) {
        Inplace012 inplace012 = new Inplace012();
        int[] arr ={2,0,2,1,1,0};
        int[] newarr = inplace012.inPlaceSort(arr);
        for(int i:newarr){
            System.out.println(i+" ");
        }
    }

    public int[] inPlaceSort(int[] nums) {

        int zeroes = 0;
        int ones = 0;
        int twos = 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroes += 1;
            if (nums[i] == 1)
                ones += 1;
            if (nums[i] == 2)
                twos += 1;
        }
        int count = 0;
        while (zeroes > 0) {
            nums[count++] = 0;
            zeroes -= 1;
        }
        while (ones > 0) {
            nums[count++] = 1;
            ones -= 1;
        }
        while (twos > 0) {
            nums[count++] = 2;
            twos -= 1;
        }
        return nums;
    }

}
