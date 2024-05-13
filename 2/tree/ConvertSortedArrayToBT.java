package tree;

import java.util.ArrayList;
//Convert Sorted Array to Binary Search Tree

class ConvertSortedArrayToBT {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        binarySearchArr(nums, 0, nums.length - 1, list);
        TreeNode treeNode = null;
        for (Integer i : list) {
            System.out.print(i + " ");
            treeNode = insertData(treeNode, i);
        }
        return treeNode;
    }

    public TreeNode insertData(TreeNode treeNode, int data) {

        if (treeNode == null)
            return new TreeNode(data);

        else if (treeNode.val < data)
            treeNode.right = insertData(treeNode.right, data);
        else
            treeNode.left = insertData(treeNode.left, data);

        return treeNode;
    }

    public void binarySearchArr(int[] nums, int start, int end, ArrayList<Integer> list) {

        while (start <= end) {

            int mid = start + (end - start) / 2;
            list.add(nums[mid]);

            binarySearchArr(nums, start, mid - 1, list);
            binarySearchArr(nums, mid + 1, end, list);
            return;
        }
    }


}
