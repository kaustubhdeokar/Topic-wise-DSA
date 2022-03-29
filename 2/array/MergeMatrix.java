import java.util.*;

public class MergeMatrix{


    public void mergeIntervals(int[][] arr){

        int[][] newarr = new int[arr.length][2];
        int count = 0;

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
            if(i!=arr.length-1 && arr[i][1]>=arr[i+1][0]){
                newarr[count][0] = arr[i][0];
                newarr[count][1] = arr[i+1][1];
                i+=1;
            }
            else{
                newarr[count][0] = arr[i][0];
                newarr[count][1] = arr[i][1];
            }
            count++;
        }
        for(int i=0;i<count;i++){
            System.out.println(newarr[i][0]+" "+newarr[i][1]);
        }

    }

    public static void main(String[] args){

        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        MergeMatrix mergeMatrix = new MergeMatrix();
        mergeMatrix.mergeIntervals(arr);

    }

}