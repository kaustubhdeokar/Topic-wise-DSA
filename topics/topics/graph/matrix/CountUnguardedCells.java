package graph.matrix;

public class CountUnguardedCells {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] cells = new int[m][n];
        for(int[] wall: walls){
            cells[wall[0]][wall[1]] = -1;
        }
        for(int[] guard: guards){
            cells[guard[0]][guard[1]] = 2; // guards present.
        }

        for(int[] guard: guards){
            int i = guard[0];
            int j = guard[1];
            traverse(i+1, j,1,0, cells);
            traverse(i-1, j,-1,0, cells);
            traverse(i, j+1,0,1, cells);
            traverse(i, j-1,0,-1, cells);
        }

        int countUnsecured = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(cells[i][j] == 0) countUnsecured+=1;
            }
        }

        return countUnsecured;

    }

    public void traverse(int x, int y, int xincr, int yincr, int[][] cells)
    {
        if(valid(x,y,cells)){
            //System.out.println("mark, x:"+x+" y:"+y);
            cells[x][y] = 1; // secured.
            traverse(x+xincr,y+yincr,xincr,yincr, cells);
        }

    }

    public boolean valid(int x, int y, int[][] cells)
    {
        return x>=0 && y>=0 && x<cells.length && y<cells[0].length && cells[x][y]!=-1 && cells[x][y]!=2;
    }

    public static void main(String[] args) {

        int m = 4, n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1}, {2,2}, {1,4}};

        CountUnguardedCells count = new CountUnguardedCells();
        int totalcount = count.countUnguarded(m, n, guards, walls);
        System.out.println(totalcount);
    }

}
