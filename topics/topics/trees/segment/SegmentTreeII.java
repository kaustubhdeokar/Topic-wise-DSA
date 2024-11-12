package trees.segment;

import java.util.ArrayDeque;

public class SegmentTreeII {


    private SegmentTreeNode buildTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode curr = new SegmentTreeNode(start, end);
        curr.left = buildTree(nums, start, mid);
        curr.right = buildTree(nums, mid + 1, end);
        curr.sum = curr.left.sum + curr.right.sum;
        return curr;
    }

    public void update(SegmentTreeNode node, int pos, int val) {
        if (node == null) return;

        if (node.start == node.end) {
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (pos <= mid) {
                update(node.left, pos, val);
            } else {
                update(node.right, pos, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int sumRange(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) return node.sum;

        int mid = node.start + (node.end - node.start) / 2;
        if (mid < start) {
            return sumRange(node.right, start, end);
        } else if (mid >= end) {
            return sumRange(node.left, start, end);
        } else {
            return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
        }
    }


    public void levelOrder(SegmentTreeNode root) {
        ArrayDeque<SegmentTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                SegmentTreeNode top = queue.remove();
                System.out.print(top.start + ":" + top.end + ":" + top.sum + "  ");
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 4, 9, 3};
        SegmentTreeII segmentTreeII = new SegmentTreeII();
        SegmentTreeNode root = segmentTreeII.buildTree(nums);
        segmentTreeII.levelOrder(root);

//        segmentTreeII.update(root, 3, 3);
//        segmentTreeII.levelOrder(root);

        int res = segmentTreeII.sumRange(root, 2, 5);
        System.out.println("res:" + res);
    }

}
