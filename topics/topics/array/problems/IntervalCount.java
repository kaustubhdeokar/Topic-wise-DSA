package array.problems;

public class IntervalCount {

    public static void main(String[] args) {

        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};

        int queryTime = 4;

        System.out.println(studentsStudyingAtQueryTime(startTime, endTime, queryTime));

    }

    private static int studentsStudyingAtQueryTime(int[] startTime, int[] endTime, int queryTime) {

        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count += 1;
            }
        }
        return count;

    }

}
