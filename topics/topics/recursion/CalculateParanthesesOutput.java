package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//241. Different Ways to Add Parentheses
//leetcode pod 19th sep
//todo: optimize
public class CalculateParanthesesOutput {
    Set<Character> operators = Set.of('+','-','*');

    public List<Integer> diffWaysToCompute(String expression) {


        List<Integer> answer = new ArrayList<>();
        if(expression.length()==1){
            answer.add(Integer.parseInt(expression));
            return answer;
        }
        else if(expression.length()==0){
            return answer;
        }

        else{
            for(int i=0;i<expression.length();i++){
                char currOp = expression.charAt(i);
                if(operators.contains(currOp)){

                    String left = expression.substring(0,i);
                    String right = expression.substring(i+1);
                    List<Integer> leftAns = diffWaysToCompute(left);
                    List<Integer> rightAns = diffWaysToCompute(right);

                    for(int l:leftAns){
                        for (int r: rightAns){
                            if(currOp=='+')
                                answer.add(l+r);
                            else if(currOp=='-')
                                answer.add(l-r);
                            else if(currOp=='*')
                                answer.add(l*r);
                        }
                    }

                }
            }
        }
        if(answer.size()==0){
            answer.add(Integer.parseInt(expression));
        }
        return answer;

    }
    public static void main(String[] args) {

        CalculateParanthesesOutput calculateParanthesesOutput = new CalculateParanthesesOutput();
        List<Integer> integers = calculateParanthesesOutput.diffWaysToCompute("2*3-4*5");
        System.out.println(integers);

    }

}
