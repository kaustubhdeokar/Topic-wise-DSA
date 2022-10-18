public class SpiralMatrix{

    public void printSpiralMatrixFor(int[][] array, int i, int j, boolean[][] visited){

        if(i>=0 && i<array.length && j>=0 && j<array[0].length && !visited[i][j]){
            visited[i][j] = true;
            System.out.println("i:"+i+" j:"+j+" array:"+array[i][j]);
            printSpiralMatrixFor(array, i+1, j, visited);
            printSpiralMatrixFor(array, i, j+1, visited);
            printSpiralMatrixFor(array, i, j-1, visited);
            printSpiralMatrixFor(array, i-1, j, visited);
            
            
            
        }
    }

    public static void main(String[] args){

        int[][] array = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        boolean[][] visited = new boolean[array.length][array[0].length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length; j++){
                spiralMatrix.printSpiralMatrixFor(array, i, j, visited);
            }
        }

    }
    
}