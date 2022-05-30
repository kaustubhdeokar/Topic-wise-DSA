//https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(point1,point2)->Double.compare(dist(point1),dist(point2)));
        return Arrays.copyOfRange(points, 0, k);
    }
    public double dist(int[] arr){
        return Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2));
    }
}
