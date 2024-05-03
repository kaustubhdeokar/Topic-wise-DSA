public class UnionFindByRankCompression {

    public void union_(int x, int y, int parent[], int rank[])
    {
        int x_parent = find(parent, x);
        int y_parent = find(parent, y);
        
        if(x_parent == y_parent)
            return;
            
        if(rank[x_parent]>rank[y_parent])
        {
            parent[y_parent] = x_parent;
            rank[x_parent]+=1;
        }
        else
        {
            parent[x_parent] = y_parent;
            y_parent+=1;
        }

    }

    //Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[])
    {
        return find(par,a) == find(par,b);
    }
    
    int find(int[] parent, int x)
    {
        if(parent[x] == x)
            return x;
        return find(parent, parent[x]);
    }
    
    
}
