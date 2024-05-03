package stack;

import java.util.*;

public class MaxAreaHistogram {
    
    public static void main(String[] args) {
        
        MaxAreaHistogram maxArea = new MaxAreaHistogram();
        int[] buildings = new int[]{6, 2, 5, 4, 5, 1, 6};
        int res = maxArea.largestRectangleArea(buildings);
        System.out.println("result:"+res);

    }

    class MapNumToIndex{
        int height;
        int index;
        MapNumToIndex(int height, int idx){
            this.height = height;
            this.index = idx;
        }
    }

    public int largestRectangleArea(int[] heights) {
        
        //find nearest smaller to left. 
        //arr -> 2, 1 5,6,2,3
        //idx -> 0  1 2 3 4 5
        //nearest smaller to left idx
        //    ->-1 -1 1 2 1 4
        // current idx - nearest smaller idx
        //    -> 1 2  1 1 3 1   -> (1)

        int[] smallerToLeft = new int[heights.length];
        Stack<MapNumToIndex> stack = new Stack<>();

        for(int i=0;i<heights.length;i++){
            
            if(stack.isEmpty()){
                smallerToLeft[i] = -1;
            }
            else if(stack.peek().height < heights[i]){
                smallerToLeft[i] = stack.peek().index;
            }
            else{
                while(!stack.isEmpty() && stack.peek().height >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    smallerToLeft[i] = -1;
                }
                else{
                    smallerToLeft[i] = stack.peek().index;
                }
            }

            stack.add(new MapNumToIndex(heights[i],i));
        }

        for(int i=0;i<heights.length;i++){
            smallerToLeft[i] = i - smallerToLeft[i];
        }

        // for(int num: smallerToLeft){
        //     System.out.print(num+" ");
        // }

        // find nearest smaller to right. 
        //arr -> 2,1 5,6,2,3
        //idx -> 0 1 2 3 4 5
        //nearest smaller to right idx
        //    -> 1 6 4 4 6 6 
        // nearest smaller idx - current idx
        //    -> 1 5 2 1 2 1 -> (2)

        int[] smallerToRight = new int[heights.length];
        Stack<MapNumToIndex> stack2 = new Stack<>();
        
        for(int i=heights.length-1;i>=0;i--){
            
            if(stack2.isEmpty()){
                smallerToRight[i] = heights.length;
            }
            else if(stack2.peek().height < heights[i]){
                smallerToRight[i] = stack2.peek().index;
            }
            else{
                while(!stack2.isEmpty() && stack2.peek().height >= heights[i]){
                    stack2.pop();
                }
                if(stack2.isEmpty()){
                    smallerToRight[i] = heights.length;
                }
                else{
                    smallerToRight[i] = stack2.peek().index;
                }
            }
            
            stack2.add(new MapNumToIndex(heights[i],i));
        }
        //System.out.println();

        for(int i=0;i<heights.length;i++){
            smallerToRight[i] = smallerToRight[i] - i ;
        }
        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<heights.length;i++){
            maxArea = Integer.max(maxArea, (smallerToRight[i] + smallerToLeft[i] - 1)*heights[i]);
        }

        // for(int num:smallerToRight){
        //     System.out.print(num+" ");
        // }
        //(1) + (2) - 1

        //          -> 1 2 1 1 3 1 
        //          -> 1 5 2 1 2 1  
        //count     -> 1 6 2 1 4 1
        //arr[i]    -> 2,1,5,6,2,3
        //ans = count*arr[i]
        return maxArea;
    }


}
