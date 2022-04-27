package graph;


import java.util.HashSet;

public class Graph {
    int vertices; //Total number of vertices in graph
    DoublyLinkedList<Integer>[] adjacencyList; //An array of linked lists to store adjacent vertices.

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);

            //for undirected graph uncomment the line below
            //this.adjacencyList[destination].insertAtEnd(source);
        }
    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("|" + i + "| => ");

                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            } else {

                System.out.println("|" + i + "| => " + "null");
            }
        }
    }

    public String bfs(Graph g) {
        String result = "";

        // traverse(g.adjacencyList);

        DoublyLinkedList<Integer>[] list = g.adjacencyList;
        int vertices = g.vertices;
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                result += bfsTraversal(i, visited, list);
            }
        }
        return result;
    }

    public String bfsTraversal(int source, boolean[] visited, DoublyLinkedList<Integer>[] list) {

        Queue<Integer> queue = new Queue<>(vertices);
        queue.enqueue(source);
        String result = "";

        while (!queue.isEmpty()) {

            int topVertice = queue.dequeue();

            if (!visited[topVertice]) {

                if (list[topVertice] != null && list[topVertice].getHeadNode() != null) {
                    DoublyLinkedList.Node temp = list[topVertice].getHeadNode();

                    while (temp != null) {
                        queue.enqueue((Integer) temp.data);
                        temp = temp.nextNode;
                    }
                }
                result += String.valueOf(topVertice);
                visited[topVertice] = true;
            }
        }


        return result;
    }

    public String dfs(Graph g) {
        String result = "";

        int vertices  = g.vertices;

        boolean[] visited = new boolean[vertices];

        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                result+= dfsTraversal(g, i,visited);
            }
        }
        return result;
    }

    public String dfsTraversal(Graph g, int source, boolean[] visited){

        Stack<Integer> stack = new Stack<>(g.vertices);
        DoublyLinkedList<Integer>[] list = g.adjacencyList;
        String result = "";
        stack.push(source);

        while(!stack.isEmpty()){

            int top = stack.pop();
            if(!visited[top]){

                if(list[top]!=null && list[top].getHeadNode()!=null){

                    DoublyLinkedList.Node temp = list[top].getHeadNode();
                    while(temp!=null){
                        stack.push((Integer)temp.data);
                        temp = temp.nextNode;
                    }
                }
            }
            result += String.valueOf(top);
            visited[top] = true;
        }
        return result;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 4);

//        graph.printGraph();
        graph.bfs(graph);

    }


}
