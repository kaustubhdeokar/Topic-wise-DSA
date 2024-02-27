import java.util.ArrayDeque;

public class ReplaceOWithX {
    
    class Node{
        int i;
        int j;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
        public String toString(){
            return "i:"+i+" j:"+j;
        }
    }

    public static void main(String[] args) {
        
        char[][] grid = {{'X', 'X', 'X', 'X'}, 
                        {'X', 'O', 'X', 'X'}, 
                        {'X', 'O', 'O', 'X'}, 
                        {'X', 'O', 'X', 'X'}, 
                        {'X', 'X', 'O', 'O'}};

        ReplaceOWithX replace = new ReplaceOWithX();
        replace.solve(grid);
        

    }

    public void solve(char[][] board) {
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        int rows = board.length;
        int cols = board[0].length;
        
        //adding O's from edge rows and cols.
         
        for(int i=0;i<cols;i++){
            if(board[0][i] == 'O'){
                q.add(new Node(0,i)); 
            }            
            if(board[rows-1][i]=='O'){
                q.add(new Node(rows-1, i));
            }
        }

        for(int i=0;i<rows;i++){
            if(board[i][0] == 'O'){
                q.add(new Node(i,0));
            }
            if(board[i][cols-1]=='O'){
                q.add(new Node(i,cols-1));
            }
        }

        //collected all O's which are linked to the boundary
        //then, bfs is to be done on these to see what O's can never be converted to X's.

        transform(board, q);

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='1'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void transform(char[][] board, ArrayDeque<Node> q){
        
        int rows = board.length;
        int cols = board[0].length;

        while(!q.isEmpty()){
            
            Node current = q.remove();
            int i = current.i;
            int j = current.j;
            board[i][j] = '1'; // mark O as '1' as they will never be converted to X's

            if((i+1)<rows && board[i+1][j] == 'O'){
                q.add(new Node(i+1,j));
            }

            if((i-1)>=0 && board[i-1][j] == 'O'){
                q.add(new Node(i-1, j));
            }

            if((j+1)<cols && board[i][j+1] == 'O'){
                q.add(new Node(i,j+1));
            }

            if((j-1)>=0 && board[i][j-1] == 'O'){
                q.add(new Node(i, j-1));
            }

        }

    }

}
