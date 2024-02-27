public class ConnectedComponents {
    
    public static void main(String[] args) {
        
        
        int[][] arr = { {0,1,1,0},
                        {0,1,1,0},
                        {0,0,1,0},
                        {0,0,0,0},
                        {1,1,0,1}};

        int traversals = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1){
                    traverse(arr,i,j);
                    traversals += 1;
                }
            }
        }
        
        System.out.println("No. of traversals:"+traversals);
    }

    public static void traverse(int[][] arr, int i, int j){
        

        if(i>=0 && j>=0 && i < arr.length && j < arr[i].length && arr[i][j]==1){
            arr[i][j] = 2;
            traverse(arr, i, j+1);
            traverse(arr, i+1, j);
            traverse(arr, i-1, j);
            traverse(arr, i, j-1);
        }
    }
}
