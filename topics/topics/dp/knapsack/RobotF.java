package dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RobotF {

    public static void main(String[] args) {

        int[] robot = new int[]{0, 4, 6};
        List<Integer> robotList = new ArrayList<>();
        for (int r : robot) {
            robotList.add(r);
        }
        int[][] factory = new int[][]{{2, 2}, {6, 2}};
        RobotF robotF = new RobotF();
        System.out.println(robotF.minimumTotalDistance(robotList, factory));
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        robot.sort((r1, r2) -> Integer.compare(r1, r2));
        List<Integer> factories = new ArrayList<>();
        for (int[] fact : factory) {
            for (int f = 0; f < fact[1]; f++) {
                factories.add(fact[0]);
            }
        }
        return calculateMinDist(robot, robot.size(), factories, factories.size());
    }

    public long calculateMinDist(List<Integer> robot, int numRobot, List<Integer> factories, int numFactories) {

        System.out.println("numRobot:" + numRobot + " numFac:" + numFactories);
        if (numRobot == 0 || numFactories == 0) return 0;

        if (numRobot == 1) {
            int minDist = Integer.MAX_VALUE;
            while (numFactories > 0) {
                minDist = Integer.min(minDist, Math.abs(factories.get(numFactories-1) - robot.get(0)));
                numFactories -= 1;
            }
            return minDist;
        }

        if (numRobot < numFactories) {
            long a = Math.abs(factories.get(numFactories - 1) - robot.get(numRobot - 1)) +
                    calculateMinDist(robot, numRobot - 1, factories, numFactories - 1);
            long b = calculateMinDist(robot, numRobot - 1, factories, numFactories - 1);
            return Long.min(a, b);
        } else {
            long a = Math.abs(factories.get(numFactories - 1) - robot.get(numRobot - 1));
            long b = calculateMinDist(robot, numRobot - 1, factories, numFactories - 1);
            return a + b;

        }
    }
}
