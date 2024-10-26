package trees.tree;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class CanFlipABT {


    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //the tree can be or cannot be flipped.
        //levels in each node have to be same and of the same value, same parent.
        //for each level, if we have the parent and children set. we can have something
        //like level:parent:children string and put it into a queue structure.
        //this should match.

        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val != root2.val) return false;


        int level = 0;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Queue<TreeNode> q1 = new ArrayDeque<>(); q1.add(root1);
        Queue<TreeNode> q2 = new ArrayDeque<>(); q2.add(root2);


        while(!q1.isEmpty() && !q2.isEmpty()){

            int size = q1.size();
            for(int i=0;i<size;i++){
                TreeNode top1 = q1.remove();
                if(top1.left!=null){
                    set1.add(level+":"+top1.val+":"+top1.left.val);
                    q1.add(top1.left);
                }
                if(top1.right!=null){
                    set1.add(level+":"+top1.val+":"+top1.right.val);
                    q1.add(top1.right);
                }
            }

            size = q2.size();
            for(int i=0;i<size;i++){
                TreeNode top2 = q2.remove();
                if(top2.left!=null){
                    set2.add(level+":"+top2.val+":"+top2.left.val);
                    q2.add(top2.left);
                }
                if(top2.right!=null){
                    set2.add(level+":"+top2.val+":"+top2.right.val);
                    q2.add(top2.right);
                }
            }

            if(!set1.equals(set2)){
                return false;
            }
            set1.clear();
            set2.clear();
            level+=1;
        }
        if(q1.isEmpty() && q2.isEmpty()) return true;

        return false;


    }


}
