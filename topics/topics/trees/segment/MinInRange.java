package trees.segment;

public class MinInRange {

    class SegmentTreeNodeForMin {
        int start, end;
        SegmentTreeNodeForMin left, right;
        int min;

        public SegmentTreeNodeForMin(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
        }

        public SegmentTreeNodeForMin(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 1, 4, 9, 3};
        MinInRange minRange = new MinInRange();
        minRange.buildTree(arr, 0, arr.length - 1);

    }

    public SegmentTreeNodeForMin buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNodeForMin(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;

        SegmentTreeNodeForMin curr = new SegmentTreeNodeForMin(start, end);
        curr.left = buildTree(nums, start, mid);
        curr.right = buildTree(nums, mid + 1, end);
        curr.min = Math.min(curr.left.min, curr.right.min);

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
            node.sum = Math.min(node.left.sum, node.right.sum);
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
            return Integer.min(sumRange(node.left, start, mid) , sumRange(node.right, mid + 1, end));
        }
    }

}
