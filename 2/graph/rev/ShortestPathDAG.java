import java.util.*;

public class ShortestPathDAG{
      public int[] minStep(int n){
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=1;i<=n;i++){
            
            System.out.print("i:"+i+" ");

            for(int j=i;j<=n;j++){
                
                if(j==i+1){
                    graph.get(i).add(j);
                    System.out.print(j+" "); 
                }
                
                if(j==(3*i)){
                    graph.get(i).add(j);
                    System.out.print(j+" ");
                }
            }
        }
        
        int[] distances = new int[n+1];
        for(int i=0;i<=n;i++){
            distances[i] = Integer.MAX_VALUE;
        }
        distances[1] = 0;
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int top = q.remove();
            for(int adj: graph.get(top)){
                distances[adj] = Integer.min(distances[adj], distances[top]+1);
                q.add(adj);
            }
        }
        
        return distances;
        
    }

    public static void main(String[] args){
        ShortestPathDAG shortestPath = new ShortestPathDAG();
        int[] distances = shortestPath.minStep(9);
        for(int i:distances){
            System.out.print(i+" ");
        }
    }
}