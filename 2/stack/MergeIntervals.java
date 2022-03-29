import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Meeting{

    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

public class MergeIntervals {

    public void mergeIntervals(int[][] arr) {

        Stack<Meeting> stack = new Stack<>();
        Arrays.sort(arr, Comparator.comparingInt(i -> i[0]));

        stack.push(new Meeting(arr[0][0], arr[0][1])); //first meeting pushed.

        for (int i = 1; i < arr.length; i++) {
            //last meeting's end overlaps with this meeting.
            if (stack.peek().end >= arr[i][0]) {

                Meeting modifiedMeeting = stack.pop();
                modifiedMeeting.end = Integer.max(modifiedMeeting.end, arr[i][1]);
                stack.push(modifiedMeeting);

            } else {
                stack.push(new Meeting(arr[i][0], arr[i][1]));
            }
        }

        int noOfMeetings = stack.size();
        int[][] meetings = new int[stack.size()][2];

        for (int i=0;i<noOfMeetings;i++){

            Meeting meeting = stack.pop();
            System.out.println(meeting.start+" " +meeting.end);

        }




    }

    public static void main(String[] args) {

        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.mergeIntervals(arr);

    }

}
