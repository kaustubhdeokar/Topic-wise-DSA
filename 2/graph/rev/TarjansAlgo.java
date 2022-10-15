import java.util.*;

public class TarjansAlgo {
    
    public ArrayList<ArrayList<Integer>> tarjans(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        int[] discovery = new int[n];
        int[] lowestDisc = new int[n]; //lowest discovery of adjacent nodes.
        int[] time = {1};
        int parent = -1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        
        Arrays.fill(lowestDisc, Integer.MAX_VALUE);
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                findStronglyConnectedComponents(i, parent, visited, recStack, adj, time, discovery, lowestDisc, stack);
            }
        }
        
        
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int lowValue = -1;
        
        while(!stack.isEmpty()){
            
            int top = stack.peek();
            lowValue = lowestDisc[top];
            ArrayList<Integer> list = new ArrayList<>();
            
            while(!stack.isEmpty() && lowestDisc[top] == lowValue){
                list.add(top);
                stack.remove();
                if(stack.size()!=0)
                    top = stack.peek();
            }
            
            Collections.sort(list, (l1,l2)->Integer.compare(l1,l2));
            resultList.add(list);
        }
        
        return resultList;
        
    }
    
    public void findStronglyConnectedComponents(int current, int parent, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> graph, int[] time, 
                int[] discovery, int[] low, ArrayDeque<Integer> stack)
    {
        visited[current] = true;
        recStack[current] = true;
        discovery[current] = low[current] = time[0];
        time[0]+=1;
        
        stack.add(current);
        
        for(int child: graph.get(current)){
            
            if(!visited[child]){
                
                findStronglyConnectedComponents(child, current, visited, recStack, graph, time, discovery, low, stack);
                low[current] = Integer.min(low[current], low[child]);
                
            }
            else if(recStack[child]){
                low[current] = Integer.min(low[current], discovery[child]);
            }
        }
        
        recStack[current] = false;
        
    }

}
