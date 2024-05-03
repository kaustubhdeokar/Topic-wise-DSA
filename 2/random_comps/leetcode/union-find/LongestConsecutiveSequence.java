import java.util.*;

public class LongestConsecutiveSequence{

    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        
        for(int i:nums){
            if(parentMap.get(i)!=null){
                continue;
            }
            
            if(parentMap.get(i+1)!=null){
                parentMap.put(i, find(parentMap, parentMap.get(i+1))); 
            }
            
            if(parentMap.get(i)==null){
                parentMap.put(i, i); 
            }
            
            if(parentMap.get(i-1)!=null){
                parentMap.put(i-1, find(parentMap, parentMap.get(i))); 
            }

        }
        
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        int maxValue = -1;
        
        for(Map.Entry<Integer, Integer> entry: parentMap.entrySet()){
            int value = find(parentMap,entry.getValue());
            if(resultMap.get(value)==null){
                resultMap.put(value, 1);
            }
            else{
                resultMap.put(value, resultMap.get(value)+1);
                maxValue = Integer.max(maxValue, resultMap.get(value));
            }
        }
        
        return maxValue;
        
    }
    
    public int find(HashMap<Integer, Integer> map, int x){
        if(map.get(x)==x)
            return x;
        else return find(map, map.get(x));
    }

    public static void main(String[] args){

        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        System.out.println(sequence.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}