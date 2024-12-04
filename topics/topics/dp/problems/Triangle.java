package dp.problems;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        //2
        //3 4
        //6 5 7
        //4 1 8 3

        //for i = 1, we will store cost to appear at each cell.
        //cost = min(tr[i][j] + tri[i-1][j], tri[i][j] + tri[i-1][j-1] (if exists))

        int rows = triangle.size();
        for(int i=1;i<rows;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j!=0){
                    int min =
                            Math.min(triangle.get(i).get(j)+triangle.get(i-1).get(j),
                                    triangle.get(i).get(j)+triangle.get(i-1).get(j-1));

                    triangle.get(i).set(j, min);
                }
                else{
                    triangle.get(i).set(j, triangle.get(i-1).get(j));
                }
            }
        }

        for(int j=0;j<triangle.get(rows-1).size();j++){
            System.out.print(triangle.get(rows-1).get(j)+" ");
        }

        return 0;
    }
}
