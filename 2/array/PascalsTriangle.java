import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> printPascalsTriangle(int n) {

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>() {{
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

    /**
     * leetcode user: rheaxu
     */
    public List<List<Integer>> printPascalsTriangleLeetCode(int n) {

        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            row.add(0, 1);//will introduce a time issue. -> shifting all elements on each iteration.
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<>(row));
        }
        return allrows;
    }

    public List<Integer> printPascalsTriangleNthRow(int n) {

        List<List<Integer>> answer = printPascalsTriangle(n);
        return answer.get(n - 1);

    }


    public void print(List<Integer> arr) {
        for (int elem : arr)
            System.out.print(elem + " ");
        System.out.println();
    }


    public static void main(String[] args) {

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> list = pascalsTriangle.printPascalsTriangle(5);

        for (List<Integer> list1 : list) {
            pascalsTriangle.print(list1);
        }

        List<Integer> lists = pascalsTriangle.printPascalsTriangleNthRow(5);
        for (Integer i : lists) {
            System.out.print(i + " ");
        }
    }

}
