package trees.binarytree;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    //https://leetcode.com/problems/path-sum/
    public void fromRootToLeaf(TreeNode treeNode, ArrayList<Integer> list, int[] currSum) {

        if (treeNode == null) return;

        currSum[0] += treeNode.val;
        list.add(treeNode.val);

        if (treeNode.left == null && treeNode.right == null) {
            System.out.println(list);
            System.out.println("Leaf node reached:" + currSum[0]);
        }

        fromRootToLeaf(treeNode.left, list, currSum);
        fromRootToLeaf(treeNode.right, list, currSum);

        currSum[0] -= treeNode.val;
        list.remove(list.size() - 1);

    }

//    https://leetcode.com/problems/path-sum-iii/
    public void topDownBetweenAnyNode(TreeNode treeNode, ArrayList<Integer> list, int[] currSum, int sumRequired)
    {

        if (treeNode == null) return;

        currSum[0] += treeNode.val;
        list.add(treeNode.val);

        if (currSum[0] == sumRequired) {
            System.out.println("found:" + list);
        }
        int tempSum = currSum[0];
        List<Integer> tempList;
        for (int i = 0; i < list.size(); i++) {
            tempSum -= list.get(i);
            //(i+1!=list.size()) -> if the list is empty then even if our target sum is reached (0) don't consider it.
            if (tempSum == sumRequired && (i+1!=list.size())) {
                tempList = list.subList(i + 1, list.size());
                System.out.println("found:" + tempList);
            }
        }

        topDownBetweenAnyNode(treeNode.left, list, currSum, sumRequired);
        topDownBetweenAnyNode(treeNode.right, list, currSum, sumRequired);

        currSum[0] -= treeNode.val;
        list.remove(list.size() - 1);

    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = tree.pathSumSampleTree2();

        PathSum pathSum = new PathSum();
        ArrayList<Integer> list = new ArrayList<>();
//      pathSum.fromRootToLead(sampleBst, list, new int[]{0});
        pathSum.topDownBetweenAnyNode(root, list, new int[]{0}, 1);
    }
}
