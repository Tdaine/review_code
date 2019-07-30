package work.DFS;

/**
 * @author abaka
 * @date 2019/7/30 15:08
 */
public class Solve {
    class Solution {
        private int[][] points = {{0,1},{0,-1},{1,0},{-1,0}};
        public void dfs(char[][] board,int col,int row,int x,int y){
             //book[x][y] = 1;
             board[x][y] = 'Z';
             for (int i = 0; i < 4; i++){
                 int newX = x + points[i][0];
                 int newY = y + points[i][1];
                 if (newX < 0 || newX >= row || newY < 0 || newY >= col )
                     continue;
                 if (board[newX][newY] == 'O')
                     dfs(board,col,row,newX,newY);
             }

        }


        public void solve(char[][] board) {
            if (board.length == 0)
                return;
            int row =  board.length;
            int col = board[0].length;

            for (int i = 0; i < row; i++){
                if (board[i][0] == 'O')
                    dfs(board,col,row,i,0);
                if (board[i][col - 1] == 'O')
                    dfs(board,col,row,i,col - 1);
            }


            for (int i = 0; i < col; i++){
                if (board[0][i] == 'O')
                    dfs(board,col,row,0,i);
                if (board[row - 1][i] == 'O')
                    dfs(board,col,row,row - 1,i);
            }

            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (board[i][j] == 'Z')
                        board[i][j] = 'O';
                    else if (board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }
    }
}
