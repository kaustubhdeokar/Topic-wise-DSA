public class UnionFind {
    
    //Function to merge two nodes a and b.
    public void union_(int a, int b, int par[], int rank[])
    {
        int x = find(par, a);
        int y = find(par, b);
        
        if(x==y)
            return;
            
        par[x] = y;

        /*
         
            2
           /  
          1   

         */

    }

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        return find(par,a) == find(par,b);
    }
    
    int find(int[] parent, int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent, parent[x]);
    }
    

}
