package simulation;

import java.util.*;

//874. Walking Robot Simulation 4 Sep
public class Robot {

    public static void main(String[] args) {

        int[] commands = new int[]{4,-1,4,-2,4};
        int[][] obstacles = new int[][]{{2,4}};

        Robot robot = new Robot();
        robot.robotSim(commands, obstacles);
    }

    public int robotSim(int[] commands, int[][] obstacles) {

        int x = 0;
        int y = 0;
        int max = 0;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currDirection = 0;
        Map<Integer, Set<Integer>> obstacleMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            if (!obstacleMap.containsKey(obstacle[0])) {
                obstacleMap.put(obstacle[0], new HashSet<>());
            }
            obstacleMap.get(obstacle[0]).add(obstacle[1]);
        }
        for (int i = 0; i < commands.length; i++) {
            int currCommand = commands[i];
            if (currCommand == -1) {
                currDirection = (currDirection + 1) % direction.length;
            } else if (currCommand == -2) {
                currDirection = (currDirection - 1 + direction.length) % direction.length;
            } else {
                while (currCommand > 0) {
                    int nxtX = x + direction[currDirection][0];
                    int nxtY = y + direction[currDirection][1];
                    if (getobstacles(nxtX, nxtY, obstacleMap)) {
                        break;
                    }
                    x = nxtX;
                    y = nxtY;
                    currCommand -= 1;
                    max = Integer.max(max, x * x + y * y);
                }
            }

        }

        return max;
    }

    private static boolean getobstacles(int x, int y, Map<Integer, Set<Integer>> obstacleMap) {
        if (obstacleMap.containsKey(x) && obstacleMap.get(x).contains(y)) {
            return true;
        }
        return false;
    }


}
