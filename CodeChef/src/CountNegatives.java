import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountNegatives {

    static void func(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(Arrays.toString(arr[i + j]));
            }
        }
        System.out.println(arr.length+" "+arr[0].length);
    }

    public static void main(String[] args) {
        int[][] mn = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        func(mn);

        List<Integer> list = new ArrayList<>();

        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer s1,Integer s2){
                return Integer.compare(s1,s2);
            }
        });



    }
}
