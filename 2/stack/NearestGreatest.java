import java.util.*;

public class NearestGreatest{

    class MapNumberToIndex{
        int number;
        int index;
        
        MapNumberToIndex(int number, int index){
            this.number = number;
            this.index = index;
        }
        
    }
    
     public int[] findNearestGreatest(int[] arr, int start, int end, int incr){
    
        int[] result = new int[arr.length];
        int n = arr.length;
        Stack<MapNumberToIndex> stack = new Stack<>();

        for(int i=start;i<=end;i+=incr){
            int curr = arr[i];
            
            //for nearest smallest to left, just altering the below comparison will do.
            while(!stack.isEmpty() && stack.peek().number > curr){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stack.peek().index;
            }
            stack.push(new MapNumberToIndex(arr[i], i));
        }
        
        return result;
    }
    
    public static void main(String[] args){
        
        NearestGreatest ng = new NearestGreatest();

//      int[] arr = {5,1,3,2,4};
//      int[] res = ng.findNearestGreatest(arr, arr.length-1, 0, -1); // as this traverses from right to left, this will find greatest/smallest for right.
        int[] arr = {4,2,3,1,5};
        int[] res = ng.findNearestGreatest(arr, 0, arr.length-1, 1);  // as this traverses from left to right, this will find greatest/smallest for left.
 
        for(int i: res){
            System.out.print(i+" ");
        }
   }
        
}
            
