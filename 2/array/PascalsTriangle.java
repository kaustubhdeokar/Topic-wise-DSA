import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> printPascalsTriangle(int n) {

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<Integer>() {{
            add(1);
        }});

        ArrayList<Integer> arr = new ArrayList<>() {{
            add(1);
            add(1);
        }};

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> newArr = new ArrayList<>();
            newArr.add(1);
            for (int j = 0; j < i - 2; j++) {
                newArr.add(arr.get(j) + arr.get(j + 1));
            }
            newArr.add(1);
            answer.add(newArr);
            arr = newArr;
        }

        return answer;

    }

    public void print(ArrayList<Integer> arr) {
        for (int elem : arr)
            System.out.print(elem + " ");
        System.out.println();
    }


    public static void main(String[] args) {

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> list = pascalsTriangle.printPascalsTriangle(5);

        for (List<Integer> list1 : list) {
            for (Integer i : list1) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
