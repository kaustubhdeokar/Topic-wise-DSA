//https://leetcode.com/problems/course-schedule/

public class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        int[] indegree = new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][1]]+=1;
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        int nodesProcessed = 0;
        
        while(!queue.isEmpty()){
            int top = queue.remove();
            nodesProcessed+=1;
            for(int adj:graph.get(top)){
                indegree[adj]-=1;
                if(indegree[adj]==0){
                    queue.add(adj);
                }
            }
        }
        
        return nodesProcessed==numCourses;
    }
}