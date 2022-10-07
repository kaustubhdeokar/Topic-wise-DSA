import java.util.*;

/**

djikstra's does not work for a graph with negative edges.
 */

public class Djikstras{

    static int[] djikstrasWithPQ(int vertices, ArrayList<ArrayList<ArrayList<Integer>>> graph, int source){
        
        int[] visited = new int[vertices];
        int[] finalDist = new int[vertices];
        for(int i=0;i<vertices;i++)
            finalDist[i] = Integer.MAX_VALUE;
        finalDist[source] = 0;

        PriorityQueue<Pair> distance = new PriorityQueue<>((Pair p1, Pair p2)-> Integer.compare(p1.dist, p2.dist));
        distance.add(new Pair(source, 0));

        while(!distance.isEmpty()){

            Pair top = distance.remove();
            System.out.println("removed: "+top.toString());
            

            int currSource = top.node;
            int distanceToNode = top.dist;
            visited[currSource] = 1;
            
            for(ArrayList<Integer> neighbours: graph.get(currSource))
            {
                int destination = neighbours.get(0);
                int distanceToDestination = neighbours.get(1);

                if(visited[destination] == 0 && (finalDist[destination] > finalDist[currSource]+ distanceToDestination))
                {
                    finalDist[destination] = finalDist[currSource] + distanceToDestination;
                    distance.add(new Pair(destination, finalDist[destination]));

                    System.out.println("updated distance for destination:"+ destination+" to :"+finalDist[destination]);
                }
            }
        
        }

        return finalDist;
    }

    static int[] djikstra(int vertices, ArrayList<ArrayList<ArrayList<Integer>>> graph, int source){
        
        int[] visited = new int[vertices];
        int[] distances = new int[vertices];
        
        for(int i=0;i<vertices;i++){
            distances[i] = Integer.MAX_VALUE;
        }
        
        distances[source] = 0;
        
        for(int i=0;i<vertices-1;i++){
            
            int curr = -1;
            int minDistance = Integer.MAX_VALUE;
            
            for(int j=0;j<vertices;j++){
                if(visited[j]==0 && distances[j]<minDistance){
                    minDistance = distances[j];
                    curr = j;
                    System.out.println("current node:"+curr);
                }
            }
            
            visited[curr] = 1;
            
            for(ArrayList<Integer> adj: graph.get(curr)){
                
                int dest = adj.get(0);
                int dist = adj.get(1);
                
                if(visited[dest]==0){
                    distances[dest] = Integer.min(distances[dest], distances[curr]+dist);
                }
                                
            }       
                
        } 
        

        return distances;
        
    }

    public static void main(String[] args){

        ArrayList<ArrayList<ArrayList<Integer>>> weightedGraph = new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> nodeDistance = new ArrayList<>()
            {{
                add(new ArrayList<Integer>(){{ add(1); add(1);}});
                add(new ArrayList<Integer>(){{ add(2); add(2);}});
            }};
        weightedGraph.add(nodeDistance);

        nodeDistance = new ArrayList<>()
            {{
                add(new ArrayList<Integer>(){{add(0); add(1);}});
                add(new ArrayList<Integer>(){{add(3); add(3);}});
            }};
        weightedGraph.add(nodeDistance);

        nodeDistance = new ArrayList<>()
        {{
            add(new ArrayList<Integer>(){{add(0); add(2);}});
            add(new ArrayList<Integer>(){{add(3); add(4);}});
        }};

        weightedGraph.add(nodeDistance);


        nodeDistance = new ArrayList<>()
        {{
            add(new ArrayList<Integer>(){{add(2); add(4);}});
            add(new ArrayList<Integer>(){{add(1); add(3);}});
        }};
        weightedGraph.add(nodeDistance);

        Djikstras djikstras = new Djikstras();
        int[] shortestDistanceFromSourceToOtherVertex = djikstras.djikstrasWithPQ(4, weightedGraph, 0);

        for(int i:shortestDistanceFromSourceToOtherVertex){
            System.out.print(i+" ");
        }

    }
}