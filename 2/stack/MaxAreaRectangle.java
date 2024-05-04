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
    
        public int largestRectangleArea(int[] heights) 
        {
        
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
        
            //printArr(smallerToLeft);
        
            int[] smallerToRight = new int[heights.length];
            stack.clear();

            for(int i=heights.length-1;i>=0;i--){
                while(!stack.isEmpty() && stack.peek().height>=heights[i]){
                    stack.pop();
                }
            
                if(stack.isEmpty())
                {
                    smallerToRight[i] = heights.length;
                }
                else
                {
                    smallerToRight[i] = stack.peek().index;
                }
                stack.push(new MapNumToIndex(heights[i], i));
            } 
        
            //printArr(smallerToRight);
 
            int maxArea = Integer.MIN_VALUE;

            for(int i=0;i<heights.length;i++){
                maxArea = Integer.max(maxArea, (smallerToRight[i] - smallerToLeft[i] - 1) * heights[i]);
            }
          
            return maxArea;

        }
    
        public int maximalRectangle(char[][] matrix) {
            
            int maxAreaRec = Integer.MIN_VALUE;
    
            int[][] arr = new int[matrix.length][matrix[0].length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    
                    if(matrix[i][j]=='0'){
                        arr[i][j] = 0;
                    }
                    else{
                        arr[i][j] = 1; 
                        if(i>0){
                            arr[i][j]+=arr[i-1][j];
                        }
                    }
                    
                }
        
                maxAreaRec = Integer.max(maxAreaRec, largestRectangleArea(arr[i]));
            }        
            
            for(int[] a: arr){
                for(int i: a){
                    System.out.print(i+" ");
                }
                System.out.println();
            }    
            
            return maxAreaRec;
        }
        
        public static void main(String[] args){
        
            char[][] matrix = 
                
                /*
                {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
                };
                */
                
                {{'0','1'},{'1','0'}};


                
           MaxAreaRectangle maxAreaRectangle = new MaxAreaRectangle();
           System.out.println(maxAreaRectangle.maximalRectangle(matrix)); 
            
        }

}
