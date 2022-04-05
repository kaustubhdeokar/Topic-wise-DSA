import java.util.Set;
import java.util.HashSet;

public class ZeroSetMatrix {


    /**
     * Approach.
     * <p>
     * Use two sets - 1 for row & other for column, (setI, setJ)
     * iterate over the matrix
     * - if(arr[i][j]==0) add i -> setI & j to SetJ.
     * <p>
     * now iterating over the matrix again
     * if i or j are in the setI or setJ , set arr[i][j]==0
     *
     * @param arr
     */
    public void setZeroes(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        Set<Integer> setI = new HashSet<>();
        Set<Integer> setJ = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    setI.add(i);
                    setJ.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (setI.contains(i) || setJ.contains(j))
                    arr[i][j] = 0;
            }
        }

    }

//    public void setZeroesWithoutAdditionalSpace(int[][] arr) {
//
//        int rows = arr.length;
//        int cols = arr[0].length;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (arr[i][j] == 0){
//                    arr[i][0] = 0;
//                    arr[0][j] = 0;
//                }
//            }
//        }
//
//        for(int i=0;i<rows;i++){
//            if(arr[i][0]==0){
//                for(int j=1;j<cols;j++){
//                    arr[i][j]=0;
//                }
//            }
//        }
//
//        for(int j=0;j<cols;j++){
//            if(arr[0][j]==0){
//                for(int i=1;i<rows;i++){
//                    arr[i][j]=0;
//                }
//            }
//        }
//
//    }


}
