package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MaxAvgOfClass {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        Comparator<double[]> incrementComp = (d1, d2) -> Double.compare(d2[0], d1[0]);
        PriorityQueue<double[]> q = new PriorityQueue<>(incrementComp);
        int index = 0;
        for (int[] c : classes) {
            double currStudent = c[0];
            double passStudent = c[1];
            double prevPercent = currStudent / passStudent;
            double percent = (currStudent + 1) / (passStudent + 1);
            q.add(new double[]{percent - prevPercent, percent, index++});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] top = q.remove();
            index = (int) top[2];
            classes[index][0] += 1;
            classes[index][1] += 1;
            System.out.println("class:" + classes[index][0] + ":" + classes[index][1]);
            double newPercent = (1.0 * (classes[index][0] + 1)) / (1.0 * (classes[index][1] + 1));
            double increment = newPercent - top[0];
            q.add(new double[]{increment, newPercent, index});
        }
        double maxPassRatio = 0;
        for (int[] c : classes) {
            maxPassRatio += ((1.0 * c[0]) / (1.0 * c[1]));
        }
        return maxPassRatio/classes.length;
    }

    public static void main(String[] args) {

        MaxAvgOfClass max = new MaxAvgOfClass();
        int[][] arr = {{1, 2}, {3, 5}, {2, 2}};
        double maxRatio = max.maxAverageRatio(arr, 2);
        System.out.println(maxRatio);

    }

}
