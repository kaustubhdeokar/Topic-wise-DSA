package tree;

import java.util.*;

public class ChildrenSumProperty {

    public boolean isSumProperty(TreeNode root)
    {
        boolean[] isPropSatisfied = {true};
        
        traverseTree(root, isPropSatisfied);
        
        return isPropSatisfied[0];
    }
    
    public int traverseTree(TreeNode root, boolean[] isPropSatisfied){
        
        if(!isPropSatisfied[0])
            return -1;
            
        if(root==null) return 0;
        int left = traverseTree(root.left, isPropSatisfied);
        int right = traverseTree(root.right, isPropSatisfied);
        
        System.out.println("root:"+root.val+" left:"+left+" right:"+right);
        
        if(root.left==null && root.right==null)
            return root.val;
        
        else if(root.val!=(left+right))
            isPropSatisfied[0] = false;
        
        return root.val;
    }

    public static void main(String[] args) {
        
        TreeNode treeNode = new TreeNode();
        ChildrenSumProperty sumProperty = new ChildrenSumProperty();
        boolean ans = sumProperty.isSumProperty(treeNode.buildCompleteTree());
        System.out.println("expected true, is :"+ans);
    }

}
