package array.problems;

import java.util.Arrays;

//2491. Divide Players Into Teams of Equal Skill
//#array #sorting.

public class DivideIntoTeamOfEqualSkill {
    public static void main(String[] args) {

        DivideIntoTeamOfEqualSkill divide = new DivideIntoTeamOfEqualSkill();
        int[] skill = new int[]{3, 2, 5, 1, 3, 4};
        System.out.println(divide.dividePlayersWithFrequencyTable(skill)); // O(n)
        System.out.println(divide.dividePlayers(skill)); // O(Log n)
    }

    public long dividePlayers(int[] skill) {

        // [1,2,3,3,4,5]
        // sort and first and last.
        // [1,1,1,1] all equal
        // [1,1,2,3,4,4,10,10]

        Arrays.sort(skill);
        int len = skill.length;
        long output = 0;
        int expectedSum = -1;
        for (int i = 0; i < len / 2; i++) {
            if (expectedSum == -1) {
                expectedSum = skill[i] + skill[len - i - 1];
            } else if ((skill[i] + skill[len - i - 1]) != expectedSum) {
                return -1;
            }
            output += ((long) skill[i] * skill[len - i - 1]);
        }
        return output;
    }

    public long dividePlayersWithFrequencyTable(int[] skills) {
        int min = 1001;
        int max = 0;
        int[] skillArr = new int[1001];

        for (int skill : skills) {
            min = Integer.min(min, skill);
            max = Integer.max(max, skill);
            skillArr[skill] += 1;
        }

        int expected = min + max;
        long output = 0;
        for (int i = 1; i < 1001; i++) {
            while (skillArr[i] > 0) {
                if (skillArr[expected - i] > 0) {
                    output += ((long) i * (expected - i));
                    skillArr[expected - i] -= 1;
                } else {
                    return -1;
                }
                skillArr[i] -= 1;
            }
        }
        return output;
    }
}
