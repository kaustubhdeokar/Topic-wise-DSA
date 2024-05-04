import java.util.*;

public class MaxAreaHistogram {
    
    class MapNumToIndex{
        int height;
        int index;
        MapNumToIndex(int height, int idx){
            this.height = height;
            this.index = idx;
        }
    }

    public static void main(String[] args) {
        
        MaxAreaHistogram maxArea = new MaxAreaHistogram();
        int[] buildings = new int[]{6, 2, 5, 4, 5, 1, 6};
        int res = maxArea.largestRectangleArea(buildings);
        System.out.println("result:"+res);

    }

    public void printArr(int[] arr){

        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public int largestRectangleArea(int[] heights) {
        
        int[] smallerToLeft = new int[heights.length];
        Stack<MapNumToIndex> stack = new Stack<>();

        for(int i=0;i<heights.length;i++){
            
             while(!stack.isEmpty() && stack.peek().height >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    smallerToLeft[i] = -1;
                }
                else{
                    smallerToLeft[i] = stack.peek().index;
                }
            
            stack.add(new MapNumToIndex(heights[i],i));
        }
        
        printArr(smallerToLeft);
        
        int[] smallerToRight = new int[heights.length];
        stack.clear();

        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek().height>=heights[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                smallerToRight[i] = heights.length;
            }
            else{
                smallerToRight[i] = stack.peek().index;
            }
            stack.push(new MapNumToIndex(heights[i], i));
        } 
        
        printArr(smallerToRight);
 
        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<heights.length;i++){
            maxArea = Integer.max(maxArea, (smallerToRight[i] - smallerToLeft[i] - 1) * heights[i]);
        }
          
        return maxArea;
/*
         
*/
    }


}
