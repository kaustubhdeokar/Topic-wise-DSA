//https://leetcode.com/problems/course-schedule-ii/

public class CourseScheduleII{

     public int[] findOrder(int numCourses, int[][] prerequisites) {
     
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]+=1;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }        
        
        int[] finalOrder = new int[numCourses];
        int itr = 0;
        while(!q.isEmpty()){
            int top = q.remove();
            finalOrder[itr++] = top;
            for(int adj:graph.get(top)){
                indegree[adj]-=1;
                
                if(indegree[adj]==0){
                    q.add(adj);
                }
                
            }
        }
        
        if(itr==numCourses)
            return finalOrder;
        else 
            return new int[0];
        
    }
}