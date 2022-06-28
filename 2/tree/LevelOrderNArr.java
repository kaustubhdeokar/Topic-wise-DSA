package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelOrderNArr {

    public List<List<Integer>> levelOrder(NArrNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root==null)
            return list;
        else
            levelOrder(root,list,0);

        return list;
    }

    class NodeLevel{
        NArrNode node;
        int level;
        NodeLevel(NArrNode node, int level){
            this.node = node;
            this.level = level;
        }
    }


    public void levelOrder(NArrNode root, List<List<Integer>> list, int level){

        ArrayDeque<NodeLevel> queue = new ArrayDeque<>();
        queue.add(new NodeLevel(root,level));

        while(!queue.isEmpty()){

            NodeLevel curr = queue.poll();
            NArrNode node = curr.node;
            int val = node.val;
            int nodeLevel = curr.level;

            if(list.size()<=nodeLevel){
                list.add(new ArrayList<Integer>());
            }
            list.get(nodeLevel).add(val);

            List<NArrNode> children = node.children;
            for(NArrNode nodeItr:children){
                queue.add(new NodeLevel(nodeItr,nodeLevel+1));
            }
        }
    }
    
}
