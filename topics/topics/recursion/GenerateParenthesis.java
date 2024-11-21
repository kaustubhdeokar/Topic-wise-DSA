package recursion;

import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        gp.generateParanthesis(3);
    }

    private void generateParanthesis(int i) {
        List<String> result = new java.util.ArrayList<>();
        generate(0, 0, i * 2, i, new StringBuilder(), result);
        System.out.println(result);
    }

    public void generate(int left, int right, int lengthExpected, int n, StringBuilder str, List<String> result) {
        if (str.length() == lengthExpected) {
            result.add(str.toString());
            return;
        }


        if (right < left) {
            generate(left, right + 1, lengthExpected, n, str.append(")"), result);
            str.deleteCharAt(str.length() - 1);
        }

        if (left < n) {
            generate(left + 1, right, lengthExpected, n, str.append("("), result);
            str.deleteCharAt(str.length() - 1);
        }



    }

}
