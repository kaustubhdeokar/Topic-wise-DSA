package segmenttree;

import tree.TreeNode;

public class Construction {


    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};
        Construction construction = new Construction();
        TreeNode rootNode = construction.constructSegmentTree(arr, 0, 3);
        rootNode.levelOrderTraversal(rootNode);

        int[] segmentTreeArray = new int[4 * arr.length];
        int arrIndex = 0;
        construction.constructSegmentTreeArr(arr, 0, 3, segmentTreeArray, arrIndex);
        for (int i : segmentTreeArray) {
            System.out.print(i + " ");
        }


    }

    private int constructSegmentTreeArr(int[] arr, int start, int end, int[] segmentTreeArray, int arrIndex) {

        if (start == end) {
            segmentTreeArray[arrIndex] = arr[start];
        } else {
            int mid = start + (end - start) / 2;
            segmentTreeArray[arrIndex] = constructSegmentTreeArr(arr, start, mid, segmentTreeArray, 2 * arrIndex + 1)
                    + constructSegmentTreeArr(arr, mid + 1, end, segmentTreeArray, 2 * arrIndex + 2);
        }
        return segmentTreeArray[arrIndex];
    }

    private TreeNode constructSegmentTree(int[] arr, int start, int end) {

        TreeNode node = new TreeNode(-1);
        if (start == end) {
            return new TreeNode(arr[start]);
        } else {
            int mid = start + (end - start) / 2;
            node.left = constructSegmentTree(arr, start, mid);
            node.right = constructSegmentTree(arr, mid + 1, end);
            node.value = node.left.value + node.right.value;
        }

        return node;
    }

}
