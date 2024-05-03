package graph.rev.TopologicalSort;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        //findings indegree's of all nodes. 

        int[] indegree = new int[n];
        
        for(List<Integer> list: edges){
            int to = list.get(1);
            indegree[to] += 1;
        }
        
        // if indegree is 0 -> that's our node. 
        
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                resultList.add(i);
            }
        }
        return resultList;
    }
    
    
}