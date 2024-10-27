package recursion;

import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {

    }

    public void generate(int left, int right, int lengthExpected, int n, String str, List<String> result){
        if(str.length()==lengthExpected){
            result.add(new String(str));
        }

        if(left>right && left<n){
            generate(left+1, right, lengthExpected, n, str+"(", result);
            generate(left, right+1, lengthExpected, n, str+")", result);
        }
        else{
            generate(left+1, right, lengthExpected, n, str+"(", result);
        }
    }

}
