package tree;

import java.util.*;

public class TreeToDLL {

    static class TreeNode{
        
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
        
        public void traverse(TreeNode node){
            if(node==null)
                return;
            System.out.println(node.data);
            traverse(node.right);
        }
    }

    private void convertTreeToDoublyLinkedList(TreeNode rootNode, TreeNode[] newRoot, TreeNode[] curr) {

        if(rootNode==null)
            return;
        
        convertTreeToDoublyLinkedList(rootNode.left, newRoot, curr);
        
        if(curr[0]==null){
        //    System.out.println("curr is null");
            curr[0] = rootNode;
            newRoot[0] = rootNode;
          //  System.out.println("curr:"+curr[0].data);
        }
        else{
            rootNode.left = curr[0];
//            System.out.println("rootNode:"+ rootNode.data);
  //          System.out.println("rootNode-prev:"+ rootNode.left.data);
            curr[0].right = rootNode;
    //        System.out.println("curr:"+ curr[0].data);
      //      System.out.println("curr next:"+ curr[0].right.data);
            curr[0] = rootNode; 
        }

        convertTreeToDoublyLinkedList(rootNode.right, newRoot, curr);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        /*
                30
             /      \
            20       10
           /  \     /  \
           5   15  2    3  
    
        */

        TreeToDLL treeToDLL = new TreeToDLL();
        TreeNode[] curr = {null};
        TreeNode[] newRoot = {null};
        treeToDLL.convertTreeToDoublyLinkedList(root, newRoot, curr);
        root.traverse(newRoot[0]);
    }
}
