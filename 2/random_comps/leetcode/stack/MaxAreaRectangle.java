package stack;

import java.util.*;

public class MaxAreaRectangle {
    
    
        class MapNumToIndex{
            int height;
            int index;
            MapNumToIndex(int height, int idx){
                this.height = height;
                this.index = idx;
            }
        }
    
        public int largestRectangleArea(int[] heights) {
            
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
                smallerToLeft[i] = i - smallerToLeft[i];
                stack.add(new MapNumToIndex(heights[i],i));
            }
    
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
                smallerToRight[i] = smallerToRight[i] - i ;
                stack2.add(new MapNumToIndex(heights[i],i));
            }
    
            int maxArea = Integer.MIN_VALUE;
    
            for(int i=0;i<heights.length;i++){
                maxArea = Integer.max(maxArea, (smallerToRight[i] + smallerToLeft[i] - 1)*heights[i]);
            }
    
            return maxArea;
        }
    
        public int maximalRectangle(char[][] matrix) {
            
            int maxAreaRec = Integer.MIN_VALUE;
    
            int[][] arr = new int[matrix.length][matrix[0].length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    
                    if(i>0){
                        arr[i][j] += arr[i-1][j];
                    }
    
                    if(matrix[i][j]=='0'){
                        arr[i][j] = 0;
                    }
                    else{
                        arr[i][j] += 1; 
                    }
                }
    
                // for(int k:arr[i]){
                //     System.out.print(k+" ");
                // }
                // System.out.println();
    
                maxAreaRec = Integer.max(maxAreaRec, largestRectangleArea(arr[i]));
            }
    
            return maxAreaRec;
        }
    

}
