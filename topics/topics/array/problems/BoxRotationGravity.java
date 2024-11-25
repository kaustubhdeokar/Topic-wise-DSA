package array.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/rotating-the-box/?envType=daily-question&envId=2024-11-23
//leetcode pod = 23 nov
public class BoxRotationGravity {
    public char[][] rotateTheBox(char[][] box) {

        //row 2
        //c
        //-7-6-5-4-3-2-1
        // # # # . . * .

        //list [(c-1)] ,
        //c-2 ->obstacle, clear lst.
        // list[] , [c-3],
        // list[c-3] [c-3, c-4]
        // c-5 is stone -> so list isn't empty, swap box[row][list.get(0)], current row, col -
        //placed at c-3
        // remote list(0), add to list, c-5
        //[c-4, c-5]

        int rows = box.length;
        int cols = box[0].length;

        for(int row=0;row<rows;row++){
            LinkedList<Integer> tempL = new LinkedList<>();
            int col = cols-1;
            while(col>=0){
                if(box[row][col]=='.') //empty
                {
                    tempL.add(col);//stone can be inserted.
                }
                else if(box[row][col]=='*') //obstacle.
                {
                    tempL.clear(); // cannot replace stones as bound by obstacle.
                }
                else{ //stone
                    if(tempL.size()!=0){
                        int maxCol = tempL.removeFirst();
                        box[row][maxCol] = '#';
                        box[row][col] = '.';
                        tempL.add(col);
                    }
                }
                col-=1;
            }
        }

        //00 01 02 03
        //10 11 12 13

        //first row, last column
        //second row, secondlast column
        // 0  1
        // 10 00
        // 11 01
        // 12 02
        // 13 03

        int newRows = cols;
        int newCols = rows;
        char[][] invert = new char[newRows][newCols];
        for(int row=0;row<rows;row++){
            int newRow = 0;
            int newCol = newCols-row-1;
            for(int col=0;col<cols;col++){
                invert[newRow++][newCol] = box[row][col];
            }
        }

        return invert;
    }

    public static void main(String[] args) {
        BoxRotationGravity boxRotationGravity = new BoxRotationGravity();
        char[][] box = {{'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}};
        char[][] result = boxRotationGravity.rotateTheBox(box);
        System.out.println(result);
    }
}
