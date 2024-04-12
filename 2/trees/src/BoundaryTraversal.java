package traversal;
import traversal.Node;
import java.util.ArrayList;
import java.util.*;

public class BoundaryTraversal {

   

    public ArrayList<Integer> boundaryTraversal(Node tree) {

        ArrayList<Integer> list = new ArrayList<>();
        if (tree == null)
            return list;

        ArrayList<ArrayList<Integer>> listByLevel = new ArrayList<>();
        traverseLevelOrder(tree, listByLevel, 1);
        return list;
    }

    public void traverseLevelOrder(Node tree, ArrayList<ArrayList<Integer>> list, int level){
        
        //traverse by level, 
            //for each level, a list ->   {firstnode_,_lastnode}
            //if first node is empty fill it. 
            //after which always replace the last node in the list.
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(tree);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.pop();
                addToList(curr, list, level);
                if(curr.left != null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                System.out.println("level:"+level+" list:"+list);    
            }
            level+=1;
        }
    }

    public void addToList(Node curr, ArrayList<ArrayList<Integer>> list, int level){
        ArrayList<Integer> innerList = new ArrayList<>();
        if(list.size()<level){
            list.add(innerList);
        }
        if(list.get(level-1).size()<2){
            list.get(level-1).add(curr.val);
        }
        else{
            list.get(level-1).set(1, curr.val);
        }

    }

    public static void main(String[] args) {
        
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        Node node = formNode();
        ArrayList<Integer> list = boundaryTraversal.boundaryTraversal(node);
        for(Integer i: list){
            System.out.print(i+" ");
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
         System.out.print(q.pollLast()+" ");
        }
        
    }

    public static Node formNode(){
                    /*
                     7
                  /    \
                 2      9
                / \    / \
                1   4  8   10
                   / \
                   3  5
                */
        Node root = new Node(7);
        root.left = new Node(2);
        root.right = new Node(9);

        root.left.left = new Node(1);
        root.left.right = new Node(4);

        root.right.left = new Node(8);
        root.right.right = new Node(10);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        return root;

    }

}
