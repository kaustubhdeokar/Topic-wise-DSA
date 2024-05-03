public class Graph {

    int vertices;
    LL[] list;

    Graph(int vertices) {
        this.vertices = vertices;
        list = new LL[vertices + 1];
        for (int i = 0; i <= vertices; i++)
            list[i] = new LL();
    }

    public void addEdge(int source, int destination, boolean isBidirectional) {
        list[source].insert(destination);
        if (isBidirectional) {
            list[destination].insert(source);
        }
    }

    public int findCenter(int[][] edges) {

        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1], true);
        }

        for (int i = 0; i < vertices; i++) {
            System.out.print("i=" + i + ":");
            LL.Node temp = list[i].head;
            int length = 0;
            while (temp != null) {
                temp = temp.next;
                length += 1;
            }
            if (length == vertices - 1) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        Graph g = new Graph(edges.length + 1);
        System.out.println(g.findCenter(edges));

    }

}
