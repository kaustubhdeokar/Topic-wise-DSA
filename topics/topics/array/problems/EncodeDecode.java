package array.problems;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {

        EncodeDecode encodeDecode = new EncodeDecode();
        String res = encodeDecode.encode(List.of("hello", "world"));
        System.out.println(res);
        encodeDecode.decode(res);
    }

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for (String s : strs) {
            ans.append(String.format("%04d", s.length())).append(s);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> resultSts = new ArrayList<>();
        int i;
        for (i = 0; i < str.length(); i++) {
            StringBuilder length = new StringBuilder();
            int j = i;
            while (Character.isDigit(str.charAt(j))) {
                length.append(str.charAt(j));
                j += 1;
            }
            int strLength = Integer.parseInt(length.toString());
            resultSts.add(str.substring(j, j + strLength));
            i += (j+strLength);
        }
        System.out.println(resultSts);
        return resultSts;
    }
}
