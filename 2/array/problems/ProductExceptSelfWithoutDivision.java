import java.util.Arrays;

class ProductExceptSelfWithoutDivision {
    public int[] productExceptSelf(int[] nums) {
        
        int countZeroes = 0;
        int product = 1;
        int zeroIndex = 0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==0){
                countZeroes+=1;
                zeroIndex = i;
            }
            
            else{
                product*= nums[i];
            }
            
        }
        
        //more than one zeroes, always 0;
        if(countZeroes > 1){
            Arrays.fill(nums,0);
            return nums;
        }
        //one zero, product of all rest numbers.
        else if(countZeroes == 1){
            Arrays.fill(nums,0);
            nums[zeroIndex] = product;
            return nums;
        }
        
        for(int i=0;i<nums.length;i++){
            nums[i]=(int)((product*1.0)*Math.pow(nums[i],-1));            
        }
        return nums;
        
    }
}
