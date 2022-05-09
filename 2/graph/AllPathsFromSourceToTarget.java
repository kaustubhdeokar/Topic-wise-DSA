class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int source = 0;
        int destination = graph.length-1;
        queue.add(source);
        
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return findPaths(queue, graph, path, paths);        
        
    }
    
   public List<List<Integer>> findPaths(ArrayDeque<Integer> queue, int[][] graph, List<Integer> path, List<List<Integer>> paths) {

        while (!queue.isEmpty()) {

            int top = queue.pop();
            path.add(top);

            for (Integer i : graph[top]) {

                if (i == graph.length - 1) 
                {
                    path.add(graph.length - 1);
                    paths.add(new ArrayList<>(path));
                    path.removeIf(num -> num == graph.length - 1);
                } 
                else 
                {
                    queue.add(i); //if part of the path -> add.
                    findPaths(queue, graph, path, paths);
                    path.remove(i); // if not -> remove
                }

            }

        }

        return paths;
    }
    
}
