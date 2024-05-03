package graph.rev;

import java.util.*;

public class EventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int vertices = graph.length;
        List<Integer> answer = new ArrayList<>();
        int[] visited = new int[vertices];
        int[] currStack = new int[vertices];



        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<vertices;i++){
            if(visited[i]==0) {
                topologicalSort(graph, i, visited, q);
            }
        }


        visited = new int[vertices];
        int[] currVisited = new int[vertices];

        while(!q.isEmpty()){

            int top = q.remove();

            if(visited[top]==0)
            {
                System.out.println("top:"+top);
                if(!cycle(graph, visited, currStack, top))
                {
                    printVis(visited, currVisited, vertices);

                    for(int j=0;j<vertices;j++)
                    {
                        if(visited[j]==1 && visited[j]!=currVisited[j])
                        {
                            System.out.println("added:"+j);
                            answer.add(j);
                            currVisited[j] = visited[j];
                        }
                    }
                }

                else
                {
                    System.out.println("cycle found");
                    for(int j=0;j<vertices;j++) {
                        if (visited[j] == 1 && visited[j] != currVisited[j]) {
                            currVisited[j] = visited[j];
                        }
                    }
                }
            }

        }

        return answer;

    }

    public void printVis(int[] visited, int[] currVisited, int vertices){
        System.out.print("visited");
        for(int i=0;i<vertices;i++){
            System.out.print(visited[i]+" ");
        }

        System.out.print("curr visited");
        for(int i=0;i<vertices;i++){
            System.out.print(currVisited[i]+" ");
        }
        System.out.println();
    }

    public void topologicalSort(int[][] graph, int curr, int[] visited, ArrayDeque<Integer> q){
        visited[curr] = 1;
        for(int i:graph[curr]){
            if(visited[i]==0){
                topologicalSort(graph, i, visited, q);
            }
        }

        q.add(curr);
    }


    public boolean cycle(int[][] graph, int[] visited, int[] currStack, int curr){
        visited[curr] = 1;
        currStack[curr] = 1;

        for(int i:graph[curr]){
            if(visited[i]==0 && cycle(graph, visited, currStack, i)){
                return true;
            }
            else if(currStack[i]==1){
                return true;
            }
        }
        System.out.println("false for:"+curr);

        currStack[curr] = 0;
        return false;
    }

    public static void main(String[] args) {

        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        EventualSafeStates safeStates = new EventualSafeStates();
        List<Integer> integers = safeStates.eventualSafeNodes(graph);
        Collections.sort(integers, (i1, i2)-> Integer.compare(i1, i2));
        for(int i:integers){
            System.out.print(i+" ");
        }

    }

}

