package work.DFS;

/**
 * @author abaka
 * @date 2019/7/27 15:36
 */
public class NumIsLands {
    /**
     * 本题的意思是连在一起的陆地都算做一个岛屿，本题可以采用类似渲染的做法，尝试以每个点作为渲染的起点，可以渲染
     * 的陆地都算做一个岛屿，最后看渲染了多少次，即深度优先算法执行了多少次
     */
    static class Solution {
        static int[][] point = {{0,1},{1,0},{0,-1},{-1,0}};
        public void DFS(char[][] grid,int col,int row,int x,int y){
            if(x < 0 || y < 0 || x >= row || y >= col){
                return;
            }
            if(grid[x][y] == '1'){
                for(int i = 0; i < 4; i++){
                    int newx = x + point[i][0];
                    int newy = y + point[i][1];
                    grid[x][y] = 'z';
                    DFS(grid, col, row, newx, newy);
                }
            }
        }

        public int numIslands(char[][] grid) {
            if(grid.length == 0)
                return 0;
            int row = grid.length;
            int col = grid[0].length;
            int count = 0;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        DFS(grid, col, row, i, j);
                    }
                }
            }
            return count;
        }
    }
}
