package array.problems.unique_binary_str_lc_20_feb;

public class UniqueBinaryString {
    //https://en.wikipedia.org/wiki/Cantor%27s_diagonal_argument
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        UniqueBinaryString uniqueBinaryString = new UniqueBinaryString();
        String[] strs = new String[]{"10", "01","00"};
        uniqueBinaryString.findDifferentBinaryString(strs);

    }
}
