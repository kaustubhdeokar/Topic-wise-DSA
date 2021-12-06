import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//https://www.codechef.com/LRNDSA01/problems/LAPIN
public class Lapindrome {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        scan.nextLine();
        while (testCases > 0) {

            String str = scan.nextLine();
            int length = str.length();
            String left = null;
            String right = null;
            if ((length & 1) != 0) {
                left = str.substring(0, length / 2);
                right = str.substring((length / 2) + 1);
            }
            else {
                left = str.substring(0, length / 2);
                right = str.substring(length / 2);
            }

            Map<Character, Integer> leftMap = formMap(left);
            Map<Character, Integer> rightMap = formMap(right);

            if(compareMaps(leftMap,rightMap)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

            testCases -= 1;
        }

    }

    private static boolean compareMaps(Map<Character, Integer> leftMap, Map<Character, Integer> rightMap) {

        if(leftMap.size()!=rightMap.size()){
            return false;
        }
        else{
            for(Map.Entry<Character,Integer> entry:leftMap.entrySet()){
                if (!leftMap.get(entry.getKey()).equals(rightMap.get(entry.getKey()))) {
                    return false;
                }
            }
            }
        return true;
    }

    private static Map<Character, Integer> formMap(String left) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            if (map.containsKey(left.charAt(i))) {
                map.put(left.charAt(i), map.get(left.charAt(i)) + 1);
            }
            else {
                map.put(left.charAt(i), 1);
            }
        }
        return map;
    }
}
