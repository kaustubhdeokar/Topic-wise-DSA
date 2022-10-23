package tree;

import java.util.*;

public class KDistance {

    public List<Integer> distanceK(TreeNode root, int k){

        List<Integer> resultList = new ArrayList<>();
        distanceK(root, 0, k, resultList);
        return resultList;
    }

    public void distanceK(TreeNode root, int currLevel, int targetLevel, List<Integer> list){
            if(root==null || currLevel>targetLevel)
                return;
            if(currLevel == targetLevel)
                list.add(root.val);
            distanceK(root.left, currLevel+1, targetLevel, list);
            distanceK(root.right, currLevel+1, targetLevel, list);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode();
        KDistance nodesAtDistanceK = new KDistance();
        List<Integer> resultList = nodesAtDistanceK.distanceK(root.buildTree(), 1);
        for(Integer i: resultList){
            System.out.print(i+" ");
        }
  }


}
