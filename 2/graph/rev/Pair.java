public class Pair{

    int node;
    int dist;

    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }

    public String toString(){
        return "node:"+node+" dist:"+dist;
    }

}