import java.util.*;

public class Graph{

    public ArrayList<ArrayList<Integer>> createGraph(int[][] arr){
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer> innerList = new ArrayList<>();
            for(int j=0;j<arr[i].length;j++){
                innerList.add(arr[i][j]);
            }
            adjList.add(innerList);
        }
        return adjList;
    }

    public void  printGraph(ArrayList<ArrayList<Integer>> adjList){

        for(ArrayList<Integer> innerList:  adjList){
            printList(innerList);
            System.out.println();
        }

    }

    public void printList(ArrayList<Integer> list){
        for(Integer i:list){
            System.out.print(i+" ");
        }
    }


}