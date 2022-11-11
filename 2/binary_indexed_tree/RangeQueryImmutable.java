//https://leetcode.com/problems/range-sum-query-mutable

public class RangeQueryImmutable {

    int[] tree;
    int[] nums;
        
        public RangeQueryImmutable(int[] nums) {
            
            this.nums = nums;
            tree = new int[nums.length+1];
            constructTree();
        }
        
        public void constructTree(){
            for(int i=0;i<nums.length;i++){
                update(i, nums[i], nums.length);
            }        
        }
        
        public void update(int index, int val, int n){
    
            index+=1;
    
            while(index <= n){
                tree[index] += val;
                index += (index&(-index));
            }
            
        }
    
        public void update(int index, int val) {
            
            int origValue = val;
            val = val - nums[index];
            nums[index] = origValue;
            update(index, val, nums.length);
        }
        
        public int getSum(int index){
            
            index+=1;
            int sum = 0;
            
            while(index>0){
                
                sum+=tree[index];
                index -= (index&(-index));
                
            }
            
            return sum;
        }
        
        public int sumRange(int left, int right) {
            
            if(left==0){
                return getSum(right);
            }
            else
                return getSum(right) - getSum(left-1);
            
        }
}
    


