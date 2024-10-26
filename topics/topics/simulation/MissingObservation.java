package simulation;
//2028. Find Missing Observations - 5 sep
public class MissingObservation {

    public static void main(String[] args) {
        MissingObservation missing = new MissingObservation();
        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;
        int[] result = missing.missingRolls(rolls, mean, n);
        for(int res: result){
            System.out.print(res+" ");
        }
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {

        int m = rolls.length;
        int totalSum = mean * (n + m);
        int currentSum = 0;
        for (int r : rolls) {
            currentSum += r;
        }

        int answer = totalSum - currentSum;

        int[] pendingRolls = new int[n];
        int[] incorrectAns = new int[]{};
        if (answer / n > 6 || answer / n < 1) {
            return incorrectAns;
        } else {
            int roll = 0;
            while (n > 0) {
                roll = answer / n;
                if (roll > 6 || roll < 1) {
                    return incorrectAns;
                }
                n -= 1;
                answer -= roll;
                pendingRolls[n] = roll;
            }
        }
        return pendingRolls;
    }
}
