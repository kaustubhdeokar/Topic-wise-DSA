package trees.binarytree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

import java.util.ArrayList;
import java.util.ListIterator;

public class AllKPathSums {

    public static void main(String[] args) {

        TreeNode bt = new BinarySearchTree().kSumPathTree();
        AllKPathSums all = new AllKPathSums();
        all.allKSumPaths(bt, 7);
    }

    public void allKSumPaths(TreeNode treeNode, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        allKSumPaths(treeNode, list, k);
    }

    private void allKSumPaths(TreeNode root, ArrayList<Integer> list, int k)
    {
        if (root == null) return;

        list.add(root.val);
        System.out.println(list);

        ListIterator<Integer> listIterator = list.listIterator(list.size());
        int sum = 0;
        while(listIterator.hasPrevious())
        {
            sum += listIterator.previous();
            if(sum==k)
            {
                System.out.println("Found");
            }
        }
        System.out.println("---------");

        allKSumPaths(root.left, list, k);
        allKSumPaths(root.right, list, k);
        list.remove(list.size() - 1);

    }

}
